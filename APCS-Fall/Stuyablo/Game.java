import java.util.*;
public class Game{
    static Adventurer[]party=new Adventurer[4];
    static Adventurer opponent;
    static Adventurer[]initialParty;
    static Adventurer initialOpponent;
    static Random rand = new Random();
    public static void main(String[]donkeykong){
	System.out.println("\nWelcome to the game!\n");
	makeParty();
	makeOpponent();
	fight();
    }
    public static Adventurer chooseClass(String name,Adventurer player){
	boolean repeat=true;
	while (repeat){
	    System.out.println("Choose your class:\nA : Warrior\nB : Wizard\nC : Rogue\nD : Martial Artist\nE : Priest");
	    System.out.print("> ");
	    Scanner in = new Scanner(System.in);
	    String line = in.nextLine();
	    if (line.toUpperCase().equals("A")){//you can use equalsIgnoreCase here
		player=new Warrior(name,20,5,2,5);
		repeat=false;
	    }else if (line.toUpperCase().equals("B")){
		player=new Wizard(name,20,2,5,5);
		repeat=false;
	    }else if (line.toUpperCase().equals("C")){
		player=new Rogue(name,20,2,2,8);
		repeat=false;
	    }else if (line.toUpperCase().equals("D")){
		player=new MartialArtist(name,20,4,2,6);
		repeat=false;
	    }else if(line.toUpperCase().equals("GALGATHOR")){
		System.out.println("Congratulations! You unlocked the secret Dragon Warrior class!");
		player=new DragonWarrior(name);
		repeat=false;
	    }else if(line.toUpperCase().equals("E")){
		player=new Priest(name,20,2,5,5);
		repeat=false;
	    }else{
		System.out.println("Bro, "+line+" is not an option!");
	    }
	}
	System.out.println(player.getName()+", a "+player.getJob()+", has been added to your party.");
	return player;
    }
    public static void makeParty(){
	boolean done=false;
	while (!done){
	    System.out.println("Use default party? (Y/N)");
	    System.out.print("> ");
	    Scanner in = new Scanner(System.in);
	    String line = in.nextLine().toUpperCase();
	    if(line.equals("Y")){
		defaultParty();
		done=true;
	    }else if (line.equals("N")){
		for(int z=0;z<4;z++){
		    System.out.println("What is party member #"+(z+1)+"'s name?");
		    System.out.print("> ");
		    Scanner inz = new Scanner(System.in);
		    String linez = inz.nextLine();
		    party[z]=chooseClass(linez,party[z]);
		    assignBonusStats(party[z],18);
		}
		done=true;
	    }else{
		System.out.println("Bro, "+line+" is not an option!");
	    }
	}

    }
    public static void defaultParty(){
	party[0]=new Warrior("Gaston",20,12,6,12);
	party[1]=new Wizard("Jafar",20,6,12,12);
	party[2]=new Rogue("Aladdin",20,7,7,16);
	party[3]=new MartialArtist("Li Shang",20,10,6,14);
    }
    public static void makeOpponent(){
	int profession=rand.nextInt(4);
	if (profession==0){
	    opponent=new Warrior("Bad Guy",40,14,8,14);
	}else if (profession==1){
	    opponent=new Wizard("Bad Guy",40,8,14,14);
	}else if (profession==2){
	    opponent=new Rogue("Bad Guy",40,10,10,24);
	}else if (profession==3){
	    opponent=new MartialArtist("Bad Guy",40,12,8,16);
	}
    }
    public static void fight(Adventurer player){// SPLIT THIS CODE UP INTO METHODS SO WE CAN REPEAT IT FOR THE PARTY BATTLE. IDEALLY THIS WHOLE METHOD WILL GO AWAY SOON
	//This code is now unused; it is a remnant of the pre-party days.
	System.out.println("You are engaged in combat with "+opponent.getName()+", a "+opponent.getJob()+".");
	int turnCount=0;
	boolean willing=true;
	while ((opponent.getHP()>0)&&(player.getHP()>0)){
	    turnCount++;
	    System.out.println("TURN "+turnCount+"\n\n");
	    int opponentChoice=rand.nextInt(2);
	    if ((opponentChoice==0)&&(opponent.canSpecialAttack())){
		opponent.specialAttack(player);
	    }else{
		opponent.attack(player);
	    }
	    if (player.getHP()<=0){
		System.out.println(player.getName()+" was defeated!");
		break;
	    }
	}
	
	//after battle
	if (opponent.getHP()<=0){
	    System.out.println("You Win!");
	}else {
	    System.out.println("You Lose :(");
	}
    }
    public static void playerTurn(Adventurer player){
	hangOn(500);
	if(player.getHP()<=0){
	    System.out.println(player.getName()+" is incapacitated.\n");
	    player.setHP(0);
	}else{
	    System.out.println("\nChoose an action for "+player.getName()+" (Hit rate: "+player.HitRate(opponent)+"%):\n\nA : attack");//display min & max damage here maybe???
	    if(player.getJob().equals("Priest")){
		System.out.println("H : heal\nG : give up");
	    }else{
		System.out.println("S : special attack\nG : give up");
	    }
	    System.out.print("> ");
	    boolean choice=true;
	    boolean gaveUp=false;
	    while (choice){
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().toUpperCase();
		if (line.equals("A")){
		    player.attack(opponent);
		    choice=false;
		}else if(line.equals("S") && !(player.getJob().equals("Priest"))){
		    choice=(!(player.canSpecialAttack()));
		    player.specialAttack(opponent);
		}else if(line.equals("H") && player.getJob().equals("Priest")){
		    healWho(player);
		    choice=(!(player.canSpecialAttack()));
		}else if (line.equals("G")){
		    System.out.println(player.getName()+" gave up...");
		    player.setHP(0);
		    choice=false;
		}else{
		    System.out.println("Bro, "+line+" is not an option!");
		    System.out.print("> ");
		}
	    }
	}
	
    }
    public static void fight(){
	System.out.println("You are engaged in combat with "+opponent.getName()+", a "+opponent.getJob()+".");
	int turnCount=0;
	boolean willing=true;
	while ((opponent.getHP()>0)&&isPartyAlive()){
	    turnCount++;
	    System.out.println("TURN "+turnCount);
	    hangOn(500);
	    System.out.println("PARTY STATS: \n"+party[0].getStats()+"\n"+party[1].getStats()+"\n"+party[2].getStats()+"\n"+party[3].getStats());
	    hangOn(1000);
	    System.out.println("OPPONENT STATS: \n"+opponent.getStats());
	    hangOn(1000);
	    for(int z=0;z<4;z++){
		playerTurn(party[z]);
		if (opponent.getHP()<=0){
		    hangOn(1000);
		    System.out.println(opponent.getName()+" was defeated!");
		    break;
		}else if(!isPartyAlive()){
		    System.out.println("Your entire party has been defeated :(");
		}
	    }
	    if (opponent.getHP()<=0){
		break;
	    }else if(!isPartyAlive()){
		break;
	    }
	    int opponentPlayerChoice=opponentPlayerChoice(party[0],party[1],party[2],party[3]);
	    int opponentAttackChoice=rand.nextInt(2);
	    if ((opponentAttackChoice==0)&&(opponent.canSpecialAttack())){
		opponent.specialAttack(party[opponentPlayerChoice]);
	    }else{
		opponent.attack(party[opponentPlayerChoice]);
	    }
	    if (party[opponentPlayerChoice].getHP()<=0){
		System.out.println(party[opponentPlayerChoice].getName()+" was defeated!");
		party[opponentPlayerChoice].setHP(0);
	    }
	}
	hangOn(500);
	//after battle
	if (opponent.getHP()<=0){
	    System.out.println("You Win!");
	}else {
	    System.out.println("You Lose :(");
	}
	fightAgain();
    }
    public static boolean isPartyAlive(){
	return ((party[0].getHP()+party[1].getHP()+party[2].getHP()+party[3].getHP())>0);
    }
    public static int opponentPlayerChoice(Adventurer p0, Adventurer p1, Adventurer p2, Adventurer p3){
        int hp0,hp1,hp2,hp3;
	hp0=10000;
	hp1=10000;
	hp2=10000;
	hp3=10000;
	if(p0.getHP()>0){
	    hp0=p0.getHP();
	}
	if(p1.getHP()>0){
	    hp1=p1.getHP();
	}
	if(p2.getHP()>0){
	    hp2=p2.getHP();
	}
	if(p3.getHP()>0){
	    hp3=p3.getHP();
	}
	if(p0.getHP()==p1.getHP() && p1.getHP()==p2.getHP() && p2.getHP()==p3.getHP()){
	    return rand.nextInt(4);
	}
	int choice=Math.min(Math.min(hp0,hp1),Math.min(hp2,hp3));
	if(choice==p1.getHP()){
	    return 1;
	}else if(choice==p2.getHP()){
	    return 2;
	}else if(choice==p3.getHP()){
	    return 3;
	}else{
	    return 0;
	}
    }
    public static void assignBonusStats(Adventurer player,int bonusStats){//This is based on Mr. K's code.
	System.out.println("As a "+player.getJob()+", you have "+player.getSTR()+" STR,"+player.getDEX()+" DEX, and "+player.getINT()+" INT");
	hangOn(500);
	System.out.println("You have "+bonusStats+" points.\nHow many do you want to allocate to STR?");
	int STR = getUserInt(0,bonusStats);
	player.setSTR( player.getSTR()+STR );
	bonusStats = bonusStats - STR;
	if(bonusStats > 0){
	    System.out.println("You have "+bonusStats+" points to put into DEX/INT.\nHow many do you want to allocate to DEX?");
	    int DEX = getUserInt(0,bonusStats) ;
	    player.setDEX( player.getDEX() + DEX);
	    bonusStats = bonusStats - DEX;
	    //leftover goes to int.
	    player.setINT( player.getINT() + bonusStats );
	}
    }
    public static int getUserInt(int min,int max){//Thanks Mr. K for letting me use this helpful method.
	Scanner in = new Scanner(System.in);
	int result;
	do{
	    hangOn(500);
	    System.out.println("Enter a non-negative integer less than "+(max+1));
	    result = in.nextInt();
	}while(result < min || result > max);
	return result;
    }
    public static void fightAgain(){
	for (int z=0;z<party.length;z++){
	    party[z].resetStuff();
	}
        makeOpponent();
	boolean choice=false;
	while(!choice){
	System.out.println("Fight again with the same party? (Y/N)");
	System.out.print("> ");
	Scanner in = new Scanner(System.in);
	String line = in.nextLine().toUpperCase();
	    if(line.equals("Y")){
		fight();
		choice=true;
	    }else if(line.equals("N")){
		choice=true;
	    }else{
		System.out.println("Bro, "+line+" is not an option!");
	    }
	}
    }
    public static void healWho(Adventurer player){
	if(player.canSpecialAttack()){
	    System.out.println("Heal which party member?\nA : "+
			       party[0].getName()+"("+party[0].getHP()+"/"+party[0].getMaxHP()+")\nB : "+
			       party[1].getName()+"("+party[1].getHP()+"/"+party[1].getMaxHP()+")\nC : "+
			       party[2].getName()+"("+party[2].getHP()+"/"+party[2].getMaxHP()+")\nD : "+
			       party[3].getName()+"("+party[3].getHP()+"/"+party[3].getMaxHP()+")\n"
			       );
	    boolean choice=false;
	    while(!choice){
		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().toUpperCase();
		if(line.equals("A")){
		    player.heal(party[0]);
		    choice=true;
		}else if(line.equals("B")){
		    player.heal(party[1]);
		    choice=true;
		}else if(line.equals("C")){
		    player.heal(party[2]);
		    choice=true;
		}else if(line.equals("D")){
		    player.heal(party[3]);
		    choice=true;
		}else{
		    System.out.println("Bro, "+line+" is not an option!");
		}
	    }
	}else{
	    System.out.println("Not enough "+player.getResource()+" :(");
	}
    }
    public static void hangOn(int time){
	try {
	    Thread.sleep(time);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }
    /* under construction
       public static void areYouSure(){
       if (line.toUpperCase()=="A"){
       line="A: Warrior";
       }else if (line.toUpperCase()=="B"){
       line="B: Wizard";
		}else if (line.toUpperCase()=="C"){
		line="C: Rogue";
		}
	    bool answeredYesNo=false;
	while (not answeredYesNo){
	    System.out.println("Your choice was "+line+".\nAre you sure? (Y/N)");
	    System.out.print("> ");
	    Scanner in = new Scanner(System.in);
	    String YN = in.nextLine();
	    if (YN.toUpperCase()=="Y"){
	    answeredYesNo=true;
		}else if (YN.toUpperCase()=="N"){
	    answeredYesNo=true;
		}else{
	    System.out.println("Dude you're supposed to actually type y or n. Try again");
		}
		}
	} under construction */
}
