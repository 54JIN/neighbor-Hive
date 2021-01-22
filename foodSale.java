public class foodSale{
    /*
    **Linked List with a mixture of Stack concept: insert time complexity of O(1)
    */
    //data
    String foodName;
    double foodPrice;
    boolean priceHaggle;

    //pointers
    foodSale head;
    foodSale previous;

    public foodSale(){
        this.head = null;
        this.previous = null;
    }
    public foodSale(String foodName, double foodPrice, boolean priceHaggle){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.priceHaggle = priceHaggle;
        this.previous = null;
    }
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
    
}