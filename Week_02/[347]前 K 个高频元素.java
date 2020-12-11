//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 585 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            int cout = 1;
            if (map.containsKey(i)){
                cout = map.get(i) + 1;
            }
            map.put(i, cout);
        }

        //int[] 代表存入队列中的元素 第一个值是数组值，第二个值是在数组出现次数，根据次数进行排序比较
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1] - t1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getKey(), count = entry.getValue();
            if (queue.size()==k){
                if (queue.peek()[1]< count){
                    queue.poll();
                } else {
                    continue;
                }
            }
            queue.offer(new int[]{val, count});
        }

        int[] resArr = new int[k];
        for (int i = 0;i< k;i++){
            resArr[i] = queue.poll()[0];
        }
        return resArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
