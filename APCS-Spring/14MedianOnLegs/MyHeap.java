import java.util.*;
import java.io.*;
public class MyHeap{
    ArrayList<Integer>pirate;//an ARRRRRRaylist
    boolean maxHeap;
    int hackJack=0;//ultra-obscure reference
    public MyHeap(boolean max){
	maxHeap = max;
	pirate=new ArrayList<Integer>();
	pirate.add(0);
    }
    public MyHeap(){
	maxHeap = true;
	pirate=new ArrayList<Integer>();
	pirate.add(0);
    }
    public void add(int g){
	hackJack++;
	pirate.add(hackJack,g);
	for(int z=hackJack;checkItOut(pirate.get(z),pirate.get(z/2))&&(z>1);z/=2){
	    int swap=pirate.get(z);
	    pirate.set(z,pirate.get(z/2));
	    pirate.set(z/2,swap);
	}
    }
    public int remove(){
	hackJack--;
	int removeMe = pirate.get(1);
	pirate.set(1, pirate.remove(hackJack));
	for (int z = 1; z * 2 + 1 < z && (checkItOut(pirate.get(z * 2), pirate.get(z)) || checkItOut(pirate.get(z * 2 + 1), pirate.get(z)));) {
	    int g = pirate.get(z);
	    if (checkItOut(pirate.get(z * 2), pirate.get(z))) {
		pirate.set(z, pirate.get(z * 2));
		pirate.set(z * 2, g);
		z *= 2;
	    } else {
		pirate.set(z, pirate.get(z * 2 + 1));
		pirate.set(z * 2 + 1, g);
		z = z * 2 + 1;
	    }
	}
	return removeMe;
    }
    public String name(){
	return "jeremy.elkayam";
    }
    public int peek(){
	return pirate.get(1);
    }
    public String toString(){
	ArrayList<Integer>lolol=new ArrayList<Integer>();
	for(int z=0;z<lolol.size();z++){
	    lolol.add(z);
	}
	return pirate.toString()+"\n"+lolol.toString();
    }
    private boolean checkItOut(int a, int b){
	if(maxHeap)
	    return a>b;
	else
	    return a<b;
    }
    public int size(){
	return hackJack;
    }
}
