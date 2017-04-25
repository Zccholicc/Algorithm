import edu.princeton.cs.algs4.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Gs{
  protected static void anime(Comparable[] a){
    StdDraw.enableDoubleBuffering();
    StdDraw.clear();
    Gs.draw(a);
    StdDraw.show();
    StdDraw.pause(1);
  }
  protected static void draw(Comparable[] a){
    int N=a.length;
    for (int n= 0; n < N; n++){
          double x = 1.0*n/N;
          double y = a[n]/200.0;
          double rw = 0.5/N;
          double rh = a[n]/200.0;
          StdDraw.filledRectangle(x, y, rw, rh);
    }
  }
  public static boolean less(Comparable m,Comparable n){
    return m.compareTo(n)<0;
  }
  public static void exch(Comparable[] a,int m,int n){
    Comparable t=a[m];
    a[m]=a[n];
    a[n]=t;
  }
  protected static boolean isSorted(Comparable[] a){
    for(int n=1;n<a.length;n++){
      if(less(a[n],a[n-1])){
        return false;
      }
    }
    return true;
  }
  public static void testTime(String sort,Comparable[] a){
    Comparable[] b=Arrays.copyOf(a,a.length);
    double start=System.currentTimeMillis();
    if(sort.equals("Shell")){
        ShellSort.sort(b);
    }
    double end =System.currentTimeMillis();
    System.out.println(end-start);
  }
}
