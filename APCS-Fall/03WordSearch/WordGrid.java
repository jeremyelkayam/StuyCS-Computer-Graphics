import java.util.*;
import java.io.*;
public class WordGrid{
    private char[][]data;
    private int height;
    private String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //it's the legend of zelda and it's really rad
    //those creatures from ganon are pretty bad
    //there's octoroks and tektites and leevers too
    //but with your help, our hero pulls through
    static Random rand;
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    static String wordList="";
    public static ArrayList dict(String fileName){
	ArrayList dictionary=new ArrayList<String>();
	try{
	    File text = new File(fileName);
	    Scanner scnr = new Scanner(text);
	    while(scnr.hasNext()){
		dictionary.add(scnr.next());
	    }
	}catch (FileNotFoundException lol){
	    System.out.println(lol);
	}
	return dictionary;
    }
    public void loadWordsFromFile(String filename, boolean fillRandomLetters){
	ArrayList dictionary=dict(filename);
        Collections.shuffle(dictionary);
	int wordsOnLine = 0;
        for(int x=0;x<dictionary.size();x++){
	    //this is an easy way to make sure I get random words without any repeats.
	    int timesTried=0;
	    boolean added=false;
	    while(timesTried<100 && !added){
		int choice=rand.nextInt(3);
		int direction=rand.nextInt(2);
		if(choice==0){
		    added=addWordVertical(dictionary.get(x),
					  rand.nextInt(data.length),
					  rand.nextInt(data[0].length),
					  direction);
		}else if(choice==1){
		    added=addWordHorizontal(dictionary.get(x),
					    rand.nextInt(data.length),
					    rand.nextInt(data[0].length),
					    direction);
		}else if(choice==2){
		    added=addWordDiagonal(dictionary.get(x),
					  rand.nextInt(data.length),
					  rand.nextInt(data[0].length),
					  direction,
					  rand.nextInt(2));
		}
		timesTried++;
	    }
	    if(added){
		if(wordsOnLine<3){
		    wordList+=dictionary.get(x)+" ";
		    wordsOnLine+=1;
		}else{
		    wordList+=dictionary.get(x)+"\n";
		    wordsOnLine=0;
		}
	    }
	}
	if(fillRandomLetters){
	    for(int z=0;z<data.length;z++){
		for(int y=0;y<data[z].length;y++){
		    if(data[z][y]=='_'){
			data[z][y]=alphabet.charAt(rand.nextInt(alphabet.length()));
			//put a new random letter in every empty spot	    
		    }
		}
	    }    
	}
    }
    public WordGrid(int rows,int cols,boolean replaceUnderscores,long randSeed){
	data=new char[rows][cols];
	clear();
	setSeed(randSeed);
	loadWordsFromFile("dict.txt",replaceUnderscores);
	//System.out.println(randSeed); it's definitely using the proper seed...
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int z=0;z<data.length;z++){
	    for(int y=0;y<data[z].length;y++){
		data[z][y]='_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result="";
	for(int z=0;z<data.length;z++){
	    for(int y=0;y<data[z].length;y++){
		result+=data[z][y]+" ";
	    }
	    result+="\n";
	}
	return result+"\nWORD LIST\n"+wordList;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(Object wordz,int row, int col,int direction){// I didn't refactor my code because I thought about it for 45 minutes in class and then worked on it on Thursday after school and then decided that refactoring is 2tuff4me and gave up. Don't believe me? Check the commits
	String word = wordz.toString();
	if(direction==1){
	    word=new StringBuilder(word).reverse().toString();
	}
	boolean works=true;
	if(data[row].length-col>=word.length()){
	    for(int z=0;z<word.length();z++){
		String workingChar=String.valueOf(data[row][z+col]);//converts the char we're looking at to a string
		works=(works && (workingChar.equals("_") || data[row][z+col]==word.charAt(z)));
		//must A: have worked in the past, B: either have an empty space or a character matching the corresponding character in our word.
		
	    }
	    if(works){
		for(int z=0;z<word.length();z++){
		    char wordBit = word.charAt(z);
		    data[row][z+col]=wordBit;
		}
		return true;
	    }   
	}
	return false;
    }//IT FINALLY WORKS... NOW FOR THE HARD STUFF T_T
    public boolean addWordVertical(Object worzd,int row, int col,int direction){
	String word=worzd.toString();
	if(direction==1){
	    word=new StringBuilder(word).reverse().toString();
	}
	boolean works=true;
	if(data.length-row>=word.length()){
	    for(int z=0;z<word.length();z++){
		String workingChar=String.valueOf(data[row+z][col]);
		works=(works && (workingChar.equals("_") || data[row+z][col]==word.charAt(z)));
		
	    }
	    if(works){
		for(int z=0;z<word.length();z++){
		    char wordBit = word.charAt(z);
		    data[row+z][col]=wordBit;
		}
		return true;
	    }   
	}
	return false;
    }//that was surprisingly easy, well I guess it's because I got the tough thinking done and just had to copy some code
    public boolean addWordDiagonal(Object wordz,int row, int col,int direction,int direction2){
	String word = wordz.toString();
	if(direction==1){
	    word=new StringBuilder(word).reverse().toString();
	}
	boolean works=true;
	if(direction2==0){
	    if(data.length-row>=word.length() && data[row].length-col>=word.length()){
		for(int z=0;z<word.length();z++){
		    String workingChar=String.valueOf(data[row+z][col+z]);
		    works=(works && (workingChar.equals("_") || data[row+z][col+z]==word.charAt(z)));
		
		}
		if(works){
		    for(int z=0;z<word.length();z++){
			char wordBit = word.charAt(z);
			data[row+z][col+z]=wordBit;
		    }
		    return true;
		}
	    }
	    return false;
	}
	else{
	    if(data.length-row>=word.length() && col-data[row].length>=word.length()){
		for(int z=0;z<word.length();z++){
		    String workingChar=String.valueOf(data[row+z][col-z]);
		    works=(works && (workingChar.equals("_") || data[row+z][col-z]==word.charAt(z)));
		
		}
		if(works){
		    for(int z=0;z<word.length();z++){
			char wordBit = word.charAt(z);
			data[row+z][col-z]=wordBit;
		    }
		    return true;
		}
	    }
	    return false;
	}
    }
    public void setSeed(long seed){
	rand = new Random(seed);
    }
    //vertical + diagonal should be implemented as well. Well now they ARE implemented, Mr. K #rekt
}
