package ru.job4j.ood.srp.report;


import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.assertThat;

class XmlReportEngineTest {
    @Test
    public void whenXMLReportGenerated() throws Exception {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(employee);
        Report engine = new XmlReportEngine(store);
        String s = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(s)
                .append("<employee>").append(s)
                .append(String.format("<list name=\"%s\">", employee.getName())).append(s)
                .append(String.format("<hired>%s</hired>", parser.parse(employee.getHired()))).append(s)
                .append(String.format("<fired>%s</fired>", parser.parse(employee.getFired()))).append(s)
                .append(String.format("<salary>%s</salary>", employee.getSalary())).append(s)
                .append("</list>").append(s)
                .append("</employee>").append(s);
        assertThat(engine.generate(em -> true)).isEqualToIgnoringWhitespace(expect.toString());
    }
}