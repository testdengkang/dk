package com.nged;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 该例子主要用户 对24小时进行逻辑分割时（开始时间可以大于结束时间 但是需要在24小时范围内） 判断当前时间是否在时间段内
 */
public class HourAndMMDemo {

    public static void main(String[] args){
        String[] timeparam1 = new String[]{"8:30","20:00"};
        String[] timeparam2 = new String[]{"20:40","8:00"};
        String[] st2 = timeparam1;
        String[] nowtime = new String[]{"0:00","23:59","8:00","8:01","8:40","12:59","15:03","20:00","20:39","20:40","20:45"};
        Calendar calendar = Calendar.getInstance();
//        int now_y = calendar.get(Calendar.YEAR);//得到年份
//        int now_m = calendar.get(Calendar.MONTH)+1;//得到月份
//        int now_d = calendar.get(Calendar.DATE);//得到月份中今天的号数
        int now_h = calendar.get(Calendar.HOUR_OF_DAY);//得到一天中现在的时间，24小时制
        int now_mm = calendar.get(Calendar.MINUTE);//得到分钟数
//        int now_s = calendar.get(Calendar.SECOND);//得到秒数

        for(String nt:nowtime){
            now_h = getHour(nt);
            now_mm = getMinter(nt);

            int stHour = getHour(st2[0]);
            int endHour = getHour(st2[1]);
            if(stHour<=endHour){
                checkTime(now_h,now_mm,st2[0],st2[1]);

            }else if(stHour>endHour){
                checkTime(now_h,now_mm,st2[0],"23:59");
                checkTime(now_h,now_mm,"0:00",st2[1]);
            }

        }




    }

    public static void checkTime(int now_h,int now_mm,String starttime,String endtime){
        int stHour = getHour(starttime);
        int endHour = getHour(endtime);
        String nt = now_h+":"+now_mm;
        if(now_h==stHour&&now_mm>=getMinter(starttime)){
            System.out.println(nt+" in "+starttime+"--"+endtime);
            return ;
        }
        if(now_h>stHour && now_h<endHour){
            System.out.println(nt+" in "+starttime+"--"+endtime);
            return ;
        }

        if(now_h==endHour&&now_mm<=getMinter(endtime)){
            System.out.println(nt+" in "+starttime+"--"+endtime);
            return ;
        }
    }

    public static int getHour(String dt){

        return  Integer.valueOf(dt.split(":")[0]);
    }

    public static int getMinter(String dt){
        return Integer.valueOf(dt.split(":")[1]);
    }
}
