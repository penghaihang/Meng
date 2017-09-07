package com.peng.meng.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author peng
 *
 */
@Configuration  
@PropertySource("classpath:config.properties")  
@EnableTransactionManagement  
@EnableJpaRepositories(basePackages={"com.peng.meng.repository"}) 
public class AppConfig {
	 @Resource  
	    private Environment env;  
	    @Bean(destroyMethod="close")  
	    public DataSource dataSource() {  
	    	BasicDataSource dataSource=new BasicDataSource();  
	        dataSource.setDriverClassName(env.getProperty("dbcp.driver"));
	        dataSource.setUrl(env.getProperty("dbcp.url"));  
	        dataSource.setUsername(env.getProperty("dbcp.username"));  
	        dataSource.setPassword(env.getProperty("dbcp.password"));  
	        dataSource.setInitialSize(Integer.valueOf(env.getProperty("dbcp.initialSize")));  
	        dataSource.setMinIdle(Integer.valueOf(env.getProperty("dbcp.minIdle")));  
	        dataSource.setMaxIdle(Integer.valueOf(env.getProperty("dbcp.maxIdle")));
	        dataSource.setMaxActive(Integer.valueOf(env.getProperty("dbcp.maxActive")));  
	        dataSource.setMaxWait(Integer.valueOf(env.getProperty("dbcp.maxWait")));  
	        return dataSource;  
	    }  
	    @Bean  
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){  
	        HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();  
	        jpaVendorAdapter.setGenerateDdl(true);  
	        jpaVendorAdapter.setShowSql(true);  
	        Properties jpaProperties=new Properties();  
	        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");//validate,create,create-drop  
	        System.out.println("mysql的Dialect是:"+env.getProperty("hibernate.dialect"));
	        
	        jpaProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	        jpaProperties.setProperty("hibernate.show_sql","false");
//	        jpaProperties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//	        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
//	        jpaProperties.setProperty("hibernate.jdbc.batch_size", "50");
//	        jpaProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
//	        jpaProperties.setProperty("hibernate.cache.use_query_cache", "true");
	        //jpaProperties.setProperty("hibernate.cache.region.factory_class", org.hibernate..SingletonEhCacheRegionFactory.getName());
	        //jpaProperties.setProperty("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
	        //jpaProperties.setProperty("net.sf.ehcache.configurationResourceName", "/ehcache.xml");
	        //jpaProperties.setProperty("hibernate.generate_statistics", "false");
	      
	        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();  
	        emf.setDataSource(dataSource());  
	        emf.setPackagesToScan("com.peng.meng.domain");  
	        emf.setJpaVendorAdapter(jpaVendorAdapter);  
	        emf.setJpaProperties(jpaProperties);  
	        return emf;  
	    }  
	    @Bean  
	    public PlatformTransactionManager transactionManager(){  
	        JpaTransactionManager transactionManager=new JpaTransactionManager();  
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject()); 
	        return transactionManager;  
	    }  
}
