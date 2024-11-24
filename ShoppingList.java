import java.util.Iterator;
import java.util.LinkedList;

public class ShoppingList {
    
    LinkedList<Category> categories;
    
    public ShoppingList(){
        this.categories = new LinkedList<>();
        this.categories.add(new Category("Miscellaneous"));
    }

    public ShoppingList(String categoryTitle){
        categories = new LinkedList<>();
        categories.add(new Category(categoryTitle));
    }

    public void updateBought(String itemTitle, int amountPurchased){

        Iterator<Category> categoryIter = categories.iterator();
        boolean found = false;

        while (categoryIter.hasNext()) {
            Category currentCategory = categoryIter.next();
            Iterator<Item> itemIter = currentCategory.getItems().iterator();

            while (itemIter.hasNext()) {
                Item currenItem = itemIter.next();
                if (currenItem.getTitle().toLowerCase().equals(itemTitle.toLowerCase())){
                    found = true;
                    try{
                        currenItem.updateBought(amountPurchased);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }

            if (found) break;
        }
        if (!found){
            System.out.println("The item does not exist. Please check your spelling, or make sure the item exists.");
        }
    }

    public void markBought(String itemTitle){

        Iterator<Category> categoryIter = categories.iterator();
        boolean found = false;

        while (categoryIter.hasNext()) {
            Category currentCategory = categoryIter.next();
            Iterator<Item> itemIter = currentCategory.getItems().iterator();

            while (itemIter.hasNext()) {
                Item currenItem = itemIter.next();
                if (currenItem.getTitle().toLowerCase().equals(itemTitle.toLowerCase())){
                    found = true;
                    try{
                        currenItem.markBought();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }

            if (found) break;
        }
        if (!found){
            System.out.println("The item does not exist. Please check your spelling, or make sure the item exists.");
        }
    }
    
    public void addCategory(String title) {
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category element = iterator.next();
            if (element.getTitle().equals(title)) {
                System.out.println("The category already exists");
                return;
            }
        }
        categories.add(new Category(title));
    }

    public void addItem(String itemTitle,String categoryTitle,int amountNeeded){
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category element = iterator.next();
            if(element.getTitle().equals(categoryTitle)){
                element.addItem(itemTitle,amountNeeded);
                return;
            }
        }
        this.addCategory(categoryTitle);
        addItem(itemTitle,categoryTitle,amountNeeded);
        System.out.println("Item successfully added.");
    }
    
    public void deleteItem(String itemTitle){
        Iterator<Category> categoryIter = categories.iterator();
        boolean found = false;

        while (categoryIter.hasNext()) {
            Category currentCategory = categoryIter.next();
            Iterator<Item> itemIter = currentCategory.getItems().iterator();

            while (itemIter.hasNext()) {
                Item currenItem = itemIter.next();
                if (currenItem.getTitle().toLowerCase().equals(itemTitle.toLowerCase())){
                    found = true;
                    try{
                        itemIter.remove();
                        System.out.println("Deleted: " + itemTitle);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }

            if (found) break;
        }
        if (!found){
            System.out.println("The item does not exist. Please check your spelling, or make sure the item exists.");
        }
    }

    public void deleteCategory(String categoryTitle){
        Iterator<Category> categoryIter = categories.iterator();
        boolean found = false;

        while (categoryIter.hasNext()) {
            Category currentCategory = categoryIter.next();
            
            if(currentCategory.getTitle().toLowerCase().equals(categoryTitle.toLowerCase())){
                categoryIter.remove();
                found = true;
                System.out.println("Deleted " + categoryTitle);
                break;
            }
        }
        if (!found){
            System.out.println("The category does not exist. Please check your spelling, or make sure the category exists.");
        }
    }
    
    public void viewShoppingList(){
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category element = iterator.next();
            System.out.println("**" + element.getTitle());
            element.describeItems();
        }
    }
}
