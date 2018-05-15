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

        if (sec < 10) {
            sec = Integer.parseInt("0" + sec);
        }
        if (ms < 10) {
            return min + ":" + sec + ".00" + ms;
        } else if (ms < 100) {
            return min + ":" + sec + ".0" + ms;
        } else {
            return min + ":" + sec + "." + ms;
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
