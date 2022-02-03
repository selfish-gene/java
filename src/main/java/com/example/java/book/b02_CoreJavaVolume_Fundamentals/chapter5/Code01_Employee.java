package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5;

import java.time.LocalDate;
import java.util.Objects;

public class Code01_Employee {
    // instance fields
    private String name;
    private double salary;
    private LocalDate hireDay;

    // constructor
    public Code01_Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Code01_Employee that = (Code01_Employee) otherObject;
        return Double.compare(that.getSalary(), getSalary()) == 0
                && getName().equals(that.getName())
                && getHireDay().equals(that.getHireDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary(), getHireDay());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
