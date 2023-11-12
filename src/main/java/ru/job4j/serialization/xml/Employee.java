package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private String firstName;

    @XmlAttribute
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private boolean married;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] workDay;
    private Info info;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int age, boolean married, String[] workDay, Info info) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
        this.workDay = workDay;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", married=" + married
                + ", workDay=" + Arrays.toString(workDay)
                + ", info=" + info
                + '}';
    }
}
