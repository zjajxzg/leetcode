package exercise.easy._013;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToInt {

    /**
     * 利用map来存储罗马字符和数字的映射关系
     * 从左到右处理 前一位 >= 后一位 直接相加即可
     * 否则后一位减前一位 因为之前已经加过一次 减两次
     */
    public static int romanToInt1(String s) {
        Map<Character, Integer> map = new HashMap<>(8);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int x = 0;
        int a;
        int b;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }
        for (int i = 0; i < s.length() - 1; i++) {
            a = map.get(s.charAt(i));
            b = map.get(s.charAt(i + 1));
            x += a;
            // 最后一位直接加集客
            if (i == s.length() - 2) {
                x += b;
            }
            // 前一位小于后一位 减2次前一位 前面已经加过一次
            if (a < b) {
                x -= 2 * a;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("IV"));
    }
}
