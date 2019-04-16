package equals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEntrySetTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(8, "wangwu");
        map.put(2, "lisi");
        map.put(20, "lisi");
        map.put(12, "lisi");
        map.put(7, "zhangsan");
        map.put(16, "xuliu");
        map.put(6, "xuliu");
        method(map);
    }

    private static void method(Map<Integer, String> map) {
        Set entrySet = map.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + ":" + me.getValue());
            
        }
    }
}
