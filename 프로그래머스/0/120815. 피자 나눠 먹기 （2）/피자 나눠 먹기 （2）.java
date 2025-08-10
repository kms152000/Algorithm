class Solution {
    public int solution(int n) {
        int slices = 6;
        int piz = 1;
        
        while ((piz * slices) % n != 0) {
            piz++;
        }
        
        return piz;
    }
}