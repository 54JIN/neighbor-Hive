public class buyerData {
    /*
    TO DO
    1.fix the nullpointer exception of removeBuyer(when removing the first item after the head)


    */
    //linked list class

    //instance variables
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;

    String preference_food;
    foodSale selectedFood;
    condimentSale selectedCondiments;
    drinkSale selectedDrinks;

    //pointers
    buyerData head;
    buyerData previous;

    //Sellers goods
    foodSale avaFoods;
    drinkSale avaDrinks;
    condimentSale avaCondiments;

    //create empty buyerData
    public buyerData(){
        this.head=null;
        this.previous=null;
    }

    //create buyerData info with given
    public buyerData(String firstName, String lastName, String address, String city, String state, int zip){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.previous=null;
    }

    //add a buyer data to the linked list
    //complexity O(1) adding it in the start of the linked list
    public void addBuyer(String firstName, String lastName, String address, String city, String state, int zip){
        buyerData temp = new buyerData(firstName,lastName,address,city,state,zip);
        if(head == null){
            head = temp;
        }
        else{
            temp.previous = head;
            head = temp;
        }
    }
    //O(1) insert time
    public void addData(buyerData tempData){
        if(head == null){
            head = tempData;
        }
        else{
            tempData.previous = head;
            head = tempData;
        }
    }

    //check if the linkedlist contains the buyer info
    /*
    **why are you returning the buyerData, if you want the method to return a buyer then call the method: getBuyer.
    */
    public buyerData contsinsBuyer(String firstName, String lastName, String address, String city, String state, int zip){
        //if linkedlist empty return false
        if (head==null){
            return null;
        }
        else{
            buyerData cursor = head;
            while(cursor.previous != null){
                if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.address.equals(address) && cursor.city.equals(city) && cursor.state.equals(state) && cursor.zip==zip ){
                    return cursor;
                }
                cursor=cursor.previous;
            }
            if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.address.equals(address) && cursor.city.equals(city) && cursor.state.equals(state) && cursor.zip==zip ){
                return cursor;
            }
            else{
                return null;
            }

        }
    }

    //check if buyer info exists in the linked list but with less info needed
    /*
    **this wouldn't work because two people can live within the same zip with the same first and last name.
    */
    public buyerData containsBuyerSimple(String firstName,String lastName,int zip){
        if(head ==null){
            return null;
        }
        else{
            buyerData cursor= head;
            while(cursor.previous != null){
                if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.zip == zip){
                    return cursor;
                }
                else{
                    cursor=cursor.previous;
                }
            }
            if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.zip == zip){
                return cursor;
            }
            else{
                return null;
            }

        }
    }

    //revmove buyer from the linked list with full info provided
    /*
    **Wouldn't work because two people with same first and last name can exist within the same zip.
    */
    public boolean removeBuyer(String firstName,String lastName, int zip){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            //throw new RuntimeException("No Food In data base");
            return false;
        }
        if(head.firstName.equals(firstName) && head.lastName.equals(lastName) && head.zip==zip && head.previous == null){
            head = null;
            return true;
        }
        else if(head.firstName.equals(firstName) && head.lastName.equals(lastName) && head.zip==zip){
            head = head.previous;
            return true;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            buyerData cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.zip==zip){
                    cursor.previous = cursor.previous.previous;
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.firstName.equals(firstName) && cursor.lastName.equals(lastName) && cursor.zip==zip){
                buyerData temp = new buyerData();
                cursor = temp;
                return true;
            }
            //if the food item is not within the list return false
            else{
                return false;
            }
        }
    }

    //find perferenced food in all sellers
    public void findFood(sellerData seller){
        //make a cursor for sellers's food
        foodSale food=seller.avaFoods;
        //traverse thourgh all seller
        sellerData sell=seller;
        try{
            while(sell.previous != null){
                while(food.previous != null){
                    if(food.foodName.equals(preference_food)){
                        System.out.println(preference_food +" is found in "+ sell.sellerLastName+", "+sell.sellerFirstName);
                        return;
                    }
                    food=food.previous;
                }
                //check last item within the food list of the seller
                if(food.foodName.equals(preference_food)){
                    System.out.println(preference_food +" is found in "+ sell.sellerLastName+", "+sell.sellerFirstName);
                    return;
                }
                sell=sell.previous;
                food=sell.previous.avaFoods;
            }
            //check last seller's stuff
            while(food.previous != null){
                if(food.foodName.equals(preference_food)){
                    System.out.println(preference_food +" is found in "+ sell.sellerLastName+", "+sell.sellerFirstName);
                    return;
                }
                food=food.previous;
            }
            //check last item within the food list of the seller
            if(food.foodName.equals(preference_food)){
                System.out.println(preference_food +" is found in "+ sell.sellerLastName+", "+sell.sellerFirstName);
                return;
            }
            System.out.println("no food found within the sellers");

        }catch(NullPointerException e){
            System.out.println("null pointer exception");
        }

        
        
        
    }








    public static void main(String[] args){

        
        String firstName="Peter";
        String lastName="Wang";
        String address="home";
        String city="Bergenfield";
        String state="nj";
        int zip=01111;
        buyerData head= new buyerData();
        head.addBuyer(firstName, lastName, address, city, state, zip);
        //head.addBuyer("Satip","juju","not home","Bergenfield","nj",01111);
        System.out.println(head.containsBuyerSimple(firstName, lastName, zip));
        //System.out.println(head.containsBuyerSimple("Satip", "juju", 01112));
        
        //head.removeBuyer("Satip", "juju", 01111);
        head.removeBuyer(firstName, lastName, zip);
        //System.out.println(head.containsBuyerSimple("Satip","juju",01111));
        System.out.println(head.containsBuyerSimple(firstName, lastName, zip));


        
    }
}
