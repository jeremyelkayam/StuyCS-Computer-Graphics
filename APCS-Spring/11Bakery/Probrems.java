public class Probrems{
    //maybe I should've called it "promblems"
    public Drawer findDrawer(int studentID)
    {
	for(Drawer z : myDrawerList){
	    if(z.getMaxID()>=studentID){
		return z;
	    }
	}
    }
    public void removeStudent(Student student){
	Drawer d=findDrawer(student.getID());
	Iterator<Student>iterator=d.iterator();
	while(iterator.hasNext()){
	    if(iterator.next().equals(student))
		iterator.remove();
	}
    }

}