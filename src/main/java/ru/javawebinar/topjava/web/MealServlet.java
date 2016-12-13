package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    List<Meal> meals = Collections.synchronizedList(new ArrayList<Meal>());
    List<MealWithExceed> mealsWithExceeded;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOG.debug("redirect to meals");

        if ("filling".equalsIgnoreCase(request.getParameter("action"))) {
            fillingTable();
        }
        if ("delete".equalsIgnoreCase(request.getParameter("action"))) {
            delete(Integer.parseInt(request.getParameter("mealId")));
        }
        if ("update".equalsIgnoreCase(request.getParameter("action")))
            update(Integer.parseInt(request.getParameter("mealId")), request, response);

        mealsWithExceeded = MealsUtil.getFilteredWithExceeded(meals, LocalTime.MIN, LocalTime.MAX, 2000);
        Collections.sort(mealsWithExceeded, new Comparator<MealWithExceed>() {
            @Override
            public int compare(MealWithExceed o1, MealWithExceed o2) {
                return o1.getId() - o2.getId();
            }
        });
        request.setAttribute("mealsWithExceeded", mealsWithExceeded);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }

    private void update(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Iterator<Meal> iterator = meals.iterator();
        Meal meal = null;
        while(iterator.hasNext())
        {
            meal = iterator.next();
            if (meal.getId() == id)
                break;
        }
        request.setAttribute("newMeal", meal);
    }

    private void fillingTable()
    {
        meals.add(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    private void delete(int id)
    {
        Iterator<Meal> iterator = meals.iterator();
        while(iterator.hasNext())
        {
            Meal meal = iterator.next();
            if (meal.getId() == id)
                iterator.remove();
        }
    }

    private boolean isExists(int id)
    {
        Iterator<Meal> iterator = meals.iterator();
        Meal meal = null;
        while(iterator.hasNext())
        {
            meal = iterator.next();
            if (meal.getId() == id)
                return true;
        }
        return false;
    }

    private void addMeal(HttpServletRequest request)
    {
        int id = 0;
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(request.getParameter("datetime"));
        }
        catch (DateTimeParseException e) {}

        String description = request.getParameter("description");
        int calories = 0;
        try {
            calories = Integer.parseInt(request.getParameter("calories"));
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch (NumberFormatException e){}

        if (isExists(id))
            delete(id);

        meals.add(new Meal(id, localDateTime, description, calories));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOG.debug("meal added");

        request.setCharacterEncoding("UTF-8");

        addMeal(request);

        mealsWithExceeded = MealsUtil.getFilteredWithExceeded(meals, LocalTime.MIN, LocalTime.MAX, 2000);
        Collections.sort(mealsWithExceeded, new Comparator<MealWithExceed>() {
            @Override
            public int compare(MealWithExceed o1, MealWithExceed o2) {
                return o1.getId() - o2.getId();
            }
        });
        request.setAttribute("mealsWithExceeded", mealsWithExceeded);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }


}

