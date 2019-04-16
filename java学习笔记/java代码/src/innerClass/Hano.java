package innerClass;

import java.util.ArrayList;
import java.util.List;

public class Hano {

    public static void main(String[] args) {
        
        List<String> firList = new ArrayList<String>();
        firList.add("1");
        firList.add("2");
        firList.add("3");
        firList.add("4");
        firList.add("14");
        firList.add("224");
        List<String> twoList = new ArrayList<String>();
        twoList.add("2");
        twoList.add("3");
        firList.removeAll(twoList);
        System.out.println(firList.toString());
    }

}
