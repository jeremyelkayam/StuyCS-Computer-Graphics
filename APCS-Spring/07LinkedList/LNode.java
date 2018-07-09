public class LNode<T>{
    T data;
    LNode<T> next;
    
    public LNode(){
	this(null,null);
    }
    public LNode(T LOL,LNode<T> stuff){
	data=LOL;
	next=stuff;
    }
    public LNode(T LOL){
	this(LOL,null);
    }
    public T getData(){
	return data;
    }
    public LNode<T> getNext(){
	return next;
    }
    public void setData(T datum){
	data=datum;
    }
    public void setNext(LNode<T> subsequent){
	next=subsequent;
    }
}