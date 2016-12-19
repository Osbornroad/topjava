package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
/*
    {
        MealsUtil.MEALS.forEach(meal -> save(meal));
    }
*/
    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        repository.put(meal.getId(), meal);
        return meal;
    }
    // false if not found
    @Override
    public boolean delete(int id, int userId) {
        if (get(id, userId) != null) {
            repository.remove(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public Meal get(int id, int userId) {
        Meal meal = repository.get(id);
        if ((meal != null) && (userId == meal.getUserId()))
            return meal;
        else
            return null;
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        Collection<Meal> filteredColl = new ArrayList<>();
        for (Meal meal : repository.values())
        {
            if (userId == meal.getUserId())
                filteredColl.add(meal);
        }
        Collections.sort((List) filteredColl, (Comparator<Meal>) (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
        return filteredColl;
    }
}

