public class Item {

    private String title;
    private int amountNeeded;
    private int bought;

    public Item(String title){
        this.title = title;
    }

    public Item(String title, int amountNeeded){
        this.title = title;
        this.amountNeeded = amountNeeded;
    }

    public void addToAmountNeeded(int additional){
        this.amountNeeded += additional;
    }

    public void updateBought(int bought){
        if (this.amountNeeded - bought < 0){ throw new IllegalArgumentException("More is bought than was required");}
        else{
            this.bought += bought;
        }
    }

    public boolean isFulfilled(){
        return getAmountLeft() == 0;
    }

    public void markBought(){
        bought = amountNeeded;
    }

    public int getAmountLeft(){
        return (amountNeeded - bought);
    }

    public String getTitle(){
        return this.title;
    }
    public int getAmountNeeded(){
        return amountNeeded;
    }
    public int getBought(){
        return bought;
    }
}
