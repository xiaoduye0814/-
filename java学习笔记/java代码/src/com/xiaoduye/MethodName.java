package com.xiaoduye;

public class MethodName {
    public static void main(String[] args) {
        MethodName methodName = new MethodName();
        String clazz1 = Thread.currentThread().getStackTrace()[1]
                .getClassName();
        System.out.println(clazz1);
        methodName.anotherMethod();
    }

    private void anotherMethod() {
        String clazz = this.getClass().getName();
        System.out.println(clazz);
    }
}
