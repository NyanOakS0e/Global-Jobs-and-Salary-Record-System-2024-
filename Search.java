package com.global_job_and_salary;

import java.util.LinkedList;

public class Search {

    // Search for the same object in the list and return that object if found
    public GlobalJobAndSalary search(String country, String jobTitle, String category, LinkedList<GlobalJobAndSalary> gjsList)
    {
        for(GlobalJobAndSalary gjs: gjsList)
        {
            if (gjs.getCountry().equalsIgnoreCase(country) && gjs.getJobTitle().equalsIgnoreCase(jobTitle) &&
                    gjs.getCategory().equalsIgnoreCase(category))
            {
                return gjs;
            }

        }
        return null;

    }

}
