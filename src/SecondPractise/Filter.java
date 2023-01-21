package SecondPractise;

import java.util.List;

public interface Filter {
    List<Object> getModificatedList(List<Object> list);

    static String getCleanString(String string){
        if(string.toLowerCase().trim().equals("true")){
            return "false";
        }
        if(string.toLowerCase().trim().equals("false")){
            return "true";
        }
        return string.trim();
    }
    static int getIntegerNumber(Double someNumber){
        return someNumber.intValue();
    }
    static boolean getReverseBoolean(boolean bool){
            return !bool;
    }
}
