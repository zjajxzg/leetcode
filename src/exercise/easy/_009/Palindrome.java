package exercise.easy._009;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Palindrome {
    /**
     * 利用第7题的reverse方法解  reverse之后比较是否相同即可
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int i = 1;
        int xx = x;
        while (true) {
            x = x / 10;
            if (x == 0) {
                break;
            }
            i++;
        }
        int z = 0;
        int num;
        for (int j = 1; j <= i; j++) {
            num = xx % (int) (Math.pow(10, j)) / (int) Math.pow(10, j - 1);
            z += num * (int) (Math.pow(10, (i - j)));
        }
        System.out.println(z);
        return z == xx;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(-121));
    }
}
