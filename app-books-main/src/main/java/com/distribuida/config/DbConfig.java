package com.distribuida.config;


import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DbConfig {
    @Inject
    @ConfigProperty(name="db.connection.username")
    private String dbUser;

    @Inject
    @ConfigProperty(name="db.connection.password")
    private String dbPassword;

    @Inject
    @ConfigProperty(name="db.connection.url")
    private String dbUrl;

    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);

        //ds.setMinimumIdle(1);
        //ds.setMaximumPoolSize(5);

        return ds;
    }
    @PersistenceContext
    private EntityManager em;
    public EntityManager em(){
        return em;
    }
/*
    @Produces
    @ApplicationScoped
    public DbClient dbClent() {

        var pool = ConnectionPool.builder()
                .username(dbUser)
                .password(dbPassword)
                .url( dbUrl )
                .build();

        return JdbcDbClientProviderBuilder
                .create()
                .connectionPool(pool)
                .build();
    }
*/
}
