package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int choices;
        do {
            System.out.println("Choose a calculator");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator");
            System.out.println("3. Present Value Calculator");
            System.out.println("0. Exit");
            System.out.println("Enter your choice of calculator: ");
            choices = scanner.nextInt();
            switch (choices) {
                case 1:
                    mortgageCalculator();
                    break;
                case 2:
                    futureCalculator();
                    break;
                case 3:
                    presentValueCalculator();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid. Try again.");
            }
        } while (choices != 0);
    }

    public static void mortgageCalculator() {
        System.out.println("Please enter the principal amount: $ ");
        double principal = scanner.nextDouble();

        System.out.println("Please enter the interest rate %: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the loan length (in years): ");
        int years = scanner.nextInt();

        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int months = years * 12;

        double monthlyPayment = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months) /(Math.pow(1 + monthlyInterestRate, months) - 1);

        double totalInterestPaid = monthlyPayment * years * 12 - principal;

        System.out.println("A $" + principal + " loan at " + annualInterestRate + " interest for " + years + " years would have a $" + String.format("%.2f",monthlyPayment) + "/mo payment with a total interest of $" + String.format("%.2f", totalInterestPaid));

    }

    public static void futureCalculator() {
        System.out.println("Please enter user amount of deposit : $ ");
        double deposit = scanner.nextDouble();

        System.out.println("What is your annual interest rate?: % ");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years until maturity: ");
        int yearsFC = scanner.nextInt();

        double dailyInterestRate = annualInterestRate / 100 / 365;

        double futureValue = deposit * Math.pow(1 + dailyInterestRate, yearsFC * 365);

        double totalInterestEarned = futureValue - deposit;

        System.out.println("If you deposit $" + deposit + " in a CD that earns " + annualInterestRate + "% interest and matures in " + yearsFC +" years, your CD's ending balance will be $" + String.format("%.2f",futureValue) + " and you would have earned $" + String.format("%.2f",totalInterestEarned) + " in interest");

    }

    public static void presentValueCalculator () {
        System.out.println("Please enter monthly payout amount: $ ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Please enter annual interest rate: % ");
        double expectedInterestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years to pay out ");
        double yearsPVC = scanner.nextDouble();

        double monthlyInterestRatePVC = expectedInterestRate / 100 / 12;

        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRatePVC, - yearsPVC * 12)) / monthlyInterestRatePVC;

        System.out.println("To fund an annuity that pays $" + monthlyPayout + " monthly for " + expectedInterestRate + " years and earns an expected " + String.format("%.2f",monthlyInterestRatePVC) + "% interest, you would need to invest $" + String.format("%.2f",presentValue) + " today.");
    }
}
