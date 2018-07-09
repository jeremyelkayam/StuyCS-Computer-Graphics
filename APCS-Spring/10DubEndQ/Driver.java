public class Driver{
    public static void main(String[]starDeque){
	MyDeque<Integer> spock=new MyDeque<Integer>();
	spock.addFirst(new Integer(10));
	spock.addFirst(new Integer(11));
	spock.addLast(new Integer(132));
	spock.addFirst(new Integer(12));
	spock.addFirst(new Integer(13));
	spock.addFirst(new Integer(14));
	spock.addFirst(new Integer(15));
	System.out.println(spock);
	spock.addLast(new Integer(20));
	spock.addLast(new Integer(21));
	spock.addLast(new Integer(22));
	spock.addLast(new Integer(23));
	spock.addLast(new Integer(24));
	System.out.println(spock);/*
	for(int z=0;z<100;z++){
	    spock.removeLast();
	    System.out.println(spock);
	    }*/
	spock.removeLast();
	spock.removeFirst();
	System.out.println(spock.getLast());
	System.out.println(spock.getFirst());
    }
}
