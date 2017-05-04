import java.util.*;
import edu.princeton.cs.algs4.*;
public class RedBlackBST<Key extends Comparable<Key>,Value>{
  private Node root;
  private static final boolean RED=true;
  private static final boolean BLACK=false;
  private class Node{
     Node left,right;
     Key key;
     Value val;
     int N;
     boolean color;
     double xc, yc;
    public Node(Key key,Value val,int N,boolean color){
      this.key=key; this.val=val; this.N=N; this.color=color;
    }
  }
  public boolean isEmpty(){return size(root)==0;}
  private Node balance(Node x){
    if(isRed(x.right)&&!isRed(x.left)){x=rotateLeft(x);}
    if(isRed(x.left)&&isRed(x.left.left)){x=rotateRight(x);}
    if(isRed(x.right)&&isRed(x.left)){flipColors(x);}
    x.N=size(x.left)+size(x.right)+1;
    return x;
  }
  private boolean isRed(Node x){
    if(x==null){return BLACK;}
    return x.color==RED;
  }
  private void flipColors(Node x){
    if(x==null){return;}
    x.color=!x.color;
    x.left.color=!x.left.color;
    x.right.color=!x.right.color;
  }
  private Node  rotateRight(Node x){
    Node h=x.left;
    x.left=h.right;
    h.right=x;
    h.color=x.color;
    x.color=RED;
    h.N=size(h.left)+size(h.right)+1;
    return h;
  }
  private Node  rotateLeft(Node x){
    Node h=x.right;
    x.right=h.left;
    h.left=x;
    h.color=x.color;
    x.color=RED;
    h.N=size(h.left)+size(h.right)+1;
    return h;
  }
  private Node  moveRedLeft(Node x){
    flipColors(x);
    if(isRed(x.right.left)){
      x.right=rotateRight(x.right);
      x=rotateLeft(x);
      flipColors(x);  //If you want to create a 2-3 BST ,delete this line and change the put method
    }
    return x;
  }
  private Node  moveRedRight(Node x){
    flipColors(x);
    if(isRed(x.left.left)){
      x=rotateRight(x);
      flipColors(x);
    }
    return x;
  }
  public  int   size(){
    return size(root);
  }
  private int   size(Node x){
    if(x==null){return 0;}
    return size(x.left)+size(x.right)+1;
  }
  public  Value get(Key key){
    return get(root,key);
  }
  private Value get(Node x,Key key){
    if(x==null){return null;}
    int cmp=key.compareTo(x.key);
    if(cmp<0){return get(x.left,key);}
    else if(cmp>0){return get(x.right,key);}
    return x.val;
  }
  public  void put(Key key,Value val){
    root=put(root,key,val);
    if(isRed(root)){heightBlack++;}
    root.color=BLACK;
  }
  private Node put(Node x,Key key,Value val){
    if(x==null){return new Node(key,val,1,RED);}
    if(isRed(x.right)&&isRed(x.left)){
      flipColors(x);
    }
    int cmp=key.compareTo(x.key);
    if(cmp<0){x.left=put(x.left,key,val);}
    else if(cmp>0){x.right=put(x.right,key,val);}
    x.val=val;
    if(isRed(x.right)&&!isRed(x.left)){x=rotateLeft(x);}
    if(isRed(x.left)&&isRed(x.left.left)){x=rotateRight(x);}
    x.N=size(x.left)+size(x.right)+1;
    return x;
  }
  public  Key  min(){
    return min(root).key;
  }
  private Node min(Node x){
    if(x.left==null){return x;}
    return min(x.left);
  }
  public  Key  max(){
    return max(root).key;
  }
  private Node max(Node x){
    if(x.right==null){return null;}
    return max(x.right);
  }
  public  void deleteMin(){
    if(!isRed(root.right)&&!isRed(root.left)){
      root.color=RED;
    }
    root=deleteMin(root);
    root.color=BLACK;
  }
  private Node deleteMin(Node x){
    if(x.left==null){return null;}
    if(!isRed(x.left)&&!isRed(x.left.left)){
      x=moveRedLeft(x);
    }
    x.left=deleteMin(x.left);
    return balance(x);
  }
  public  void deleteMax(){
    if(!isRed(root.right)&&!isRed(root.left)){
      root.color=RED;
    }
    root=deleteMax(root);
    root.color=BLACK;
  }
  private Node deleteMax(Node x){
    if(isRed(x.left)){x=rotateRight(x);}
    if(x.right==null){return null;}
    if(!isRed(x.right)&&!isRed(x.right.left)){
      x=moveRedRight(x);
    }
    x.right=deleteMax(x.right);
    return balance(x);
  }
  public  void delete(Key key){
    if(!isRed(root.right)&&!isRed(root.left)){
      root.color=RED;
    }
    if(get(root,key)==null){System.out.println("No key");return;}
    root=delete(root,key);
    if(!isEmpty()){root.color=BLACK;}
  }
  private Node delete(Node x,Key key){
     if(key.compareTo(x.key)<0){
       if(!isRed(x.left)&&!isRed(x.left.left)){
         x=moveRedLeft(x);
       }
       x.left=delete(x.left,key);
     }
     else{
       if(isRed(x.left)){x=rotateRight(x);}
       if(key.compareTo(x.key)==0&&(x.right==null)){
         return null;
       }
       if(!isRed(x.right)&&!isRed(x.right.left)){
         x=moveRedRight(x);
       }
       if(key.compareTo(x.key)==0){
         x.val=get(x.right,min(x.right).key);
         x.key=min(x.right).key;
         x.right=deleteMin(x.right);
       }
       else{x.right=delete(x.right,key);}
     }
     return balance(x);
  }
  public static void main(String[] args) {
    RedBlackBST<Integer,String> a=new RedBlackBST<>();
    ArrayList<Integer> col=new ArrayList<>();
    for(int i=0;i<1000;i++){
      a.put(i,"1");
      col.add(i);
    }
    Collections.shuffle(col);
    for(int i=0;i<1000;i++){
      try{
        System.out.println(col.get(i));
        a.delete(col.get(i));
      }
      catch(Exception e){
        System.out.println("OOps");
        System.exit(1);
      }
    }
    System.out.println(a.size());
  }
}
