public class Driver{
    public static void main(String[]LNodesWorld){
	MyLinkedList<String> djehutmose=new MyLinkedList<String>("LOL");
	djehutmose.add("HI");
	djehutmose.add("YO");
	djehutmose.add("WHAT'S UP");
	//System.out.println(djehutmose);
	djehutmose.add("NORTH",0);
	//System.out.println(djehutmose);
	//djehutmose.remove(0);
	//System.out.println(djehutmose.indexOf("YO"));
	System.out.println(djehutmose);
	for(String z : djehutmose){
	    System.out.println(z);
	}
	djehutmose.remove(0);
	djehutmose.remove(0);
	djehutmose.set("Your mother was a hamster and your father smelt of elderberry",2);
	System.out.println(djehutmose);
	for(String z : djehutmose){
	    System.out.println(z);
	}
    }
}
