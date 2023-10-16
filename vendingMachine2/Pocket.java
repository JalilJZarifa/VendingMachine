
/**
 * Pocket Class
 *
 * Jalil Zarifa
 * 8/12/22
 */

import java.util.HashSet;

public class Pocket
{
    private HashSet<Penny>pocket;

    /**
     * Constructor for objects of class Pocket - This adds a new penny object to the pocket hashset in a for loop.
     */
    public Pocket(int pocketSize){
            
            pocket = new HashSet<Penny>();
            for(int i = 0; i < pocketSize; i++) {
                Penny penny = new Penny();
                pocket.add(penny);
            }
            
    }
    /**
     * The pennyCount method simply returns an int - the size of the hash set: pocket.
        */
    public int pennyCount(){
        return pocket.size();
    }
    /** 
     * The removePenny method removes a penny object from the pocket hashset. For each penny object in the pocket, one will be removed.
     * If not, null is returned.
       */
    public Penny removePenny(){
        for(Penny penny : pocket){
                pocket.remove(penny);
                return penny;
        }
        return null;
    }
}
