package sim;


public class Scanner {
    static String[] keyWords = {"begin", "if", "then","while","do", "end"};

    static char[] value = new char[50];
    static int p = 0;

    //判断是否为关键字
    public static int isKeyWords(char[] str) {
        String x = new String(str).trim();
        for (int i = 0; i < 6; i++) {
            if (x.equals(keyWords[i]) ) {
                return i+1;
            }
        }
        return -1;
    }

    //判断是否为数字开头
    public static boolean isNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    //判断是否是字母
    public static boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

    //分析
    public static int analyze(String str) {
        for (int i = 0; i < value.length; i++) {
            value[i] = 0;
        }

        int type = -1;
        int cnt = 0;

        while (str.charAt(p) == ' ') {
            p++;
        }

        if (isLetter(str.charAt(p))) { //关键字或自定义变量
            while (isLetter(str.charAt(p)) || isNum(str.charAt(p))) {
                //System.out.println(str.charAt(p));
                value[cnt++] = str.charAt(p++);
            }
            type = isKeyWords(value); //关键字
            if (type == -1) {
                type = 10; //自定义变量
            }
        } else if (isNum(str.charAt(p))) { //数字
            while (isNum(str.charAt(p))) {
                value[cnt++] = str.charAt(p++);
            }
            type = 11;
        } else {
            char ch = str.charAt(p);
            switch (ch) {
                case '+' : type = 13; value[0] = ch;p++;break;
                case '-' : type = 14; value[0] = ch;p++;break;
                case '*' : type = 15; value[0] = ch;p++;break;
                case '/' : type = 16; value[0] = ch;p++;break;
                case '=' : type = 25; value[0] = ch;p++;break;
                case ';' : type = 26; value[0] = ch;p++;break;
                case '(' : type = 27; value[0] = ch;p++;break;
                case ')' : type = 28; value[0] = ch;p++;break;
                case '#' : type = 0; value[0] = ch;p++;break;
            }
        }

        if (type == -1) {
            if (str.charAt(p) == ':') {
                value[cnt++] = str.charAt(p);
                if (p+1 < str.length() && str.charAt(p+1) == '=') {
                    p++;
                    value[cnt++] = str.charAt(p);
                    type = 18;
                } else {
                    type = 17;
                }
            }

            if (str.charAt(p) == '<') {
                value[cnt++] = str.charAt(p);
                if (str.charAt(p+1) == '>') {
                    p++;
                    value[cnt++] = str.charAt(p);
                    type = 21;
                } else if (str.charAt(p+1) == '=') {
                    p++;
                    value[cnt++] = str.charAt(p);
                    type = 22;
                } else {
                    type = 20;
                }
            }

            if (str.charAt(p) == '>') {
                value[cnt++] = str.charAt(p);
                if (str.charAt(p+1) == '=') {
                    p++;
                    value[cnt++] = str.charAt(p);
                    type = 24;
                } else {
                    type = 23;
                }
            }
            p++;
        }
        return type;
    }

    public static void main(String[] args) {
        String str = "begin x:=9; if x>0 then x:=2*x+1/3; end#";
        while (p < str.length()){
            System.out.println(analyze(str) + " " + new String(value).trim());
        }
    }

}
