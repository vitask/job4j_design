package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainJSON {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"LG\":\"+7(999)111-22-33\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Thursday");
        list.add("Saturday");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Employee employee = new Employee("Oleg", "Petrov", 25, true,
                new String[]{"Monday", "Thursday", "Saturday"},
                new Info("Omsk", "+7(999)111-22-33", false));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", employee.getFirstName());
        jsonObject.put("LastName", employee.getLastName());
        jsonObject.put("Age", employee.getAge());
        jsonObject.put("City", employee.getInfo().getCity());
        jsonObject.put("HaveCar", employee.getInfo().isHaveCar());
        jsonObject.put("Day", jsonStatuses);
        jsonObject.put("Phone", jsonContact);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект employee в json-строку */
        System.out.println(new JSONObject(employee));
    }
}
