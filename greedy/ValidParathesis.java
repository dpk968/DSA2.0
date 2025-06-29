public class ValidParathesis {
    public static void main(String[] args) {
        String s = "()*))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){


        return validParenthesis(s,0,0);
    }

    public static boolean validParenthesis(String s, int c, int idx){
        if(idx==s.length()){
            if (c==0) {
                return true;
            }return false;
        }
        if(c<0) return false;

        if(s.charAt(idx)=='('){
            return validParenthesis(s, c+1, idx+1);
        }else if(s.charAt(idx)==')'){
            return validParenthesis(s, c-1, idx+1);
        }else{
            return validParenthesis(s, c+1, idx+1)||validParenthesis(s, c-1, idx+1)||validParenthesis(s, c, idx+1);
        }
    }
}
