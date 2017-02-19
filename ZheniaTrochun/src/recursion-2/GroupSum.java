/**
 * Created by zhenia on 17.02.17.
 */
public class GroupSum {
    public boolean groupSum(int start, int[] nums, int target) {
        if(start >= nums.length) return target == 0;

        if(groupSum(start + 1, nums, target)) return true;

        if(groupSum(start + 1, nums, target - nums[start])) return true;

        return false;
    }

}
