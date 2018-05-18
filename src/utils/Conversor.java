package utils;

public class Conversor {
    
    String mils, time;

    public static void milsToTime() {

    }        
    
    public static String milsToTime(String time) {
        
        int ms, min, sec;
        
        ms = Integer.parseInt(time);
                
        min = ms / 60000;
        ms -= min * 60000;
        sec = ms / 1000;
        ms -= sec * 1000;  
        
        String msS, minS, secS;
        
        msS = Integer.toString(ms);
        minS = Integer.toString(min);
        secS = Integer.toString(sec);

        if (sec < 10) {
            secS = "0" + sec;
        }
        if (ms < 10) {
            return minS + ":" + secS + ".00" + msS;
        } else if (ms < 100) {
            return minS + ":" + secS + ".0" + msS;
        } else {
            return minS + ":" + secS + "." + msS;
        }        
    }
    
    public static int TimeToMils(String time) {
        
        int min, sec, ms, res;
        
        String[]split = time.split(":|\\.");
        
        min = Integer.parseInt(split[0]);
        sec = Integer.parseInt(split[1]);
        ms = Integer.parseInt(split[2]);
        
        res = min * 60000 + sec * 1000 + ms;
        
        return res;
    }
}
