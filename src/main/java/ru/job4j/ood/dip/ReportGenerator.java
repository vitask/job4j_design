package ru.job4j.ood.dip;
    /*
    Класс ReportGenerator напрямую зависит от конкретной реализации
    FileManager в своем конструкторе, что делает его привязанным только
    к одному сервису отчетов
    */
public class ReportGenerator {

    private FileManager fileManager;

    public ReportGenerator() {
        fileManager = new FileManager();
    }

    public void generateReport() {
        fileManager.saveReport("Отчет");
    }
}
