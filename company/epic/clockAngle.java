
/*
Clock Angle
We are given a specific time(like 02:23), we need to get the angle between hour and minute(less than 180)
*/
import java.util.*;

public class clockAngle{
    static final double PI= 3.14159;
	// between minite: 60/360
    public static void get(String time){
        String[] tmp= time.split(":");
        int hour= Integer.parseInt(tmp[0]);
        int minute= Integer.parseInt(tmp[1]);
        double anglepermin= 360*1/60;
        // a hour covers 5min
        // minute/hour gives the offset in 1hour(5 min angle)
        double hourPos= hour*5*anglepermin+ (minute/60)*5*anglepermin;
        double minPos= minute*anglepermin;
        double res= Math.abs(hourPos- minPos); // arc angle       
        res= res>= 180 ? 360-res : res;
        System.out.println(res);
    }
    // round2
    public static void get2(String time){
        String[] tmp= time.split(":");
        int hour= Integer.parseInt(tmp[0]);
        int minute= Integer.parseInt(tmp[1]);

        int angelpermin= 360/60, angelperhour= 5*angelpermin;
        double hourpos= angelperhour * hour + (minute/ 60)*angelperhour;
        double minpos= angelpermin* minute;
        double res= Math.abs(hourpos - minpos);
        res= res>=180 ? 360- res : res;

        System.out.println(res);
    }
    public static void main(String[] args){
        get2("12:00");
        get2("6:00");
        System.out.println();
        
    }
    
}