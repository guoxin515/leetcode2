
package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        new Solution2().twoSum(input, 9);
    }
}

class Solution {
    // O(n^2)
    public int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums);
        int[] result = new int[2];
        System.out.println("init" + Arrays.toString(result));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        System.out.println("result" + Arrays.toString(result));
        return result;
    }
}

class Solution2 {
    // O(n)
    public int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums);
        int[] result = new int[2];
        System.out.println("init" + Arrays.toString(result));

        Map<Integer, Integer> input = new HashMap<>();
        // map：key是数组元素，value是元素对应下标
        for (int i = 0; i < nums.length; i++) {
            input.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int answer = target - nums[j];
            // 每个数字智能用一次
            if (input.containsKey(answer) && input.get(answer) != j) {
                result[0] = j;
                result[1] = input.get(answer);
            }
        }
        // 下标从小到大输出
        if (result[0] > result[1]) {
            int tmp = result[0];
            result[0] =  result[1];
            result[1] = tmp;
        }
        System.out.println("result" + Arrays.toString(result));
        return result;
    }
}

