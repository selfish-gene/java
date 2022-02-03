package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.code2;

import com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.Code01_Employee;
import com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter5.Code02_Manager;

public class EqualsTest {
    public static void main(String[] args) {
        var alice1 = new Code01_Employee("Alice Adams", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Code01_Employee("Alice Adams", 75000, 1987, 12, 15);
        var bob = new Code01_Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2)); // true
        System.out.println("alice1 == alice3: " + (alice1 == alice3)); // false
        System.out.println("alice1.equal(alice3): " + alice1.equals(alice3)); // true
        System.out.println("alice1.equal(bob): " + alice1.equals(bob)); // false
        System.out.println("bob.toString(): " + bob);

        var carl = new Code02_Manager("Carl Cracker", 80000, 1987, 12, 15);
        var boss = new Code02_Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss)); // false
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}
