/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/calculator-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution16_26_1 {
    public int calculate(String s) {
        LinkedStack numStack = new LinkedStack(); // 数字栈
        LinkedStack operaStack = new LinkedStack(); // 算符栈

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                String str = "";

                // 识别两位数、三位数等数字
                while (i < s.length()) {
                    if (Character.isDigit(s.charAt(i))) {
                        str += s.charAt(i);
                        i++;
                    } else {
                        i--; // 检测到算符则需要回退一步
                        break;
                    }
                }

                numStack.push(str);
            } else {
                // 忽略空格
                if (s.charAt(i) == ' ') {
                    continue;
                }

                // 判断算符优先级
                if (operaStack.isEmpty() || isAPreOverB(s.charAt(i), operaStack.getTopVal().charAt(0))) {
                    // 当前运算符大于算符栈顶运算符，需要先出栈计算
                    operaStack.push(s.charAt(i) + "");
                } else {
                    // 当前运算符小于等于算符栈顶运算符，需要先出栈计算
                    String right = numStack.pop(); // 先出栈的为右操作数
                    String left = numStack.pop(); // 左操作数
                    char opera = operaStack.pop().charAt(0); // 算符
                    numStack.push(calc(left, right, opera)  + ""); // 将计算结果入数字栈
                    i--; //此处由于发生过计算（有符号出栈），所以需要回退一步，以便判断 出栈之后的算符栈顶 与 当前算符 的优先级
                }
            }
        }

        // 当所有的数字或算符都入栈后，依次出栈计算
        while (!operaStack.isEmpty()) {
            String right = numStack.pop();
            String left = numStack.pop();
            char opera = operaStack.pop().charAt(0);
            numStack.push(calc(left, right, opera) + "");
        }

        return Integer.parseInt(numStack.pop());
    }

    // 判断算符优先级
    public boolean isAPreOverB(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        }

        if ((a == '+' || a == '-') && (b == '*' || b == '/')) {
            return false;
        }

        return false;
    }

    // 临时计算
    public int calc(String left, String right, char opera) {
        int numLeft = Integer.parseInt(left);
        int numRight = Integer.parseInt(right);

        switch (opera) {
            case '+' : return numLeft + numRight;
            case '-' : return numLeft - numRight;
            case '*' : return numLeft * numRight;
            case '/' : return numLeft / numRight;
            default : return 0;
        }
    }
}

// 自定义栈（双向链表实现）
class LinkedStack {
    StackNode head = new StackNode();
    StackNode tail = new StackNode();

    LinkedStack() {
        head.next = tail;
        tail.pre = head;
    }

    public void push(String val) {
        tail.pre.next = new StackNode(val);
        tail.pre.next.next = tail;
        tail.pre.next.pre = tail.pre;
        tail.pre = tail.pre.next;
    }

    public String pop() {
        StackNode result = null;
        if (head.next != tail) {
            result = tail.pre;
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
        }

        return result.val;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public String getTopVal() {
        return tail.pre.val;
    }
}

// 双向链表节点
class StackNode {
    StackNode pre = null;
    StackNode next = null;
    String val;

    StackNode(String val) {
        this.val = val;
    }

    StackNode() {}
}