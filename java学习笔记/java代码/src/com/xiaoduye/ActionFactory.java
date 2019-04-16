package com.xiaoduye;

import java.util.HashMap;
import java.util.Map;

interface Action{
    String getName();
}
public class ActionFactory {
    private Map<String, String> actionConfig = new HashMap<String, String>();

    public Action getAction(String name) {
        ActionFactory aa=new ActionFactory();
        final String clazz = Thread.currentThread().getStackTrace()[1]
                .getClassName();
        Map<String,String> map=new HashMap<String, String>();
        map.put(name, clazz);
        aa.setActionConfig(map);
        Action action = new Action() {
            @Override
            public String getName() {
                return clazz;
            }
        };
        return action;
    }

    public static void main(String[] args) {
        ActionFactory aa=new ActionFactory();
        Action ac = aa.getAction("kkk");
        String name="";
        System.out.println(ac.getName());
        Map<String,String> map=new HashMap<String, String>();
        map.put("name", ac.getName());
        aa.setActionConfig(map);
    }

    public Map<String, String> getActionConfig() {
        return actionConfig;
    }

    public void setActionConfig(Map<String, String> actionConfig) {
        this.actionConfig = actionConfig;
    }
}
