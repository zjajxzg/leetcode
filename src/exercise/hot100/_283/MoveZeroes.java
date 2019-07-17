package exercise.hot100._283;


import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
    /**
     * 双指针
     * @param nums
     */
//    public void moveZeroes(int[] nums) {
//        int first = 0;
//        int second = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                first = i;
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        second = j;
//                        int temp = nums[first];
//                        nums[first] = nums[second];
//                        nums[second] = temp;
//                        break;
//                    }
//                }
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swapArrays(nums,i,k++);
            }
        }
    }
    private void swapArrays(int[] nums,int first,int second){
        if(first == second){
            return;
        }
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
