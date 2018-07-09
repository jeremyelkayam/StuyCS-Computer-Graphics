import java.util.*;
public class Driver{
    private static String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rand=new Random();
    public static void main(String[]superArraysAreAwesome){
	/*
	SuperArrayTwo ElectricBoogaloo=new SuperArrayTwo();
	ElectricBoogaloo.add("a");
	ElectricBoogaloo.add("c");
	ElectricBoogaloo.add("b");
	ElectricBoogaloo.add("z");
	ElectricBoogaloo.add("a");
	ElectricBoogaloo.set(0,"g");
	print(ElectricBoogaloo);
	*/
	SuperArray lol=new SuperArray(); //time to test the good sort and the bad sort.
	for(int z=0;z<500;z++){
	    lol.add(""+alphabet.charAt(rand.nextInt(alphabet.length())));
	    
	}
	print(lol);
	//lol.insertionSort();
	//lol.selectionSort(); ok it works mostly
	lol.terriBubbleSort();
	print(lol);
	lol.insertionSort();
	print(lol);
	
    }//https://chrome.google.com/webstore/detail/motivation/ofdgfpchbidcgncgfpdlpclnpaemakoj
    //thanks mr. k for posting this, why don't you show us something awesome like THIS in class
    //http://i.imgur.com/VHKShpE.png <- best thing I've ever made
    public static void print(Object a){
	System.out.println(a);
    }
}
