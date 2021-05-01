/**
 * ClassName: Test20210501
 * Description: 比较含退格的字符串
 * date: 2021/5/1 22:12
 *  给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * @author wt
 * @since JDK 1.8
 */
public class Test20210501 {

        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        public String build(String str) {
            StringBuffer ret = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                char ch = str.charAt(i);
                if (ch != '#') {
                    ret.append(ch);
                } else {
                    if (ret.length() > 0) {
                        ret.deleteCharAt(ret.length() - 1);
                    }
                }
            }
            return ret.toString();
        }
}
