package ru.javawebinar.topjava.service.mealservice;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.MealServiceTest;

import java.util.Map;

/**
 * Created by User on 16.01.2017.
 */
@ActiveProfiles({Profiles.POSTGRES, Profiles.DATAJPA})
/*            POSTGRES  HSQLDB  JDBC  JPA  DATAJPA */
public class MealServicePostgresDataJpaTest extends MealServiceTest {

    @Test
    public void testMealWithUser() throws Exception {
        Map<Meal, User> testMap = service.getMealWithUser(MealTestData.ADMIN_MEAL_ID);
        Meal testMeal = (Meal) testMap.keySet().toArray()[0];
        User testUser = (User) testMap.values().toArray()[0];
        ru.javawebinar.topjava.MealTestData.MATCHER.assertEquals(MealTestData.ADMIN_MEAL1, testMeal);
        ru.javawebinar.topjava.UserTestData.MATCHER.assertEquals(UserTestData.ADMIN, testUser);
    }
}
