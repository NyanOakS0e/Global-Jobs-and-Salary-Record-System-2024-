package com.global_job_and_salary;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertNewJobAndSalary implements CrudOperation{

    protected LinkedList<GlobalJobAndSalary> gjs_List;
    private UserInputs userInputs = new UserInputs();
    private DataValidation dv = new DataValidation();
    private WriteData writeData = new WriteData();
    private Sorting sort = new Sorting();
//    public InsertNewJobAndSalary(LinkedList<GlobalJobAndSalary> gjsList)
//    {
//        this.gjsList = gjsList;
//    }

    @Override
    public void crudMethod(LinkedList <GlobalJobAndSalary> gjsList) {

        this.gjs_List = gjsList;
        System.out.println("==========Insert New Data==========");
        String country = userInputs.getCountry();
        while(!dv.validCountryWithinTheSystem(country, gjsList))
        {
            System.out.println("No such country name exists");
            country = userInputs.getCountry();
        }
        String jobTitle = userInputs.getJobTitle();
        String category = userInputs.getCategory();



        while(!dv.validCountryJobTitleCategory(country, jobTitle, category, gjsList))
        {
            System.out.println("Job with same category and same job title in the same country exists");
            country = userInputs.getCountry();
            jobTitle = userInputs.getJobTitle();
            category = userInputs.getCategory();
        }
        long salary = Long.parseLong(userInputs.getSalary());
        String currency = userInputs.getCurrency();
        float exchangeRate = Float.parseFloat(userInputs.getExchangeRate());

        gjsList.add(new GlobalJobAndSalary(country,jobTitle,category,salary,currency,exchangeRate,salary/exchangeRate));
        writeData.writeData("data/global_jobs_salaries_2024.csv", sort.sortByCountryName(gjsList));
        System.out.println("== New job record is successfully added to the CSV file ==");
    }
}
