package test;

/**
在java中，字符串“abcd”与字符串“ab你好”的长度是一样，都是四个字符。
但对应的字节数不同，一个汉字占两个字节。
定义一个方法，按照最大的字节数来取子串。
如：对于“ab你好”，如果取三个字节，那么子串就是ab与“你”字的半个，
那么半个就要舍弃。如果去四个字节就是“ab你”，取五个字节还是“ab你”.

思路：
首先要知道汉字是由连个字节所组成。而且这两个都是负数。
1，先将该字符串变成字节数组（getBytes）
2，通过要截取的长度位。来判断该位置是正数还是负数。
    只要为负数。就往回判断前一个字节是正还是负。以此类推。
    定义一个计数器，记录负数出现的次数。如果该数为偶数。那么就将要去长度的字节数。转成字符串（说明没有半个汉字存在。）
    如果是奇数。就将最后一个字节舍弃。在转成字符串。
*/
public class Test18 {
    public static void main(String[] args) {
        String str = "ab你好";
        int sub = 4;
        byte but[] = str.getBytes();
        getSubStr(but, sub);
    }

    private static void getSubStr(byte[] but, int sub) {
        int count = 0;
        for (int i = 0; i < sub; i++) {
            if (but[i] < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            sub--;
        }
        String str = new String(but, 0, sub);
        System.out.println(str);
    }
}
