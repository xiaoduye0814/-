package interfaceStudy;

interface PrintFilter{
    boolean accept(int num);
}

class NumberPrint {
    private int printNum[];

    public NumberPrint(int printNum[]) {
        this.printNum = printNum;
    }

    public void run() {
        for (int num : printNum) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public void run(PrintFilter pf) {
        for (int num : printNum) {
            if (pf.accept(num)) {
                System.out.print(num + "   ");
            }
        }
        System.out.println();
    }
}

public class Demo3 {
    public static void main(String[] args) {
        NumberPrint np = new NumberPrint(new int[] { 11, 24, 113, 24, 55, 6, 0,
                111, 2, 100 });
        np.run();
        
        NumberPrint np1 = new NumberPrint(new int[] { 11, 24, 113, 24, 55, 6, 0,
                111, 2, 100 });
        np1.run(new PrintFilter() {
            @Override
            public boolean accept(int num) {
                if(num%2==1){
                    return true;
                }
                return false;
            }
        });
    }
}
