package ru.job4j.serialization.json;

public class Info {

    private final String city;
    private final String phone;
    private final boolean haveCar;

    public Info(String city, String phone, boolean haveCar) {
        this.city = city;
        this.phone = phone;
        this.haveCar = haveCar;
    }

    @Override
    public String toString() {
        return "Info{"
                + "address='" + city + '\''
                + ", phone='" + phone + '\''
                + ", haveCar=" + haveCar
                + '}';
    }
}
