package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        // Filter Odd Numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNumbers = numbers.stream()
                .filter(isOdd)
                .toList();
        System.out.println("Odd numbers: " + oddNumbers + "\n");

        // Filter Strings Starting with 'A'
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        List <String> withANames = names.stream().filter(startsWithA).toList();
        System.out.println("Names starting with A: " + withANames +  "\n");

        // Square All Numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers1.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squared numbers: " + squaredNumbers + "\n");

        // Combine Predicates
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        List<Integer> evenAndGreaterThanFive = numbers2.stream().filter(isEven.and(greaterThanFive)).toList();
        System.out.println("Even and > 5: " + evenAndGreaterThanFive +  "\n");

        // Sort Objects Using Comparator
        List<Person> names1 = Arrays.asList(
                new Person("Luis", 40),
                new Person("Gideon", 28),
                new Person("Kayne", 35),
                new Person("Dzelle", 21),
                new Person("Earl", 20)
        );

        names1.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Sorted by age (ascending):");
        for (Person person : names1) {
            System.out.println(person);
        }
        System.out.println(" ");

        names1.sort(Comparator.comparing(Person::getName));
        System.out.println("Sorted by name:");
        for (Person person : names1) {
            System.out.println(person);
        }
        System.out.println(" ");

        names1.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println("Sorted by age (ascending):");
        for (Person person : names1) {
            System.out.println(person);
        }
        System.out.println(" ");
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}