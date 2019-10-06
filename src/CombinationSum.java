import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        helper(candidates, target,new ArrayList<>(),res,0 );
        return res;
    }
    public void helper(int[] candidates, int target,List<Integer> curComb, List<List<Integer>> res ,int start){
        if(target < 0) return;
        else if(target == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }else{
            for(int i = start; i< candidates.length ; i++){
                curComb.add(candidates[i]);
                helper(candidates,target-candidates[i],curComb,res,i);
                curComb.remove(curComb.size()-1);
            }
        }

    }
}
