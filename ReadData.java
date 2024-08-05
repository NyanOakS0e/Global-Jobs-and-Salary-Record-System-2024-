package com.global_job_and_salary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ReadData {
    private LinkedList<GlobalJobAndSalary> gjsList = new LinkedList<>();
    private static ReadData readData = new ReadData();
    private ReadData()
    {

    }
    public static ReadData getReadDataInstance()
    {
        return readData;
    }
    public LinkedList<GlobalJobAndSalary> readData(String fileName)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null)
            {
                String [] data =line.split(",");

                gjsList.add(new GlobalJobAndSalary(data[0],data[1],data[2],Long.parseLong(data[3]),data[4],Float.parseFloat( data[5])
                        ,Float.parseFloat(data[6])));
            }

            bufferedReader.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        return gjsList;
    }


}
