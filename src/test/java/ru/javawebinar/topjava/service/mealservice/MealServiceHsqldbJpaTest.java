package ru.javawebinar.topjava.service.mealservice;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.MealServiceTest;

/**
 * Created by User on 16.01.2017.
 */
@ActiveProfiles({Profiles.HSQLDB, Profiles.JPA})
/*            POSTGRES  HSQLDB  JDBC  JPA  DATAJPA */
public class MealServiceHsqldbJpaTest extends MealServiceTest {
}
