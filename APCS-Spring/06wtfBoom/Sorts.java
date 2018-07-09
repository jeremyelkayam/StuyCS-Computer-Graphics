import java.util.Arrays;
import java.util.Random;
public class Sorts{
    static Random rand=new Random();
    public static int[]sortingHat;//how do you think they get the names of the first-years in alphabetical order?
    public static void main(String[]sortingAlgorithmsAreDumb){
	int[]input1={1,4};
	int[]input2={0,3,5,14,20};
	int[]input3={6454,21,667,179,0,123};
	int[]input4=new int[(int)Math.pow(10,7)];//biggest power-of-10 array I could make without running out of memory
	for(int z=0;z<input4.length;z++){
	    input4[z]=rand.nextInt();
	    //input4[z]=rand.nextInt();//small range test
	}
	//merge(input1,input2);
	//Arrays.sort(input4);
	//sorted array test
	//input4=reverseArray(input4);
	//reverse-sorted array test
	//long start=System.currentTimeMillis();
	//mergeSort(input4);
	//long end=System.currentTimeMillis();
	//System.out.println(Arrays.toString(input3));
	//System.out.println("mergesort "+(end-start)+"ms");
	//System.out.println(input4[0]);
	//start=System.currentTimeMillis();
	//Arrays.sort(input4);
	//end=System.currentTimeMillis();
	//System.out.println(Arrays.toString(input3));
	//System.out.println("Arrays.sort "+(end-start)+"ms");
	//System.out.println(input4[0]);
	quicksort(input3);
	System.out.println(Arrays.toString(input3));
	/* ~4200 ms on a sorted array w/ a wide int range
	   ~4500 ms on a sorted array w/ a small int range
	   ~4500 ms on a reverse sorted array w/ a wide int range
	   ~4500 ms on a reverse sorted array w/ a small int range
	   ~8300 ms on an unsorted array w/ a wide int range
	   ~6200 ms on an unsorted array w/ a small int range */

    }
    public static void mergesort(int[]g){//I criticize thee for making thy students leave out capital letters!
	//System.out.println(Arrays.toString(g));
	//System.out.println(Arrays.toString(front));
	//System.out.println(Arrays.toString(back));
	int[]LOL=g;
	sortingHat=mergeSort(LOL); 
	int dex=0;
	for(int b : sortingHat){
	    g[dex]=b;
	    dex++;
	}//why didn't you tell us that we could edit the CONTENTS of a parameter but not the parameter itself... -________-
    }
    public static int[] mergeSort(int[]g){
	if(g.length<=1)
	    return g;
	int[]front=Arrays.copyOfRange(g,0,g.length/2);
	int[]back =Arrays.copyOfRange(g,g.length/2,g.length);
	return merge(mergeSort(front),mergeSort(back));
    }
    public static int[] merge(int[]a,int[]b){
	int[]result=new int[a.length+b.length];
	int z=0;
	int az=0;
	int bz=0;
	while(z<result.length){
	    //System.out.println(bz);
	    if(az<a.length && (bz>=b.length ||  a[az]<b[bz])){
		//System.out.println("Add A");
		result[z]=a[az];
		az++;
	    }
	    else{
		//System.out.println("Add B");
		result[z]=b[bz];
		bz++;
	    }
	    z++;
	    //System.out.println(bz);
	    //System.out.println(Arrays.toString(result));
	}
	return result;
    }
    public static int[]reverseArray(int[]g){
	for(int z = 0; z < g.length / 2; z++){
	    int temp = g[z];
	    g[z] = g[g.length - z - 1];
	    g[g.length - z - 1] = temp;
	}
	return g;                                                  //the theme tune from the dark world
    }                                                              //it's a dark place that's menacing
public static int partition(int[]g,int s, int e,int trinexx){      //and dark
	int piv=g[trinexx];                                        //it's dark, it's looking very bleak
	swap(g,trinexx,e);                                         //like my average (just kidding)
	                                                           //not really
	int yoshi=s;						   //:(
	for(int z=s;z<e;z++){			 		   //it is dark, like a scary thing
	    if(g[s]<piv){             				   //like stuyvesant during finals week
    		swap(g,z,yoshi);       				   //it has kids handing in textbooks
		             					   //and it puts all the cell phones in
		                                                   //a box
		yoshi++;				           //diddly dark, it's diddly dark
	    }							   //diddly dark, it's diddly dark
	}							   //diddly dark, so diddly dark
	swap(g,e,yoshi);      					   //it's daaaaaaaaaark
	return yoshi;
    }
    public static int partition(int[]g,int s,int e){
	Random rand=new Random();
	return partition(g,s,e,s+rand.nextInt(e-s+1));
    }
    public static int quickSelect(int[]g,int s,int e,int num){
	Random rand=new Random();
	if(s==e)
	    return g[s];
	int trinexx=s+rand.nextInt(e - s + 1);	 
	trinexx=partition(g,s,e,trinexx);
	if(num==trinexx){
		return g[num];
	}else if(num<trinexx){
		return quickSelect(g,s,trinexx-1,num);
	}else{
		return quickSelect(g,trinexx+1,e,num);
	}
    }
    public static void quicksort(int[]g){
	quickSort(g,0,g.length-1);
    }
    public static int[]quickSort(int[]g,int s, int e){
	if(s<e){
	    int piv=partition(g,s,e);
	    quickSort(g,s,piv-1);
	    quickSort(g,piv+1,e);
	}
	return g;
    }
    public static void swap(int[]g,int a,int b){
	int temp=g[a];
	g[a]=g[b];
	g[b]=temp;
    }
    public String name(){
	return "elkayam.jeremy";
    }
}
