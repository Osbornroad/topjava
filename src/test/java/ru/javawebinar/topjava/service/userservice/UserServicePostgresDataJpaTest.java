package ru.javawebinar.topjava.service.userservice;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserServiceTest;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 16.01.2017.
 */
@ActiveProfiles({Profiles.POSTGRES, Profiles.DATAJPA})
/*            POSTGRES  HSQLDB  JDBC  JPA  DATAJPA */
public class UserServicePostgresDataJpaTest extends UserServiceTest {

    @Test
    public void testUserWithMeals() throws Exception {
        User testUser = service.getUserWithMeals(UserTestData.USER_ID);
        List<Meal> testList  = testUser.getMeals();
        Collections.sort(testList, (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        ru.javawebinar.topjava.UserTestData.MATCHER.assertEquals(testUser, UserTestData.USER);
        ru.javawebinar.topjava.MealTestData.MATCHER.assertCollectionEquals(testList, MealTestData.MEALS);
    }


}
