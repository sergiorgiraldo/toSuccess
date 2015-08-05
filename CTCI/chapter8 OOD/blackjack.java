/*Design the data structures for a generic deck of cards Explain how you would sub- class it to implement particular card games
 */
public class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        ArrayList<Integer> scores= possibleScores();
        
    
    }
    
    /*return a list of possible scores this hand could have*/
    private ArrayList<Integer> possibleScores(){
    
    
    }
    public boolean busted(){
        return score() >21;
    }
    public boolean is21(){
        return score()==21;
    }
    public boolean isBlackJack(){
    
    }

}

public class BlackJackCard extends Card{
    public BlackJackCard(int c, Suit s){
        super(c, s);
    }
    public int value(){
        if(isAce()) return 1;
        else if(faceValue >=11 && faqceValue <=13)
            return 10;
        else
            return faceValue;
        
    }
    public boolean isAce(){
        return faceValue==1;
    }
    public int minValue(){
        if(isAce()) return 1;
        else return value();
    }
    public int maxValue(){
        if(isAce())
            return 11;
        else
            return value();
    }
    publi boolean isFaceCard(){
        return faceValue>=11 && faceValue<=13;
    }


}


/* ---------------------------------base class-----------------------------*/
public enum Suit{// suit means club, diamond, heart or spade, each has 13 cards

Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;
    private Suit(int v){
        this.value= v;
    }
    public int getValue(){
        return value;
    }

public static Suit getSuitFromValue(int value){
    switch(value){
        case 0: return this.Club;
        case 1: return this.Diamond;
        case 2: return this.Heart;
        case 3: return this.Spade;
        default: return null;
    }
}

}
public class Deck<T extends Card>{// deck means 52 cards
    private ArrayList<T> cards;// all cards, dealt or not
    private int dealtIndex=0;// marks first undealt card
    
    public void setDeckOfCards(ArrayList<T> deckofcards){
        this.cards= deckofcards;
    }
    public void shuffle(){
        for(int i= cards.length()-1; i>=0; --i){
            int j= (int)Math.random()*(cards.size()- i);
            T cardi= cards.get(i);
            T cardj= cards.get(j);
            cards.set(i, cardj);
            cards.set(j, cardi);
        }
    }
    public int remainingCards(){
        return cards.size() - dealtIndex;
    }
    // seems like dealing the cards of size number
    public T[] dealHand(int number){
        if(number > remainingCards())
            return null;
        T[] ret= new T[number];
        for(int i=0; i< number; ++i)
            ret[i]= dealCard();
        return ret;
    }
    public T dealCard(){
        if(remainingCards()==0)
            return null;
        T card= cards.get(dealtIndex);
        dealtIndex++;
        return card;
    }

}

public abstract class Card{// one card
    private boolean available= true;
    //2-10, 11 for jack, 12 for queue, 13 for king and 1 for ace
    protected int faceValue;
    protected Suit suit;
    public Card(int c, Suit s){
        this.faceValue=c;
        this.suit= s;
    }
    public abstract int value();
    public Suit suit(){
        return suit;
    }
    /*check if this card is available to be given out to someone */
    public boolean isAvailable(){
        return available;
    }
    public void markUnavailable(){
        available= false;
    }
    public void markAvailable(){
        available= true;
    }
    public void print(){
        char[] facevalues={'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K'};
        System.out.print(facevalues[this.faceValue-1]);
        switch(suit){
            case Club: System.out.print("c");
            break;
            case Diamond: System.out.print("d");
            break;
            case Spade: System.out.print("s");
            break;
            case Heart: System.out.print("h");
            break;
        }
        System.out.print(" ");
    }

}

public class Hand <T extends Card>{// judge
    protected ArrayList<T> cards= new ArrayList<T> ();
    public int score(){
        int score=0;
        for(T card : cards)
            score +=card.value();
        
        return score;
    }
    public void addCard(T card){
        cards.add(card);
    }
}