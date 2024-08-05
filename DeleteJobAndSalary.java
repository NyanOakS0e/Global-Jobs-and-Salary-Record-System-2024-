package com.global_job_and_salary;


import java.util.LinkedList;

public class DeleteJobAndSalary implements CrudOperation {
    private LinkedList<GlobalJobAndSalary> gjs_List = new LinkedList<>();
    private UserInputs userInputs = new UserInputs();
    private WriteData writeData = new WriteData();
    private Search search  = new Search();



    @Override
    public void crudMethod(LinkedList<GlobalJobAndSalary> gjsList) {

        this.gjs_List = gjsList;
        System.out.println("========== Delete Existing Job =========");

        String country = userInputs.getCountry();
        String jobTitle = userInputs.getJobTitle();
        String category = userInputs.getCategory();
        GlobalJobAndSalary deleteJob;
        while ((deleteJob = search.search(country,jobTitle,category,gjsList))==null)
        {
            System.out.println("-- Data not found in the file --");
            country = userInputs.getCountry();
            jobTitle = userInputs.getJobTitle();
            category = userInputs.getCategory();
        }

        gjsList.remove(deleteJob);

        writeData.writeData("data/global_jobs_salaries_2024.csv", gjsList);

        System.out.println("-- Data Successfully Deleted --");
    }
}
