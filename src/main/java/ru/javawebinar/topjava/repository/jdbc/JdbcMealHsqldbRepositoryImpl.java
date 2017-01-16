package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.Meal;

import javax.sql.DataSource;
import java.sql.Timestamp;


/**
 * Created by User on 16.01.2017.
 */
@Repository
@Profile(Profiles.HSQLDB)
public class JdbcMealHsqldbRepositoryImpl extends JdbcMealRepositoryImpl {

    public JdbcMealHsqldbRepositoryImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Meal save(Meal meal, int userId) {

        super.t = Timestamp.valueOf(meal.getDateTime());

        return super.save(meal, userId);
    }
}