package com.company;

public class Mechanic {
    private String fullName;
    private String companyName;

    public Mechanic(String fullName, String companyName) {
        this.fullName = fullName;
        this.companyName = companyName;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void getServed() {
        System.out.println("Вы записались на обслуживание к механику " + fullName
                + " из компании " + companyName +
                "\n\tИнформация о вашем авто:");
    }

    public void repair() {
        System.out.println("Вы записались на ремонт к механику " + fullName
                + " из компании " + companyName);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "fullName='" + fullName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
