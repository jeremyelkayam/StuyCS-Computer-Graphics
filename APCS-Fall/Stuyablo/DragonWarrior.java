public class DragonWarrior extends Adventurer{
    public DragonWarrior(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Dragon Warrior",100);
    }//Add a list of names that will be randomly chosen when you use the default.
    public DragonWarrior(){
	super("Alfelus",60,50,50,30,"Dragon Warrior",100);
    }
    public DragonWarrior(String name){
	super(name,60,50,50,30,"Dragon Warrior",100);
    }
    public String getStats(){
	return super.getStats()+" ASM "+getResource();
    }
    public void attack(Adventurer other){
	masterAttack(other,0,0," slashes a pair of big meaty claws at ");
    }
    public void specialAttack(Adventurer other){
	super.specialAttack(other,0," breathes fire on ","awesomeness");
    }
}
