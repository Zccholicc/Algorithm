import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class BottomMerge extends Gs{
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
  public static void sort(Comparable[] a){
    int N=a.length;
    aux=new Comparable[N];
    for(int i=1;i<N;i*=2){
      for(int j=0;j<N;j+=2*i){
        merge(a,j,j+i-1,Math.min(j+2*i-1,N-1));
      }
    }
  }
  public  static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int time=in.nextInt();
    Double[] a=new Double[time];
    for(int i=0;i<time;i++){
      a[i]=Math.random()*time+1;
    }
    sort(a);
    System.out.println(Gs.isSorted(a));
  }
}
