import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class TwoSumOnSortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new TwoSum().nearestTwoSum(new int[]{-9, -5, -2, -1,1,4,9,11}, 1)));
	} 

	// T = O(n), S = O(1)
	public int[] twoSum0(int[] nums, int target) {
		for (int i = 0, j = nums.length - 1; i < j;) {
			if (nums[i] + nums[j] > target) {
				j--;
			} else if (nums[i] + nums[j] < target) {
				i++;
			} else {
				return new int[]{nums[i], nums[j]};
			}
		}
		return new int[0];
	}

	// T = O(n), S = O(n)
	public int[] twoSum1(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(target - n)) {
				return new int[]{n, target - n};
			}
			set.add(n);
		}
		return new int[0];
	}

	// T = O(n*log(n)), S = O(1)
	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]) > 0) {
				return new int[]{nums[i], target - nums[i]};
			}
		}
		return new int[0]; 
	}

	// T = O(n), S = O(1)
	public int[] nearestTwoSum(int[] nums, int target) {
		int[] ans = new int[]{0, Integer.MAX_VALUE};
		for (int i = 0, j = nums.length - 1; i < j;) {
			int sum = nums[i] + nums[j];
			if (Math.abs((target - (ans[0] + ans[1]))) > Math.abs(target - sum)) {
				ans[0] = nums[i];
				ans[1] = nums[j];
			}
			if (sum > target) {
				j--;
			} else if (sum < target) {
				i++;
			} else {
				return ans;
			}
		}
		return ans;
	}
}
