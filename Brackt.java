/*
1) Take two variables max and current_max, initialize both of them as 0.
2) Traverse the string, do following for every character
    a) If current character is ‘(’, increment current_max and 
       update max value if required.
    b) If character is ‘)’. Check if current_max is positive or
       not (this condition ensure that parenthesis are balanced). 
       If positive that means we previously had a ‘(’ character 
       so decrement current_max without worry. 
       If not positive then the parenthesis are not balanced. 
       Thus return -1. 
3) If current_max is not 0, then return -1 to ensure that the parenthesis
   are balanced. Else return max
*/
import java.util.*;
public class Bracket{
    private static int check(String str){
	int current_max=0;
	int whole_max=0;
	for(int i=0;i<str.length();i++){
	    if(str.charAt(i)=='('){
		current_max+=1;
	    }
	    else if(str.charAt(i)==')'){
		current_max=current_max>0?current_max-1:-1;
	    }
	    else{continue;}
	    whole_max=Math.max(whole_max,current_max);
	    if(current_max==-1){
		return current_max;
	    }
	}
	if(current_max!=0){return -1;}
	return whole_max;
    }
