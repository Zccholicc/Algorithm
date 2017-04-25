import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class HeapSort extends Gs{
  public static void sort(Comparable[] a){
    int N=a.length-1;
    for(int k=N/2;k>=1;k--){
      sink(a,k,N);
    }
    while(N>1){
      exch(a,1,N--);
      anime(a);
      sink(a,1,N);
    }
  }
  private static void sink(Comparable[]a,int k,int N){
    while(k*2<=N){
      int j=k*2;
      if(j<N&&less(a[j],a[j+1])){
        j++;
      }
      if(!less(a[k],a[j])){
        break;
      }
      exch(a,k,j);
      anime(a);
      k=j;
    }
  }
  public static void exch(Comparable[] pq,int i,int j){
    Comparable t=pq[i];
    pq[i]=pq[j];
    pq[j]=t;
  }
  public static boolean less(Comparable i,Comparable j){
    return i.compareTo(j)<0;
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    Integer[] a=new Integer[n];
    a[0]=0;
    for(int i=1;i<n;i++){
      a[i]=n-i;
    }
    sort(a);
    anime(a);
    System.out.println(isSorted(a));
  }
}
