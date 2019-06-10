package com.bohdan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> bingoList =  Arrays.asList(
                "B45","B55",
                "F33", "F44",
                "L23","L35"
        );


//  Old code without Stream
//        List<String> fList = new ArrayList<>();
//        bingoList.forEach((String s1)-> {
//            if(s1.toUpperCase().startsWith("F")){
//                fList.add(s1);
//            }
//        });
//
//        fList.sort(Comparator.naturalOrder());
//        System.out.println(fList);

        //Using stream() will ease our life with less code
        bingoList.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("F"))
                .sorted()
                .forEach(System.out::println);

        Employees john = new Employees("John Mazin", 35, "Data Analyst");
        Employees jack = new Employees("Jack Rayner", 50, "HR");
        Employees tim = new Employees("Tim Watson", 23, "HR Lead");
        Employees sam = new Employees("Sam Canaren", 24, "Data Analyst Team Lead");
        Employees andrew = new Employees("Andrew McCormick", 34, "Data Analyst");
        Employees robert = new Employees("Robert Elliott", 44, "Project Manager");

        Departments hr = new Departments("HR");
        Departments dataTeam = new Departments("Data Analysts");
        List<Departments> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(dataTeam);

        dataTeam.addEmployee(john);
        dataTeam.addEmployee(sam);
        dataTeam.addEmployee(andrew);
        dataTeam.addEmployee(robert);
        hr.addEmployee(jack);
        hr.addEmployee(tim);

        departments.stream()
                .flatMap(departments1 -> departments1.getEmployee().stream())
                .forEach(System.out::println);

        List<String> employeeList = departments.stream()
                .map(departments1 -> departments1.getEmployee())
                .flatMap(l -> l.stream())
                .map(s -> s.getName())
                .collect(Collectors.toList());
        System.out.println(employeeList);


        //using the reduce method() - to combines all the items of the stream into a result
        departments.stream()
                .flatMap(departments1 -> departments1.getEmployee().stream())
                .reduce((e1,e2) -> e1.getAge()<e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

    }
}
