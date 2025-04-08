package telentSprintQues;
public class StringManupulation{
    public static void main(String[] args) {
        String str = "   Hello    world ";
        
        System.out.println(countNumberOfWords(str));

        reverseWords(str);
        

    }

    public static void reverseWords(String str){
        
        int s=0;
        int n=0;
        String ans = "";
        while (s<str.length() && n<str.length()) {
            while(str.charAt(s)==' '){
                s++;
            }
            n=s;
            while(str.charAt(n)!=' '){
                n++;
            }
            for(int i=n;i>=s;i--){
                ans = ans+str.charAt(i);
            }
            ans = ans+" ";
            s=n+1;

        }

        System.out.println("...."+ans.trim()+"...");
    }

    public static int countNumberOfWords(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid string");
        }
        str = str.trim();
        String[] words = str.split("\\s+");
        return words.length;
        }
}