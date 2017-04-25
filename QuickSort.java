import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class QuickSort extends Gs{
  public static int partion(Comparable[] a,int lo,int hi){
    int i=lo,j=hi+1;
    Comparable t=a[lo];
    while(true){
      while(i<hi && less(a[++i],t)){}
      while(j>lo && !less(a[--j],t)){}
      if(i>=j){
        break;
      }
      exch(a,i,j);
      anime(a);
    }
    exch(a,lo,j);
    anime(a);
    return j;
  }
  public static void sort(Comparable[] a,int lo,int hi){
    if(hi<=lo){
      return;
    }
    if(hi-lo<5){
      InsertionSort.sort1(a,lo,hi);
      return;
    }
    int j=partion(a,lo,hi);
    sort(a,lo,j-1);
    sort(a,j+1,hi);
  }
  public static void sort(Comparable[] a){
    StdRandom.shuffle(a);
    sort(a,0,a.length-1);
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int time=in.nextInt();
    Double[] a=new Double[time];
    for(int i=0;i<time;i++){
      a[i]=Math.random()*time+1;
    }
    sort(a);
    System.out.println(isSorted(a));
  }
}
