import java.util.Iterator;
import java.util.LinkedList;


public class Category {
    
    private String title;
    private LinkedList<Item> items;

    public Category(String title) {
        this.title = title;
        items = new LinkedList<Item>();
    }

    public void addItem(String title){
        items.add(new Item(title));
    }

    public void addItem(String title, int amountNeeded){
        items.add(new Item(title, amountNeeded));
    }


    public void removeItem(String title){

        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext()) {

            Item item = iterator.next();

            if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                iterator.remove();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    void describeItems(){
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item element = iterator.next();
            if (element.isFulfilled()){
                System.out.printf("     -> %s (FULFILLED)\n",element.getTitle());
            }else{
                System.out.printf("     -> %s : (%d / %d) \n",element.getTitle(),element.getBought(),element.getAmountNeeded());
            }
    }

    
    
}
}