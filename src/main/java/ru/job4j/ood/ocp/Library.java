package ru.job4j.ood.ocp;

public class Library {

    public void takeBook(String book) {
        if (book.equals("роман")) {
            System.out.println("взял книку жанра роман");
        } else if (book.equals("фантастика")) {
            System.out.println("взял книку жанра фантастика");
        } else if (book.equals("детектив")) {
            System.out.println("взял книку жанра детектив");
        }
    }
}
