public class drinkSale {
    /*
    To Do

    */

    //instance variable
    //pointers
    drinkSale head;
    drinkSale previous;//think of what is added previouslly in a stack strcuture

    //other common variables
    String name;
    double price;
    int quantity;
    int calorie;
    boolean diet;//assume to be flase until decalred
    Boolean priceHaggle;
    

    //constructors
    //creating empty Drinks class
    public drinkSale(){
        this.head=null;
        this.previous=null;
    }

    //create Drinks class without diet option
    public drinkSale(String name, double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        //assuming no diet picked
        this.diet=false;
    }

    //create Drinks class with diet option
    public drinkSale(String name, double price, int quantity, boolean diet){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.diet=diet;
    }

    //create class without diet option without quantity
    public drinkSale(String name, double price){
        this.name=name;
        this.price=price;
        //assuming only 1 drink is left
        this.quantity=1;
        //assuming no diet picked
        this.diet=false;
    }

    //create class with diet option without quantity
    public drinkSale(String name, double price, boolean diet){
        this.name=name;
        this.price=price;
        this.diet=diet;
        //assuming only 1 drink is left
        this.quantity=1;
    }

    //functions section:
    //add drink at the beginning of the linked list
    public void addDrinks(String name,double price, int quantity, boolean diet ){
        drinkSale tempDrinks= new drinkSale(name,price,quantity,diet);
        if (head == null){
            head=tempDrinks;
        }
        else{
            tempDrinks.previous = head;
            head= tempDrinks;
        }
    }

    //removing driink
    public boolean removeDrinks(String name){
        //check if entire linked list is empty
        if(head == null){
            System.out.println("no item in linked list");
            return false;
        }
        //if head is getting deleted and theres element following it
        else if(head.name.equals(name) && head.previous != null){
            head=head.previous;
            return true;
        }
        //if head is getting deleted and theres no element after
        else if(head.name.equals(name) && head.previous==null){
            drinkSale temp=new drinkSale();
            head=temp;
            return true;
        }
        else{
                //make a new cursor which loop thourgh the linkedlist to find the deleting one
                drinkSale cursor=head;
                drinkSale next=null;
                //System.out.println("process");
                while(cursor.previous != null){
                    if(cursor.name.equals(name)){
                        
                        next.previous=cursor.previous;
                        return true;
                    }
                    else{
                        
                        next=cursor;
                        cursor=cursor.previous;
                    }
                }
                if(cursor.name.equals(name)){
                    next.previous=cursor.previous;
                    return true;
                }
                else{
                    return false;
                }
                
            
        }
    }



    //getters:

    //get the price of the food
    public double getPrice(String name){
        //use getDrink function to get the class and access its attribute
        //if there are no drink found then return -1
       
        return getDrinks(name) != null ? getDrinks(name).price:-1;
    }

    //get the calorie of the food
    public int getCalorie(String name){
        //use getDrink function to get the class and access its attribute
        //if there are no drink found then return -1
        return getDrinks(name) == null ? -1:getDrinks(name).calorie;
    }

    //setters:

    //set the price of the food
    public boolean setPrice(String name,double price){
        //check if there is an drink with the requested name
        if (getDrinks(name) != null){
            getDrinks(name).price=price;
            return true;
        }
        else{
            //alert there are no drink
            return false;
        }
    }

    //set the calorie of the drink
    public boolean setCalorie(String name, int calorie){
        //check if there is an drink with the requested name
        if(getDrinks(name) != null){
            getDrinks(name).calorie=calorie;
            return true;
        }
        else{
            //alert there are no drink
            return false;
        }
    }

    //set the quantitry of the drink
    public boolean setDrinks(String name, int quantity){
        if(getDrinks(name) != null){
            getDrinks(name).quantity=quantity;
            return true;
        }
        else{
            //alert no such drink
            return false;
        }

    }


    //get the drink with requested name
    public drinkSale getDrinks(String name){
        if (head == null){
            //throw new RuntimeException("No Drink In data base at all");
            return null;
        }
        else{
            drinkSale cursor=head;
            //searching until no next drink
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

    //print
    public void print(){
        try{
            drinkSale cursor=head;
        while(cursor.previous != null){
            System.out.println(cursor.name);
            cursor=cursor.previous;
        }
        System.out.println(cursor.name);
        }
        catch(NullPointerException e){
            System.out.println("no more element in linkedlist");
        }
        
    }

    public static void main(String[] args){
        drinkSale head= new drinkSale();
        head.addDrinks("cola", 2.8, 5, false);
        head.addDrinks("sprite", 3.0, 2, true);
        head.addDrinks("beer",2.0,3,false);
        head.addDrinks("wine", 15.0, 7, false);
        head.print();

        head.setCalorie("sprite", 90);
        head.setPrice("cola", 70);
        
        
        //System.out.println(head.getPrice("cola"));
        //System.out.println(head.getCalorie("sprite"));

        head.removeDrinks("cola");
        System.out.println("\nAfter: ");
        head.print();

        head.removeDrinks("wine");
        System.out.println("\nThen: ");
        head.print();

        head.removeDrinks("sprite");
        System.out.println("\nThen: ");
        head.print();

        head.removeDrinks("beer");
        System.out.println("\nThen: ");
        head.print();

        //System.out.println("cola: "+head.getDrinks("cola"));
        //System.out.println("sprite: "+head.getDrinks("sprite"));

        //head.removeDrinks("sprite");
        //System.out.println("removed spirite: "+ head.getDrinks("sprite"));

        //head.removeDrinks("beer");
        //System.out.println("removed beer: "+ head.getDrinks("beer"));

    }
}
