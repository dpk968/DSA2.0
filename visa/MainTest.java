package visa;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> lst  = new ArrayList<>();

        for(int i=0;i<n;i++){
            lst.add(sc.next());
        }
        int k = sc.nextInt();
        System.out.println(lst);
        findBusrtArra(lst,k);
        

    }

    private static void findBusrtArra(List<String> lst, int k) {
       Stack<Pair> st = new Stack<>();
       st.add(new Pair(lst.get(0), 1));

        for (String s  : lst) {
            Pair e = st.pop();
            String curStr = e.f;
            int curCnt = e.s;

            if(curStr.equals(s)){
                curCnt++;
            }else{
                if(curCnt >= k){
                    curCnt = 1;
                    curStr = s;
                }else{
                    st.add(new Pair(curStr, curCnt));
                    curCnt = 1;
                    curStr = s;
                }
            }
        }

        while (!st.isEmpty()) {
            Pair p = st.pop();
            System.out.println(p.f);
        }

    }
}

class Pair{
    String f;
    int s;

    Pair(String f,int s){
        this.f = f;
        this.s = s;
    }
}