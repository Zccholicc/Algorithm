import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class InsertionSort {
  private static void exch(Comparable[] a,int i,int j){
    Comparable t=a[i];
    a[i]=a[j];
    a[j]=t;
  }
  private static boolean less(Comparable a,Comparable b){
    return a.compareTo(b)<0;
  }
  public static void sort1(Comparable[] a,int lo,int hi){
    int len=a.length;
    for(int i=lo;i<=hi;i++){
      for(int j=i;j>lo && less(a[j],a[j-1]);j--){
        exch(a,j,j-1);
        Gs.anime(a);
      }
    }
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    Double[] a=new Double[n];
    for(int i=0;i<n;i++){
      a[i]=Math.random()*n+1;
    }
    System.out.println(Arrays.toString(a));
  }
}
