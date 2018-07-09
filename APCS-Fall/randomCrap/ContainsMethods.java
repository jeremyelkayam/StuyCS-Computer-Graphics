public class ContainsMethods{
    public static void main(String[]args){
	//blah
    }
    public static boolean contains(int value,int[]q){
	for(int z=0;z<q.length;z++){
	    if(q[z]==value){
		return true;
	    }
	}
	return false;
    }
    public static boolean contains(int value,int[][]q){
	for(int z=0;z<q.length;z++){
	    if(contains(value,q[z])){
		return true;
	    }
	}
	return false;
    }
}