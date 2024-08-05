package com.global_job_and_salary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class InsertRecordTestClass {
    public LinkedList <GlobalJobAndSalary> gjsList = new LinkedList<>();
    UserInputs userInputs = new UserInputs();
    DataValidation dv = new DataValidation();
    WriteData writeData = new WriteData();
    Sorting sort = new Sorting();

    Scanner sc = new Scanner(System.in);
    public InsertRecordTestClass(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void insert()
    {
        System.out.println("===== Insert New Record ======");
        System.out.println("Input Country Name");
        String country = sc.nextLine();
        System.out.println("Input Job Title");
        String jobTitle = sc.nextLine();
        System.out.println("Input Category");
        String category = sc.nextLine();

        while(!dv.validCountryJobTitleCategory(country, jobTitle, category, gjsList))
        {
            country = sc.nextLine();
            jobTitle = sc.nextLine();
            category = sc.nextLine();
        }
        System.out.println("Input Salary");
        String salary = sc.nextLine();
        System.out.println("Input Currency");
        String currency = sc.nextLine();
        System.out.println("Input Exchange Rate");
        String exchangeRate = sc.nextLine();

        long salaryUpdate = Long.parseLong(salary);
        float exchange = Float.parseFloat(exchangeRate);

        float usdSalary = salaryUpdate / exchange;

        gjsList.add(new GlobalJobAndSalary(country,jobTitle,category,salaryUpdate,currency,exchange,usdSalary));
        writeData.writeData("data/global_jobs_salaries_2024.csv", sort.sortByCountryName(gjsList));
        System.out.println("== New job record is successfully added to the CSV file ==");
    }

}
