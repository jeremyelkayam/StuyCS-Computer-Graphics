import java.util.*;
public abstract class Adventurer{
    private String name;
    private int HP;
    private int maxHP;
    private int STR;
    private int INT;
    private int DEX;
    private int resource;//For the sake of not having to repeat code, I've merged the usable resources (mana/rage/etc) into one variable. At least in my version of the game, they were different in name only, so there was no change to gameplay.
    private String job; 
    Random rand = new Random();
    public Adventurer(String n, int startHP, int bSTR, int bINT, int bDEX,String job,int resource){
	setName(n);
	setMaxHP(startHP);
	setSTR(bSTR);
	setDEX(bDEX);
	setINT(bINT);
	setJob(job);
	setResource(resource);
    }  
    public Adventurer(String n,int startHP){
	this(n,startHP,8,8,8,"",25);
    }
    public Adventurer(String n){
	this(n,20,8,8,8,"",25);
    }
    public Adventurer(){
	this("Robin Hood",20,8,8,8,"",25);
    }
    public String getStats(){
	return getName()+" the "+getJob()+"\tHP  "+getHP()+"/"+getMaxHP()+"\tSTR "+getSTR()+"\tINT "+getINT()+"\tDEX "+getDEX()+"\t";
    }
    public void setName(String n){
	name=n;
    }
    public void setSTR(int n){
	STR=n;
    }
    public void setINT(int n){
	INT=n;
    }
    public void setDEX(int n){
	DEX=n;
    }
    public void setMaxHP(int n){
	maxHP=n;
	HP=n;
    }
    public void setHP(int n){
	HP=n;
	if (getHP()>getMaxHP()){
	    HP=getMaxHP();
	}
	if(getHP()<0){
	    HP=0;
	}
    }
    public void setJob(String n){
	job=n;
    }
    public void setResource(int n){
	resource=n;
    }
    public String getName(){
	return name;
    }
    public int getHP(){
	return HP;
    }
    public int getMaxHP(){
	return maxHP;
    }
    public int getSTR(){
	return STR;
    }
    public int getINT(){
	return INT;
    }
    public int getDEX(){
	return DEX;
    }
    public String getJob(){
	return job;
    }
    public int getResource(){
	return resource;
    }
    public int HitRate(Adventurer other){
	int result;
	if((Math.abs(getDEX()-other.getDEX()))<=5){
	    result=70+5*(getDEX()-other.getDEX());
	}else if ((getDEX()-other.getDEX())<0){
	    result=45+(getDEX()-(other.getDEX()-5));
	}else{
	    result=95+((getDEX()-5)-other.getDEX());
	}//For the first 5 dex the player has over the opponent, there is a 5% hit rate bonus from a base 70%. For all succeeding dex, there is a 1% bonus.
	if(result>100){
	    result=100; //wouldn't make sense to show that you have a 110% hit rate
	}else if(result<0){
	    result=0; //also wouldn't make sense to show that you have a -10% hit rate
	}
	return result;
    }
    public boolean hit(Adventurer other){
	return (rand.nextInt(100))<HitRate(other);
    }
    public int damage(Adventurer other,int atkType,int dmgType){
	int atk,def;
	if (dmgType==0){//this detects if the attack is physical or magical
		atk=getSTR();
		def=other.getSTR();
	}else if (dmgType==1){
		atk=getINT();
		def=other.getINT();
	}else{
	    atk=10;
	    def=10;//these are arbitrary values for a just-in-case situation
	}
	if (atkType==1){//special attacks cut the enemy's defense in half.
	    def/=2;
	}
	int dam = ((atk-def)+(rand.nextInt(5)-2));//Maybe should give damage a central tendency.
	if (dam<1){
	    dam=1;
	}
	return dam;
    }
    //create min damage and max damage methods here maybe
    public void masterAttack(Adventurer other,int atkType,int dmgType,String flavorText){
	//attack type is for normal attacks (0) and special attacks (1)
	//damage type is for physical attacks (0) and magical attacks (1)
	System.out.println( this.getName() + flavorText + other.getName());
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (hit(other)){
	    int blam=damage(other,atkType,dmgType);
	    System.out.println("and deals "+blam+" damage");
	    other.setHP(other.getHP()-blam);
	}else{
	    System.out.println("and misses");
	}
    }	    
    abstract void attack(Adventurer other);
    abstract void specialAttack(Adventurer other);
    public void specialAttack(Adventurer other,int dmgType,String flavorText,String resource){
	if (getResource()>=5){
	    masterAttack(other,1,dmgType,flavorText);
	    setResource(getResource()-5);
	}else{
	    System.out.println("Not enough "+resource+" :(");
	}
    }
    public boolean canSpecialAttack(){
	return (getResource()>=5);
    }
    public void heal(Adventurer other){
	if (getResource()>=5){
	    int healed=getINT()/2+(rand.nextInt(5)-3);
	    other.setHP(other.getHP()+healed);
	    setResource(getResource()-5);
	    System.out.println(getName()+" heals "+other.getName());
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("for "+healed+" HP");
	}else{
	    System.out.println("Not enough "+resource+" :(");
	}	
    }
    public void resetStuff(){
	setHP(getMaxHP());
	setResource(25);
    }
}
