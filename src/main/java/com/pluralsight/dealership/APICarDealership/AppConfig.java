package com.pluralsight.dealership.APICarDealership;

import com.pluralsight.dealership.APICarDealership.dao.VehicleDAO;
import com.pluralsight.dealership.APICarDealership.model.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
@Configuration
public class AppConfig {

    private BasicDataSource ds;

    @Bean
    public DataSource dataSource(){
        return ds;
    }
    @Autowired
    public AppConfig(@Value("${spring.datasource.url}") String url,
                     @Value("${spring.datasource.username}") String username,
                     @Value("${spring.datasource.password}") String password) {
        ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
    }
}
