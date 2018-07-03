package com.web.ext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: PackagesSqlSessionFactoryBean
 * @Description: 自定义sqlSessionFactoryBean,支持typeAliasesPackage使用通配符
 * @author lisl
 * @date 2016年10月18日 上午9:39:38
 * @since 1.0
 */
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {

	private static final Logger LOG = Logger.getLogger(PackagesSqlSessionFactoryBean.class);

	private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

	/**
	 * 
	 * @category 重写以支持使用通配符
	 * @since
	 * @author lisl
	 * @date 2016年10月18日 上午9:42:35
	 * @param typeAliasesPackage
	 * @see org.mybatis.spring.SqlSessionFactoryBean#setTypeAliasesPackage(String)
	 */
	@Override
	public void setTypeAliasesPackage(String typeAliasesPackage) {
		ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
		typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
				+ ClassUtils.convertClassNameToResourcePath(typeAliasesPackage) + "/" + DEFAULT_RESOURCE_PATTERN;
		try {
			List<String> result = new ArrayList<String>();
			Resource[] resources = resolver.getResources(typeAliasesPackage);
			if (resources != null && resources.length > 0) {
				MetadataReader metadataReader = null;
				for (Resource resource : resources) {
					if (resource.isReadable()) {
						metadataReader = metadataReaderFactory.getMetadataReader(resource);
						try {
							result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage()
									.getName());
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (result.size() > 0) {
				super.setTypeAliasesPackage(StringUtils.join(result.toArray(), ","));
			} else {
				LOG.warn("参数typeAliasesPackage:" + typeAliasesPackage + "，未找到任何包");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
