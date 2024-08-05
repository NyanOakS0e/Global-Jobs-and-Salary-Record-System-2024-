package com.global_job_and_salary;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Sorting {

    public LinkedList<GlobalJobAndSalary> sortByCountryName(LinkedList<GlobalJobAndSalary> gjsList)
    {
        gjsList.sort(Comparator.comparing(GlobalJobAndSalary::getCountry));

        return gjsList;
    }

    public LinkedList<GlobalJobAndSalary> sortByLocalSalary(LinkedList<GlobalJobAndSalary> gjsList)
    {
        gjsList.sort(Collections.reverseOrder(Comparator.comparing(GlobalJobAndSalary::getSalary)));

        return gjsList;
    }

    public LinkedList<GlobalJobAndSalary> sortByCountryAndSalary(LinkedList<GlobalJobAndSalary> gjsList)
    {
        gjsList.sort(Comparator.comparing(GlobalJobAndSalary::getCountry).thenComparing(GlobalJobAndSalary::getSalary));

        return gjsList;
    }
}
