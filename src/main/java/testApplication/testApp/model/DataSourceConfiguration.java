package testApplication.testApp.model;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {


    /*
    Local
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/secondDB");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("katrin");
        return dataSourceBuilder.build();
    }
     */

    /**
     * Heroku
     */
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://ec2-54-195-252-243.eu-west-1.compute.amazonaws.com:5432/d7buvkel31u5vm");
        dataSourceBuilder.username("cfakvxouhxjxaa");
        dataSourceBuilder.password("54a2d3b89038bea0bc6e7a90c7844a6f69feca43c6aa1d1dcfe1e3221d231a2f");
        return dataSourceBuilder.build();
    }
}