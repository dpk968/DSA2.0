class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        genrateAll(n,"",0,0,ans);

        return ans;
    }
    public void genrateAll(int n, String tmp, int s, int e, List<String> ans){
        if(tmp.length()>=2*n){
            ans.add(new String(tmp));
            return;
        }
        if(s<n) genrateAll(n,tmp+"(",s+1,e,ans);
        if(e<s) genrateAll(n,tmp+")",s,e+1,ans);
    }
}