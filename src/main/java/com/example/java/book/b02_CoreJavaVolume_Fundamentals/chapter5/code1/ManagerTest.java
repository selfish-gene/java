package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.code1;

import com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.Code01_Employee;
import com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.Code02_Manager;

public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Code02_Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        var staff = new Code01_Employee[3];

        staff[0] = boss;
        staff[1] = new Code01_Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Code01_Employee("Tommy Tester", 40000, 1990, 3, 15);

        for (Code01_Employee employee : staff) {
            System.out.println("name = " + employee.getName() + ", salary = " + employee.getSalary());
        }

        Code02_Manager[] managers = new Code02_Manager[10];
        Code01_Employee[] staff1 = managers;
        // ArrayStoreException
        staff1[0] = new Code01_Employee("Tommy Tester", 40000, 1990, 3, 15);
    }
}