package ru.javawebinar.topjava.service.userservice;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.UserServiceTest;

/**
 * Created by User on 16.01.2017.
 */
@ActiveProfiles({Profiles.POSTGRES, Profiles.JPA})
/*            POSTGRES  HSQLDB  JDBC  JPA  DATAJPA */
public class UserServicePostgresJpaTest extends UserServiceTest {
}
