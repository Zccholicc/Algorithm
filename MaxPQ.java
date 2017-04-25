import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class MaxPQ<Key extends Comparable<Key>>{
  private Key[] pq;
  private int N;
  private static final int DEFAULT_SIZE=10;
  private boolean less(int i,int j){
    return pq[i].compareTo(pq[j])<0;
  }
  private void exch(int i,int j){
    Key t=pq[i];
    pq[i]=pq[j];
    pq[j]=t;
  }
  public MaxPQ(){
    pq=(Key[]) new Comparable[DEFAULT_SIZE+1];
  }
  public MaxPQ(int maxSize){
    pq=(Key[]) new Comparable[maxSize+1];
  }
  public boolean isEmpty(){
    return N==0;
  }
  public int size(){
    return N;
  }
  public void insert(Key a){
    N++;
    if(N>=pq.length){
      pq=Arrays.copyOf(pq,2*N+1);
    }
    pq[N]=a;
    swim(N);
  }
  public Key delMax(){
    Key t=pq[1];
    pq[1]=pq[N];
    sink(1);
    return t;
  }
  public String toString(){
    return Arrays.toString(Arrays.copyOfRange(pq,1,N+1));
  }
  private void sink(int k){
    while(k*2<N){
      int j=k*2;
      if(j<N&&less(j,j+1)){
        j++;
      }
      if(!less(k,j)){
        break;
      }
      exch(k,j);
      k=j;
    }
  }
  private void swim(int k){
    while(k>1&&less(k/2,k)){
      exch(k/2,k);
      k/=2;
    }
  }
  public static void main(String[] args) {
    MaxPQ<Double> a=new MaxPQ<>();
    Scanner in=new Scanner(System.in);
    int time=in.nextInt();
    for(int i=0;i<time;i++){
      a.insert(Math.random()*time+1);
    }
    System.out.println(a.toString());
  }
}
