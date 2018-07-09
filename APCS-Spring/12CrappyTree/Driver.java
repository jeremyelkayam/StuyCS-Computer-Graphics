public class Driver{
    static TreeNode<String>hi=new TreeNode<String>("Yo");
    static TreeNode<String>hello=new TreeNode<String>("Hey");
    static TreeNode<String>howAboutThat=new TreeNode<String>("NullPointerException");
    public static void main(String[]marsBars){
	System.out.println(hi);
	hi.setLeft(hello);
	hi.setRight(howAboutThat);
    }
}