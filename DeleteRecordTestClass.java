package com.global_job_and_salary;

import java.util.LinkedList;
import java.util.Scanner;

public class DeleteRecordTestClass {
    public LinkedList <GlobalJobAndSalary> gjsList = new LinkedList<>();
    WriteData writeData = new WriteData();
    Sorting sort = new Sorting();
    Search search = new Search();

    Scanner sc = new Scanner(System.in);
    public DeleteRecordTestClass(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void delete()
    {
        System.out.println("===== Delete Record ======");
        System.out.println("Input Country Name");
        String country = sc.nextLine();
        System.out.println("Input Job Title");
        String jobTitle = sc.nextLine();
        System.out.println("Input Category");
        String category = sc.nextLine();

        GlobalJobAndSalary deleteObj = search.search(country, jobTitle, category, gjsList);

        gjsList.remove(deleteObj);

        writeData.writeData("data/global_jobs_salaries_2024.csv", sort.sortByCountryName(gjsList));
        System.out.println("== Successfully deleted ==");
    }

}
