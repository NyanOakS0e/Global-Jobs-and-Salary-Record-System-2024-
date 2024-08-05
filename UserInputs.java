package com.global_job_and_salary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInputs {
    public Scanner sc = new Scanner(System.in);
    private DataValidation dv = new DataValidation();


    public int userInput()
    {
        System.out.print("Enter menu number between 1 and 8: ");
        String input = sc.nextLine();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));

        while(!list.contains(input))
        {
            System.out.println("-- Enter only number between 1 and 8 --");

            System.out.print("Enter: ");
            input = sc.nextLine();

        }
        return Integer.parseInt(input);
    }


    public String getCountry()
    {
        System.out.print("Enter Country Name ");
        String country = sc.nextLine();
        if(!dv.validCountry(country))
        {
            System.out.print("-- Every first letter must be capital case --\n");
            country = getCountry();
        }
        return country;
    }

    public String getJobTitle()
    {
        System.out.print("Enter job title ");
        String jobTitle = sc.nextLine();
        if(!dv.validJobTitle(jobTitle))
        {
            System.out.print("-- Enter valid job title (e.g, Software Developer) --\n");
            jobTitle = getJobTitle();

        }
        return jobTitle;
    }

    public String getCategory()
    {
        System.out.print("Enter category ");
        String category = sc.nextLine();
        if(!dv.validCategory(category))
        {
            System.out.print("-- First letter must be capital case --\n");

            category = getCategory();
        }
        return category;
    }
    public String getSalary()
    {
        System.out.print("Enter local salary ");
        String salary = sc.nextLine();
        if(!dv.validSalary(salary))
        {
            System.out.print("-- Enter valid local salary --\n");
            salary = getSalary();
        }
        return salary;
    }

    public String getExchangeRate()
    {
        System.out.print("Enter exchange rate ");
        String exchangeRate = sc.nextLine();
        if(!dv.validExchangeRate(exchangeRate))
        {
            System.out.print("-- Enter valid exchange rate --\n");
            exchangeRate = getExchangeRate();
        }
        return exchangeRate;
    }

    public String getCurrency()
    {
        System.out.print("Enter currency ");
        String currency = sc.nextLine();
        if(!dv.validCurrency(currency))
        {
            System.out.print("-- Enter valid currency (e.g, MMK) --\n");
            currency = getCurrency();
        }
        return currency;
    }





}
