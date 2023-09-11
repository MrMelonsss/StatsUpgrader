package org.mrmelon__.statsupgrader.users;

import java.util.ArrayList;

public class Users {

    private static ArrayList<String> users = new ArrayList<>(); // Список всех юзеров

    public static boolean userChecker(String nickname){ // Проверка игрока на то, есть ли он в списке юзеров
        if (users.contains(nickname)) return true; // Проверка на присутствие игрока в списке
        return false;
    }

    public static void addUser(String nickname){ // Метод, добавляющий юзера в список
        users.add(nickname);
    }

    public static ArrayList getUsers(){ // Метод, возвращающий список юзеров
        return users;
    }

}
