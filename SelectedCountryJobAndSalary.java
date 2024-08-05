package com.global_job_and_salary;

import javax.xml.crypto.Data;
import java.util.LinkedList;

public class SelectedCountryJobAndSalary {
    private LinkedList<GlobalJobAndSalary> gjsList;
    private UserInputs userInputs = new UserInputs();
    private WriteData writeData = new WriteData();
    private Sorting sort = new Sorting();
    private DataValidation dv = new DataValidation();
    private AsciiTableGenerate table = new AsciiTableGenerate();

    public SelectedCountryJobAndSalary(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void selectedCountryJobAndSalaryReport()
    {
        System.out.println("===== Selected Country Job and Salary Report =====");

        String country = userInputs.getCountry();
        LinkedList<GlobalJobAndSalary> selectedCountryList = new LinkedList<>();

        while(!dv.validCountryWithinTheSystem(country, gjsList))
        {
            System.out.println("No such country name found in the system");
            country = userInputs.getCountry();
        }

        for(GlobalJobAndSalary gjs: gjsList)
        {
            if(country.equalsIgnoreCase(gjs.getCountry()))
            {
                selectedCountryList.add(gjs);
            }

        }
        writeData.writeData("data/SelectedCountryJobandSalary.csv", sort.sortByLocalSalary(selectedCountryList));


        System.out.println("Report successfully generated");

        table.tableDraw(sort.sortByLocalSalary(selectedCountryList));
    }
}
