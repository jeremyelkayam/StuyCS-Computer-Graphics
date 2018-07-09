import java.util.*;
import java.io.*;
public class Sorts{//I hate algorithm design
    //mergesort was the last really cool algorithm
    //mazesolver was the last fun algorithm (and it was admittedly pretty cool)
    public static int[] heapSort(int[]z){//I realized that my heap was actually terrible and didn't work at all >_>
	/* unfinished heapsort:
	heapify(z);
	sortTheHeap(z);
	return z;
	*/
	
	//temporary cheapsort:
	PriorityQueue<Integer>cheap=new PriorityQueue<Integer>();
	for(int g : z){
	    cheap.add(g);
	}
	for(int g=0;g<z.length;g++){
	    z[g]=cheap.remove();
	}
	return z;
    }
    private static void heapify(int[]arr){
	for(int z=arr.length-1;z>=0;z--){
	    moveDown(arr,z,arr.length);
	}
    }
    private static void moveDown(int[]arr,int z, int end){

    }
    private static void sortTheHeap(int[]arr){
	
    }
    public static void main(String[]args){//Following the theme of laziness, I've opted to not include a creative name
	int[]z={1,6,4,8,7};
	System.out.println(Arrays.toString(heapSort(z)));
	
    }
    
}

