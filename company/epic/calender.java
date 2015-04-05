package ll;
/*
 Calendar
Get a date (mon/day/year) from user. Print exact the week of dates (Sun to Sat). ex) input: 2/20/2001 if the day is Wednesday
output: 
Sunday 2/17/2001
Monday 2/18/2001
Tuesday 2/19/2001
Wednesday 2/20/2001
Thursday 2/21/2001
Friday 2/22/2001
Saturday 2/23/2002
*/

import java.util.*;
/*
 把四個數加起來然後除七的餘數就是，如果整除就是星期日。這四個數分別是：

Ｙ(year)：年份減2000

Ｌ(leap days)：從2000年1月1日到該日之間的閏日數目

M(month)：月份的代號，從一月到十二月分別是511462403513，即是一月是５，二、三月是１，四月是4，五月是6，如此類推，十二月是3

D(day)：日號

就是說——Ｙ＋Ｌ＋M＋Ｄ（除7的餘數）
*/
public class calender{
    // only support days later than 1/1/2000
	// formula: (Y + L + M+ D) %7 
	// 0: Sunday, 1: Monday..... 6: Saturday
    public static void generate(String input){
        // check if input is valid
    	String[] tmp= input.split("\\/");
    	 if(!isValid(tmp))
    		 return;
    	 // store input
    	 int mm=Integer.parseInt(tmp[0]);
    	 int dd=Integer.parseInt(tmp[1]);
    	 int yy= Integer.parseInt(tmp[2]);
    	 
        //get Y
    	 int Y= yy-2000;
    	 // get L
    	 int L= (mm >=3 && isLeapYear(yy) )? (yy-2000)/4 +1 : (yy-2000)/4;
    	 // get M
    	 int[] monthcode={5,1, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3}; // can be different for each year
    	 int M= monthcode[mm-1];
    	 // get D
    	 int D= dd;
    	 String[] week={"SUN", "MON", "TUE", "WEND", "THUR", "FRI","SATUR"};
    	 String res= week[(Y+L+M+D)%7];
    	 System.out.println(res);
        	
        
    }
    public static boolean isLeapYear(int year){
    	return year%400==0 || year%4==0 && year%400!=0;
    }
    public static boolean isValid(String[] tmp){
    	if(tmp.length <3) return false;       
        if(Integer.parseInt(tmp[0]) >13 || Integer.parseInt(tmp[0]) <0 )
        	return false;       
        if(Integer.parseInt(tmp[1]) >31 || Integer.parseInt(tmp[0]) <0 )
        	return false;
        if(Integer.parseInt(tmp[2]) <0 )
        	return false;
        return true;
    }
    public static void main(String[] args){
        generate("2/20/2001");
        System.out.println();
        
    }
    
}