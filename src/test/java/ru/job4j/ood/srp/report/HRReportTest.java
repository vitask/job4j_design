package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class HRReportTest {

    @Test
    public void whenHRReportGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 30);
        Employee worker3 = new Employee("Vitalya", now, now, 120);
        Employee worker4 = new Employee("Katya", now, now, 140);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        Report engine = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(worker4.getName()).append(" ").append(worker4.getSalary()).append(System.lineSeparator())
                .append(worker3.getName()).append(" ").append(worker3.getSalary()).append(System.lineSeparator())
                .append(worker1.getName()).append(" ").append(worker1.getSalary()).append(System.lineSeparator())
                .append(worker2.getName()).append(" ").append(worker2.getSalary()).append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}