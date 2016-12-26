package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Objects;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;
import static ru.javawebinar.topjava.util.DateTimeUtil.DATE_TIME_FORMATTER;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final Meal MEAL_0 = new Meal(START_SEQ + 0, LocalDateTime.parse("2016-12-24 10:00", DATE_TIME_FORMATTER), "Breakfast", 500);
    public static final Meal MEAL_1 = new Meal(START_SEQ + 1, LocalDateTime.parse("2016-12-24 13:00", DATE_TIME_FORMATTER), "Lunch", 1000);
    public static final Meal MEAL_2 = new Meal(START_SEQ + 2, LocalDateTime.parse("2016-12-24 18:00", DATE_TIME_FORMATTER), "Dinner", 500);
    public static final Meal MEAL_3 = new Meal(START_SEQ + 3, LocalDateTime.parse("2016-12-26 10:00", DATE_TIME_FORMATTER), "Breakfast", 500);
    public static final Meal MEAL_4 = new Meal(START_SEQ + 4, LocalDateTime.parse("2016-12-26 13:00", DATE_TIME_FORMATTER), "Lunch", 1000);
    public static final Meal MEAL_5 = new Meal(START_SEQ + 5, LocalDateTime.parse("2016-12-26 18:00", DATE_TIME_FORMATTER), "Dinner", 509);

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getDateTime(), actual.getDateTime())
                            && Objects.equals(expected.getDescription(), actual.getDescription())
                            && Objects.equals(expected.getCalories(), actual.getCalories())
                    )
    );
}
