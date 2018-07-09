//You don't post announcements anymore :(
//I promise to make meaningful commit comments if you make announcements!
import java.util.LinkedList;
import java.util.EmptyStackException;
public class MyStack<T>{
    LinkedList<T>stuff=new LinkedList<T>();//I'm gonna stack Mr. K in the face if he doesn't make more announcements!
    public static String name(){//did you hear about the kickstarter for a new Staq Fu game???
	return "elkayam.jeremy";
    }
    public T peek(){//I find your stack of faith disturbing.
	if(empty())
	    throw new EmptyStackException();
	return stuff.get(0);
    }
    public T push(T item){//Stack in Black
	stuff.add(0,item);
	return item;
    }
    public T pop(){//Google's best doodle was the Stac-Man one.
	if(empty())
	    throw new EmptyStackException();
	return stuff.remove(0);
    }
    public boolean empty(){//I'll be stack
	return stuff.isEmpty();
    }
    public int search(Object o){//Stick and Stack, the Tappet brothers
	int g=stuff.indexOf(o);
	if(g==-1)
	    return g;
	return g+1;
    }
}
