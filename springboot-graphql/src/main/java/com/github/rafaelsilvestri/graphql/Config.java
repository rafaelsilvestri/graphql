package com.github.rafaelsilvestri.graphql;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories
@EnableTransactionManagement
public class Config extends AbstractJdbcConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(Config.class);

    @Value("${dbHost}")
    private String dbHost;
    @Value("${dbPort}")
    private String dbPort;
    @Value("${dbUser}")
    private String dbUser;
    @Value("${dbPwd}")
    private String dbPwd;
    @Value("${dbName}")
    private String dbName;

    @Bean
    public DataSource dataSource() {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbName));
        ds.setUsername(dbUser);
        ds.setPassword(dbPwd);
        return ds;
    }

    /**
     * used internally to submit SQL statements to the database.
     */
    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * support for transactions that span more than a single statement
     */
    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
