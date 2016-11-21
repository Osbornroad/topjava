package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );

        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);

//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> exceedByDay = new HashMap<>();
        int countCalories;
        for (UserMeal userMeal : mealList)
        {
            LocalDate date = userMeal.getDateTime().toLocalDate();
            if(!exceedByDay.containsKey(date))
                exceedByDay.put(date, 0);
            countCalories = exceedByDay.get(date) + userMeal.getCalories();
            exceedByDay.put(date, countCalories);
        }

        List<UserMealWithExceed> mealListWithExceed = mealList
                .stream()
                .filter(userMeal -> (userMeal.getDateTime().toLocalTime().isAfter(startTime)
                        && userMeal.getDateTime().toLocalTime().isBefore(endTime)))
                .map(filtredMeal -> new UserMealWithExceed(
                        filtredMeal.getDateTime(),
                        filtredMeal.getDescription(),
                        filtredMeal.getCalories(),
                        exceedByDay.get(filtredMeal.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());

        // TODO return filtered list with correctly exceeded field
        return mealListWithExceed;
    }
}
