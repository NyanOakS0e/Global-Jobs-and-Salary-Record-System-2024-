package com.global_job_and_salary;

public class Menu {

    UserInputs userInputs = new UserInputs();

    public void menu()
    {
        System.out.println("--------------------------------------");
        System.out.println("|    Global Jobs and Salaries Menu   |");
        System.out.println("--------------------------------------");
        System.out.println("1. Insert new job");
        System.out.println("2. Update the existing job");
        System.out.println("3. Delete the existing job");
        System.out.println("4. Selected country's all job report");
        System.out.println("5. Highest salary job and lowest salary job of each country report");
        System.out.println("6. List of countries sorting with the highest salary job report");
        System.out.println("7. Counting different job titles in each country report");
        System.out.println("8. Exit the program");
        System.out.println("--------------------------------------");
    }

}
