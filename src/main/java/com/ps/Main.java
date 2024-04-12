package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the principal amount: $ ");
        double principal = scanner.nextDouble();

        System.out.println("Please enter the interest rate %: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the loan length (in years): ");
        int years = scanner.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, years);

        double totalInterestPaid = monthlyPayment * years * 12 - principal;

        System.out.println("A $" + principal + " loan at " + annualInterestRate + " interest for " + years + " years would have a $" + String.format("%.2f",monthlyPayment) + "/mo payment with a total interest of $" + String.format("%.2f", totalInterestPaid));
    }

    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int years) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int months = years * 12;
        double monthlyPayment = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months) /(Math.pow(1 + monthlyInterestRate, months) - 1);
        return monthlyPayment;
    }
}
