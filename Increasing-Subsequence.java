public class Solution {
private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0) return res;

        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
                dfs(nums,list,i);
            }
        }
        return res;
    }
 
    private void dfs(int[] nums, List<Integer> list, int pos) {
        if(pos == nums.length) return;
        
        list.add(nums[pos]);
        if(list.size() >= 2) res.add(new ArrayList<Integer>(list));
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = pos+1; i < nums.length; i++) {
            if(nums[i] >= nums[pos] && !map.containsKey(nums[i])) {
                map.put(nums[i],1);
                dfs(nums,list,i);
            }
        }
        list.remove(list.size()-1);
    }
}
