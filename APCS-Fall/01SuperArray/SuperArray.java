public class SuperArray{
    private Object[]array;
    private int length;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	array = new Object[size];
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
    public void add(Object e){
	if(length==array.length){
	    resize(length*2);
	}
	array[length]=e;
	length+=1;
    }
    public void add(int index, Object o){
	Object[]result;
	if(index>=size()){
	    result=new Object[index+1];
	}else{
	    result=new Object[length+1];
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
	Object[]result=new Object[newSize];
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
    public Object get(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return array[index];
	}
    }
    public Object set(int index, Object e){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    array[index]=e;
	    return array[index];
	}
    }
    public Object remove(int index){
	Object[]result=new Object[array.length];
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    for(int z=0;z<length;z++){
		if(!(z==index)){
		    result[z]=array[z];
		}
	    }
	}
	Object returnMe = array[index];
	array=result;
	length-=1;
	if(length<=(array.length/4)){
	    resize(array.length/2);
	}
	return returnMe;
    }
}
