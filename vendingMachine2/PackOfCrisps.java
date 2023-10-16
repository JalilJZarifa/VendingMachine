/**
 * Pack of crisps class
 *
 * Jalil Zarifa
 * 8/12/22
 */
public class PackOfCrisps{
    private boolean open;
    private int numOfCrisps;
    private String flavour;
    /**
     * Constructor for PackOfCrisps class. The string parameter is used to initialise the string, flavour.
     */
    public PackOfCrisps(String InputFlavour){
        open = false;
        numOfCrisps = 10;
        flavour = InputFlavour;
    }
    /**
     * The isEmpty method, which returns a boolean value(true or false) checks if the packet of crisps is empty by counting the number of crisps inside. 
     * This was initialised at 10. If the number of crisps is 0, a true statement is returned indiciating that the packet is empty. Else a false value is
     * returned indicating that the number of crisps is above 0, so not empty.
     */
    public boolean isEmpty(){
        if(numOfCrisps==0){
            return true;
        }else {
            return false;
        }    
    }
    /**
     * The isClosed method, similarly to the isEmpty method, returns a boolean value. This, unlike the isEmpty method, checks whether the packet of crisps
     * has been opened yet. If it is, a false value is returned indicating that it is not closed, else true is returned indiciating that it is closed.
     */
    public boolean isClosed(){
        if(open){
            return false;
        } else {
            return true;
        }
    }
    /**
     * This method closes the packet of crisps by equating it is false.
     */
    public void open(){
        open=false;
    }
    /**
     * This method returns a string which is the flavour of crisp
     */
    public String getFlavour(){
        return flavour;
    }
    /**
     * This method eats the crisps. If the packet is not false, meaning open, and the packet is not empty, a crisp will be deducted from the packet,
     * simulating someone eating a crisp one by one. Else, a message indicating that the packet is yet to be opened will be displayed.
     */
    public void eatCrisp(){
        
        if (!open && !isEmpty()){
            numOfCrisps--;
        } else { 
            System.out.println("need to open the packet first!");
        }

    }
    
}
