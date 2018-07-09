import java.util.LinkedList;
public class MyQueue<T>{
    LinkedList<T>kwayway=new LinkedList<T>();
    public boolean add(T n){
	kwayway.add(0,n);
	return true;
    }
    public boolean enqueue(T n){
	return add(n);
    }
    public boolean offer(T n){
	return add(n);
    }
    public T remove(){
	return kwayway.remove(0);
    }
    public T dequeue(){
	return remove();
    }
    public T element(){
	return kwayway.get(0);
    }
    public T peek(){
	return element();
    }
    public T poll(){
	return remove();
    }
}