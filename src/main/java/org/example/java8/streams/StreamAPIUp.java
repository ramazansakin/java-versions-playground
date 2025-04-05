package org.example.java8.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


// Exercises
// 1- Filtering with Multiple Conditions: Filter the list to find all people who are older than 25 years and live in either "New York" or "Los Angeles".
// 2- Mapping with Transformation: Create a list of strings containing the names of all people in uppercase.
// 3- Sorting with Comparator: Sort the list of people first by city in ascending order, and then by age in descending order within each city.
// 4- Grouping and Counting: Group the list of people by their city, and then count the number of people in each city.
// 5- Aggregation with Mapping: Calculate the average age of people in each city.
// 6- Finding with Mapping: Find the oldest person in each city.
// 7- FlatMap Operation: Create a list of all unique cities where the people live.
// 8- Partitioning: Partition the list of people into two groups: one containing people older than 30 years and the other containing people younger than or equal to 30 years.
// 9- Reducing Operation: Find the person with the longest name in the list.
// 10- Advanced Filtering: Filter the list to find all people whose name contains the letter 'a', and then count the number of distinct cities they live in.

public class StreamAPIUp {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Abby", 45, "New York"));
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Adam", 55, "Chicago"));
        people.add(new Person("Bob", 30, "Los Angeles"));
        people.add(new Person("Charlie", 35, "Chicago"));
        people.add(new Person("Daniel", 22, "Seattle"));
        people.add(new Person("Seth", 16, "San Francisco"));
        people.add(new Person("Kai", 34, "Seattle"));
        people.add(new Person("David", 40, "San Francisco"));
        people.add(new Person("Ken", 37, "Los Angeles"));
        people.add(new Person("Tom", 79, "New York"));
        people.add(new Person("ObuObuhakamitabuha:)", 39, "Uganda"));
        people.add(new Person("Jonathan", 19, "Los Angeles"));
        people.add(new Person("Jane", 29, "Los Angeles"));

        // 1- Filtering with Multiple Conditions: Filter the list to find all people who are older than 25 years and live in either "New York" or "Los Angeles".
        List<Person> filteredPeople =
                people.stream()
                        .filter(person -> person.getAge() > 25)
                        .filter(person -> person.getCity().equals("New York") || person.getCity().equals("Los Angeles"))
                        .toList();

        // Enhanced for-loop
        for (Person person : filteredPeople) {
            System.out.println(person);
        }

        System.out.println("-------------------------------------------------------------------");

        // 2- Mapping with Transformation: Create a list of strings containing the names of all people in uppercase.
        List<String> upperNames =
                people.stream()
                        .map(person -> person.getName().toUpperCase(Locale.ROOT))
                        .toList();

        upperNames.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // 3- Sorting with Comparator: Sort the list of people first by city in ascending order, and then by age in descending order within each city.
        List<Person> sortedPeople = people.stream().sorted(new PersonCityAndAgeComparator()).toList();
        sortedPeople.forEach(System.out::println);

        // 3-2 Alternative
        // Sorting using Comparator
        Comparator<Person> cityComparator = Comparator.comparing(Person::getCity);  // Default ASC
        Comparator<Person> ageComparatorDesc = Comparator.comparing(Person::getAge).reversed(); // DESC

        // !!! If Collections used like below, the actual list ll be sorted!!!
        // Sort first by city in ascending order, then by age in descending order within each city
        people.sort(cityComparator.thenComparing(ageComparatorDesc));

        // Print sorted list
        people.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");


        // 4- Grouping and Counting: Group the list of people by their city, and then count the number of people in each city.
        people.stream()
                .collect(Collectors.groupingBy(Person::getCity))
                .forEach((city, peopleList) -> System.out.printf("%s -> %d\n", city, peopleList.size()));


        System.out.println("-------------------------------------------------------------------");

        // 5- Aggregation with Mapping: Calculate the average age of people in each city.
        people.stream()
                .collect(Collectors.groupingBy(Person::getCity))
                .forEach((city, peopleList) -> {
                            double avg = peopleList.stream().mapToInt(Person::getAge).average().orElse(0.0);
                            System.out.printf("%s -> average age : %.2f\n", city, avg);
                        }
                );

        // 5-2 Alternative :
        // Calculate the average age of people in each city
        Map<String, Double> averageAgeByCity = people.stream()
                .collect(Collectors.groupingBy(
                                Person::getCity,
                                Collectors.averagingDouble(Person::getAge)
                        )
                );

        System.out.println("-------------------------------------------------------------------");

        // 6- Finding with Mapping: Find the oldest person in each city.
        Map<String, Optional<Person>> oldestPersonByCity = people.stream().collect(
                Collectors.groupingBy(
                        Person::getCity,
                        Collectors.maxBy(Comparator.comparing(Person::getAge))
                )
        );

        oldestPersonByCity.forEach((city, person) -> System.out.printf("%s -> oldest person : %s\n", city, person.get()));

        // 6.2- All people names for each city
        people.stream().collect(
                Collectors.groupingBy(
                        Person::getCity,
                        Collectors.mapping(Person::getName, Collectors.toList())
                )
        ).forEach((cityName, peopleNAmeList) -> {
            System.out.println(cityName);
            peopleNAmeList.forEach(System.out::println);
        });


        System.out.println("-------------------------------------------------------------------");

        // 7- FlatMap Operation: Create a list of all unique cities where the people live.
        List<String> allCities = people.stream().map(Person::getCity).distinct().toList();
        allCities.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");


        // 8-  Partitioning: Partition the list of people into two groups: one containing people older than 30 years
        //     and the other containing people younger than or equal to 30 years.
        Predicate<Person> condition = person -> person.getAge() > 30;
        Map<Boolean, List<Person>> partitioning30 = people.stream().collect(
                Collectors.partitioningBy(
                        condition
                )
        );

        List<Person> olderPeople30 = partitioning30.get(true);
        List<Person> youngerOrEqualPeople30 = partitioning30.get(false);

        System.out.println("The Older partition: ");
        olderPeople30.forEach(System.out::println);

        System.out.println("The Younger partition: ");
        youngerOrEqualPeople30.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");


        // 9-  Reducing Operation: Find the person with the longest name in the list
        Person oldestPerson = people.stream()
                .collect(
                        Collectors.maxBy(Comparator.comparing(person -> person.getName().length())
                        )
                ).orElseThrow(() -> new RuntimeException("There is no person in the list!"));

        // 9-2 : alternative
        Person oldestPerson2 = people.stream()
                .max(Comparator.comparing(person -> person.getName().length()))
                .orElseThrow(() -> new RuntimeException("There is no person in the list!"));

        System.out.println("The Person with the longest name : " + oldestPerson);

        System.out.println("-------------------------------------------------------------------");

        // 10- Advanced Filtering: Filter the list to find all people whose name contains the letter 'a',
        // and then count the number of distinct cities they live in.

        // Filter the list to find all people whose name contains the letter 'a'
        List<Person> filteredPeopleList = people.stream()
                .filter(person -> person.getName().toLowerCase().contains("a"))
                .toList();

        // Count the number of distinct cities they live in
        int distinctCities = filteredPeopleList.stream()
                .map(Person::getCity)
                .collect(Collectors.toSet())
                .size();

        long distinctCitiesByPeopleNamedStartingA = people.stream()
                .filter(person -> person.getName().startsWith("A"))
                .map(Person::getCity)
                .distinct()
                .count();

        System.out.println("Related distinct city number : " + distinctCitiesByPeopleNamedStartingA);

        System.out.println("-------------------------------------------------------------------");

    }


    // 3
    public static class PersonCityAndAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            // Compare names using natural ordering (lexicographic order)
            int comp = p1.getCity().compareTo(p2.getCity());
            if (comp == 0) return Integer.compare(p2.getAge(), p1.getAge());
            else return comp;
        }

    }

}