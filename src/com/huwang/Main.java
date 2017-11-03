package com.huwang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("请输入时间戳:");
        long x = input.nextLong();
        x = x + 28800;
        int second = (int) (x % 60);//秒
        int minute = (int) (x % 3600 / 60);//分钟
        int hour = (int) (x % 86400 / 3600);//小时
        int leap_year = (int) (x / 86400 / 1461);
        int year,month,day;//年月日
        if (x / 86400 % 1461 > 730)//计算年份
        {
            if (x / 86400 % 1461 > 1096) {
                year = leap_year * 4 + 3;
                day=(int)x / 86400-leap_year*1461-1096;
            }
            else {
                year = leap_year * 4 + 2;
                day=(int)x / 86400-leap_year*1461-730;
            }
        } else {
            year = leap_year * 4 + (int) (x / 86400 % 1461 / 365);
            day=(int)x / 86400-leap_year*1461-(int) (x / 86400 % 1461 / 365)*365;
        }
        int year_month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int leap_year_month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            for (month = 0; month < 12; month++) {
                day = day - leap_year_month[month];
                if (day < 0) {
                    month--;
                    day = day + leap_year_month[month];
                    break;
                }
            }
        } else {
            for (month = 0; month < 12; month++) {
                day = day - year_month[month];
                if (day <= 0) {
                    month--;
                    day = day + year_month[month];
                    break;
                }
            }
        }
        System.out.print((1970+year)+"年"+(month+2)+"月"+day+"日"+hour+"时"+minute+"分钟"+second+"秒");
    }
}

