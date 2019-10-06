public class ClimbingStairs {
    public static void main(String[] args) {
        int res = climbStairs(4);
        System.out.println(res);
        String s = "hello";
        
    }
    public static int climbStairs(int n) {
        if(n<2) return 1;
        int oneStep = 1;
        int twoStep = 1;
        int res = 0;
        for(int i = 2; i<=n ; i++){
            res = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = res;
        }
        return res;
    }
}
