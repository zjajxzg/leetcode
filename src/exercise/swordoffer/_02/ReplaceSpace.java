package exercise.swordoffer._02;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author zhigang.xu
 */
public class ReplaceSpace {
    /**
     * 直接使用java提供的api
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "20%");
    }

    /**
     * 空格的ASCII码值32   时间复杂度O(n)
     *
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 32) {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(replaceSpace(stringBuffer));
        System.out.println(replaceSpace2(new StringBuffer("we are happy")));
    }
}
