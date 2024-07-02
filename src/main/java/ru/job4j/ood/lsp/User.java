package ru.job4j.ood.lsp;

/*
    Нарушение LSP, так как возвращаемый тип изменен
 */

public class User {
    String loadDerails() {
        return "User Details";
    }
}

class AdminUser extends User {
    Integer loadDetails() {
        return 123;
    }
}
