package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);
    
    void evictCache();

    /**
     * 7.1 достать по id пользователя вместе с его едой
     */
    // null if not found
    User getUserWithMeals(int userId);
}
