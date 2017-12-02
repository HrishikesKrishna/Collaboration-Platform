package com.hk.AirChatBackEnd.config;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hk.AirChatBackEnd.Dao.BlogDAO;
import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.DaoImplementation.BlogDAOImpl;
import com.hk.AirChatBackEnd.DaoImplementation.ForumDAOImpl;
import com.hk.AirChatBackEnd.DaoImplementation.UserDAOImpl;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.BlogComment;
import com.hk.AirChatBackEnd.Models.Forum;
import com.hk.AirChatBackEnd.Models.ForumComment;
import com.hk.AirChatBackEnd.Models.Friend;
import com.hk.AirChatBackEnd.Models.Job;
import com.hk.AirChatBackEnd.Models.User;


	@Configuration
	@ComponentScan("com.hk.AirChatBackEnd")
	@EnableTransactionManagement
public class DatabaseConfiguration {

		
			    @Autowired
			    @Bean(name="sF")
			    public SessionFactory sF(DataSource dataSource) {
			        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
			        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
			        
			        sessionBuilder.addProperties(getHibernateProperties());
			        sessionBuilder.addAnnotatedClass(Blog.class);
			        sessionBuilder.addAnnotatedClass(User.class);
			        sessionBuilder.addAnnotatedClass(Forum.class);
			        sessionBuilder.addAnnotatedClass(BlogComment.class);
			        sessionBuilder.addAnnotatedClass(ForumComment.class);
			        sessionBuilder.addAnnotatedClass(Job.class);
			        sessionBuilder.addAnnotatedClass(Friend.class);
			        
			        
			        
			       
			        
			        return sessionBuilder.buildSessionFactory();
			    }
			    @Autowired
			    @Bean(name = "datasource") 
				    public DataSource dataSource() {
			        DriverManagerDataSource dataSource = new DriverManagerDataSource();
			        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=orcl)))");
			        dataSource.setUsername("hrishi");
			        dataSource.setPassword("krishna");
			        System.out.println("DB success");
			        return dataSource;
			    }

			    private Properties getHibernateProperties() {
			        Properties properties = new Properties();
			        properties.put("hibernate.show_sql", "true");
			        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			        properties.put("hibernate.format_sql", "true");
			        
			  properties.put("hibernate.default_schema", "hrishi");
			        properties.put("hibernate.hbm2ddl.auto", "update");
			        properties.put("hibernate.connection.autocommit", true);
			        return properties;
			    }
			    @Autowired
			    @Bean(name="transactionmanager")
			        public HibernateTransactionManager txManager(SessionFactory sF) {
			                return new HibernateTransactionManager(sF);
			        }
			    @Autowired
			    @Bean(name="blogDao")
			    public BlogDAO getBlogDAO(SessionFactory sf )
			    {
			    	System.out.println("BlogDao object created");
			    	return new BlogDAOImpl(sf);
			    }
			    @Autowired
			    @Bean(name="userDao")
			    public UserDAO getUserDAO(SessionFactory sf )
			    {
			    	System.out.println("UserDao object created");
			    	return new UserDAOImpl(sf);
			    } @Autowired
			    @Bean(name="forumDao")
			    public ForumDAO getForumDAO(SessionFactory sf )
			    {
			    	System.out.println("ForumDao object created");
			    	return new ForumDAOImpl(sf);
			    }
			}
