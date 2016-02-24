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
        dataSource.setUser("stg_pg_ord");
        dataSource.setPassword("stg_pg_ord");
        //points to staging db of dev environment.
        dataSource.setURL("jdbc:oracle:thin:stg_pg_ord/stg_pg_ord@db-order-pg-oms.dev.pg-orders.services.qa.walmart.com:1521/stg_pg_ord.gecwalmart.com");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

}
