package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
@Transactional
public class JpaMealRepositoryImpl implements MealRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Meal save(Meal meal, int userId) {
        User user = em.getReference(User.class, userId);
            if ((meal.getUser() == null))
                meal.setUser(user);
            else {
                if (meal.getUser().getId() != userId)
                    throw new NotFoundException("Попытка обновить чужую еду");
            }

        if (meal.isNew())
        {
            em.persist(meal);
            return meal;
        }
        else {
            return em.merge(meal);
        }
    }

    //Ok
    @Override
    public boolean delete(int id, int userId) {
        Meal result = em.find(Meal.class, id);
        if ((result != null) && (result.getUser() != null) && (result.getUser().getId() == userId))
            return em.createNamedQuery(Meal.DELETE).setParameter("id", id).executeUpdate() != 0;
        else
            throw new NotFoundException("Попытка удалить несуществующую или чужую еду");
    }

    //Ok
    @Override
    public Meal get(int id, int userId) {
        Meal result = em.find(Meal.class, id);
        if ((result != null) && (result.getUser() != null) && (result.getUser().getId() == userId))
            return result;
        else
            throw new NotFoundException("Попытка получить несуществующую или чужую еду");
    }

    //Ok
    @Override
    public List<Meal> getAll(int userId) {
        return em.createNamedQuery(Meal.ALL_SORTED, Meal.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}