import java.util.*;
class wordlength{
  String longestwordlength(String text){
    String longestword ="";
    String[] words = text.split(" ");
    for(String a : words){
      if(a.length() >= longestword.length())
        longestword = a;
    }
    return longestword;
  }
}
public class longestString{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String num = in.nextLine();
    wordlength obj = new wordlength();
    String ans;
    ans = obj.longestwordlength(num);
    System.out.println(ans);
  }
}
