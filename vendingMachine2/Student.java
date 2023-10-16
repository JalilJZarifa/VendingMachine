
/**
 * Student Class
 *
 * Jalil Zarifa
 * 8/12/22
 */
import java.util.ArrayList;
public class Student
{
    private static int STUDENT_ID = 0;
    private String studentFav;
    private SnackMachine Smachine;
    private String IDnum;
    private Pocket pocket;
    private PackOfCrisps studentPack;

    /**
     * Constructor for objects of class Student. The string parameter is used to initialise the student's favourite, this is the same with the snack machine
     * class being used to initialise Smachine = machine.
     */
    public Student(String flavour, SnackMachine machine)
    {
        STUDENT_ID++;
        studentFav = flavour;
        Smachine = machine;
        IDnum = "student" + STUDENT_ID;
        pocket = new Pocket(20);
        studentPack = null;
        
    }

    /**
     * If the amount inside of the pocket in terms of pennies is less than the price retrieved from the machine, a statement indicating the lack of pennies
     * will be displayed. The student's ID number (being the student object + the ID number) will be added into the statement to indicate which student is 
     * attempting to buy crisps. The same is done in the else if, however the only difference is that the comparison is between how many of the student's
     * favourite packs are in the snack machine (Smachine). Again, if there aren't any packs available, a statement will be displayed.
     * 
     * The last else indicates that the student has enought money and their favourite is available. As such, a new penny object is created where the snack
     * machine uses this to insert into the machine where the price will be incremented. A penny is then removed from the pocket of the student. This is
     * essentailly the student purchasing the packet of crisps in an exchange of goods.
     * 
     * After this the method buyPack is used from the SnackMachine class to give to the student and to do this a new object is created and given the value
     * of the student pack and so the student now has the packet of crisps.
       */
    private void buyCrisps()
    {
        if(pocket.pennyCount() < Smachine.getCost()){
            System.out.println(IDnum + " "+ "doesn't have enough money to buy a pack!");
        }else if(Smachine.countPacks(studentFav) == 0) {
            System.out.println("The machine has ran out of" + " " +IDnum + " " +"'s favourite" + " " + studentFav + " " + "crisps");
        }else {
            Penny pen = new Penny();
            for (int i=0; i < Smachine.getCost(); i++){
                Smachine.insertMoney(pen);
                pocket.removePenny();
            }
            Smachine.buyPack(studentFav);
            PackOfCrisps pack = new PackOfCrisps(studentFav);
            studentPack = pack;
            
        }
        
    }
    /**
     * If there is no pack currently present - this means that the student hasn't bought one and needs to buy one, as such the buyCrisps method is called.
     * If there is a pack and it's closed - the student needs to simply open the pack and so the open pack method from the PackOfCrisps class is called.
     * If there is a pack and it's not currently empty, a statement indiciating that the student is eating their favourite crisps is displayed.
     * While there is a pack and it's not empty, the eatCrisp() method will continue to be called.
     * After the pack has been finished, a print statement is displayed and the pack is returned to null.
     * 
       */
    public void snackTime(){
    if(studentPack == null){
            System.out.println(IDnum + " " + "is buying a pack of crisps");
            buyCrisps();
    }
    if(studentPack != null && studentPack.isClosed()){
            System.out.println(IDnum + " " + "is opening the packet");
            studentPack.open();
    }
    if(studentPack != null && !(studentPack.isEmpty())){
        System.out.println(IDnum + " " + "is eating their favourite" + " " + studentFav + " " + "crisps");
    } 
    while(studentPack != null && !(studentPack.isEmpty())){
        studentPack.eatCrisp();
    }
    if(studentPack != null && studentPack.isEmpty()){
        System.out.println(IDnum + " " + "has finished the packet!");
        studentPack = null;
    }
    
    }
}       
