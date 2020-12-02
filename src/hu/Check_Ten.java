package hu;

public class Check_Ten {
    public static void main(String[] args) {
        System.out.println(checkTen("53.5e93"));
    }

    public static boolean checkTen(String s) {
        if (s == null || s.length() == 0)
            return false;
        //排除空格  全为空格则返回false
        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        if (start == s.length()) {
            return false;
        }

        //判断第一个e与最后一个e出现的位置是否相同
        if (s.indexOf("e") != s.lastIndexOf("e")) {
            return false;
        }
        s = s.substring(start, end + 1);
        //将字符串从e出分割
        String[] str = s.split("e");
        if (str.length > 2 || str.length < 1) {
            return false;
        }
        String temp = str[0];
        if (temp.equals(".") || temp.equals("") || temp.equals("+") || temp.equals("-")
                || temp.equals("-.") || temp.equals(".+")) {
            return false;
        }
        //底数部分
        int flag = 1;
        if (temp.charAt(0) == '+' || temp.charAt(0) == '-') {
            temp = temp.substring(1);
        } else if (temp.charAt(0) == '.' || (temp.charAt(0) >= '0' && temp.charAt(0) <= '9')) {
        } else {
            return false;
        }
        for (int i = 0; i < temp.length(); i++) {
            if (flag == 1 && temp.charAt(i) == '.') {
                flag = 0;
                continue;
            } else if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        //如果s只是e，那么返回false
        if (str.length == 1 && !s.contains("e")) {
            return true;
        }
        if (str.length == 1 && s.contains("e")) {
            return false;
        }
        //指数只能有数字；+；-
        temp = str[1];
        if (temp.equals(".") || temp.equals("") || temp.equals("+") || temp.equals("-")) {
            return false;
        }
        if (temp.charAt(0) == '+' || temp.charAt(0) == '-') {
            temp = temp.substring(1);
        } else if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
        } else {
            return false;
        }
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
