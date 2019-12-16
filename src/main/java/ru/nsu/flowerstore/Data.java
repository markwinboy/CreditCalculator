package ru.nsu.flowerstore;

import java.util.ArrayList;
import java.util.List;

public class Data {

    String minSum;
    String maxSum;
    String minTime;
    String maxTime;
    String rate;

    public Data(String minSum, String maxSum, String minTime, String maxTime, String rate){
        this.minSum = minSum;
        this.maxSum = maxSum;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.rate = rate;
    }

    public String toSql(){
       return "('"+minSum+"', "+
                "'"+maxSum+"', "+
                "'"+minTime+"', "+
                "'"+maxTime+"', "+
                "'"+rate+"')";
    }

    public String getMinSum() {
        return minSum;
    }

    public String getMaxSum() {
        return maxSum;
    }

    public String getMinTime() {
        return minTime;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public String getRate() {
        return rate;
    }

//    public Boolean validation(){
////        if(minSum<500 || maxSum<minSum || maxSum>100000 || (maxSum+minSum)%100!=0){
////            return false;
////        }
////        if(minTime<1 || maxTime<minTime || maxTime>36) {
////            return false;
////        }
////
////        if(rate<1.0 ||  rate>150.0) {
////            return false;
////        }
////        return true;
////    }

    public String validationMaxSum(){
        int maxSum = 0;
        int minSum = 0;
        try {
            maxSum = Integer.parseInt(this.maxSum);
            minSum = Integer.parseInt(this.minSum);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Max Sum введено не корректно " + maxSum;
        }
        if((maxSum+minSum)%100!=0){
            return "Не кратно 100";
        }else if(maxSum>100000){
            return "Нужно меньше 100000";
        }else if(maxSum<minSum){
            return "минимальное превышает максимальное значение";
        }
        return "";
    }
    public String validationMinSum(){
        int maxSum = 0;
        int minSum = 0;
        try {
            maxSum = Integer.parseInt(this.maxSum);
            minSum = Integer.parseInt(this.minSum);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "min Sum введено не корректно " + minSum;
        }
        if((maxSum+minSum)%100!=0){
            return "Не кратно 100";
        }else if(minSum<500){
            return "Нужно больше 500";
        }else if(maxSum<minSum){
            return "минимальное превышает максимальное значение";
        }
        return "";
    }
    public String validationMinTime(){
        int maxTime = 0;
        int minTime = 0;
        try {
            maxTime = Integer.parseInt(this.maxTime);
            minTime = Integer.parseInt(this.minTime);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "min Time введено не корректно " + minTime;
        }
        if(minTime<1){
            return "Нужно больше 1";
        }else if(maxTime<minTime){
            return "минимальное превышает максимальное значение";
        }
        return "";
    }
    public String validationMaxTime(){
        int maxTime = 0;
        int minTime = 0;
        try {
            maxTime = Integer.parseInt(this.maxTime);
            minTime = Integer.parseInt(this.minTime);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Max Time введено не корректно " + maxTime;
        }
        if(maxTime>36){
            return "Нужно меньше 36";
        }else if(maxTime<minTime){
            return "минимальное превышает максимальное значение";
        }
        return "";
    }
    public String validationRate(){
        int rate = 0;
        try {
            rate = Integer.parseInt(this.rate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Rate введено не корректно " + rate;
        }
        if(rate>150.0) {
            return "Нужно меньше 150";
        }else if(rate<1.0){
            return "Нужно больше 1";
        }
        return "";
    }

    public List<String> getErrorMessages() {
        List<String> errorsStrList = new ArrayList<>();

        if (!validationRate().equals("")) {
            errorsStrList.add(validationRate());
        }
        if (!validationMaxSum().equals("")) {
            errorsStrList.add(validationMaxSum());
        }
        if (!validationMinSum().equals("")) {
            errorsStrList.add(validationMinSum());
        }
        if (!validationMinTime().equals("")) {
            errorsStrList.add(validationMinTime());
        }
        if (!validationMaxTime().equals("")) {
            errorsStrList.add(validationMaxTime());
        }
        return errorsStrList;
    }


}

