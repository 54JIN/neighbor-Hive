public class main {
    public static void main(String[] args){

        
        //populates the sellers
        sellerData seller=new sellerData();
        String sellerFirstName="Peter";
        String sellerLastName="Wang";
        String sellerAddress="home";
        String sellerCity="bj";
        String sellerState="nj";
        int sellerZip=07621;
        seller.addData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        
        //populate the foods sells for sellers
        foodSale food= new foodSale();
        food.add("burger", 5.0, true);
        food.add("chicken", 2.5, false);
        food.add("cake", 3.0, false);

        //attach the food into the sellerData
        seller.avaFoods=food;

        //populat the buyers
        buyerData buyer=new buyerData();
        String firstName="sajin";
        String lastName="juju";
        String address="bridge";
        String city="bj";
        String state="nj";
        int zip=07621;
        buyer.addBuyer(firstName, lastName, address, city, state, zip);

        //set up buyers perefrence
        buyer.preference_food="burger";
        buyer.findFood(seller);

        //peek
        
    }
}
