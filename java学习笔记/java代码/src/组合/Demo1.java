package 组合;

class Card {
    public void spend() {
        System.out.println("400元");
    }
}

class Person {
    private Card card;

    public Person(Card card) {
        this.card = card;
    }

    public void shopping() {
        card.spend();
    }
}

class Chinese extends Person {

    public Chinese(Card card) {
        super(card);
    }

    public void shopping() {
        System.out.println("讨价还价");
        super.shopping();
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Chinese ch = new Chinese(new Card());
        ch.shopping();
    }
}
