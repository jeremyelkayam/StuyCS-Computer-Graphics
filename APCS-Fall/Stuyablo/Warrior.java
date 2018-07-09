public class Warrior extends Adventurer{
    private int rage;
    public Warrior(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Warrior",0);
    }  
    public Warrior(){
	super("Gaston",20,10,4,10,"Warrior",0);
    }
    public Warrior(String name){
	super(name,20,10,4,10,"Warrior",0);
    }
    public String getStats(){
	return super.getStats()+" RGE "+getResource();
    }
    public void setHP(int n){
	if(getHP()>n){
	    setResource(getResource()+(getHP()-n));
	    System.out.println(getName()+"'s rage increases!");
	}
	super.setHP(n);
    }
    public void attack(Adventurer other){
	masterAttack(other,0,0," punches ");
    }
    public void specialAttack(Adventurer other){
	super.specialAttack(other,0," swings an axe at ","rage");
    }
    public void resetStuff(){
	super.resetStuff();
	setResource(0);
    }
}
