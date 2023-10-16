/**
 * Snack Machine class
 *
 * Jalil Zarifa
 * Version 1
 */
import java.util.ArrayList;
    
public class SnackMachine{
    private ArrayList<PackOfCrisps>packets;
    private int capacity;
    private int cost;
    private int payment;
    private ArrayList<Penny>pennies;
    /**
     * Constructor for objects of class Student
     */
    public SnackMachine(int maxCrisps, int packCost){
        packets = new ArrayList<PackOfCrisps>();
        capacity = maxCrisps;
        cost = packCost;
        pennies = new ArrayList<Penny>();
        payment = 0;
        
    }
    /**
     * This method returns an int, being the cost of the pack.
       */
    public int getCost(){
        return cost;
    }
    /**
     * This method adds a pack of crisps to the snack machine. The PackOfCrisps class is used to create the pack object which is then used to add to the
     * machine. If the size of the array packets is smaller than the size of the initally stated capacity, a packet is added to the machine, else the system
     * will print out a statement explaining that the maximum has been reached.
     */
    public void addPack(PackOfCrisps pack){
        if(packets.size()<capacity){
            packets.add(pack);
        }
        else{
            System.out.println("Maximum capacity reached!");
        }
    }
    /**
     * This method returns an int as it's purpose is to count the packs in the machine. A string parameter is used to compare the flavours. A for loop is 
     * executed to go through each element of the array, it will increment until the size of the array is reached. An if statement is used to check each
     * element of the array. If the flavour requested is the same as the flavour in the array, it will use the get method to get the index of the element
     * in the array, the flavour it is (element) and compare it to the flavour initially requested. This is why it is in the brackets of the signature. An 
     * int variable, c, is given the value 0 and incremets each time the if statement executes (which means each time the flavour requested has been
     * counted). As a result, the number returned will be the amount of the packet that is available in the array.
     */
    public int countPacks(String flavour){
       int c = 0;
       for(int i=0; i<packets.size();i++){
           if(packets.get(i).getFlavour()==flavour){
                c++;
            }
       }
       return c;
    } 
    /**
     * This method simply adds a penny to the pennies array. Each time this happens, the payment variable is incremented to ensure that there is enough
     * purchasing power (essentially enough pennies in the machine). The Penny object in the signature is created to be able to add a penny into the array.
     */
    public void insertMoney(Penny penny){
        pennies.add(penny);
        payment++;
    }
    /**
     * The buyPack function uses an if statement to check whether the payment given is greater than or equal to the cost. If so, a for loop will be executed
     * where it will go through the size of the array (Which is the whole array). This is done one by one. For each element it will check if the flavour 
     * requested (Which is why the string parameter flavour is present - to compare the flavours) is the one in the array. If so, c, which was initially
     * given the value 0, will take the value of the index of the flavour and then be removed from the array. This is essentally a crisp packet being 
     * bought and taken out a snack machine. A new PackOfCrisps object is created (Which is why the class is in the signature) where it takes on the value
     * of the flavour which has been requested. The payment from the user is then taken down to 0 and no change is given - this may be recognised as a flaw
     * of the method. The packet of crisp object is then returned through the form of x. The class otherwise returns null which means that the payment was
     * not higher or equal to the cost.
     */
    public PackOfCrisps buyPack(String flavour){   
        int c=0;
        if (payment>=cost){       
               for(int i=0; i<packets.size();i++){
                   if(packets.get(i).getFlavour()==flavour){
                        c=i;
                        packets.remove(c);
                        PackOfCrisps x = new PackOfCrisps(flavour);
                        payment=0;
                        return x;
                    }
               }
        }
        
        return null;
    }
    /**
     * This method simply outputs the amount of crisp packets in the snack machine by taking the size of the array. It then counts the amount of pennies
     * through the payment variable which inceremented each time a penny was added in the insetMoney() method.
     */
    public void describe(){
        System.out.println("The snack machine has: " + packets.size() + " " + "packets of crisps and "
        + payment + " " + "pennies");
    }
}
