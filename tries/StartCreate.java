//package tries;
//
//import java.util.Scanner;
//
//public class StartCreate {
////    public static Tries root = new Tries();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////
////        String str = sc.nextLine();
//        createTries("apple");
//        createTries("apps");
//        createTries("apxl");
//
//        System.out.println(search("app"));
//        System.out.println(search("appy"));
//
//        System.out.println(isStartsWith("app"));
//        System.out.println(isStartsWith("dev"));
//        sc.close();
//    }
//
//    private static boolean search(String string) {
//        Tries curNode = root;
//
//        for (char ch : string.toCharArray()) {
//            if(curNode.arr[ch - 'a'] == '\u0000' && curNode.arr[ch - 'a']!=ch){
//                return false;
//            }
//            curNode = curNode.child;
//        }
//        return curNode.isTerminal;
//    }
//
//    private static boolean isStartsWith(String str) {
//        Tries curNode = root;
//
//        for (char ch : str.toCharArray()) {
//            char c = curNode.arr[ch-'a'];
//            if (c == '\u0000') {
//                return false;
//            }
//            curNode = curNode.child;
//        }
//
//        return true;
//    }
//
//    public static void createTries(String str) {
//
//        Tries node = root;
//        for (char ch : str.toCharArray()) {
//            if (node.arr[ch - 'a'] == '\u0000') {
//                node.arr[ch - 'a'] = ch;
//                if(node.child == null){
//                    node.child = new Tries();
//                }
//            }
//            node = node.child;
//        }
//        node.isTerminal = true;
//    }
//}
