package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.mock.InMemoryMealRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Натусик on 17.12.2016.
 */
public class MealRepositoryTestingMain {

    public static void main (String[] args)
    {
        InMemoryMealRepositoryImpl repository = new InMemoryMealRepositoryImpl();
        /*
        Collection<Meal> collection;
        collection = repository.getAll(AuthorizedUser.id());
        for (Meal meal : collection)
        {
            System.out.println(meal.toString());
        }

        for (int i = 1; i <= 6; i++)
        {
            Meal meal = repository.get(i, AuthorizedUser.id());
            if (meal == null)
                System.out.println("This is null");
            else
                System.out.println(meal.toString());
        }
        */

    }
}
