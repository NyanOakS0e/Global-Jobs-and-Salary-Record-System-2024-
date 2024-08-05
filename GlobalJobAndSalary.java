package com.global_job_and_salary;

public class GlobalJobAndSalary {

    private String country;
    private String jobTitle;
    private String category;
    private long salary;
    private String currency;
    private float exchangeRate;
    private float usdSalary;

    public GlobalJobAndSalary(String country, String jobTitle, String category,
                              long salary, String currency, float exchangeRate,
                              float usdSalary)
    {
        this.country = country;
        this.jobTitle = jobTitle;
        this.category = category;
        this.salary = salary;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.usdSalary = usdSalary;
    }

    public String getCountry() {
        return country;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCategory() {
        return category;
    }

    public long getSalary() {
        return salary;
    }

    public String getCurrency() {
        return currency;
    }

    public float getExchangeRate() {
        return exchangeRate;
    }

    public float getUsdSalary() {
        return usdSalary;
    }

    public void setUsdSalary(float usdSalary) {
        this.usdSalary = usdSalary;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "GlobalJobAndSalary{" +
                "country='" + country + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", category='" + category + '\'' +
                ", salary=" + salary +
                ", currency='" + currency + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", usdSalary=" + usdSalary +
                '}';
    }
}
