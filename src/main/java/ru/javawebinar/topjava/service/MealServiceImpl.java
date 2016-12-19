package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal, int userId) throws NotFoundException {
        if (meal.getUserId() == userId)
            return repository.save(meal);
        else throw new NotFoundException("Saving had denied: the meal is belongs to another user");

    }

    // false if not found
    @Override
    public boolean delete(int id, int userId) throws NotFoundException {
        boolean isDeleted = repository.delete(id, userId);
        if (isDeleted)
            return isDeleted;
        else
            throw new NotFoundException("Deleting had denied: the meal isn't exists or belongs to another user");
    }

    // null if not found
    @Override
    public Meal get(int id, int userId) throws NotFoundException {
        Meal meal = repository.get(id, userId);
        if (meal != null)
            return meal;
        else
            throw new NotFoundException("Getting had denied: the meal isn't exists or belongs to another user");
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }
}
