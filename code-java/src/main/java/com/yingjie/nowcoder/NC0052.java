package com.yingjie.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>Title: NC0052</p>
 * <p>Description: </p>
 *
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class NC0052 {

    public boolean isValid(String s) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put('}', '{');
        dict.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!dict.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.empty() || !stack.pop().equals(dict.get(ch))) {
                return false;
            }
        }
        return stack.empty();
    }
}
