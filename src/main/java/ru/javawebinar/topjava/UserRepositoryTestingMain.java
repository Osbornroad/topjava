package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl;

import java.util.List;

/**
 * Created by User on 16.12.2016.
 */
public class UserRepositoryTestingMain {
    public static void main(String[] args){

        InMemoryUserRepositoryImpl repository = new InMemoryUserRepositoryImpl();
        List<User> list;

        list = repository.getAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        System.out.println("**********************************");

        repository.delete(3);
        list = repository.getAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        System.out.println("**********************************");

        repository.save(new User("Cat", "veronica@gmail.com", "cat", Role.ROLE_USER));
        list = repository.getAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
        System.out.println("**********************************");

        System.out.println(repository.get(3).toString());
        System.out.println("**********************************");
 /*       System.out.println(repository.getByEmail("nata@gmail.com").toString());
        System.out.println("**********************************");
*/
    }
}
