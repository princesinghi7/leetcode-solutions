class Solution {
    public String maximumNumber(String num, int[] change) {
        char stb[] = num.toCharArray();
        boolean flag = false;
        for(int i = 0; i < stb.length; i++){
            if(stb[i] - '0'<change[stb[i]-'0']){
                stb[i] = (char)(change[stb[i]-'0']+'0');
                flag = true;
            }
            else if(stb[i]-'0' == change[stb[i]-'0'] ||!flag){
                continue;
            }
            else{
                break;
            }
        }
        return new String(stb);
    }
}