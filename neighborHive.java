import java.util.Scanner;
public class neighborHive{
    public static void main(String[] args){
        buyerData buyersList = new buyerData();
        sellers sellersList = new sellers();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Command: ");
            String command = scan.nextLine().toLowerCase();
            if(command.equals("stop")){
                break;
            }
            else if(command.equals("add buyer")){
                System.out.println("First Name: ");
                String firstName = scan.nextLine().toLowerCase();
                System.out.println("Last Name: ");
                String lastName = scan.nextLine().toLowerCase();
                System.out.println("Address: ");
                String address = scan.nextLine().toLowerCase();
                System.out.println("City: ");
                String city = scan.nextLine().toLowerCase();
                System.out.println("State: ");
                String state = scan.nextLine().toLowerCase();
                System.out.println("Zip Code: ");
                int zip = Integer.parseInt(scan.nextLine());
                buyersList.addBuyer(firstName, lastName, address, city, state, zip);
            }
            else if(command.equals("add seller")){
                System.out.println("First Name: ");
                String sellerFirstName = scan.nextLine().toLowerCase();
                System.out.println("Last Name: ");
                String sellerLastName = scan.nextLine().toLowerCase();
                System.out.println("Address: ");
                String sellerAddress = scan.nextLine().toLowerCase();
                System.out.println("City: ");
                String sellerCity = scan.nextLine().toLowerCase();
                System.out.println("State: ");
                String sellerState = scan.nextLine().toLowerCase();
                System.out.println("Zip Code: ");
                int sellerZip = Integer.parseInt(scan.nextLine());
                sellersList.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
            }
            else if(command.equals("add food")){
                System.out.println("What type of food: ");
                String foodName = scan.nextLine().toLowerCase();
                double foodPrice = Double.parseDouble(scan.nextLine());
                boolean priceHaggle = scan.nextLine().toLowerCase().equals("true")? true : false;
                foodSale food = new foodSale();
                food.add(foodName, foodPrice, priceHaggle);
                sellersList.addFood(food, seller);
            }
            else if(command.equals("search food")){
                System.out.println("What type of food: ");
                String foodName = scan.nextLine().toLowerCase();

            }
            //scan.close();
        }
    }
}