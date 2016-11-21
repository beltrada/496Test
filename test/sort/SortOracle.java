package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortOracle  {
    public static boolean isSorted(List<Integer> original, List<Integer> sorted){
	/* 
	   Determines whether `sorted` is a sorted (ascending) version
	   of `original` by sorting original with a known good
	   implementation. This method should ***not*** mutate sorted

	   @param   original  a list of integers 
	   @param   sorted    a (possibly sorted) list of integers  
	   @returns      True if the list is sorted in ascending order
	*/
	    Collections.sort(original);

	    Integer originalSorted[] = new Integer[original.size()];

	    originalSorted = original.toArray(originalSorted);

	    Integer sortedArray[] = new Integer[sorted.size()];

	    sortedArray = sorted.toArray(sortedArray);

	    if(Arrays.equals(originalSorted,sortedArray)){
	   		return true;
	    }
	    else{
			return false;
		}
    }


}
