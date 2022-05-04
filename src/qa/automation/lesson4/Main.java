package qa.automation.lesson4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sortable sortByNameObject = new SortByName();
        Sortable sortByAgeObject = new SortByAge();

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person(15, "Dima"));
        people.add(new Person(23, "Kamil"));
        people.add(new Person(24, "Anna"));
        people.add(new Person(16, "Sasha K"));
        people.add(new Person(25, "Sasha H"));
        people.add(new Person(24, "Yulya"));
        people.add(new Person(21, "Damir"));
        people.add(new Person(24, "Nadya"));

        System.out.println(people);

        sortByAgeObject.sort(people);
        System.out.println(people);

        sortByNameObject.sort(people);
        System.out.println(people);

    }
}
