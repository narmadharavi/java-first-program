package com.h2;
import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private float[] credits;

    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits){
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for (float credit:credits) {
            sum+=credit;
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for (float debit:debits) {
            sum+=debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate(){
        return sumOfCredits()-sumOfDebits();
    }

    public static void main(String[] args){
        String[] creditAsString = args[0].split(",");
        String[] debitAsString = args[1].split(",");

        float[] credits = new float[creditAsString.length];
        float[] debits = new float[debitAsString.length];

        for( int i=0; i<creditAsString.length;i++){
             credits[i] = Float.parseFloat(creditAsString[i]);
        }
        for( int i=0; i<debitAsString.length;i++){
             debits[i] = Float.parseFloat(debitAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = "+ netSavings+ ", remaining days in month = "+remainingDaysInMonth(LocalDate.now()));
    }


}
