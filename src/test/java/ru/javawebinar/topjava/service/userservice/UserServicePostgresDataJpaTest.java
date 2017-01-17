package ru.javawebinar.topjava.service.userservice;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserServiceTest;


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
        Map<User, List<Meal>> testMap = service.getUserWithMeals(UserTestData.USER_ID);
        User testUser = (User) testMap.keySet().toArray()[0];
        List<Meal> testList  = (List<Meal>) testMap.values().toArray()[0];
        ru.javawebinar.topjava.UserTestData.MATCHER.assertEquals(testUser, UserTestData.USER);
        ru.javawebinar.topjava.MealTestData.MATCHER.assertCollectionEquals(testList, MealTestData.MEALS);
    }


}
