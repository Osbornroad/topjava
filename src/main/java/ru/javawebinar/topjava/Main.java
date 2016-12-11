package ru.javawebinar.topjava;

import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello Topjava Enterprise!");
        System.out.println();
        System.out.println(TimeUtil.formatLocalDateTime(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "yyyy-MM-dd HH:mm"));
    }
}
