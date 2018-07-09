import java.util.ArrayList;
import java.util.*;
public class RunningMedian{
    PriorityQueue<Integer> highr=new PriorityQueue<Integer>(1);
    PriorityQueue<Integer>lower=new PriorityQueue<Integer>(1,Collections.reverseOrder());
    ArrayList<Integer>cheap=new ArrayList<Integer>();
    public RunningMedian(){
	
    }
    public void add(int value) {
	cheap.add(value);
	if (lower.size()==0 && highr.size() == 0) {
	    lower.add(value);
	} else if (value < getMedian()) {
	    lower.add(value);
	} else {
	    highr.add(value);
	}
	rebalance();
    }
    private void rebalance() {
	while (highr.size() - lower.size() > 1) {
	    lower.add(highr.remove());
	}
	while (lower.size() - highr.size() > 1) {
	    highr.add(lower.remove());
	}
    }
    public double cheapMedian(){
	Collections.sort(cheap);
	if(cheap.size()%2==0)
	    return ((double)cheap.get(cheap.size()/2-1)+cheap.get(cheap.size()/2))/2;
	else
	    return cheap.get(cheap.size()/2);
    }
    public double getMedian(){
	if(lower.size()==0){
	    return highr.peek();
	}else if(highr.size()==0){
	    return lower.peek();
	}else if((lower.size()+highr.size())%2==0){
	    return ((double)lower.peek()+highr.peek())/2;
	}else if(lower.size()>highr.size()){
	    //System.out.println(1);
	    return lower.peek();
	}
	else{
	    return highr.peek();
	}
    }
    public String toString(){
	Collections.sort(cheap);
	return cheap.toString();
    }
    public String name(){
	return "elkayam.jeremy";
    }
}
