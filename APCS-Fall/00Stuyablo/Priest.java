public class Priest extends Adventurer{
    //The priest will be centered on healing. Considering: He has no special attack but instead he has the ability to heal one ally. How much HP??? 5-10? More? Less?
    public Priest(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Priest",25);
    }
    public Priest(){
	super("Frollo",20,4,10,10,"Priest",25);
    }
    public Priest(String name){
	super(name,20,4,10,10,"Priest",25);
    }
    public String getStats(){
	return super.getStats()+" MAN "+getResource();
    }
    public void attack(Adventurer other){
	masterAttack(other,0,1," chants some incantations at ");
    }
    public void specialAttack(Adventurer other){
	System.out.println("Bwahahaha, priests can't special attack!");
    }
}
