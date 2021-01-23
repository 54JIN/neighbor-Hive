public class sellers{

    //Sellers information
    String sellerName;
    String sellerAddress;
    String sellerCity;
    String sellerState;
    int sellerZip;

    //Sellers goods
    foodSale avaFoods;
    drinkSale avaDrinks;
    condimentSale avaCondiments;

    //Binary Tree information
    sellers root;
    sellers leftTree;
    sellers rightTree;

    //Initializations for class
    public sellers(){
        this.leftTree = null;
        this.rightTree - null;
    }
    //Initializations for class with information
    public sellers(String sellerName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerCity = sellerCity;
        this.sellerState = sellerState;
        this.sellerZip = sellerZip;
        this.leftTree = null;
        this.rightTree = null;
    }

    public static void main(String[] args){
        String name = "Sajin";
        String name2 = "Zihe zhang 35 trump ave bergenfield nj 07621";
        String name3 = "Sajin Saju 45 Melrose ave bergenfield nj 07621";
        int temp = name.hashCode();
        long temp2 = Math.abs(name2.hashCode()/name2.length());
        long temp3 = Math.abs(name3.hashCode()/name3.length());
        System.out.println(temp);
        System.out.println(temp2);
        System.out.println(temp3);
    }
}