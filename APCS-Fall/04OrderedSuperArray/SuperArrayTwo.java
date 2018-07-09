public class SuperArrayTwo extends SuperArray{
    public void add(int index, String o){
	add(o);
    }
    public void add(String e){
	super.add(e);
	for(int z=size()-1;z>0;z--){
	    if(get(z).compareTo(get(z-1))<get(z-1).compareTo(get(z))){
		String temp = get(z);
		super.set(z,get(z-1));
		super.set(z-1,temp);
	    }
	}
    }
    public String set(int index,String e){
	remove(index);
	add(e);
	return e;
    }
}
