//Kim Asenbeck
//CS230 Pre-Lab
//Hashtable spell checker


import java.util.*;

public class PreLab{
  
  public static Hashtable dates = new Hashtable(10); // 10 initial spots
  // populate the table
  
  public static void main (String[]args){
    dates.put("Commencement", "5/29/2015");
    dates.put("Last Day of Classes", "5/8/2015");
    dates.put("Marathon Monday", "4/20/2015");
    System.out.println(dates);
//    String str = dates.get("Commencement");
    System.out.println((dates.containsKey("Sam's birthday")));
    for (int i=0; i<20; i++ ) {
      dates.put("Important Day "+i, " 4/"+ i +"/2015");
    }
        System.out.println(dates);
        System.out.println("Commencement date: " + dates.get("Commencement"));
  }
}