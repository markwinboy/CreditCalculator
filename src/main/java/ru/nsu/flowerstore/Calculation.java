package ru.nsu.flowerstore;

import java.util.Calendar;

public class Calculation {
    private int sumOfCredit;
    private double interestRate;
    private int numberOfMonth;

    public Calculation(int sumOfCredit, double interestRate, int numberOfMonth) {
        this.sumOfCredit = sumOfCredit;
        this.interestRate = interestRate;
        this.numberOfMonth = numberOfMonth;
    }

    public double sumCalculate(){
        return getMonthPaymentSum()*numberOfMonth;
    }

    public double totalInterestRate(){
        return interestRate*numberOfMonth/12;
    }

    public double getMonthPaymentSum(){
        return sumOfCredit*coef();
    }

    public double coef(){
        return (getMonthInterestRate()/100*Math.pow((1+getMonthInterestRate()/100),numberOfMonth))/(Math.pow((1+getMonthInterestRate()/100),numberOfMonth)-1);
    }

    public double getMonthInterestRate(){
        return interestRate/12;
    }
    public String getDate(int numberMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, + numberMonth);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH)+1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        String s = day+"-"+month+"-"+year;
        return s;
    }

}
