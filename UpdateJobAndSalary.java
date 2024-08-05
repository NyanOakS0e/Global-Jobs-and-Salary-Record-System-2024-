package com.global_job_and_salary;

import java.util.LinkedList;
import java.util.Scanner;

public class UpdateJobAndSalary implements CrudOperation{
    private LinkedList<GlobalJobAndSalary> gjs_List = new LinkedList<>();
    private Search search = new Search();
    private UserInputs inputs = new UserInputs();
    private DataValidation dv = new DataValidation();
    private WriteData writeData = new WriteData();
    private Scanner sc = new Scanner(System.in);

//    public UpdateJobAndSalary(LinkedList<GlobalJobAndSalary> gjsList)
//    {
//        this.gjs_List = gjsList;
//    }

    @Override
    public void crudMethod(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjs_List = gjsList;
        System.out.println("============== Update Existing job and Salary =============");
        String country = inputs.getCountry();
        String jobTitle = inputs.getJobTitle();
        String category = inputs.getCategory();
        GlobalJobAndSalary updateObj;
        while((updateObj = search.search(country, jobTitle, category, gjsList))== null)
        {
            System.out.println("-- Data not found in the file --");
            country = inputs.getCountry();
            jobTitle = inputs.getJobTitle();
            category = inputs.getCategory();
        }

        System.out.println("======== Data Found =========\n");
        System.out.println("-- Please enter new country --");
        String updateCountry = inputs.getCountry();
        System.out.println("-- Please enter new job title --");
        String updateJobTitle = inputs.getJobTitle();
        System.out.println("-- Please enter new category --");
        String updateCategory = inputs.getCategory();
        System.out.println("-- Please enter new local salary-- ");
        String updateLocalSalary = inputs.getSalary();
        System.out.println("-- Please enter new currency -- ");
        String updateCurrency = inputs.getCurrency();
        System.out.println("-- Please enter new exchange rate -- ");
        String updateExchangeRate = inputs.getExchangeRate();
        updateObj.setCountry(updateCountry);

        updateObj.setJobTitle(updateJobTitle);

        updateObj.setCategory(updateCategory);

        updateObj.setSalary(Long.parseLong(updateLocalSalary));

        updateObj.setCurrency(updateCurrency);
        updateObj.setExchangeRate(Float.parseFloat(updateExchangeRate));
        updateObj.setUsdSalary(Long.parseLong(updateLocalSalary)/Float.parseFloat(updateExchangeRate));
        writeData.writeData("data/global_jobs_salaries_2024.csv", gjsList);
        System.out.println("-- Data Successfully Updated --");
    }
}
