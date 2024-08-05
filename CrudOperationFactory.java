package com.global_job_and_salary;

public class CrudOperationFactory {


    public CrudOperation getCrudOperation(String crudType)
    {
        if(crudType == null)
        {
            return null;
        }

        if(crudType.equalsIgnoreCase("insert"))
        {
            return new InsertNewJobAndSalary();
        }
        else if(crudType.equalsIgnoreCase("update"))
        {
            return new UpdateJobAndSalary();
        }
        else if(crudType.equalsIgnoreCase("delete"))
        {
            return new DeleteJobAndSalary();
        }

        return null;
    }
}
