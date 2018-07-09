import java.util.*;
public class SortStuff{
    static Random rand=new Random();
    public static void main(String[]yo){
	long startTime,endTime;
	int[]endor,a,b,c;
	endor=new int[100000];//would do 1 million (endor has at least that many ewoks) but these machines are too slow
	for(int ewok=0;ewok<endor.length;ewok++){
	    endor[ewok]=rand.nextInt();
	}
	a = Arrays.copyOf(endor, endor.length);
	b = Arrays.copyOf(endor, endor.length);
	c = Arrays.copyOf(endor, endor.length);
	startTime = System.currentTimeMillis();
	endor=terriBubbleSort(endor);
	endTime = System.currentTimeMillis();
	System.out.println("Bubble\n"+(endTime-startTime)+" ms");
	startTime = System.currentTimeMillis();
	a=insertionSort(a);
	endTime = System.currentTimeMillis();
	System.out.println("Insertion\n"+(endTime-startTime)+" ms");
	startTime = System.currentTimeMillis();
	b=selectionSort(b);
	endTime = System.currentTimeMillis();
	System.out.println("Selection\n"+(endTime-startTime)+" ms");
	startTime = System.currentTimeMillis();
	c=defaultSort(c);
	endTime = System.currentTimeMillis();
	System.out.println("Default\n"+(endTime-startTime)+" ms");
	System.out.println("T/F The sorts work: "+(Arrays.equals(endor,a)&&Arrays.equals(a,b)&&Arrays.equals(b,c)));
    }
    public static int[] terriBubbleSort(int[]deathStar){
	for(int z=deathStar.length-1;z>=0;z--){
	    for(int g=0;g<z;g++){
		if(deathStar[g]>deathStar[g+1]){
		    swap(deathStar,g,g+1);
		}
	    }
	}
	return deathStar;
    }
    public static int[] insertionSort(int[]xwing){
	for(int z=1;z<xwing.length;z++){
	    int temp=xwing[z];
	    int g=z;
	    while((g>0) && temp<xwing[g-1]){
		xwing[g]=xwing[g-1];
		g--;
	    }
	    xwing[g]=temp;
	}
	return xwing;
    }
    public static int[] defaultSort(int[]cloudCity){
	Arrays.sort(cloudCity);
	return cloudCity;
    }
	
    public static void swap(int[]g,int index0, int index1){
	int temp = g[index0];
	g[index0]=g[index1];
	g[index1]=temp;
    }
    public static int[] selectionSort(int[]tatooine){
	int min;
	int jabba;
	for (int z = 0; z < tatooine.length; z++) {
	    min = tatooine[z];
	    jabba = z;
	    for (int g = z; g < tatooine.length; g++) {
		if (tatooine[g]<min) {
		    min = tatooine[g];
		    jabba = g;
		}
	    }
	    tatooine[jabba] = tatooine[z];
	    tatooine[z] = min;
	}
	return tatooine;
    }
    public static String name(){
	return "Elkayam,Jeremy";
    }
    public static int period(){
	return 6;
    }
    public static int[] radixSort(int[]hoth){
	ArrayList<ArrayList>ATAT=new ArrayList<ArrayList>();
	for(int z=0;z<10;z++){
	    place=Math.expt(10,z);
	}
    }
}