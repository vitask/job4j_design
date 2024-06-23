package ru.job4j.ood.srp;

public class User {

    /* Этот класс выполняет две задачи: управление пользователем и обрабатывание файлов
     * Следует разделить класс на два отдельных класса: один для управления настройками пользователя, другой для работы с файлами
     */

    public void createUser(String userName) {

    }

    public void deleteUser(String userName) {

    }

    public void saveUserToFile(User user) {

    }

    public User loadUserFromFile() {
        return new User();
    }
}
