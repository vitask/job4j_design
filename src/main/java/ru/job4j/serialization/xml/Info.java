package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
public class Info {

    @XmlAttribute
    private String city;
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private boolean haveCar;

    public Info() {
    }

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
