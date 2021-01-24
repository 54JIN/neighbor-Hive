public class sellerData{

    //Sellers information
    String sellerFirstName;
    String sellerLastName;
    String sellerAddress;
    String sellerCity;
    String sellerState;
    int sellerZip;

    //Sellers goods
    foodSale avaFoods;
    drinkSale avaDrinks;
    condimentSale avaCondiments;

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
    public static void main(String[] args){
        sellerData temp = new sellerData();
        String sellerFirstName = "Sajin";
        String sellerLastName = "Saju";
        String sellerAddress = "45 Melrose Ave";
        String sellerCity = "Bergenfield";
        String sellerState = "NJ";
        int sellerZip = 07621;
        temp.addData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        //temp.addData("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621);
        //temp.addData("Peter", "Zhang", "35 Mel Ave", "Bergenfield", "NJ", 07621);
        //System.out.println(temp.containsData("Sajin", "Saju", "45 Melrose Ave", "Bergenfield", "NJ", 07621));
        System.out.println(temp.containsData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
    }
}