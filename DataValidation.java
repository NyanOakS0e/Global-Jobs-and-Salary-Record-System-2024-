package com.global_job_and_salary;

import java.util.LinkedList;

public class DataValidation {

    protected boolean validCountry(String country)
    {
        return country.matches("^[A-Z][a-zA-Z]*(\\s*[A-Z][a-zA-Z]*)*$");

    }
    protected boolean validJobTitle(String jobTitle)
    {
        return jobTitle.matches("^[A-Z][a-zA-Z]*(\\s*[A-Z][a-zA-Z]*)*$");
    }

    protected boolean validCategory(String category)
    {
        return category.matches("^[A-Z][a-zA-Z]*(\\s*[A-Z][a-zA-Z]*)*$");
    }
    protected boolean validSalary(String salary)

    {
        return salary.matches("[0-9]+");
    }

    protected boolean validCurrency(String currency)
    {
        return currency.matches("[A-Z]{3}");
    }


    protected boolean validExchangeRate(String exchangeRate)
    {
        return exchangeRate.matches("^\\d+(\\.\\d{1,10})?$");
    }


    public boolean validCountryJobTitleCategory(String country, String jobTitle,
                                                String category,
                                                LinkedList<GlobalJobAndSalary> gjsList)
    {
        for(GlobalJobAndSalary n:gjsList)
        {
            if(n.getCountry().equals(country)
                    && n.getJobTitle().equals(jobTitle)
                    && n.getCategory().equals(category))
            {
                return false;
            }
        }
        return true;
    }

    public boolean validCountryWithinTheSystem(String country, LinkedList<GlobalJobAndSalary> gjsList)
    {

        for(GlobalJobAndSalary n:gjsList)
        {
            if(n.getCountry().equalsIgnoreCase(country))
            {
                return true;
            }

        }
        return false;
    }
}
