package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeList {

    @XmlElement(name = "employee")
    List<Employee> employee;

    public EmployeeList() {

    }

    public EmployeeList(List<Employee> list) {
        this.employee = list;
    }
}
