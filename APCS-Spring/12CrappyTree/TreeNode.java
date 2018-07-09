public class TreeNode<T>{
    T data;
    TreeNode<T> l;
    TreeNode<T> r;
    public TreeNode(T value){
	setData(value);
	setLeft(null);
	setRite(null);
    }
    public void setData(T value){
	data=value;
    }
    public void setLeft(TreeNode<T> node){
	l=node;
    }
    public void setRite(TreeNode<T> node){//right is longer than left
	r=node;
    }
    public TreeNode<T> getLeft(){
	return l;
    }
    public TreeNode<T> getRite(){
	return r;
    }
    public T getData(){
	return data;
    }
    public String preOrder(){
	return ""+getData()+getLeft().preOrder()+getRite().preOrder();
    }
    public String inOrder(){
	return ""+getLeft().preOrder()+getData()+getRite().preOrder();
    }
    public String toString(){
	return (String)data;
    }
}