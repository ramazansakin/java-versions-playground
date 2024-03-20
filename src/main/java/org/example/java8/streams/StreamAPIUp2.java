package org.example.java8.streams;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPIUp2 {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Abby", 45, "New York", null));
        people.add(new Person("Alice", 25, "New York", List.of("Football", "Video Games")));
        people.add(new Person("Adam", 55, "Chicago", List.of("Basketball", "Video Games")));
        people.add(new Person("Bob", 30, "Los Angeles", null));
        people.add(new Person("Charlie", 35, "Chicago", null));
        people.add(new Person("Daniel", 22, "Seattle", List.of("Table Tennis")));
        people.add(new Person("Ash", 32, "Seattle", List.of("Video Games")));
        people.add(new Person("Seth", 16, "San Francisco", null));
        people.add(new Person("Kai", 34, "Seattle", List.of("Hentball", "Volleyball")));
        people.add(new Person("David", 40, "San Francisco", List.of("Volleyball", "Painting")));
        people.add(new Person("Ken", 37, "Los Angeles", List.of("Swimming")));
        people.add(new Person("Tom", 79, "New York", List.of("Camping", "Fishing")));
        people.add(new Person("Jonathan", 19, "Los Angeles", null));
        people.add(new Person("Jane", 29, "Los Angeles", List.of("Camping", "Fishing")));


        System.out.println("-------------------------------------------------------------------");
        // Filtering and Mapping:
        // Write a lambda expression to filter the list of people above to include only those who are older than 30.
        // Map the filtered list to a list of strings containing only the names of the people.
        List<String> peopleNamesUp30 = people.stream().filter(person -> person.getAge() > 30).map(person -> person.getName().toUpperCase()).toList();
        peopleNamesUp30.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");
        // Sorting and Grouping:
        // Sort the list of people by their age in descending order.
        // Group the sorted list by the city they live in, creating a Map<String, List<Person>> where the key is the city name.
        Map<String, List<Person>> sortedPeopleByCityMap = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.groupingBy(Person::getCity));
        sortedPeopleByCityMap.forEach((city, peopleList) -> {
            System.out.println("City : " + city + " --> People : ");
            peopleList.forEach(System.out::println);
        });

        System.out.println("-------------------------------------------------------------------");
        // Aggregation and Reduction:
        // Find the average age of people in the list using streams and the Collectors.averagingInt method.
        // Find the oldest person in the list using the Collectors.maxBy method.
        Double avgAge = people.stream().collect(Collectors.averagingInt(Person::getAge));
        Person oldestPerson = people.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge))).orElseThrow(() -> new RuntimeException("No person in list!"));
        // "max" can be used directly instead of using "collect with maxBy"
        Person oldestPerson2 = people.stream().max(Comparator.comparing(Person::getAge)).orElseThrow(() -> new RuntimeException("No person in list!"));

        System.out.println("Oldest person : " + oldestPerson + " --- average age : " + avgAge);


        System.out.println("-------------------------------------------------------------------");
        // Combining Operations:
        // Filter the list to include only people aged 25 or younger.
        // Map the filtered list to a list of strings containing their names.
        // Sort the names alphabetically.
        // Collect the sorted names into a new list.
        List<String> peopleNamesUp25 = people.stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                .sorted()
                .toList();

        peopleNamesUp25.forEach(System.out::println);


        System.out.println("-------------------------------------------------------------------");
        // Conditional Mapping:
        // Use the Collectors.groupingBy method to group people by their age range (e.g., 0-20, 21-40, 41-60, 61+).
        //      Map each age range to a string describing the range (e.g., "0-20", "21-40", etc.).
        //      Collect the mapping into a Map<String, List<Person>>.
        Map<String, List<Person>> peopleByAgeRange = people.stream().collect(Collectors.groupingBy(
                person -> {
                    int age = person.getAge();
                    if (age <= 20) return "0-20";
                    else if (age <= 40) return "21-40";
                    else if (age <= 60) return "41-60";
                    else return "61+";
                }
        ));

        peopleByAgeRange.forEach((ageRange, peopleList) -> {
            System.out.println("Age Range : " + ageRange + " --> People : ");
            peopleList.forEach(System.out::println);
        });


        System.out.println("-------------------------------------------------------------------");
        // Chaining Predicates 1:
        // Define multiple predicates using lambda expressions to filter the list of people.
        // Chain these predicates together using the Predicate.and method to create a single predicate.
        // Use the combined predicate to filter the list.

        // Filter 1
        Predicate<Person> hasEvenAge = person -> person.getAge() % 2 == 0;

        // Filter 2
        Predicate<Person> startsNameWithA = person -> person.getName().startsWith("A");

        Predicate<Person> combinedFilter = hasEvenAge.and(startsNameWithA);

        List<Person> combinedFilteredList = people.stream().filter(combinedFilter).toList();
        combinedFilteredList.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");
        // Chaining Predicates 2
        // Define multiple predicates using lambda expressions to filter the list of people.
        // Chain these predicates together using the Predicate.and method to create a single predicate.
        // Use the combined predicate to filter the list.

        // Filter 1
        BiPredicate<Person, String> isStartingNameWith = (person, prefix) -> person.getName().startsWith(prefix);

        // Filter 2
        BiPredicate<Person, String> isLivingInCity = (person, city) -> person.getCity().equals(city);

        // If the parameters of both predicates same, we can chain them
        BiPredicate<Person, String> combined = isLivingInCity.and(isStartingNameWith);


        // Combine filters using Predicate.and
        Predicate<Person> combinedFilter2 = person ->
                isStartingNameWith.test(person, "T") && isLivingInCity.test(person, "New York");

        List<Person> doubleFilteredPeople = people.stream().filter(combinedFilter2).toList();

        doubleFilteredPeople.forEach(System.out::println);


        System.out.println("-------------------------------------------------------------------");
        // FlatMapping:
        // Create a list of hobbies for each person.
        // Use flatMap to flatten the list of lists into a single list of hobbies.
        // Collect the distinct hobbies into a Set.
        Set<String> allHobbies = people.stream()
                .filter(person -> person.getHobbies() != null)
                .flatMap(person -> person.getHobbies().stream())
                .collect(Collectors.toSet());
        allHobbies.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

    }

}
