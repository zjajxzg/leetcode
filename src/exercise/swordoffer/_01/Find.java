package exercise.swordoffer._01;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author zhigang.xu
 */
public class Find {
    /**
     * 暴力  遍历所有一维数组
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 暴力+二分（有序的东西有意识的联想到二分）
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find2(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (!binarySearch(target, array[i])) {
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * 二分查找一个数在不在一个有序数组中（非递归版本）
     * @param target
     * @param array
     * @return
     */
    private static boolean binarySearch(int target, int[] array) {
        int right = array.length, left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) {
                return true;
            } else if (target < array[mid]) {
                right = (mid + right) / 2;
            } else if (target > array[mid]) {
                left = (mid + left) / 2;
            }
        }
        return false;
    }

    /**
     * 二分递归版
     *
     * @param target
     * @param array
     * @return
     */
    private static boolean binarySearchRecursive(int target, int[] array) {
        return true;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find2(3, array));
    }
}
