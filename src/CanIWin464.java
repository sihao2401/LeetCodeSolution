import java.util.*;
import java.util.PriorityQueue;
public class CanIWin464 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length == 0) return;
        int firstSmall = -1;
        int firstLarge=-1;
        for(int i =nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall==-1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        for(int j = nums.length-1; j>firstSmall ; j--){
            if(nums[j]>nums[firstSmall]){
                firstLarge = j;
                break;
            }
        }
        if(firstLarge==-1){
            return;
        }
        swap(nums, firstSmall,firstLarge);
        reverse(nums, firstSmall+1,nums.length-1);
        return;

    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static int divide(int dividend, int divisor) {

        if(divisor == 0) throw new IllegalArgumentException("divisor cannot be zero.");
        int sign = 1;
        if((dividend>0 && divisor<0)|| (dividend<0 && divisor>0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lres = dividel(ldividend,ldivisor);
        int res=0;
        if( lres >Integer.MAX_VALUE) {
            res = sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
            res = (int)(sign*lres);
        }
        return res;
    }
    public static long dividel(long ldividend , long ldivisor ) {
        if(ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multi = 1;
        while((sum+sum) <= ldividend ){
            sum+=sum;
            multi+=multi;
        }
        return multi + dividel(ldividend-sum,ldivisor);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur!=null && count!=k ){
            cur=cur.next;
            count++;
            if(k == count){
                cur = reverseKGroup(cur, k);
                while(count-->0){
                    ListNode temp = head.next;
                    head.next = cur;
                    cur = head;
                    head = temp;
                }
            }
            head = cur;
        }
        return head;
    }

}
