package com.adeking.kix;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("com.adeking.kix.mapper")
public class PersistenceConfig {

    /**
     * when use XML
     * <bean id="datasource" class="org.springframework.jdbc.datasource.DriverMangerDataSource">
     * <property name="driverClassName" value="xxx"/>
     * <property name="username" value="xxx"/>
     * <property name="password" value="xxx"/>
     * </bean>
     */
    @Bean
    public DataSource dataSource() {
        // return new EmbeddedDatabaseBuilder()
        // .setType(EmbeddedDatabaseType.H2)
        // .addScript("schema.sql")
        // .addScript("data.sql")
        // .build();
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:db/database.sqlite3");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    /**
     * when use XML
     * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
     * <property name="dataSource" ref="dataSource"/>
     * </bean>
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        // Transaction 
        factoryBean.setTransactionFactory(new ManagedTransactionFactory());
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    // @Bean
    // @Override
    // public PlatformTransactionManager annotationDrivenTransactionManager() {
    //     return new DataSourceTransactionManager(dataSource());
    // }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}