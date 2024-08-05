package com.global_job_and_salary;

import java.util.LinkedList;
import java.util.Scanner;

public class UpdateRecordTestClass {
    public LinkedList <GlobalJobAndSalary> gjsList = new LinkedList<>();
    WriteData writeData = new WriteData();
    Sorting sort = new Sorting();
    Search search = new Search();

    Scanner sc = new Scanner(System.in);
    public UpdateRecordTestClass(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void update()
    {
        System.out.println("===== Update Record ======");
        System.out.println("Input Country Name");
        String country = sc.nextLine();
        System.out.println("Input Job Title");
        String jobTitle = sc.nextLine();
        System.out.println("Input Category");
        String category = sc.nextLine();

        GlobalJobAndSalary updateObj = search.search(country, jobTitle, category, gjsList);

        System.out.println("Enter update country");
        updateObj.setCountry(sc.nextLine());

        System.out.println("Enter update job title");
        updateObj.setJobTitle(sc.nextLine());

        System.out.println("Enter update category");
        updateObj.setCategory(sc.nextLine());

        System.out.println("Enter update salary");
        updateObj.setSalary(Long.parseLong(sc.nextLine()));

        System.out.println("Enter update currency");
        updateObj.setCurrency(sc.nextLine());

        System.out.println("Enter update exchange rate");
        updateObj.setExchangeRate(Float.parseFloat(sc.nextLine()));

        updateObj.setUsdSalary(updateObj.getSalary()/updateObj.getExchangeRate());

        writeData.writeData("data/global_jobs_salaries_2024.csv", sort.sortByCountryName(gjsList));
        System.out.println("== Successfully updated ==");
    }

}
