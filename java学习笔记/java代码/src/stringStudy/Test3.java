package stringStudy;

public class Test3 {

    public static void main(String[] args) {
        int num[] = { 11, 2, 7, 31, 4, 15 };
        listArr(num);
        insertSort(num);
        listArr(num);
    }

    static void listArr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        System.out.println(sb.delete(sb.length() - 1, sb.length()));
    }
    
    /**
     * 插入排序
     * 思路：外层循环每次搞定一个数的正确位置，将第i个元素插入到它应该在位置
     *          i的范围 1~length-1
     *      内存循环：将第i个数不断的和前面比，小就换，直到遇上比它还小的数就停
     *          次数不定while
     *          如果次元素被换到了第0个位置，也要停
     */
    static void insertSort(int[] arr) {
        // { 2, 4, 11, 7, 15,31  }
        for (int i = 1; i < arr.length; i++) { //i=1
            int pos = i; //pos记住被插入元素的角标
            while (pos > 0 && arr[pos] < arr[pos - 1]) {
                changeList(arr, pos, pos - 1);
                pos--;
            }
        }
    }
    /**
     * 交换位置
     */
    static void changeList(int arr[], int pos, int i) {
        int temp = arr[i];
        arr[i] = arr[pos];
        arr[pos] = temp;
    }
}
