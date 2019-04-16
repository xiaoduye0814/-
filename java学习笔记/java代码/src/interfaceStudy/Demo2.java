package interfaceStudy;

interface PCI {
    void open();

    void close();
}

class MainBoard {
    private PCI pci;

    public MainBoard(PCI pci) {
        this.pci = pci;
    }
    public void usePci() {
        pci.open();
    }
}

class SoundCard implements PCI {

    public void open() {
        System.out.println("声卡开启");
    }
    public void close() {
        System.out.println("声卡关闭");
    }

}
public class Demo2 {

    public static void main(String[] args) {
        // 1
        MainBoard mainBoard = new MainBoard(new PCI() {
            public void open() {
                System.out.println("网卡OPen");
            }
            
            public void close() {
            }
        });
        mainBoard.usePci();
        // 2
        SoundCard soundCard = new SoundCard();
        MainBoard mainBoard2 = new MainBoard(soundCard);
        mainBoard2.usePci();
        //3
        class DisplayCard implements PCI {
            public void open() {
                System.out.println("显卡OPen");
            }
            public void close() {
            }
        }
        new MainBoard(new DisplayCard()).usePci();
    }
}
