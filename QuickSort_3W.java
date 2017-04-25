import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class QuickSort_3W extends Gs{
  public static void sort(Comparable[] a,int lo,int hi){
    if(hi<=lo){
      return;
    }
    int lt=lo,i=lo+1,gt=hi;
    Comparable v=a[lo];
    while(i<=gt){
      int cmp=a[i].compareTo(v);
      if(cmp<0){
        exch(a,lt++,i++);
      }
      else if(cmp>0){
        exch(a,gt--,i);
      }
      else{
        i++;
      }
      sort(a,lo,lt-1);
      sort(a,gt+1,hi);
    }
  }
     int len=a.length;
    sort(a,0,len-1);
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
