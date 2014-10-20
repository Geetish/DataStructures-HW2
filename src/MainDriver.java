import java.util.ArrayDeque;
import java.util.Deque;

/************************************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Homework 2
 * 
 * Objectives:
 * 1. Understand how Queue/Deque can be used as an aid in an algorithm.
 * 2. Explore and compare different data structures 
 *    (ArrayDeque and LinkedList) and their methods 
 *    to solve the same problem.
 *
 ************************************************************************/

public class MainDriver {

	public static void main(String[] args) {
		try{// the size and rotation values to be changed
		int size = 66;
        int rotation = 100;
		//int size =66;
		//int rotation = 100;
        Josephus game = new Josephus();
        StopWatch timer1 = new StopWatch();
        System.out.println("Survivor's position: " + game.playWithAD(size, rotation));
        System.out.println("Computing time with ArrayDeque used as Queue/Deque: "+timer1.elapsedTime()+" millisec.");
        
        
        StopWatch timer2 = new StopWatch();
        System.out.println("Survivor's position: " + game.playWithLL(size, rotation));
        System.out.println("Computing time with LinkedList used as Queue/Deque: "+timer2.elapsedTime()+" millisec.");
        
        
        StopWatch timer3 = new StopWatch();
        System.out.println("Survivor's position: " + game.playWithLLAt(size, rotation));
        System.out.println("Computing time with LinkedList (remove with index) : "+timer3.elapsedTime()+" millisec.");
        
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
    
	}
	
}