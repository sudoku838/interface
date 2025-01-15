package interfaise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Сортировка {
    static class Company {
        String name; //название
        int persons; //количество сотрудников
        int money; // месячный фонд заработной платы

        public String getName() { // свойство
            return name;
        }

        public int getPersons() { // свойство
            return persons;
        }

        public Company(
                String name, int persons, int money) {
            this.name = name;
            this.persons = persons;
            this.money = money;
        }

        //  печать информации о компании
        public void show() {
            System.out.println("В компании " + name +
                    " трудятся " + persons + " сотрудников ");
            System.out.println("Фонд зарплаты: " + money);
        }

        // описания других методов – см. пример 3.4
    } // класс Company

    // создание класса для сравнения объектов по
    // первому критерию - количество сотрудников
    static class Count implements Comparator<Company> {
        public int compare(Company x, Company y) {
            if (x.getPersons() > y.getPersons())
                return 1;
            else if (x.getPersons() < y.getPersons())
                return -1;
            else
                return 0;
        }
    }

    // создание класса для сравнения объектов по
    // второму критерию – названию компании
    static class CName implements Comparator<Company> {
        public int compare(Company x, Company y) {
            if (x.getName().compareToIgnoreCase(y.getName()) > 0)
                return 1;
            else
            if (x.getName().compareToIgnoreCase(y.getName()) < 0)
                return -1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        List<Company> comp1 = new ArrayList<Company>() {
                new Company("ABCD3", 102, 900001),
                new Company("ABCD1", 101, 900002),
                new Company("ABCD2", 100, 900003)
        };

        for (Company z : comp1)
            z.show();

        // создание экземпляра класса, реализующего
        // сравнение объектов по
        // количеству сотрудников
        Count SortPersons = new Count();

        // сортировка по количеству сотрудников
        Collections.sort(comp1, SortPersons);

        // вывод результата сортировки
        System.out.println("Результат сортировки:");
        for (Company z : comp1)
            z.show();

        // создание экземпляра класса, реализующего
        // сравнение  объектов по названию компании
        CName SortName = new CName();

        // сортировка по названию компании
        Collections.sort(comp1, SortName);

        // вывод результата сортировки
        System.out.println("Результат сортировки:");
        for (Company z : comp1)
            z.show();
    }
}

