package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {

    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN));

            adminUserController.create(new User(2, "userName-2", "email-2", "password-2", Role.ROLE_USER));


            MealRestController mealRestController = appCtx.getBean(MealRestController.class);
            //mealRestController.save(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
            //mealRestController.save(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
            //mealRestController.save(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
            //mealRestController.save(new Meal(2, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
            //mealRestController.save(new Meal(2, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
            //mealRestController.save(new Meal(2, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));

            Collection<Meal> collection = mealRestController.getAll();
            for (Meal meal : collection) {
                System.out.println(meal.toString());
            }
            System.out.println("********************************************");
/*
            mealRestController.delete(1);

            collection = mealRestController.getAll();
            for (Meal meal : collection) {
                System.out.println(meal.toString());
            }
            System.out.println("********************************************");

            System.out.println(mealRestController.get(6).toString());
            System.out.println("********************************************");
   */     }
    }
}
