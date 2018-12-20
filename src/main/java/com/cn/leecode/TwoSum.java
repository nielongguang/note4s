package com.cn.leecode;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {


    public static void main(String[] args) {
        int [] nums = new int[] {1,4,6,12,5,7,2,5};
        TwoSum twoSum =new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));

        Stack<Integer> l1 =new Stack<>();
        l1.push(1);
        l1.push(9);
        l1.push(1);

        Stack<Integer> l2 =new Stack<>();
        l2.push(8);
        l2.push(1);
        l2.push(2);

        twoSum.addTwoNumbers(l1,l2).forEach(System.out::println);

        System.out.println(twoSum.lengthOfLongestSubstringHashMap("asfgagadsfadf"));
        System.out.println(twoSum.lengthOfLongestSubstringSet("asfgagadsfadf"));
    }

    /**
     *  思路
     *  使用hash桶 一遍放一边和之前放入的数据比对。发现满足条件的数据则返回结果
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (map.containsKey(s)) {
                return new int[]{i, map.get(s)};
            }
            //map put值放在下面预期能少判定一次，含义为当前put值与target 与其他值相比
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("参数不符合条件");
    }

    public Stack<Integer> addTwoNumbers(Stack<Integer> l1, Stack<Integer> l2) {
        Stack<Integer> stack = new Stack<>();
        int len =  Math.max(l1.size(),l2.size())+1;
        int up=0;

        int i = 0;
        while (i < len || up>0) {
            Integer n1 = 0;
            if (l1.size()>0){
                n1=l1.pop();
            }
            Integer n2 = 0;
            if (l2.size()>0){
                n2=l2.pop();
            }
            if (n1+n2+up>=10){
                stack.push(n1+n2+up-10);
                up=1;
            }else {
                stack.push(n1+n2+up);
                up=0;
            }

            i++;
        }
        return stack;
    }

 //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。abecabs

     public int lengthOfLongestSubstring(String s) {
         int n = s.length(), ans = 0;
         int[] index = new int[128]; // current index of character
         // try to extend the range [i, j]
         for (int j = 0, i = 0; j < n; j++) {
             i = Math.max(index[s.charAt(j)], i);
             ans = Math.max(ans, j - i + 1);
             index[s.charAt(j)] = j + 1;
         }
         return ans;
     }



        public int lengthOfLongestSubstringSet(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
//                System.out.println(String.format("i={%s},j={%s},ans={%s}",i,j,ans));
            }
            return ans;


        }



        public int lengthOfLongestSubstringHashMap(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    //取出导致重复的下标-> 滑动到该窗口之后,因为当前窗口的最大值已得出
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                //j为当前下标，i为上次出现重复的下标 j-i<=0
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);

//                System.out.println(String.format("i =[%s],j=[%s],ans=[%s]",i,j,ans));
            }
            return ans;

        }

}
