import java.util.Iterator;
public class MyLinkedList<T> implements Iterable<T>{
    LNode<T> first=null;
    int length=0;
    LNode<T> last=null;//make a new variable that always points to the last LNode
    public MyLinkedList(T g){
	add(g);
    }
    
    public Iterator<T> iterator(){
	return new MyLinkedListIterator<T>(first);
    }
    
    public boolean add(T g){
	if(first==null){
	    first=new LNode<T>(g);
	    last=first;
	}else{
	    last.setNext(new LNode<T>(g));
	    last=last.getNext();
	}
	length++;
	return true;
    }
    public void set(T g,int dex)throws IndexOutOfBoundsException{
	if(dex>size() || dex<0){
	    throw new IndexOutOfBoundsException("Inconceivable!");
	}
	if(dex==0){
	    add(g);
	}else{
	    LNode<T> now=first;
	    for(int z=0;z<dex;z++){
		now=now.getNext();
	    }
	    now.setData(g);
	}
    }
    public boolean add(T g,int dex)throws IndexOutOfBoundsException{	
	if(dex>=size() || dex<0){
	    throw new IndexOutOfBoundsException("Inconceivable!");
	}
	LNode<T> now=first;
	if(dex==0){
	    first=new LNode<T>(g,now);
	    
	}else{
	    for(int z=0;z<dex-1;z++){
		now=now.getNext();
	    }
	    now.setNext(new LNode<T>(g,now.getNext()));
	}
	length++;
	return true;
    }
    public String toString(){
	String result="[";
	LNode<T> now=first;
	result+=now.getData()+", ";
	while(now.getNext()!=null){
	    now=now.getNext();
	    result+=now.getData()+", ";
	}
	result=result.substring(0,result.length()-2)+"]";
	return result;
    }
    public int size(){	
	return length;
    }
    public T remove(int dex)throws IndexOutOfBoundsException{
	if(dex>=size() || dex<0){
	    throw new IndexOutOfBoundsException("Inconceivable!");
	}
	LNode<T> now=first;
	T result;
	if(dex==0){
	    result=first.getData();
	    first=first.getNext();	    
	}else{
	    for(int z=0;z<dex-1;z++){
		now=now.getNext();
	    }
	    result=now.getNext().getData();
	    now.setNext(now.getNext().getNext());
	}
	length--;
	if(dex==size()){
	    last=now.getNext();
	}
	return result;
    }
    public T get(int dex)throws IndexOutOfBoundsException{
	if(dex>=size() || dex<0){
	    throw new IndexOutOfBoundsException("Inconceivable!");
	}
	//you keep using that word... I do not think it means what you think it means.
	LNode<T> now=first;
	for(int z=0;z<dex;z++){
	    now=now.getNext();
	}
	return now.getData();
    }
    public int indexOf(T findMe){
	LNode<T> now=first;
	for(int z=0;z<size();z++){
	    //System.out.println(now.getData());
	    if(now.getData().equals(findMe)){
		return z;
	    }
	    //System.out.println("LOL");
	    now=now.getNext();
	}
	return -1;
    }
    public String name(){
	return "elkayam.jeremy";
    }/*
       >can I just say that Mr. K's grading methods are getting lazier and lazier and it's getting quite annoying and student-unfriendly
       >making it easier for himself to do his job is fine, but not giving ANY credit because of not including a name method is stupid
       >sure it didn't compile for you, but only because you compiled it under certain circumstances that you didn't force us to compile under
       >just unfair overall
       >I want to like this class but when stupid stuff like this happens it makes me unhappy
       >I don't think Mr. K will read these comments (at least, I hope not)
       >mfw greentexting doesn't work in java
       (my gif is at home)
     */

    
    private class MyLinkedListIterator<T> implements Iterator<T>{
	LNode<T>current;
	boolean start=true;
	public MyLinkedListIterator(LNode<T>start){
	    current=start;
	}
	public boolean hasNext(){
	    return current.getNext()!=null;
	}
	public T next(){
	    if(!start){
		current=current.getNext();
	    }
	    start=false;
	    return current.getData();
	}
	public void remove(){
	    throw new UnsupportedOperationException("What do you mean he didn't bother to write a remove method!? That's inconceivable!!");
	}
    }
}
