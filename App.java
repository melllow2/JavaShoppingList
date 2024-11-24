import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        boolean running = true;
        ShoppingList list = new ShoppingList();

        while (running) {
            System.out.println("\n*************SHOPPING LIST ORGANIZER*************");
            System.out.println("1. Add item\r\n" + //
            "2. Add category\r\n" + //
            "3. Update item\r\n" + //
            "4. Delete item\r\n" + //
            "5. Mark an item as purchased\r\n" + //
            "6. Delete category\r\n" + //
            "7. View items\r\n" + //
            "8. Exit");
            System.out.print("\nWhat do you want to do?: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println();

            try {
                switch (choice) {
                
                    case (1) -> {
                        System.out.print("Enter the name of the item: ");
                        String itemTitle = sc.next();
                        
                        System.out.print("Enter the category of the item (Enter 'm' if you want to put it into Miscellaneous): ");
                        String categoryTitle = sc.next();
                        if (categoryTitle.equals("")) categoryTitle = "Miscellaneous";
    
                        System.out.print("Enter the amount of the item you want to purchase: ");
                        int amountNeeded = sc.nextInt();
    
                        list.addItem(itemTitle, categoryTitle, amountNeeded);
                    }
                        
                    case (2) -> {
                        System.out.print("Enter the name of the category: ");
                        String categoryTitle = sc.next();
    
                        list.addCategory(categoryTitle);
                    }
    
                    case (3) -> {
                        System.out.print("Enter the name of the item you want to update: ");
                        String itemTitle = sc.next();
    
                        System.out.print("Enter the amount of the item you have purchased: ");
                        int amountNeeded = sc.nextInt();
    
                        list.updateBought(itemTitle, amountNeeded);
                    }
    
                    case (4) -> {
                        System.out.print("Enter the name of the item you want to delete: ");
                        String itemTitle = sc.next();
    
                        list.deleteItem(itemTitle);
                    }
                    
                    case (5) -> {
                        System.out.print("Enter the name of the item you want to mark purchased: ");
                        String itemTitle = sc.next();
    
                        list.markBought(itemTitle);
                    }

                    case (6) -> {
                        System.out.print("Enter the name of the category you want to delete: ");
                        String categoryTitle = sc.next();
    
                        list.deleteCategory(categoryTitle);
                    }
    
                    case (7) -> {
                        list.viewShoppingList();
                    }
                
                    case (8) -> {
                        running = false;
                        sc.close();
                        System.out.println("Thank you for using our application.");
                    }
    
                    default -> {
                        System.out.println("Please enter a valid choice from the menu.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input.");
            }
        }
    }
        
}
