package com.global_job_and_salary;


import de.vandermeer.asciitable.AsciiTable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestAndLowestSalaryJob {
    private LinkedList<GlobalJobAndSalary> gjsList;
    private WriteData writeData = new WriteData();
    private Sorting sort = new Sorting();
    private AsciiTableGenerate table = new AsciiTableGenerate();


    public HighestAndLowestSalaryJob(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }



    public void highestAndLowestSalaryJobReport()
    {

        LinkedList<GlobalJobAndSalary> orderedCountryAndSalary;
        System.out.println("===== Highest and Lowest Salary Job of Each Country =====");

        orderedCountryAndSalary = sort.sortByCountryAndSalary(gjsList);


        // Use map to group by country
        Map<String, List<GlobalJobAndSalary>> groupedByCountry = orderedCountryAndSalary.stream()
                .collect(Collectors.groupingBy(GlobalJobAndSalary::getCountry));

        LinkedList<GlobalJobAndSalary> firstAndLastJobs = new LinkedList<>();

        for (List<GlobalJobAndSalary> jobs : groupedByCountry.values()) {
            firstAndLastJobs.add(jobs.getFirst()); // First job
            if (jobs.size() > 1) {
                firstAndLastJobs.add(jobs.getLast()); // Last job
            }
        }

        writeData.writeData("data/HighestAndLowestSalaryJob.csv", sort.sortByCountryName(firstAndLastJobs));

        table.tableDraw(firstAndLastJobs);
    }
}
