package exercise.swordoffer._09;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    /**
     * 每一步都有跳与不跳两种选择  2^n-1
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
//        return (int) Math.pow(2, target - 1);
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().jumpFloorII(3));
    }
}
