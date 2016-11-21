package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortTest  {



    private static List<Integer> randomIntegerArray(int n){
	return null;
    }

    public List<Integer> generateRandomList(int length){

    	List<Integer> li = new ArrayList<Integer>();

    	Random rand = new Random();
    	rand.setSeed(System.currentTimeMillis());

    	for(int i = 0; i<length; i++){
    		Integer r = rand.nextInt() % 256;
    		li.add(r);
    	}

    	return li;
    }


    /*
    @Test // This test is an example template using an oracle
    public void randomTestExample() {
	int n_runs = 10;
	for(int i=0;i<n_runs;i++){
	    
	    // Generate a random array of size 10
	    List<Integer> sorted = randomIntegerArray(10);

	    // Copy the sorted array before sorting it 
	    List<Integer> original = new ArrayList(sorted);

	    // Sort it
	    Sort.sort(sorted);

	    // Test the result 
	    assertTrue(SortOracle.isSorted(original,sorted));
	}
    }
    
    */
    @Test
    public void randomTestOracle() {  

    	int n_runs = 100;
    	Random rand = new Random();
    	rand.setSeed(System.currentTimeMillis());

    	for(int i =0; i<n_runs;i++){

    		List<Integer> sorted = generateRandomList(rand.nextInt(1000));
    		List<Integer> original = new ArrayList(sorted);
    		Sort.sort(sorted);
    		assertTrue(SortOracle.isSorted(original,sorted));
    	}  

    }

    @Test
    public void randomTestAssertion() {    

    	int n_runs = 100;
    	Random rand = new Random();
    	rand.setSeed(System.currentTimeMillis());

    	for(int i =0; i<n_runs;i++){

    		List<Integer> sorted = generateRandomList(rand.nextInt(1000));
    		
    		List<Integer> original = new ArrayList(sorted);

    		Sort.sort(sorted);
    		assertEquals(original.size(), sorted.size());
    		assertEquals(Collections.max(sorted).intValue(),sorted.toArray(new Integer[0])[sorted.size()-1].intValue());
    		if(sorted.size()>=2){
    			assertTrue(sorted.toArray(new Integer[0])[sorted.size()-1].intValue()>=sorted.toArray(new Integer[0])[sorted.size()-2].intValue());
    		}
    		assertEquals(Collections.min(sorted).intValue(), sorted.toArray(new Integer[0])[0].intValue());
    		if(sorted.size()>=300){
    			assertTrue(sorted.toArray(new Integer[0])[100].intValue()<=sorted.toArray(new Integer[0])[101].intValue());
    		}
    	}  

    }
}
