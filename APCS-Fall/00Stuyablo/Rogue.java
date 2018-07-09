public class Rogue extends Adventurer{
    private int stamina;
    public Rogue(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Rogue",25);
    }  
    public Rogue(){
	super("Aladdin",20,5,5,14,"Rogue",25);
    }
    public Rogue(String name){
	super(name,20,5,5,14,"Rogue",25);
    }
    public String getStats(){
	return super.getStats()+" STM "+getResource();
    }
    public void attack(Adventurer other){
	masterAttack(other,0,0," slaps ");
    }
    public void specialAttack(Adventurer other){
	super.specialAttack(other,0," attempts to assassinate ","stamina");
    }
}
