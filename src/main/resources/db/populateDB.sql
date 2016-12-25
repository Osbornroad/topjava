DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE meal_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100000, '2016-12-24 10:00', 'Breakfast', 500);
INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100000, '2016-12-24 13:00', 'Lunch', 1000);
INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100000, '2016-12-24 18:00', 'Dinner', 500);
INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100001, '2016-12-26 10:00', 'Breakfast', 500);
INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100001, '2016-12-26 13:00', 'Lunch', 1000);
INSERT INTO meals (user_id, datetime, description, calories)
    VALUES (100001, '2016-12-26 18:00', 'Dinner', 509);
