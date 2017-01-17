package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.Meal;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


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

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        super.tStart = Timestamp.valueOf(startDate);
        super.tEnd = Timestamp.valueOf(endDate);

        return super.getBetween(startDate, endDate, userId);
    }
}