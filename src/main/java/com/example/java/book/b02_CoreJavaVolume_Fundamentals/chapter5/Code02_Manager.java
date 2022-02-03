package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5;

import java.util.Objects;

public class Code02_Manager extends Code01_Employee {

    private double bonus;

    public Code02_Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;
        Code02_Manager that = (Code02_Manager) otherObject;
        return Double.compare(that.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return "Code02_Manager{" +
                super.toString() +
                "bonus=" + bonus +
                '}';
    }
}
