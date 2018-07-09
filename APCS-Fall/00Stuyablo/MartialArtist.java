public class MartialArtist extends Adventurer{
    public MartialArtist(String n, int startHP, int bSTR, int bINT, int bDEX){
	super(n,startHP,bSTR,bINT,bDEX,"Martial Artist",25);
    }  
    public MartialArtist(){
	super("Li Shang",20,8,4,12,"Martial Artist",25);
    }
    public MartialArtist(String name){
	super(name,20,8,4,12,"Martial Artist",25);
    }
    public String getStats(){
	return super.getStats()+" QI  "+getResource();
    }
    public void attack(Adventurer other){
	masterAttack(other,0,0," kicks ");
    }
    public void specialAttack(Adventurer other){
	super.specialAttack(other,0," roundhouse kicks ","qi");
    }
}
