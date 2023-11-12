package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Company {
    public static void main(String[] args) throws Exception {
        final Employee employee = new Employee("Oleg", "Petrov", 25, true,
                new String[]{"Monday", "Thursday", "Saturday"},
                new Info("Omsk", "+7(999)111-22-33", false));

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        /* Сериализация */
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Десерелизация */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Employee result = (Employee) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}