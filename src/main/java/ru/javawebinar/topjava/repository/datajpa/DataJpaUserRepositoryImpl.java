package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;

/**
 * GKislin
 * 27.03.2015.
 */

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    @Autowired
    private CrudUserRepository crudRepository;

    @Autowired CrudMealRepository crudMealRepository;

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    public User getUserWithMeals(int userId) {
        return crudRepository.getUserWithMeals(userId);
    }

/*    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public Map<User, List<Meal>> getUserWithMeals(int userId) {
        User user = get(userId);
        List<Meal> meals = crudMealRepository.findAll(userId);
        return Collections.singletonMap(user, meals);
    }*/
}
