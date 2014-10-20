import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Homework 2 
 * Solve Josephus problem with different data structures
 * and compare running time
 * 
 * Andrew id: gnayak		 
 * Name: Geetish Nayak
 *
 *********************************************************/

public class Josephus {
	
	/**
   	 * This method uses ArrayDeque data structure as Queue/Deque 
   	 * to find the survivor's position. 
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be greater than 0.
     * @return The position value of the survivor.
     */
	@SuppressWarnings(value = { "all" })
	public int playWithAD(int size, int rotation){
		if(size<=0 || rotation<=0){
			throw new RuntimeException("Size and Rotation cannot be less than or equal to zero");
		}
		else{
			// Declaration of ArrayDeque
			Deque<Integer> deque =new ArrayDeque();
			for(int i=0;i<size;i++){
				deque.addLast(i+1);
			}
			// This variable is used for iteration purpose
			int j=0;
			while(true){
				//The End Condition
				// This means that there is only one person left in the queue
				if(deque.size()==1){
					break;
				}
				// Increment the iterator
				j++;
				//if j reaches the number of rotations we
				// have to remove the first element in the dequeue
				if(j==rotation){
					deque.removeFirst();
					j=0;
				}
				else{
					// this is with respect to adding the people 
					// to the lasts
					deque.addLast((Integer)deque.removeFirst());
				}
			}
			// Return the last person who is left
			return (Integer)deque.removeFirst();
		}
    }

    /**
   	 * This method uses LinkedList data structure as Queue/Deque 
   	 * to find the survivor's position. 
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be greater than 0.
     * @return The position value of the survivor.
     */
    public int playWithLL(int size, int rotation){
    	// Exception handling
    	if(size<=0 || rotation<=0){
			throw new RuntimeException("Size and Rotation cannot be less than or equal to zero");
		}
    	else{
    		// Declaration of LinkedList type of object
    		LinkedList<Integer> linkedList=new LinkedList<Integer>();
    		for(int i=0;i<size;i++){
    			linkedList.addLast(i+1);
    		}
    		int j=0;
    		while(true){
    			// This means that there is only one person
    			// in the list now hence break
    			if(linkedList.size()==1){
    				break;
    			}
    			j++;
    			// if j reaches the number of rotations we
				// have to remove the first element in the linkedList
    			if(j==rotation){
					linkedList.removeFirst();
					j=0;
				}
				else{
					// Adding people to the last 
					linkedList.addLast((Integer)linkedList.removeFirst());
				}
    		}
    		// Return the only person who is left in the list
    		return (Integer)linkedList.removeFirst();
    	}
    	
    }

    /**
   	 * This method uses LinkedList data structure to find the survivor's position. 
   	 * However, this does not use the LinkedList as Queue/Deque. 
   	 * Instead, this method uses index to find a person to be executed in the circle.
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be greater than 0.
     * @return The position value of the survivor.
     */
    public int playWithLLAt(int size, int rotation){
    	if(size<=0 || rotation<=0){
    		throw new RuntimeException("Size and Rotation cannot be less than or equal to zero");
		}
    	else{
    		LinkedList<Integer> linkedList=new LinkedList<Integer>();
    		for(int i=0;i<size;i++){
    			linkedList.addLast(i+1);
    		}
    		// Initialization of 2 iterators
    		int j=-1;
    		int k=0;
    		while(true){
    			// This means that there is only one person
    			// in the list now hence break
    			if(linkedList.size()==1){
    				break;
    			}
    			j++;
    			k++;
    			if(j==linkedList.size()){
    				j=0;
    			}
    			if(k==rotation){
    				// Remove with index
					linkedList.remove(j);
					j=j-1;
					k=0;
					if(j==linkedList.size()){
						j=0;
					}
						
				}
    		}
    		// Remove the last person who is there
    		// in the queue
    		return (Integer)linkedList.removeFirst();
    	}

    }
    
}