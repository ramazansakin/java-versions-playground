package org.example.java8.streams;


import java.util.*;
import java.util.stream.Collectors;

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String city;

    private List<String> hobbies;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Person(String name, int age, String city, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.getAge(), o.getAge());
    }

}

// Exercises - Basic
// 1- Filtering: Filter the list to find all people who are older than 30 years.
// 2- Mapping: Create a list of strings containing only the names of all people in the list.
// 3- Sorting: Sort the list of people by their age in ascending order.
// 4- Grouping: Group the list of people by their city.
// 5- Aggregation: Calculate the average age of all people in the list.
// 6- Find: Find the first person in the list who is from "Los Angeles".
// 7- Count: Count the number of people in the list who are younger than 25 years.
// 8- Limit and Skip: Get the first 3 people from the list and then skip the first 2 people and print the rest
// 9- All Match: Check if all people in the list are older than 18 years.
// 10- Any Match: Check if there is at least one person in the list from "Chicago".

public class StreamAPIIntermediate {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", 30, "Los Angeles"));
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Charlie", 35, "Chicago"));
        people.add(new Person("Daniel", 16, "Seattle"));
        people.add(new Person("Adam", 55, "Chicago"));
        people.add(new Person("Seth", 16, "San Francisco"));
        people.add(new Person("Kai", 34, "Seattle"));
        people.add(new Person("David", 40, "San Francisco"));
        people.add(new Person("Keith", 23, "Chicago"));
        people.add(new Person("Furry", 16, "San Francisco"));
        people.add(new Person("Santa", 34, "Seattle"));
        people.add(new Person("Rei", 40, "Miami"));

        // 1- Filtering: Filter the list to find all people who are older than 30 years.
        List<Person> peopleOlderThan30 = people.stream().filter(person -> person.getAge() > 30).toList();
        peopleOlderThan30.forEach((person) -> {
            System.out.println(person);
        });

        System.out.println("-------------------------------------------------------------------");

        // 2- Mapping: Create a list of strings containing only the names of all people in the list.
        List<String> peopleNames = people.stream().map(person -> person.getName()).toList();
        peopleNames.forEach(name -> System.out.println(name));

        System.out.println("-------------------------------------------------------------------");

        // 3- Sorting: Sort the list of people by their age in ascending order.
        List<Person> ageOrderedPeople = people.stream().sorted().toList();
        ageOrderedPeople.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        List<Person> nameOrderedPeople = people.stream().sorted(new PersonNameComparator().reversed()).toList();
        Collections.sort(people, new PersonNameComparator());

        nameOrderedPeople.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // 4- Grouping: Group the list of people by their city.
        Map<String, Long> peopleByCity = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
//        System.out.println(peopleByCity);

        // Tuple -> Map Entry
        peopleByCity.forEach((city, peopleSize) -> System.out.println("City: " + city + ", peopleSize: " + peopleSize));

        System.out.println("-------------------------------------------------------------------");


        // 5- Aggregation: Calculate the average age of all people in the list.
        double averageAgePeople = people.stream().mapToInt(Person::getAge).average().orElse(0.0);
        System.out.println("Average age of people : " + averageAgePeople);

        System.out.println("-------------------------------------------------------------------");


        // 6- Find: Find the first person in the list who is from "Los Angeles".
        Optional<Person> person = people.stream().filter(person1 -> person1.getCity().equals("Los Angeles")).findFirst();

        // Ternary if-else
        String personName = person.isPresent() ? person.get().getName() : "No person";
        System.out.println("First Person from San Francisco : " + personName);

        System.out.println("-------------------------------------------------------------------");


        // 7- Count: Count the number of people in the list who are younger than 25 years.
        long numberOfYoungerPeople25 = people.stream().filter(person1 -> person1.getAge() < 25).count();
        System.out.println("Number of people who are younger than 25 years old: " + numberOfYoungerPeople25);

        System.out.println("-------------------------------------------------------------------");


        // 8- Limit and Skip: Get the first 3 people from the list and then skip the first 2 people and print the rest
        List<Person> limitedPeople = people.stream().skip(2).limit(3).toList();
//        limitedPeople.forEach(System.out::println);

        people.stream()
                .limit(3) // Get the first 3
                .peek(System.out::println) // Print them
                .skip(2) // Skip the next 2
                .forEach(System.out::println); // Print the remaining 1


        System.out.println("-------------------------------------------------------------------");

        // 9- All Match: Check if all people in the list are older than 18 years.
        boolean isAllPeopleAgeOlderThan18 = people.stream().allMatch(person1 -> person1.getAge() > 18);
        System.out.println("Are all the people's ages greater than 18 : " + isAllPeopleAgeOlderThan18);


        // 10- Any Match: Check if there is at least one person in the list from "Chicago".
        boolean anyPersonFromChicago = people.stream().anyMatch(person1 -> person1.getCity().equals("Chicago"));
        System.out.println("Is there anybody from Chicago : " + anyPersonFromChicago);

        System.out.println("-------------------------------------------------------------------");

        // Sorting by age in ascending order, then by name in alphabetical order desc (reverse order)
        people.sort(
                Comparator.comparingInt(Person::getAge)
                        .thenComparing(Comparator.comparing(Person::getName).reversed())
        );

        // Displaying the sorted list
        System.out.println("Sorted people:");
        people.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");


        // **
        // 11- Group all the people with city, and map it to average age of each city
        Map<String, Double> avgAgeByCity =
                people.stream().collect(
                        Collectors.groupingBy(
                                Person::getCity,
                                Collectors.averagingDouble(Person::getAge)    // List<Person> -> Double
                        )
                );

        System.out.println("Average of age by city:");
        avgAgeByCity.forEach((city, ageAvg) ->
                System.out.printf("%s : %.2f\n", city, ageAvg));

        System.out.println("-------------------------------------------------------------------");

    }

    static class PersonNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            // Compare names using natural ordering
            return p1.getName().compareTo(p2.getName());
        }
    }

}