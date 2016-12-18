package ru.javawebinar.topjava;

import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

/**
 * Created by Натусик on 17.12.2016.
 */
public class MealCreatingTestMain {

    public static void main (String[] args)
    {
        List<MealWithExceed> list = MealsUtil.getWithExceeded(MealsUtil.MEALS, 2000);
        for (MealWithExceed mealWithExceed : list)
        {
            System.out.println(mealWithExceed.toString());
        }
    }
}
