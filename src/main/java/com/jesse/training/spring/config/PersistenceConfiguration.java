package com.jesse.training.spring.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "com.jesse.training.spring" })
@EnableJpaRepositories(
  basePackages = {
    "com.jesse.training.spring.repository"
  }
)
public class PersistenceConfiguration {
  @Bean
  public DataSource dataSource(
    @Value("${db.jdbc.driver:org.h2.Driver}") String jdbcDriver,
    @Value("${db.jdbc.url:jdbc:h2:mem:testdb}") String jdbcUrl,
    @Value("${db.jdbc.username:sa}")  String jdbcUser,
    @Value("${db.jdbc.password:}") String jdbcPassword) {
    DataSourceBuilder<?> builder = DataSourceBuilder.create();
    builder.driverClassName(jdbcDriver);
    builder.url(jdbcUrl);
    builder.username(jdbcUser);
    builder.password(jdbcPassword);
    return builder.build();
  }
}
