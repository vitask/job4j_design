package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.generic.MemStore;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class JsonReportEngineTest {
    @Test
    public void whenJSONReportGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100);
        store.add(employee);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report engine = new JsonReportEngine(store, parser);
        StringBuilder expect = new StringBuilder()
                .append(String.format("[{\"fired\":\"%s\",", parser.parse(employee.getHired())))
                .append(String.format("\"name\":\"%s\",", employee.getName()))
                .append(String.format("\"hired\":\"%s\",", parser.parse(employee.getFired())))
                .append(String.format("\"salary\":%.0f}]", employee.getSalary()));
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}