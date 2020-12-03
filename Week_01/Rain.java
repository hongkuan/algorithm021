package com.tj.kuan;

import java.util.Stack;

public class Rain {
    /**
     * 1.暴力破解：找出每一根柱子当前积水量， 分别找到左右两边最高两个 中最小的一个柱子减去当前高度  时间复杂度为O(n^2)空间复杂度为o(1)
     * 2.动态规划：左右两个数组 分别存放当前下标从右到左 和 从左到右到最高柱子的容水量  然后合并遍历这个数组 取当前值最小减去当前柱子高度 时间复杂度为O(n)空间复杂度为o(n)
     * 3.栈：遍历数组，将可能形成低洼的下标入栈，当出现大于栈顶高度时 出栈计算容水量，直到遍历完整个数组 时间复杂度为O(n)空间复杂度为o()n
     * 4.双指针夹逼：左右两端 指针指向柱子 较矮的中间肯定会积水，
     * 较矮段根据当前指针和存放的当前端最大值小 则积水就是最大值减去当前值，
     * 如果大于当前端最大值更新指针
     * 如果大于另一侧端值
     * 进入另一端循环计算积水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (null == height || height.length < 3) return 0;
        /*
        1.暴力破解
        int sum =0 ;
        for (int i =1 ;i < height.length; i++){
            int maxLeft =0, maxRight =0;
            for (int j =i;j>=0;j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j=i; j< height.length; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            sum += Math.min(maxLeft, maxRight) - height[i];
        }
        return sum;*/
        /*
        2.动态规划
        int sum =0;
        int[] maxLeftArr = new int[height.length],maxRightArr = new int[height.length];
        maxLeftArr[0] = height[0];
        for (int i =1; i< height.length; i++){
            maxLeftArr[i] = Math.max(height[i], maxLeftArr[i-1]);
        }
        maxRightArr[height.length- 1] = height[height.length -1];
        for (int i =height.length -2; i>=0; i--){
            maxRightArr[i] = Math.max(height[i], maxRightArr[i+1]);
        }
        for (int i =0; i< height.length; i++){
            sum += Math.min(maxLeftArr[i], maxRightArr[i]) -height[i];
        }

        return sum;*/

        /*
        3.栈
        int sum =0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length){
            while (!stack.isEmpty()&& height[cur] > height[stack.peek()]){
                int oldTop = stack.pop();
                if(stack.isEmpty()) break;
                int w = cur - stack.peek() -1;
                int h = Math.min(height[cur], height[stack.peek()]) - height[oldTop];
                sum += w * h;
            }
            stack.push(cur++);
        }
        return sum;*/
        //4.双指针
        /*int sum =0 ;
        int leftIndex = 0, rightIndex = height.length -1;
        int leftMax = 0, rightMax =0;
        while (leftIndex < rightIndex){
            if (height[leftIndex]< height[rightIndex]){
                if (leftMax< height[leftIndex]){
                    leftMax = height[leftIndex];
                }else {
                  sum += leftMax - height[leftIndex];
                }
                ++leftIndex;
            } else {
                if (rightMax < height[rightIndex]) {
                    rightMax = height[rightIndex];
                }else {
                    sum += rightMax - height[rightIndex];
                }
                --rightIndex;
            }
        }

        return  sum;*/
        if (height == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < height.length) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int bot = s.pop();
                maxBotWater = s.isEmpty() ? // empty means no il
                        0 : (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
