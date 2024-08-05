package com.global_job_and_salary;

import java.sql.SQLOutput;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    LinkedList<GlobalJobAndSalary> globalJobAndSalaries = new LinkedList<>();
    CrudOperationFactory crudOperationFactory = new CrudOperationFactory();
    public static void main(String[] args) {
        Main m = new Main();
//        String FILEPATH = "data/SampleData.csv";
        String FILEPATH = "data/global_jobs_salaries_2024.csv";
        ReadData rd = ReadData.getReadDataInstance();
        m.globalJobAndSalaries = rd.readData(FILEPATH);

        m.displayMenu();
    }

    private void displayMenu()
    {
        System.out.println("🔺Welcome to Global Jobs and Salary Records System🔺");
        Menu menu = new Menu();
        UserInputs userInputs = new UserInputs();
        menu.menu();

        switch (userInputs.userInput())
        {
            case (1):
                CrudOperation insert = crudOperationFactory.getCrudOperation("insert");

                long startTime = System.currentTimeMillis();
                insert.crudMethod(globalJobAndSalaries);
                long endTime = System.currentTimeMillis();

                System.out.println("Total Time taken is "+ (endTime-startTime)/1000 +" seconds");

                Runtime runtime = Runtime.getRuntime();
                runtime.gc();
                long memory = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Memory used in bytes "+ memory + " bytes");
                displayMenu();
                System.out.println();
            case (2):
                CrudOperation update = crudOperationFactory.getCrudOperation("update");
                update.crudMethod(globalJobAndSalaries);
                displayMenu();
            case(3):
                CrudOperation delete = crudOperationFactory.getCrudOperation("delete");
                delete.crudMethod(globalJobAndSalaries);
                displayMenu();
                System.out.println();
            case (4):
                SelectedCountryJobAndSalary selectedCountryJobAndSalary = new SelectedCountryJobAndSalary(globalJobAndSalaries);
                selectedCountryJobAndSalary.selectedCountryJobAndSalaryReport();
                displayMenu();
            case (5):
                HighestAndLowestSalaryJob highestAndLowestSalaryJob = new HighestAndLowestSalaryJob(globalJobAndSalaries);
                highestAndLowestSalaryJob.highestAndLowestSalaryJobReport();
                displayMenu();
            case (6):
               CountriesWithHighestSalaryJob highestSalaryJob = new CountriesWithHighestSalaryJob(globalJobAndSalaries);
               highestSalaryJob.countriesWithHighestSalaryJobReport();
                displayMenu();
            case (7):
                CountDifferentJobTitle countJobTitle = new CountDifferentJobTitle(globalJobAndSalaries);
                countJobTitle.countDifferentJobTitleReport();
                displayMenu();
            default:
                System.out.println("--- Thank you for using the system ---");
                System.out.println("System is exiting⛔");
                System.exit(0);
        }
    }
}