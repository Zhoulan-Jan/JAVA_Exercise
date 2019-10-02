public class Exam {
    public static void main(String[] args) {
        String id = "340524198001010018";
        System.out.println(id.length());

        int sum = 0;
        int[] value = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        for (int i = 0; i < value.length; i++) {
            sum += value[i] * (id.charAt(i) - '0');  //注意ascii码 //189
        }
        System.out.println(sum);

        char[] code = {'1','0','X','9','8','7','6','5','4','3','2'};
        int ans = sum % 11;
        if (code[ans] == id.charAt(17)) {
            System.out.println("true");
        } else {
            System.out.println(false);
        }
    }
}
