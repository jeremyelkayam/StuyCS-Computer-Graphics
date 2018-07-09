import java.util.*;
public class SuperArray{
    private String[]array;
    private int length;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	array = new String[size];
	length= 0;
    }
    public String toString(){
	String result="[";
	for(int z=0;z<length;z++){
	    result+=array[z]+" ";
	}
	result+="]";
	return result;
    }
    public void add(String e){
	if(length==array.length){
	    resize(length*2);
	}
	array[length]=e;
	length+=1;
    }
    public void add(int index, String o){
	String[]result;
	if(index>=size()){
	    result=new String[index+1];
	}else{
	    result=new String[length+1];
	}
	length+=1;
	for(int z=0;z<length;z++){
	    if(z==index){
		result[z]=o;
	    }else if(z>index){
		result[z]=array[z-1];
	    }else{
		result[z]=array[z];
	    }
	}
	array=result;
    }
    public int size(){
	return length;
    }
    public void resize(int newSize){
	String[]result=new String[newSize];
	for(int z=0;z<newSize;z++){
	    if(z<length){
		result[z]=array[z];
	    }else{
		result[z]=null;
	    }
	}
	array=result;
	if(array.length<length){
	    length=array.length;
	}
    }
    public void clear(){
	length=0;
    }
    public String get(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return array[index];
	}
    }
    public String set(int index, String e){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    array[index]=e;
	    return array[index];
	}
    }
    public String remove(int index){
	String[]result=new String[array.length];
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    for(int z=0;z<length;z++){
		System.out.println(z);
		if(z<index){
		    result[z]=array[z];
		}else if(z>index){
		    result[z-1]=array[z];
		}
	    }
	}
	String returnMe = array[index];
	array=result;
	length-=1;
	if(length>=(array.length/4)){
	    resize(array.length/2);
	}
	return returnMe;
    }
    public void selectionSort(){
	for(int z=size()-1;z>0;z--){
	    int min=z;
	    for(int g=1;g<=z;g++){
		if(get(g).compareTo(get(min))>0){
		    min=g;
		}
	    }
	    swap(z,min);
	}
    }
    public void insertionSort(){
	for(int z=1;z<size();z++){
	    String temp=get(z);
	    int g=z;
	    while((g>0) && (temp.compareTo(get(g-1))<0)){
		set(g,get(g-1));
		g--;
	    }
	    set(g,temp);
	}
    }
    public void defaultSort(){
	String[]partTwo=new String[size()];
	for(int z=0;z<0;z++){
	    partTwo[z]=get(z);
	}
	array=partTwo;
	Arrays.sort(array);//wow I literally did this to avoid null pointer exceptions and it still fails -_-
    }/*
    public void badInsertionSort(){
	SuperArrayTwo c = new SuperArrayTwo();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
	}*/
    public void terriBubbleSort(){
	for(int z=size()-1;z>=0;z--){
	    for(int g=0;g<z;g++){
		if(get(g).compareTo(get(g+1))<get(g+1).compareTo(get(g))){
		    swap(g,g+1);
		    System.out.println("swap");
		}//it didn't work at all!
		System.out.println("sub-for");
	    }
	    System.out.println("for");
	}
    }
    public void doubleBubbleSort(){
	
    }
    public void swap(int index0, int index1){//....forgot that I had this -_-
	String temp = get(index0);
	set(index0,get(index1));
	set(index1,temp);
    }
    public int find(String f){
	for(int z=0;z<size();z++){
	    if(get(z).equals(f)){
		return z;
	    }
	}
	return -1;
    }
}
