/*========== BTree.java ==========  
  Lab: Complete
  1. TreeNode.java
  2. add()
  3. pre/post/in Order()
  4. getHeight
  5. getLevel
  6. toString
  
  Basic binary tree.
  Uses TreeNode
  Stolen from DW.
=========================*/

import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    static Random rand=new Random(1);

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }
    public BTree(E g){
	root=new TreeNode<E>(g);
    }
    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) { 
	if(root==null){
	    root=new TreeNode<E>(d);
	}else{
	    add(root,new TreeNode<E>(d));
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn){
	boolean left=rand.nextInt(2)==0;
	if(curr.getLeft()==null){
	    curr.setLeft(bn);
	}else if(curr.getRite()==null){
	    curr.setRite(bn);
	}else{
	    if(left){
		add(curr.getLeft(),bn);
	    }else{
		add(curr.getRite(),bn);
	    }
	}
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	System.out.println(curr.getData());
	if(curr.getLeft()!=null)
	    preOrder(curr.getLeft());
	if(curr.getRite()!=null)
	    preOrder(curr.getRite());
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	if(curr.getLeft()!=null)
	    inOrder(curr.getLeft());
	System.out.println(curr.getData());
	if(curr.getRite()!=null)
	    inOrder(curr.getRite());
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if(curr.getLeft()!=null)
	    postOrder(curr.getLeft());
	if(curr.getRite()!=null)
	    postOrder(curr.getRite());
	System.out.println(curr.getData());
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
	return -1;
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    private int maxLength() {//Thanks Dennis 
		// returns the minimum number of characters required
		// to print the data from any node in the tree
		if (root == null)
			return 0;
		return maxLength(root);
	}

	private int maxLength(TreeNode<E> curr) {
		int max = curr.toString().length();
		int temp;
		if (curr.getLeft() != null) {
			temp = maxLength(curr.getLeft());
			if (temp > max)
				max = temp;
		}
		if (curr.getRite() != null) {
			temp = maxLength(curr.getRite());
			if (temp > max)
				max = temp;
		}
		return max;
	}

	private String spaces(double n) {
		// returns a String of n spaces
		String result = "";
		for (int i = 0; i < n; i++)
			result += " ";
		return result;
	}

	/*
		getLevel will produce a String for each level of the tree.
		The resulting Strings will look like this:

		._______________________________
		._______________._______________
		._______._______._______._______
		.___.___.___.___.___.___.___.___
		._._._._._._._._._._._._._._._._

		toString will combine those Strings and provide an output that
		will look like this:

		_______________.
		_______._______________.
		___._______._______._______.
		_.___.___.___.___.___.___.___.
		._._._._._._._._._._._._._._._.

		In these diagrams, each dot represents wordLength characters,
		each underscore represents wordLength spaces, and, for any nodes
		that are null, the dots will be "replaced" by underscores.
	*/

	private String getLevel(TreeNode<E> curr, int currLevel, int targetLevel, int height, int wordLength) {
		if (currLevel == 1)
			return curr.toString() + spaces(wordLength - curr.toString().length()) +
				spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
		String result = "";
		if (curr.getLeft() != null)
			result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
		else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		if (curr.getRite() != null)
			result += getLevel(curr.getRite(), currLevel - 1, targetLevel, height, wordLength);
		else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		return result;
	}

	public String toString() {
		if (root == null)
			return "";
		String result = "";
		int height = getHeight();
		int wordLength = maxLength();
		// add the every level of the tree except the last one
		for (int level = 1; level < height; level++)
			// remove extra spaces from the end of each level's String to prevent lines from
			// getting unnecessarily long and add spaces to the front of each level's String
			// to keep everything centered
			result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
				getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
				"\n";
		// now add the last level (level = height)
		result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
		return result;
	}
	

    public static void main( String[] args ) {
	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 4; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	//System.out.println( t );
    }
}