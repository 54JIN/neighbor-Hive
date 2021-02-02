public class buyerData {
    /*
    TO DO
    -still gonna fix findFood()

    UPDATED:
    -added getBuyer() and containsBuyer()
    -fixed removeBuyer
    */
    //linked list class

    //instance variables
    String buyerFirstName;
    String buyerLastName;
    String buyerAddress;
    String buyerCity;
    String buyerState;
    int buyerZip;

    foodSale selectedFood;
    condimentSale selectedCondiments;
    drinkSale selectedDrinks;

    //pointers
    buyerData head;
    buyerData previous;

    //create empty buyerData
    public buyerData(){
        this.head = null;
        this.previous = null;
    }

    //create buyerData info with given
    public buyerData(String firstName, String lastName, String address, String city, String state, int zip){
        this.buyerFirstName = firstName;
        this.buyerLastName = lastName;
        this.buyerAddress = address;
        this.buyerCity = city;
        this.buyerState = state;
        this.buyerZip = zip;
        this.previous = null;

        this.selectedFood = new foodSale();
        this.selectedDrinks = new drinkSale();
        this.selectedCondiments = new condimentSale();
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
    public void addBuyer(buyerData tempData){
        if(head == null){
            head = tempData;
        }
        else{
            tempData.previous = head;
            head = tempData;
        }
    }

    //check if the linkedlist contains the buyer info
    public buyerData getBuyer(String firstName, String lastName, String address, String city, String state, int zip){
        //if linkedlist empty return false
        if (head == null){
            return null;
        }
        else{
            buyerData cursor = head;
            while(cursor.previous != null){
                if(cursor.buyerFirstName.equals(firstName) && cursor.buyerLastName.equals(lastName) && cursor.buyerAddress.equals(address) && cursor.buyerCity.equals(city) && cursor.buyerState.equals(state) && cursor.buyerZip == zip ){
                    return cursor;
                }
                cursor=cursor.previous;
            }
            if(cursor.buyerFirstName.equals(firstName) && cursor.buyerLastName.equals(lastName) && cursor.buyerAddress.equals(address) && cursor.buyerCity.equals(city) && cursor.buyerState.equals(state) && cursor.buyerZip == zip ){
                return cursor;
            }
            else{
                return null;
            }

        }
    }

    //check if buyer info exists in the linked list 
    //returns an boolean
    public boolean containsBuyer(String firstName, String lastName, String address, String city, String state, int zip){
        //if linkedlist empty return false
        if (head == null){
            return false;
        }
        else{
            buyerData cursor = head;
            while(cursor.previous != null){
                if(cursor.buyerFirstName.equals(firstName) && cursor.buyerLastName.equals(lastName) && cursor.buyerAddress.equals(address) && cursor.buyerCity.equals(city) && cursor.buyerState.equals(state) && cursor.buyerZip == zip ){
                    return true;
                }
                cursor=cursor.previous;
            }
            if(cursor.buyerFirstName.equals(firstName) && cursor.buyerLastName.equals(lastName) && cursor.buyerAddress.equals(address) && cursor.buyerCity.equals(city) && cursor.buyerState.equals(state) && cursor.buyerZip == zip ){
                return true;
            }
            else{
                return false;
            }

        }
    }
    

    //revmove buyer from the linked list with full info provided
    /*
    **Wouldn't work because two people with same first and last name can exist within the same zip.
    */
    public void removeBuyer(String buyerFirstName, String buyerLastName, String buyerAddress, String buyerCity, String buyerState, int buyerZip){
        if(head != null || head.previous != null){
            if(head.buyerFirstName.equals(buyerFirstName) && head.buyerLastName.equals(buyerLastName) && head.buyerAddress.equals(buyerAddress) && head.buyerCity.equals(buyerCity) && head.buyerState.equals(buyerState) && head.buyerZip == buyerZip){
                head = head.previous;
            }
            //if it does not match the head then:
            else{
                buyerData cursor = head;
                while(cursor.previous != null){
                    if(cursor.buyerFirstName.equals(buyerFirstName) && cursor.buyerLastName.equals(buyerLastName) && cursor.buyerAddress.equals(buyerAddress) && cursor.buyerCity.equals(buyerCity) && cursor.buyerState.equals(buyerState) && cursor.buyerZip == buyerZip){
                        cursor.previous = cursor.previous.previous;
                        break;
                    }
                    cursor = cursor.previous;
                }
            }
        }
    }
    //add food onto the sellers options
    //O(n) time complexity
    public void addFood(foodSale food, String buyerFirstName, String buyerLastName, String buyerAddress, String buyerCity, String buyerState, int buyerZip){
        
    }
    //removes specific food within the sellers options of food
    //O(n) time complexity
    public void removeFood(String foodName, String buyerFirstName, String buyerLastName, String buyerAddress, String buyerCity, String buyerState, int buyerZip){
        buyerData cursor = getBuyer(buyerFirstName, buyerLastName, buyerAddress, buyerCity, buyerState, buyerZip);
        if(cursor != null){
            cursor.selectedFood.removeFood(foodName);
        }
    }
    //searches through the sellers avaliable food list to find the food and if found return true
    //O(n) time complexity
    public boolean containsFood(String foodName, String buyerFirstName, String buyerLastName, String buyerAddress, String buyerCity, String buyerState, int buyerZip){
        buyerData cursor = getBuyer(buyerFirstName, buyerLastName, buyerAddress, buyerCity, buyerState, buyerZip);
        if(cursor != null){
            return cursor.selectedFood.containsFood(foodName);
        }
        return false;
    }
    public static void main(String[] args){

        
        String buyerFirstName="Peter";
        String buyerLastName="Wang";
        String buyerAddress="home";
        String buyerCity="Bergenfield";
        String buyerState="nj";
        int buyerZip=01111;
        buyerData temp = new buyerData();
        temp.addBuyer(buyerFirstName, buyerLastName, buyerAddress, buyerCity, buyerState, buyerZip);
        //head.addBuyer("Satip","juju","not home","Bergenfield","nj",01111);
        System.out.println(temp.containsBuyer(buyerFirstName, buyerLastName, buyerAddress, buyerCity, buyerState, buyerZip));
        //System.out.println(head.containsBuyerSimple("Satip", "juju", 01112));
        
        //head.removeBuyer("Satip", "juju", 01111);
        //head.removeBuyer(firstName, lastName, address, city, state, zip);
        //System.out.println(head.containsBuyerSimple("Satip","juju",01111));
        //System.out.println(head.containsBuyer(firstName, lastName, address, city, state, zip));
        sellers temp2 = new sellers();
        String sellerFirstName = "Sajin";
        String sellerLastName = "Saju";
        String sellerAddress = "45 Melrose Ave";
        String sellerCity = "Bergenfield";
        String sellerState = "NJ";
        int sellerZip = 07621;

        
    }
}
