package com.global_job_and_salary;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AsciiTableGenerate {


    public void tableDraw(LinkedList<GlobalJobAndSalary> gjsList)
    {

        System.out.println();
        System.out.println("=========================== Ascii Table Report =================================");
        System.out.println();
        List<String> header = Arrays.asList("No.","Country","JobTitle","Category","Salary","Currency","ExchangeRate","Salary(USD)");

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(header);
        table.addRule();

        for(int i=0;i < 10 && i< gjsList.size();i++)
        {
            GlobalJobAndSalary n = gjsList.get(i);
            List<Object> tabledata = Arrays.asList(i+1,n.getCountry(), n.getJobTitle(),n.getCategory(), n.getSalary()
                                    ,n.getCurrency(),n.getExchangeRate(),n.getUsdSalary());

            table.addRow(tabledata);
            table.addRule();
        }

        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());

    }

    public void tableDraw(Map<String, Integer> sortList)
    {
        System.out.println();
        System.out.println("=========================== Ascii Table Report =================================");
        System.out.println();
        List<String> header = Arrays.asList("No.","Country","Total Job Count");

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(header);
        table.addRule();
        int count = 0;

            for (Map.Entry<String, Integer> entry : sortList.entrySet())
            {

                List<Object> tabledata = Arrays.asList(++count, entry.getKey(), entry.getValue());

                table.addRow(tabledata);
                table.addRule();

                if(count >= 20)
                {
                    table.setTextAlignment(TextAlignment.CENTER);
                    System.out.println(table.render());
                    return;
                }

            }
    }
}
