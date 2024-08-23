package ru.job4j.ood.dip;
    /*
    Класс UserService напрямую зависит от конкретной реализации
    DatabaseConnection в своем конструкторе, что делает его привязанным только
    к одной реализации БД
    */
public class UserService {
    public void registerUser(String userName) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.saveUser(userName);
    }
}
