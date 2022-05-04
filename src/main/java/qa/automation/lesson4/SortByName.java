package qa.automation.lesson4;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByName implements Sortable {
    @Override
    public void sort(ArrayList<Person> array) {
        if (array.size() == 0) {
            System.out.println("Can't sort empty array");
        } else if (array.get(0) == null) {
            System.out.println("Can't sort array of non Person");
        } else {
            array.sort(Comparator.comparing(Person::getName));
        }
    }
}
