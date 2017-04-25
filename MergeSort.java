import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class MergeSort extends Gs{
  private static Comparable[] aux;
  public static void merge(Comparable[] a,int lo,int mid,int hi){
    for(int i=lo;i<=hi;i++){
      aux[i]=a[i];
    }
    int i=lo,j=mid+1;
    for(int n=lo;n<=hi;n++){
      if      (i>mid)             {a[n]=aux[j++];}
      else if(j>hi)               {a[n]=aux[i++];}
      else if(less(aux[j],aux[i])){a[n]=aux[j++];}
      else                        {a[n]=aux[i++];}
      Gs.anime(a);
    }
  }
  private static void sort(Comparable[] a,int lo,int hi){
    if(hi<=lo){
      return;
    }
    int mid=lo+(hi-lo)/2;
    if(hi-lo<4){
      InsertionSort.sort1(a,lo,hi);
      return;
    }
    sort(a,lo,mid);
    sort(a,mid+1,hi);
    merge(a,lo,mid,hi);
  }
  public  static void sort(Comparable[] a){
    int len=a.length;
    aux=new Comparable[len];
    sort(a,0,a.length-1);
  }
  public  static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int time=in.nextInt();
    Double[] a=new Double[time];
    for(int i=0;i<time;i++){
      a[i]=Math.random()*time+1;
    }
    MergeSort.sort(a);
    System.out.println(Gs.isSorted(a));
  }
}
