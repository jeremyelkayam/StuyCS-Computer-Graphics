import java.util.Arrays;
import java.util.NoSuchElementException;
public class MyDeque<T>{//all hands on deque
    Object[]content=new Object[10];
    int h=5;//You heard right, I'm building a deque.
    int t=4;//Using galvanized nails!
    public void addFirst(T value){
	//System.out.println(h);
	if(h==0){
	    embiggen();
	    System.out.println("Let's do this!");
	}
	h--;
	content[h]=value;
    }
    public void addLast(T value){
	if(t==content.length-1)
	    embiggen();
	t++;
	content[t]=value;
    }
    public T removeFirst(){
	if(h==t+1)
	    throw new NoSuchElementException("You are a sad, strange little man and you have my pity.");
	T g=(T)content[h];
	content[h]=null;
	h++;
	return g;
    }
    public T removeLast(){
	if(t==h-1)
	    throw new NoSuchElementException("Your mother was a hamster and your father smelt of elderberry! I fart in your general direction!!!");
	T g=(T)content[t];
	content[t]=null;
	t--;
	return g;
    }
    public T getFirst(){
	if(h==t+1)
	    throw new NoSuchElementException();
	return (T)content[h];
    }
    public T getLast(){
	if(h==t+1)
	    throw new NoSuchElementException();
	return (T)content[t];
    }
    private void embiggen(){
	int newSize=content.length*2;
	Object[]news=new Object[newSize];
	int ci;
	int ni=newSize/4+h;
	for(ci=h;ci<=t;ci++){
	    news[ni]=content[ci];
	    ni++;
	    //System.out.println("LOL");
	    //System.out.println(ci);
	    //System.out.println(ni);
	}
	System.out.println(ni);
	t=ni-1;
	h=newSize/4+h;
	content=news;
    }
    public String toString(){
	return Arrays.toString(content);
    }
    public String name(){
	return "elkayam.jeremy";
    }
}
