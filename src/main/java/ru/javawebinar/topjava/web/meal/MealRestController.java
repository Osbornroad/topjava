package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    int userId = AuthorizedUser.id();

    @Autowired
    private MealService mealService;

    public Meal save(Meal meal){
        LOG.info("save meal of user №" + meal.getUserId());
        return mealService.save(meal, userId);
    }

    public boolean delete(int id){
        LOG.info("delete meal №" + id + " of user №" + userId);
        return mealService.delete(id, userId);
    }

    public Meal get(int id){
        LOG.info("get meal №" + id + " of user №" + userId);
        return mealService.get(id, userId);
    }

    public Collection<Meal> getAll(){
        LOG.info("getAll of user №" + userId);
        return mealService.getAll(userId);
    }
}
