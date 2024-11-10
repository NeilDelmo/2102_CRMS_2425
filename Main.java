package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String predefinedPassword = "pogi123";
        String predefinedEmail = "joed@example.com";

        while (true) {
            //Email dapat to o kaya username peroi saka ko na ayusin
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            Teacher teacher = new Teacher(predefinedEmail, predefinedPassword);
            teacher.setUserName("Joed");

            if (email.equals(teacher.getEmail()) &&
                    password.equals(teacher.getPassword())) {
                System.out.println("Account verified successfully! Welcome, " + teacher.getUserName());
                break;
            } else {
                System.out.println("Invalid Email or Password!");
            }
        }

    }

}