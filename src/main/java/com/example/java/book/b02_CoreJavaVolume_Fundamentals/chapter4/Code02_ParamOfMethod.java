package com.example.java.book.b02_CoreJavaVolume_Fundamentals.chapter4;

public class Code02_ParamOfMethod {
    public static void main(String[] args) {
        // basic type
        double percent = 10;
        tripleValue(percent); // doesn't work
        System.out.println(percent); // 10.0
        // reference type
        User user = new User(100);
        System.out.println(user.getSalary());
        tripleSalary(user); // works
        System.out.println(user.getSalary()); // 300
        // counter example
        User alice = new User(100);
        User bob = new User(10000);
        swap(alice, bob); // doesn't work
        System.out.println("[User alice] salary = " + alice.getSalary()); // 100
        System.out.println("[User bob] salary = " + bob.getSalary()); // 10000
    }

    /**
     * 方法调用的具体过程：
     * 1. x 初始化为 percent 值的一个副本（也就是10）。
     * 2. x 乘以 3 后等于 30，但是 percent 仍然是 10。
     * 3. 这个方法结束之后，参数变量 x 不再使用。
     *
     * @param x x
     */
    public static void tripleValue(double x) {
        x *= 3;
    }

    public static class User {
        private int salary;

        public User(int salary) {
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

        public void raiseSalary(int money) {
            this.salary += money;
        }

    }

    public static void tripleSalary(User x) {
        x.raiseSalary(x.getSalary() * 2);
    }

    public static void swap(User x, User y) {
        User temp = x;
        x = y;
        y = temp;
        System.out.println("[User x] salary = " + x.getSalary()); // 10000
        System.out.println("[User y] salary = " + y.getSalary()); // 100
    }
}
