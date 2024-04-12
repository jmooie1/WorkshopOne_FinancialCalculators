package com.ps;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class CDCalculator {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the deposit amount : $ ");
        double deposit = scanner.nextDouble();

        System.out.println("Enter the annual interest rate: % " );
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(deposit, annualInterestRate, years);

        double totalInterestEarned = futureValue - deposit;

        System.out.println("If you deposit $" + deposit + " in a CD that earns " + annualInterestRate + "% interest and matures in " + years +" years, your CD's ending balance will be $" + String.format("%.2f",futureValue) + " and you would have earned $" + String.format("%.2f",totalInterestEarned) + " in interest");

    }
    public static double calculateFutureValue(double deposit, double annualInterestRate, int years){
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int months = years * 12;
        double futureValue = deposit * Math.pow(1 + monthlyInterestRate, months);
        return futureValue;
    }
}
