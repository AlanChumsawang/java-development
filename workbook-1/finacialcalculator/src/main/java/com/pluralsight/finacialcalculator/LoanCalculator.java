package com.pluralsight.finacialcalculator;

import java.util.Scanner;
// -------------------------- //
// ---  initialize variables ---//
public class LoanCalculator {
    double principal;
    double interestRate;
    int loanLength; // in years
    double monthlyPayment;
    double totalInterest;
    double amountRemaining;
// -- Method to calculate monthly payment -- //
    public void calculateMonthlyPayment() {

        double monthlyInterestRate = interestRate / 12;
        int totalNumberOfPayments = loanLength * 12;
        monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
        amountRemaining = principal;

        // Calculate total interest paid
        for (int i = 1; i < totalNumberOfPayments; i++) {
            double interest = amountRemaining * monthlyInterestRate;
            totalInterest += interest;
            amountRemaining = amountRemaining - (monthlyPayment - interest);
        }

    }

    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Desired Loan Amount: ");
        calculator.principal = scanner.nextDouble();
        System.out.println("Enter Annual Interest Rate: ");
        calculator.interestRate = scanner.nextDouble() / 100;
        System.out.println("Enter Desired Loan Length: ");
        calculator.loanLength = scanner.nextInt();
        calculator.calculateMonthlyPayment();
        System.out.println("Monthly payment: " + calculator.monthlyPayment);
        System.out.println("Total Interest: " + calculator.totalInterest);

    }
}
