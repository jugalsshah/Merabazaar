//package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.sql.DataSource;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
//import org.springframework.orm.hibernate4.HibernateTemplate;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
////@ComponentScan.Filter(type= FilterType.ANNOTATION, value=DatabaseApplicationConfig.class)
//@ComponentScan(basePackages={"com.learnlogic.ecommerce.merabazar.database"})
//@EnableTransactionManagement
//@PropertySource({"jdbc.properties"})
//public class DataBaseConfig {
//
//	@Autowired
//	Environment environment;
//	
//	 @Bean
//	    public DataSource dataSourceSocialStudent() {
//	        System.out.println("\n\t-->");
////	        DataSource dataSrc = new DriverManagerDataSource(env.getProperty("jdbc.driverClassName"), env.getProperty("jdbc.url"), env.getProperty("jdbc.username"), env.getProperty("jdbc.password"));
//	        DataSource dataSrc = new DriverManagerDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3006/merabazar","root");
//	        System.out.println("ds created.........................");
//	        System.out.println("\n\t-+->+"+dataSrc);
//	        return dataSrc;
//	    }
//	    
//	    @Bean
//	    public AnnotationSessionFactoryBean sessionFactorySocialStudent() {
//	        AnnotationSessionFactoryBean annotationBean = new AnnotationSessionFactoryBean();
//	        annotationBean.setDataSource(dataSourceSocialStudent());
//	        annotationBean.setSchemaUpdate(true);
//	        annotationBean.setPackagesToScan(new String[] {"com.learnlogic.ecommerce.merabazar.model"});
//	        Properties props = new Properties();
//	        InputStream in = getClass().getResourceAsStream("/properties/hibernate.properties");
//	        try {
//	            props.load(in);
//	        } catch (IOException ex) {
//	            System.out.println("got error......................");
//	            Logger.getLogger(DataBaseConfig.class.getName()).log(Level.SEVERE, null, ex);
//	            ex.printStackTrace();
//	        }
//	        System.out.println("\n\t++++"+props.getProperty("hibernate.dialect"));
//	        annotationBean.setHibernateProperties(props);
//	        System.out.println("sf created........................");
//	        System.out.println("\n\t-a-->"+annotationBean);
//	        return annotationBean;
//	    }
//	    
//	    @Bean
//	    public HibernateTemplate hibernateTemplate() throws Exception {
//	        AnnotationSessionFactoryBean annotationSessionFactoryBean = sessionFactorySocialStudent();
//	        annotationSessionFactoryBean.afterPropertiesSet();
//	        System.out.println("\n\t+++b=="+annotationSessionFactoryBean.getObject());
//	        HibernateTemplate ht = new HibernateTemplate(annotationSessionFactoryBean.getObject());
//	        System.out.println("ht created..........................");
//	        return ht;
//	    }
//	    
//	    @Bean
//	    public HibernateTransactionManager transactionManager() {
//	        HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactorySocialStudent().getObject());
//	        System.out.println("htm created...........................");
//	        return htm;
//	    }
//	
//	
//}
