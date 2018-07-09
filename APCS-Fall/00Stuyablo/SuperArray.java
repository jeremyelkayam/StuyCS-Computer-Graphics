public class SuperArray{
    private Object[]array;
    private int length;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	array = new Object[size];
	length= size;
    }
    public String toString(){
	String result="[";
	for(int z=0;z<length;z++){
	    result+=array[z]+" ";
	}
	result+="]";
	return result;
    }
    public void add(Object e){
	Object[]result=new Object[length+1];
	length+=1;
	for(int z=0;z<length-1;z++){
	    result[z]=array[z];
	}
	result[length-1]=e;
	array=new Object[length];
	array=result;
    }
    public int size(){
	return length;
    }
    public void resize(int newSize){
	Object[]result=new Object[newSize];
	int size;
	if (newSize<length){
	    size=newSize;
	}else{
	    size=length;
	}
	for(int z=0;z<size;z++){
	    result[z]=array[z];
	}
	array=result;
    }
}