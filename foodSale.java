public class foodSale{
    /*

    $$ Discription
    **  Linked List with a mixture of Stack concept: insert time complexity of O(1)

    $$ To do:
    **  The add method needs to have a method (or an if statement) to check if the food item already exists within the list and if so throw ?error?
    */
    //data
    String foodName;
    double foodPrice;
    boolean priceHaggle;

    //pointers
    foodSale head;
    foodSale previous;

    //for initial decleration
    public foodSale(){
        this.head = null;
        this.previous = null;
    }
    //for creating filled temporary foodSale
    public foodSale(String foodName, double foodPrice, boolean priceHaggle){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.priceHaggle = priceHaggle;
        this.previous = null;
    }
    //add a new type of food onto the list
    public void add(String foodName, double foodPrice, boolean priceHaggle){
        foodSale temp = new foodSale(foodName, foodPrice, priceHaggle);
        if(head == null){
            head = temp;
        }
        else{
            temp.previous = head;
            head = temp;
        }
    }
    //returns the node matching the foodName provided as input to the method
    public foodSale returnFood(String foodName){
        if(head == null){
            return null;
        }
        else{
            foodSale cursor = head;
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    return cursor;
                }
                cursor = cursor.previous;
            }
            if(cursor.foodName.equals(foodName)){
                return cursor;
            }
            return null;
        }
    }
    //sets the price of the food in question
    public void setPrice(String foodName, double price){
        if(head != null){
            foodSale temp = returnFood(foodName);
            if(temp != null){
                temp.foodPrice = price;
            } 
        }
    }
    //gets the price of the food in question
    public double getPrice(String foodName){
        if(head != null){
            foodSale temp = returnFood(foodName);
            if(temp != null){
                return temp.foodPrice;
            } 
        }
        return -1;
    }
    //checks if the food exists within the list
    public boolean containsFood(String foodName){
        if(head != null){
            foodSale temp = returnFood(foodName);
            if(temp != null){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        foodSale temp = new foodSale();
        temp.add("hamburger", 1.00, false);
        temp.add("burger", 3.00, false);
        System.out.println(temp.containsFood("burger"));
        System.out.println(temp.getPrice("burger"));
        temp.setPrice("burger", 4.00);
        System.out.println(temp.getPrice("burger"));
    }
}