package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    //int userId = AuthorizedUser.getId();

    @Autowired
    private MealService mealService;

    public Meal save(Meal meal){
        LOG.info("save meal of user №" + meal.getUserId());
        return mealService.save(meal, AuthorizedUser.getId());
    }

    public boolean delete(int id){
        LOG.info("delete meal №" + id + " of user №" + AuthorizedUser.getId());
        return mealService.delete(id, AuthorizedUser.getId());
    }

    public Meal get(int id){
        LOG.info("get meal №" + id + " of user №" + AuthorizedUser.getId());
        return mealService.get(id, AuthorizedUser.getId());
    }

    public List<MealWithExceed> getAll(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime){
        LOG.info("getAll of user №" + AuthorizedUser.getId());
        List<MealWithExceed> mealWithExceeds = MealsUtil.getWithExceeded(mealService.getAll(AuthorizedUser.getId(), startDate, endDate), AuthorizedUser.getCaloriesPerDay());
        List<MealWithExceed> filteredByTimeMealWithExceeds = new ArrayList<>();
        for (MealWithExceed mealWithExceed : mealWithExceeds)
        {
            if (DateTimeUtil.isBetween(mealWithExceed.getDateTime().toLocalTime(), startTime, endTime))
                filteredByTimeMealWithExceeds.add(mealWithExceed);
        }
        return filteredByTimeMealWithExceeds;
    }
}
