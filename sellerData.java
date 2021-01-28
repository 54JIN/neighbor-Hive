public class sellerData{
    /*
    $$TO DO:
    **Make a get method for each data?
    **Make a set method for each data?
    **Make sure added data are capitialised. 
    */

    //Sellers information
    String sellerFirstName;
    String sellerLastName;
    String sellerAddress;
    String sellerCity;
    String sellerState;
    int sellerZip;

    //Sellers goods
    foodSale avaFoods;
    drinkSales avaDrinks;
    condimentSales avaCondiments;

    //Linked List pointners
    sellerData head;
    sellerData previous;

    //class initialization
    public sellerData(){
        this.head = null;
        this.previous = null;
    }
    //class initialization with content
    public sellerData(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        this.sellerFirstName = sellerFirstName;
        this.sellerLastName = sellerLastName;
        this.sellerAddress = sellerAddress;
        this.sellerCity = sellerCity;
        this.sellerState = sellerState;
        this.sellerZip = sellerZip;
        this.previous = null;

        this.avaFoods = new foodSale();
        this.avaDrinks = new drinkSales();
        this.avaCondiments = new condimentSales();
    }
    //O(1) insert time
    public void addData(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        sellerData temp = new sellerData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        if(head == null){
            head = temp;
        }
        else{
            temp.previous = head;
            head = temp;
        }
    }
    //O(1) insert time
    public void addData(sellerData tempData){
        if(head == null){
            head = tempData;
        }
        else{
            tempData.previous = head;
            head = tempData;
        }
    }
    //O(n) search time, checks if the individual exits within the list
    public boolean containsData(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        if(head == null){
            return false;
        }
        else{
            sellerData cursor = head;
            while(cursor.previous != null){
                if(cursor.sellerFirstName.equals(sellerFirstName) && cursor.sellerLastName.equals(sellerLastName) && cursor.sellerAddress.equals(sellerAddress) && cursor.sellerCity.equals(sellerCity) && cursor.sellerState.equals(sellerState) && cursor.sellerZip == sellerZip){
                    return true;
                }
                cursor = cursor.previous;
            }
            if(cursor.sellerFirstName.equals(sellerFirstName) && cursor.sellerLastName.equals(sellerLastName) && cursor.sellerAddress.equals(sellerAddress) && cursor.sellerCity.equals(sellerCity) && cursor.sellerState.equals(sellerState) && cursor.sellerZip == sellerZip){
                return true;
            }
            return false;
        }
    }
    //O(n) search time, return the node containg the data of the seller
    public sellerData getSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        if(head == null){
            return null;
        }
        else{
            sellerData cursor = head;
            while(cursor.previous != null){
                if(cursor.sellerFirstName.equals(sellerFirstName) && cursor.sellerLastName.equals(sellerLastName) && cursor.sellerAddress.equals(sellerAddress) && cursor.sellerCity.equals(sellerCity) && cursor.sellerState.equals(sellerState) && cursor.sellerZip == sellerZip){
                    return cursor;
                }
                cursor = cursor.previous;
            }
            if(cursor.sellerFirstName.equals(sellerFirstName) && cursor.sellerLastName.equals(sellerLastName) && cursor.sellerAddress.equals(sellerAddress) && cursor.sellerCity.equals(sellerCity) && cursor.sellerState.equals(sellerState) && cursor.sellerZip == sellerZip){
                return cursor;
            }
            return null;
        }
    }
    //removes the seller from the linked list on all parts: head, middle, tail
    //O(n) time complexity
    public void removeSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        if(head != null || head.previous != null){
            if(head.sellerFirstName.equals(sellerFirstName) && head.sellerLastName.equals(sellerLastName) && head.sellerAddress.equals(sellerAddress) && head.sellerCity.equals(sellerCity) && head.sellerState.equals(sellerState) && head.sellerZip == sellerZip){
                head = head.previous;
            }
            //if it does not match the head then:
            else{
                sellerData cursor = head;
                while(cursor.previous != null){
                    if(cursor.previous.sellerFirstName.equals(sellerFirstName) && cursor.previous.sellerLastName.equals(sellerLastName) && cursor.previous.sellerAddress.equals(sellerAddress) && cursor.previous.sellerCity.equals(sellerCity) && cursor.previous.sellerState.equals(sellerState) && cursor.previous.sellerZip == sellerZip){
                        cursor.previous = cursor.previous.previous;
                        break;
                    }
                    cursor = cursor.previous;
                }
            }
        }
    }
    public void addFood(String foodName, double foodPrice, boolean priceHaggle, String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        sellerData cursor = getSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        if(cursor != null){
            cursor.avaFoods.add(foodName, foodPrice, priceHaggle);;
        }
    }
    //removes specific food within the sellers options of food
    //O(n) time complexity
    public void removeFood(String foodName, String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        sellerData cursor = getSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        if(cursor != null){
            cursor.avaFoods.removeFood(foodName);
        }
    }
    public boolean containsFood(String foodName, String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        sellerData cursor = getSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        if(cursor != null){
            return cursor.avaFoods.containsFood(foodName);
        }
        return false;
    }
    public static void main(String[] args){
        
        sellerData temp = new sellerData();
        String sellerFirstName = "Sajin1";
        String sellerLastName = "Saju1";
        String sellerAddress = "451 Melrose Ave";
        String sellerCity = "Bergenfield1";
        String sellerState = "NJ1";
        int sellerZip = 076212;
        temp.addData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        temp.addData("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621);
        temp.addData("Peter", "Zhang", "35 Mel Ave", "Bergenfield", "NJ", 07621);
        System.out.println(temp.head.sellerFirstName);
        System.out.println(temp.containsData("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621));
        System.out.println(temp.containsData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        temp.removeSeller("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621);
        System.out.println(temp.containsData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        System.out.println(temp.containsData("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621));
        System.out.println(temp.containsData("Peter", "Zhang", "35 Mel Ave", "Bergenfield", "NJ", 07621));
        System.out.println(temp.head.previous.sellerFirstName);//sajin
        temp.addFood("Burger", 1.00, false, sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        System.out.println(temp.containsFood("Burger", sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        
        //sellerData temp = new sellerData();
        //temp.addData("Sajin", "Saju", "45 M", "Ber", "se", 07621);
        //sellerData temp2 = new temp;
    }
}