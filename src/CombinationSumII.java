import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),res,0);
        return res;
    }
    public void helper(int[] candidates, int target,List<Integer> curComb, List<List<Integer>> res, int start){
        if(target<0) return;
        if(target == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }
        for(int i = start; i< candidates.length; i++){
            if(i!=start && candidates[i]==candidates[i-1]) continue;
            curComb.add(candidates[i]);
            helper(candidates, target-candidates[i], curComb, res, i+1 );
            curComb.remove(curComb.size()-1);
        }

    }
}
