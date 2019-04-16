package com.xiaoduye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestOne {
    static List<String> doit(Map<String, String> map) {
        map.put("111", "111");
        map.put("181", "151");
        map.put("101", "11");
        map.put("444", "444");
        Iterator it = map.entrySet().iterator();
        List<String> list = new ArrayList<String>();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String value = (String) entry.getValue();
            if (key.equals(value)) {
                list.add(value);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        List<String> list = doit(map);

        for (String str : list) {
            System.out.println(str);
        }
    }
}
