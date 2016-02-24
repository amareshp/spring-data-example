package com.amaresh.examples.stg;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.amaresh.examples.stg"})
@EnableJpaRepositories(basePackages = {"com.amaresh.examples.stg"})
@EnableTransactionManagement
public class OrderStgConfig {

    @Bean
    DataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("user");
        dataSource.setPassword("pass");
        //points to staging db of dev environment.
        dataSource.setURL("jdbc:oracle:thin:user/pass@hostname.com:1521/service");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

}
