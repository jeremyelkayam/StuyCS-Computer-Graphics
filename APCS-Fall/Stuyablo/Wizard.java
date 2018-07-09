public class Wizard extends Adventurer{
    private int mana;
    public Wizard(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Wizard",25);
    }  
    public Wizard(){
	super("Jafar",20,4,10,10,"Wizard",25);
    }
    public Wizard(String name){
	super(name,20,4,10,10,"Wizard",25);
    }
    public String getStats(){
	return super.getStats()+" MAN "+getResource();
    }
    public void attack(Adventurer other){
	masterAttack(other,0,0," uses a stick to poke ");
    }
    public void specialAttack(Adventurer other){
	super.specialAttack(other,1," flings a lightning bolt at ","mana");
    }
}
