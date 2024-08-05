package com.global_job_and_salary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class WriteData{


    public void writeData(String fileName, LinkedList<GlobalJobAndSalary> gjsList) {
        try
        {
            FileWriter fw = new FileWriter(fileName, false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Country,Job Title,Category,Salary,Currency,Exchange Rate, Salary(USD)");

            for(GlobalJobAndSalary n:gjsList)
            {

                pw.println(n.getCountry()+","+n.getJobTitle()+","+n.getCategory()+","+n.getSalary()+","+n.getCurrency()
                        +","+n.getExchangeRate()+","+n.getUsdSalary());
            }
            pw.close();
            fw.close();

            System.out.println("New data successfully saved");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
