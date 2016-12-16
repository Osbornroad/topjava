package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {


    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public static final List<User> USERS = Arrays.asList(
            new User("Maks", "maks@gmail.com", "supermaks", Role.ROLE_ADMIN),
            new User("Nata", "nata@gmail.com", "supernata", Role.ROLE_USER),
            new User("Fedor", "fedor@gmail.com", "superfedor", Role.ROLE_USER)
    );

    {
        USERS.forEach(this::save);
    }

    @Override
    public User save(User user) {
        if (user.isNew())
            user.setId(counter.incrementAndGet());
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id, get(id));
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        if (email != null) {
            for (Map.Entry entry : repository.entrySet()) {
                User tempUser = (User)entry.getValue();
                if (email.equalsIgnoreCase(tempUser.getEmail()))
                    return tempUser;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List list;
        Collection coll = repository.values();
        if (coll instanceof List)
            list = (List)coll;
        else
            list = new ArrayList(coll);
        Collections.sort(list, (Comparator<User>) (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return list;
    }
}
