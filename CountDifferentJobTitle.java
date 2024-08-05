package com.global_job_and_salary;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;


public class CountDifferentJobTitle {
    private LinkedList<GlobalJobAndSalary> gjsList;
    private AsciiTableGenerate table = new AsciiTableGenerate();

    public CountDifferentJobTitle(LinkedList<GlobalJobAndSalary> gjsList) {
        this.gjsList = gjsList;
    }

    public void countDifferentJobTitleReport()
    {
        System.out.println("=========Count Different Job Titles===========");

        HashMap<String, Set<String>> jobTitlesByCountry = new HashMap<>();

        // fill the map with job titles
        for (GlobalJobAndSalary job : gjsList) {
            String country = job.getCountry();
            String jobTitle = job.getJobTitle();

            if (!jobTitlesByCountry.containsKey(country))
            {
                jobTitlesByCountry.put(country, new HashSet<>());
            }

            jobTitlesByCountry.get(country).add(jobTitle);
        }

        // Map to store the count of unique job titles
        HashMap<String, Integer> jobTitleCountByCountry = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : jobTitlesByCountry.entrySet())
        {
            jobTitleCountByCountry.put(entry.getKey(), entry.getValue().size());
        }


        TreeMap<String,Integer> finalSortedList = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : jobTitleCountByCountry.entrySet())
        {
            finalSortedList.put(entry.getKey(), entry.getValue());
        }

        //File write
        try
        {
            FileWriter fw = new FileWriter("data/JobTitleCountbyCountry.csv", false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Country, Job Title Count");

            for (Map.Entry<String, Integer> entry : finalSortedList.entrySet()) {
               pw.println( entry.getKey()+","+entry.getValue());
            }
            pw.close();
            fw.close();

            System.out.println("New data successfully saved");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        table.tableDraw(finalSortedList);

    }
}
