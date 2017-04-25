import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class ShellSort{
  private static void exch(Comparable[] a,int i,int j){
    Comparable t=a[i];
    a[i]=a[j];
    a[j]=t;
  }
  private static boolean less(Comparable a,Comparable b){
    return a.compareTo(b)<0;
  }
  public static void sort(Comparable[] a){
    int len=a.length;
    int h=1;
    while(h<len/3){
      h=h*3+1;
    }
    while(h>=1){
      for(int i=h;i<len;i++){
        for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){
          exch(a,j,j-h);
          }
        }
      h/=3;
    }
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    while(in.hasNextLine()){
      int time=in.nextInt();
      Double[] a=new Double[time];
      for(int i=0;i<time;i++){
        a[i]=Math.random()*time+1;
      }
      Gs.testTime("Shell",a);
      Gs.testTime("Insertion",a);
    }
  }
}
