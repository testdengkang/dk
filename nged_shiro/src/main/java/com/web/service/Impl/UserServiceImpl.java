package com.web.service.Impl;

import com.web.dao.TUserMapper;
import com.web.model.TUser;
import com.web.service.UserService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger("userService");

    @Autowired
    private TUserMapper tUserMapper;

 /*   @Autowired
    private SqlSessionTemplate bathSqlSession;*/

    @Autowired
    private SqlSessionTemplate batchSqlSession;

    @Override
    public int addUser(TUser user) {
        return tUserMapper.insert(user);
    }

    @Override
    public int updateUser(TUser user) {
        return tUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public TUser queryUserByUserName(String userName) {
        return tUserMapper.queryUserByUserName(userName);
    }




    @Override
    public void batchAddUserWithXmlForeach(List<TUser> list) {
        tUserMapper.batchInsertWithForeach(list);
    }

    @Override
    public void batchAddUserWithBatchExcutor(List<TUser> list){
        SqlSession sqlSession =batchSqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try{
            long now = System.currentTimeMillis();

            sqlSession.getConnection().setAutoCommit(false);
            TUserMapper userMapper = sqlSession.getMapper(TUserMapper.class);
            for(int i=0;i<list.size();i++){
                userMapper.insert(list.get(i));
                if(i%500==0||i==list.size()-1){
                    sqlSession.commit();
                    sqlSession.clearCache();
                }
            }
        } catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }





    }

}
