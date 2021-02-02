public class condimentSale {

    /*
    To DO

    */





    //pointers
    condimentSale head;
    condimentSale previous;//refer to next as in normal notion

    //instance variable
    String name;
    double price;
    int calorie;
    int quantity;
    boolean priceHaggle;

    //constrcutor:
    //create Condiments empty class 
    public condimentSale(){
        this.head=null;
        this.previous=null;
    }

    //create Condiments class with given name and price without quantity
    public condimentSale(String name, double price){
        this.name=name;
        this.price=price;
        this.calorie=-1;
        this.quantity=1;//assume 1 is left
    }

    //create Condiments class with givern name, price, and calorie without quantity
    public condimentSale(String name, double price, int calorie){
        this.name=name;
        this.price=price;
        this.calorie=calorie;
        this.quantity=1;//assume 1 is left
    }


    //create Condiments class with given name and price with quantity
    public condimentSale(String name,int quantity, double price ){
        this.name=name;
        this.price=price;
        this.calorie=-1;
        this.quantity=quantity;
    }

    //create Condiments class with givern name, price, and calorie with quantity
    public condimentSale(String name, double price, int calorie,int quantity){
        this.name=name;
        this.price=price;
        this.calorie=calorie;
        this.quantity=quantity;
        
    }

    //functions section:

    //add Condiemnts class at the beginning of the linked list
    public void addCondiments(String name, double price, int calorie, int quantity){
        condimentSale temp= new condimentSale(name,price,calorie,quantity);
        if(head == null){
            head=temp;
        }
        else{
            temp.previous = head;
            head=temp;
        }
    }

    //removing condiments
    public boolean removeCondiments(String name){
        condimentSale cursor=head;
        condimentSale next=null;
        if (cursor != null && cursor.name.equals(name)){
            head = head.previous;
            return true;
        }
        while(cursor != null && !cursor.name.equals(name)){
            next=cursor;
            cursor=cursor.previous;
        }
        if(cursor == null){
            return false;

        }
        next.previous=cursor.previous;
        return false;
        
    }

    //getters 
    //get the condiments with the given name / also checks if an item exists
    public condimentSale getCondiments(String name){
        if(head==null){
            return null;
        }
        else{
            condimentSale cursor=head;
            //check if name is matched within the linked list while traversing
            while(cursor.previous != null){
                if(cursor.name.equals(name)){
                    return cursor;
                }
                else{
                    cursor=cursor.previous;
                }
            }
            if(cursor.name.equals(name)){
                return cursor;
            }
            else{
                return null;
            }
        }
    }

    //get the price of the condiment
    public double getPrice(String name){
        return getCondiments(name) != null ?  getCondiments(name).price : -1;
    }

    //get the calorie of the condiment
    public int getCalorie(String name){
        return getCondiments(name) != null ? getCondiments(name).calorie : -1;
    }

    //get the quantity of the condiment
    public int getQuantity(String name){
        return getCondiments(name) != null ? getCondiments(name).quantity : -1;
    }

    //setters

    //set the price of the food
    public boolean setPrice(String name, double price){
        if(getCondiments(name)==null){
            return false;
        }else{
            getCondiments(name).price=price;
            return true;
        }
    }

    //set the calorie of the food
    public boolean setCalorie(String name, int calorie){
        if(getCondiments(name)==null){
            return false;
        }
        else{
            getCondiments(name).calorie=calorie;
            return true;
        }
    }

    //set the quantity of the food
    public boolean setQuantity(String name,int quantity){
        if(getCondiments(name)==null){
            return false;
        }
        else{
            getCondiments(name).quantity=quantity;
            return true;
        }
    }
    
    public static void main(String args[]){
        System.out.println("h");

        condimentSale head= new condimentSale();
        head.addCondiments("ketchup", 0.5, 200, 600); 
        head.addCondiments("BBQ sauce", 1.25, 250, 20);
        head.addCondiments("soy sauce", 0.75, 125, 25);
        System.out.println("ketchup: "+ head.getCondiments("ketchup"));
        System.out.println(head.getCalorie("ketchup"));
        System.out.println(head.getQuantity("ketchup"));
        head.removeCondiments("ketchup");
        System.out.println("ketchup:"+head.getCondiments("ketchup"));

        System.out.println("BBQ sauce"+head.getPrice("BBQ sauce"));
        System.out.println(head.getCalorie("BBQ sauce"));
        System.out.println(head.getQuantity("BBQ sauce"));

        head.removeCondiments("soy sauce");
        System.out.println(head.getCalorie("soy sauce"));

    }

}
