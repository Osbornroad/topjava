package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;
import static ru.javawebinar.topjava.util.DateTimeUtil.DATE_TIME_FORMATTER;

/**
 * Created by User on 26.12.2016.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(MEAL_0, service.get(100000, 100000));
        MATCHER.assertEquals(MEAL_1, service.get(100001, 100000));
        MATCHER.assertEquals(MEAL_2, service.get(100002, 100000));
        MATCHER.assertEquals(MEAL_3, service.get(100003, 100001));
        MATCHER.assertEquals(MEAL_4, service.get(100004, 100001));
        MATCHER.assertEquals(MEAL_5, service.get(100005, 100001));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(100001, 100000);
        List<Meal> list = new ArrayList<>();
        list.add(MEAL_0);
        list.add(MEAL_2);
        Collections.sort(list, (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        MATCHER.assertCollectionEquals(list, service.getAll(100000));
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        List<Meal> list = new ArrayList<>();
        list.add(MEAL_3);
        list.add(MEAL_4);
        Collections.sort(list, (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        MATCHER.assertCollectionEquals(list,
                service.getBetweenDateTimes(
                        LocalDateTime.parse("2016-12-26 10:00", DATE_TIME_FORMATTER),
                        LocalDateTime.parse("2016-12-26 13:00", DATE_TIME_FORMATTER),
                        100001));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Meal> list = new ArrayList<>();
        list.add(MEAL_3);
        list.add(MEAL_4);
        list.add(MEAL_5);
        Collections.sort(list, (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        MATCHER.assertCollectionEquals(list, service.getAll(100001));
    }

    @Test
    public void testUpdate() throws Exception {
        Meal updated = new Meal(START_SEQ + 4, LocalDateTime.parse("2016-12-26 13:00", DATE_TIME_FORMATTER), "Coffee break", 999);
        service.update(updated, 100001);
        MATCHER.assertEquals(updated, service.get(100004, 100001));
    }

    @Test
    public void testSave() throws Exception {
        Meal newMeal = new Meal(LocalDateTime.parse("2016-12-30 14:00", DATE_TIME_FORMATTER), "Second lunch", 888);
        service.save(newMeal, 100001);
        List<Meal> list = new ArrayList<>();
        list.add(MEAL_3);
        list.add(MEAL_4);
        list.add(MEAL_5);
        list.add(newMeal);
        Collections.sort(list, (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        MATCHER.assertCollectionEquals(list, service.getAll(100001));
    }

}