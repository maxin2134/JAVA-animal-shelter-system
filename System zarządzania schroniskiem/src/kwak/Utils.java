package kwak;

public class Utils {
    public static String getRodzajPliku(String name){
        int Index = name.lastIndexOf(".");
        
        if (Index == -1){
            return null;
        }            
        
        if (Index == name.length()-1){
        return null;
        }
        
        return name.substring(Index+1, name.length());
                    
    }
}
