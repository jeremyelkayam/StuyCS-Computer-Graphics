import java.util.*;
public class ArrayListMethods{
    static Random rand=new Random();
    public static void main(String[]wayezStoleMyDriver){
	ArrayList<Integer>Z = new ArrayList<Integer>();
	Z.add(1);
	Z.add(2);
	Z.add(2);
	Z.add(3);
	Z.add(5);
	System.out.println(Z);
	collapseDuplicates(Z);
	System.out.println(Z);
	randomize(Z);
	System.out.println(Z);
    }
    public static void collapseDuplicates(ArrayList<Integer>L){
	for(int z=0;z<L.size()-1;z++){
	    if(L.get(z)==L.get(z+1)){
		L.remove(z);
	    }
	}
    }
    public static void randomize( ArrayList<Integer> L) { 
	//I'm not 100% sure what this is asking but I think you want me to make a shuffle method.
	//I used the INTERNET to find a cool way of doing it that was invented for computers
	//http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle - the page has cool formatting so you know it's legit
	//#awesome #cheating #destroyedthepurposeoftheassignment #couldn'tbebotheredtothink
	for(int z=L.size()-1;z>0;z--){
	    int j=rand.nextInt(z);
	    int a=L.get(z);
	    int b=L.get(j);
	    L.set(j,a);
	    L.set(z,b);
	}
    }
}
