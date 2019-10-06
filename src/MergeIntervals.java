import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0]==null ||intervals[0].length==0) {
            return new int[][] {};
        }
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0 ; i< intervals.length; i++){
            if(intervals[i][0]<=end){
                end = Math.max(end,intervals[i][1]);

            }else{
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[] {start, end});
        return  res.toArray(new int[res.size()][]);
    }
}
