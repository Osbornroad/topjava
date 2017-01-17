package ru.javawebinar.topjava.service.userservice;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserServiceTest;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import static ru.javawebinar.topjava.UserTestData.*;

/**
 * Created by User on 16.01.2017.
 */
@ActiveProfiles({Profiles.POSTGRES, Profiles.JPA})
/*            POSTGRES  HSQLDB  JDBC  JPA  DATAJPA */
public class UserServicePostgresJpaTest extends UserServiceTest {

}
