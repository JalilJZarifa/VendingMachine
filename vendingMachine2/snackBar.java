import java.util.Random;
import java.util.ArrayList;

/**
 * snackBar class
 *
 * Jalil Zarifa
 * 8/12/22
 */
public class snackBar
{
    
    private Random rand;
    private String[] flavours;
    private SnackMachine machine;
    private ArrayList<Student>students;
    /**
     * Constructor for snackBar class - there are three integer variables which indicate what is necessary for the class to initialise and run. For each
     * student object created, a random flavour (from the initialised array) and a snack machine is assigned. This student is then added to the array. This is the same for each
     * PackOfCrisps object.
     */
    public snackBar(int NumOfStudents, int NumOfCrisps, int PennyCost)
    {
        rand = new Random();
        flavours = new String[]{ "salt", "cheese", "bbq","honey", "spicy"};
        machine = new SnackMachine(NumOfCrisps, PennyCost);
        students = new ArrayList<Student>();
        
        for(int i=0; i < NumOfStudents; i++){
            Student pupil = new Student(randomFlavour(), machine);
            students.add(pupil);
            
        }
        
         for(int i = 0; i < NumOfCrisps; i++){
            
            PackOfCrisps pack = new PackOfCrisps(randomFlavour());
            machine.addPack(pack);
            
        }
    }
    /**
     * This method returns a string which is the random flavour that is assigned to each crisp and student. First an index, i, is created. The random
     * object that was initialised in the constructor is then used to get an index of the string array of flavours at random. this index is then used to
     * return a string from the string array.
     */
    private String randomFlavour()
    {
         int i=rand.nextInt(flavours.length);
         return flavours[i];
         
    }
    /**
     * This method describes the current state of the Snack bar and snack machine. It uses the students array to count the amount of students through the
     * size() function. Then, the countPacks() function from the snackMachine class is used to count the packs of each flavour in the machine.
     */
    public void describe(){
        System.out.println("The Snack Bar has" + " " + students.size() + " " + "hungry students");
        System.out.println("The Snack Machine has:");
        System.out.println(machine.countPacks("salt") + " " + "of salt crisps");
        System.out.println(machine.countPacks("cheese") + " " + "of cheese crisps");
        System.out.println(machine.countPacks("bbq") + " " + "of bbq crisps");
        System.out.println(machine.countPacks("honey") + " " + "of honey crisps");
        System.out.println(machine.countPacks("spicy") + " " + "of spicy crisps");
    }
    /**
     * The runSnackBar method requires an integer of the number of steps the snackBar will run for. This is also used to ensure that the for loop runs for
     * the amount specified times. First the time step is printed by using i. Then, the describe function is called to display what is happening at the 
     * current time stamp. A new random object is created to randomly select a student from the student array. This student is given the value y which is
     * then used to call the snackTime function.
     */
    public void runSnackBar(int nSteps) {
        
        for (int i = 1; i <= nSteps; i++) {
            System.out.println("Time Step" + " " + i);
            describe();
            Random x = new Random();
            int y = x.nextInt(students.size());
            students.get(y).snackTime();
            
        }
    }
    
    

}

