public class drinkSales{
    //instance variable
    //pointers
    drinkSales head;
    drinkSales previous;//think of what is added previouslly in a stack strcuture

    //other common variables
    String name;
    double price;
    int quantity;
    int calorie;
    boolean diet;//assume to be flase until decalred
    

    //constructors
    //creating empty Drinks class
    public drinkSales(){
        this.head=null;
        this.previous=null;
    }

    //create Drinks class without diet option
    public drinkSales(String name, double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        //assuming no diet picked
        this.diet=false;
    }

    //create Drinks class with diet option
    public drinkSales(String name, double price, int quantity, boolean diet){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.diet=diet;
    }

    //create class without diet option without quantity
    public drinkSales(String name, double price){
        this.name=name;
        this.price=price;
        //assuming only 1 drink is left
        this.quantity=1;
        //assuming no diet picked
        this.diet=false;
    }

    //create class with diet option without quantity
    public drinkSales(String name, double price, boolean diet){
        this.name=name;
        this.price=price;
        this.diet=diet;
        //assuming only 1 drink is left
        this.quantity=1;
    }

    //functions section:
    //add drink at the beginning of the linked list
    public void addDrinks(String name,double price, int quantity, boolean diet ){
        drinkSales tempDrinks= new drinkSales(name,price,quantity,diet);
        if (head == null){
            head=tempDrinks;
        }
        else{
            tempDrinks.previous = head;
            head= tempDrinks;
        }
    }

    //removing drinks
    public boolean removeDrinks(String name){
        drinkSales cursor=head;
        drinkSales next=null;
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
    public drinkSales getDrinks(String name){
        if (head == null){
            //throw new RuntimeException("No Drink In data base at all");
            return null;
        }
        else{
            drinkSales cursor=head;
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


    public static void main(String[] args){
        drinkSales head= new drinkSales();
        head.addDrinks("cola", 2.8, 5, false);
        head.addDrinks("sprite", 3.0, 2, true);
        head.addDrinks("beer",2.0,3,false);
        head.setCalorie("sprite", 90);
        head.setPrice("cola", 70);
        
        System.out.println(head.getPrice("cola"));
        System.out.println(head.getCalorie("sprite"));

        head.removeDrinks("cola");
        System.out.println(head.getDrinks("cola"));
        System.out.println("sprite: "+head.getDrinks("sprite"));

        head.removeDrinks("sprite");
        System.out.println(head.getDrinks("sprite"));

        head.removeDrinks("beer");
        System.out.println(head.getDrinks("beer"));

    }
    
}