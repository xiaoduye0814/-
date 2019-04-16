package stringStudy;

/**
 * 选择排序
 * @author Administrator
 *
 */
public class Test2 {

    public static void main(String[] args) {
        int num[] = { 11, 88, 45, 198, 5 };
        listArr(num);
        System.out.println("-------------");
        selectSort(num);
        listArr(num);

    }

    /**
     * 选择排序思路
     * 1、定义一个外层循环，控制要排列的次数，每次搞定一个最大数
     *      假设用i来代表每次最大数摆放的位置，i的取值 0 ~ length-2
     * 2、定义一个变量pos记住最大数所在的位置，定义一个变量max记住最大数
     *       max初始值为i位置的元素,pos初始值为i
     * 3、定义顶层循环，用于遍历数组找最大数
     *      假设i 位置的最大，找出 i+1 ~ length-1里面最大的比i还大的
     *      遍历数组，如果有比max大的将值给max,同时用pos记住元素的角标
     * 4、让最大数和i位置的元素交换
     */
    static void selectSort(int[] arr) {
        // { 198, 88, 45, 11, 5 }
        for (int i = 0; i < arr.length - 1; i++) { // i=1
            int pos = i; // pos=1
            int max = arr[i]; // max=88
            // 找最大数
            for (int j = i + 1; j < arr.length; j++) { // j=2 
                if (arr[j] > max) { // 45>88
                    max = arr[j];
                    pos = j;
                }
            }
            exchange(arr, i, pos);
        }
    }

    static void exchange(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    static void listArr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
}
