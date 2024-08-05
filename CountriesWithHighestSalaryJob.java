package com.global_job_and_salary;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountriesWithHighestSalaryJob {
    private LinkedList<GlobalJobAndSalary> gjsList;
    private WriteData writeData = new WriteData();
    private Sorting sort = new Sorting();
    private AsciiTableGenerate table = new AsciiTableGenerate();

    private LinkedList<GlobalJobAndSalary> highestSalaryJobs;
    public CountriesWithHighestSalaryJob(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void countriesWithHighestSalaryJobReport()
    {
        System.out.println("======== Countries with Highest Salary Job ========");

        highestSalaryJobs = sort.sortByLocalSalary(gjsList);


        Map<String, List<GlobalJobAndSalary>> groupedByCountry = highestSalaryJobs.stream()
                .collect(Collectors.groupingBy(GlobalJobAndSalary::getCountry));

        LinkedList<GlobalJobAndSalary> highestSalaryJobsForEachCountries = new LinkedList<>();

        for (List<GlobalJobAndSalary> jobs : groupedByCountry.values()) {
            highestSalaryJobsForEachCountries.add(jobs.getFirst()); // First job

        }
        writeData.writeData("data/HighestSalaryJobs.csv", sort.sortByCountryName(highestSalaryJobsForEachCountries));

        table.tableDraw(highestSalaryJobsForEachCountries);
    }
}
