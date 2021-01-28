
import java.util.Scanner;

public class sellers {
    /*
    $$Description
    **
    $$TO DO:
    **set method,
    **get method: list of food, food in question, list of drinks, drink in question, list of condiments, condiments in question
    **ensure data are added as either all capital or all lowercase when stored.
    */
    //Sellers information
    sellerData sellerContent;
    int sellerID;

    //Binary Tree information
    sellers root;
    sellers leftTree;
    sellers rightTree;

    //Initializations for class
    public sellers(){
        this.leftTree = null;
        this.rightTree = null;
    }
    //Initializations for class with information
    public sellers(int val){
        this.sellerID = val;
        this.leftTree = null;
        this.rightTree = null;
    }
    //add seller to the binary tree recursively
    public void addBinaryTree(sellers root, sellerData tempData, int val){
        if(root.sellerID == val){
            System.out.println("check: ");
            root.sellerContent.addData(tempData);
        }
        else if(root.leftTree == null && val < root.sellerID){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root.leftTree = temp;
        }
        else if(root.rightTree == null && val > root.sellerID){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root.rightTree = temp;
        }
        else if(val < root.sellerID){
            addBinaryTree(root.leftTree, tempData, val);
        }
        else if(val > root.sellerID){
            addBinaryTree(root.rightTree, tempData, val);
        }
    }
    //return the hashVal of the data provided
    public int hashVal(String sellerFirstName, String sellerLastName, String sellerAddress, int sellerZip){
        return (int)(Math.abs((sellerFirstName + sellerLastName + sellerAddress).hashCode()/sellerZip));
    }
    //add sellers
    public void addSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        int val = (int)(Math.abs((sellerFirstName + sellerLastName + sellerAddress).hashCode()/sellerZip));
        sellerData tempData = new sellerData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        //if the root is empty
        if(root == null){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root = temp;
        }
        else{
            addBinaryTree(root, tempData, val);
        }
    }
    //search the tree for a specific ID
    public sellerData searchTree(sellers root,int ID){
        if(root != null){
            if(root.sellerID == ID){
                return root.sellerContent;
            }
            else if(ID < root.sellerID){
                return searchTree(root.leftTree, ID);
            }
            else if(ID > root.sellerID){
                return searchTree(root.rightTree, ID);
            }
        }
        return null;
    }
    //checks if the sellers is within the binary tree
    public boolean containsSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        int ID = hashVal(sellerFirstName, sellerLastName, sellerAddress, sellerZip);
        sellerData tempData = searchTree(root, ID);
        
        return tempData == null? false : tempData.containsData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
    }
    public void findFood(String food){
        //find the food, the seller, the price of the food and lists it out of all the sellers.
    }
    public static void main(String[] args){
        sellers temp = new sellers();
        /*
        String sellerFirstName = "Sajin";
        String sellerLastName = "Saju";
        String sellerAddress = "45 Melrose Ave";
        String sellerCity = "Bergenfield";
        String sellerState = "NJ";
        int sellerZip = 07621;
        temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        sellerFirstName = "Peter";
        sellerLastName = "Zhang";
        sellerAddress = "35 Melrose Ave";
        sellerCity = "Bergenfield";
        sellerState = "NJ";
        sellerZip = 07621;
        temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        */
        /*
        Scanner scan = new Scanner(System.in);
        
        boolean loop = true;
        while(loop){
            System.out.println("Input: ");
            String val = scan.nextLine();
            if(val.equals("stop")){
                loop = false;
            }
            else if(val.equals("add seller")){
                System.out.println("First Name: ");
                String sellerFirstName = scan.nextLine();
                System.out.println("Last Name: ");
                String sellerLastName = scan.nextLine();
                System.out.println("Address: ");
                String sellerAddress = scan.nextLine();
                System.out.println("City: ");
                String sellerCity = scan.nextLine();
                System.out.println("State: ");
                String sellerState = scan.nextLine();
                System.out.println("Zip: ");
                int sellerZip = Integer.parseInt(scan.nextLine());
                temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
            }
            else if(val.equals("contains seller")){
                System.out.println("First Name: ");
                String sellerFirstName = scan.nextLine();
                System.out.println("Last Name: ");
                String sellerLastName = scan.nextLine();
                System.out.println("Address: ");
                String sellerAddress = scan.nextLine();
                System.out.println("City: ");
                String sellerCity = scan.nextLine();
                System.out.println("State: ");
                String sellerState = scan.nextLine();
                System.out.println("Zip: ");
                int sellerZip = Integer.parseInt(scan.nextLine());
                System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
            }
        }
        */
    }
=======
import java.util.Scanner;

public class sellers {
    /*
    $$Description
    **
    $$TO DO:
    **set method,
    **get method: list of food, food in question, list of drinks, drink in question, list of confiments, condiment in question
    **enusre data are added as eiter all capital or all lowercase when stored.
    */
    //Sellers information
    sellerData sellerContent;
    int sellerID;

    //Binary Tree information
    sellers root;
    sellers leftTree;
    sellers rightTree;

    //Initializations for class
    public sellers(){
        this.leftTree = null;
        this.rightTree = null;
    }
    //Initializations for class with information
    public sellers(int val){
        this.sellerID = val;
        this.leftTree = null;
        this.rightTree = null;
    }
    //add seller to the binary tree recursively
    public void addBinaryTree(sellers root, sellerData tempData, int val){
        if(root.sellerID == val){
            System.out.println("check: ");
            root.sellerContent.addData(tempData);
        }
        else if(root.leftTree == null && val < root.sellerID){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root.leftTree = temp;
        }
        else if(root.rightTree == null && val > root.sellerID){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root.rightTree = temp;
        }
        else if(val < root.sellerID){
            addBinaryTree(root.leftTree, tempData, val);
        }
        else if(val > root.sellerID){
            addBinaryTree(root.rightTree, tempData, val);
        }
    }
    //return the hashVal of the data provided
    public int hashVal(String sellerFirstName, String sellerLastName, String sellerAddress, int sellerZip){
        return (int)(Math.abs((sellerFirstName + sellerLastName + sellerAddress).hashCode()/sellerZip));
    }
    //add sellers
    public void addSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        int val = (int)(Math.abs((sellerFirstName + sellerLastName + sellerAddress).hashCode()/sellerZip));
        sellerData tempData = new sellerData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        //if the root is empty
        if(root == null){
            sellers temp = new sellers(val);
            temp.sellerContent = new sellerData();
            temp.sellerContent.addData(tempData);
            root = temp;
        }
        else{
            addBinaryTree(root, tempData, val);
        }
    }
    //search the tree for a specific ID
    public sellerData searchTree(sellers root,int ID){
        if(root != null){
            if(root.sellerID == ID){
                return root.sellerContent;
            }
            else if(ID < root.sellerID){
                return searchTree(root.leftTree, ID);
            }
            else if(ID > root.sellerID){
                return searchTree(root.rightTree, ID);
            }
        }
        return null;
    }
    //checks if the sellers is within the binary tree
    public boolean containsSeller(String sellerFirstName, String sellerLastName, String sellerAddress, String sellerCity, String sellerState, int sellerZip){
        int ID = hashVal(sellerFirstName, sellerLastName, sellerAddress, sellerZip);
        sellerData tempData = searchTree(root, ID);
        
        return tempData == null? false : tempData.containsData(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
    }
    public static void main(String[] args){
        sellers temp = new sellers();
        /*
        String sellerFirstName = "Sajin";
        String sellerLastName = "Saju";
        String sellerAddress = "45 Melrose Ave";
        String sellerCity = "Bergenfield";
        String sellerState = "NJ";
        int sellerZip = 07621;
        temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        sellerFirstName = "Peter";
        sellerLastName = "Zhang";
        sellerAddress = "35 Melrose Ave";
        sellerCity = "Bergenfield";
        sellerState = "NJ";
        sellerZip = 07621;
        temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
        System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
        */
        
        Scanner scan = new Scanner(System.in);
        
        boolean loop = true;
        while(loop){
            System.out.println("Input: ");
            String val = scan.nextLine();
            if(val.equals("stop")){
                loop = false;
            }
            else if(val.equals("add seller")){
                System.out.println("First Name: ");
                String sellerFirstName = scan.nextLine();
                System.out.println("Last Name: ");
                String sellerLastName = scan.nextLine();
                System.out.println("Address: ");
                String sellerAddress = scan.nextLine();
                System.out.println("City: ");
                String sellerCity = scan.nextLine();
                System.out.println("State: ");
                String sellerState = scan.nextLine();
                System.out.println("Zip: ");
                int sellerZip = Integer.parseInt(scan.nextLine());
                temp.addSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip);
            }
            else if(val.equals("contains seller")){
                System.out.println("First Name: ");
                String sellerFirstName = scan.nextLine();
                System.out.println("Last Name: ");
                String sellerLastName = scan.nextLine();
                System.out.println("Address: ");
                String sellerAddress = scan.nextLine();
                System.out.println("City: ");
                String sellerCity = scan.nextLine();
                System.out.println("State: ");
                String sellerState = scan.nextLine();
                System.out.println("Zip: ");
                int sellerZip = Integer.parseInt(scan.nextLine());
                System.out.println(temp.containsSeller(sellerFirstName, sellerLastName, sellerAddress, sellerCity, sellerState, sellerZip));
            }
        }
        
    }

}