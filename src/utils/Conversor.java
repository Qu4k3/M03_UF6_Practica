package utils;

public class Conversor {
    
    String mils;

    public static void milToTime() {

    }        
    
    public static String milToTime(String mils) {
        
        int time, mins, secs;
        
        time = Integer.parseInt(mils);
                
        mins = time / 60000;
        time -= mins * 60000;
        secs = time / 1000;
        time -= secs * 1000;        

        if (secs < 10) {
            secs = Integer.parseInt("0" + secs);
        }
        if (time < 10) {
            return mins + ":" + secs + ".00" + time;
        } else if (time < 100) {
            return mins + ":" + secs + ".0" + time;
        } else {
            return mins + ":" + secs + "." + time;
        }        
    }
}
