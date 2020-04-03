package parser;

import java.io.*;
import java.util.ArrayList;

//遍历文档目录，读取所有的 html 文档内容，把结果解析成文本文档
//每行对应一个文档。一行中包含：文档标题、文档 url 、文档正文
public class Parser {
    private static final String INPUT_PATH = "F:\\docs\\api";
    private static final String OUTPUT_PATH = "D:\\raw_data.txt";

    public static void main(String[] args) throws IOException {
        FileWriter resultFileWriter = new FileWriter(new File(OUTPUT_PATH));
        //1.枚举出INPUT_PATH的所有文件（递归）
        ArrayList<File> fileList = new ArrayList<>();
        enumFile(INPUT_PATH, fileList);
        //System.out.println(fileList);
        //2.遍历得到的 html 文件，读取文件并转换成结构化的数据（DocInfo）
        for (File f : fileList) {
            System.out.println("converting " + f.getAbsolutePath() + " ...");
            String line = convertLine(f);
            //System.out.println(line);
            //3.把得到的结果写入输出文件中，写成行文本的形式
            resultFileWriter.write(line);
        }
        resultFileWriter.close();
    }

    //枚举出INPUT_PATH的所有文件（递归）
    private static void enumFile(String inputPath, ArrayList<File> fileList) {
        //递归遍历
        File root = new File(inputPath);
        File[] files = root.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                //是目录，递归调用
                enumFile(f.getAbsolutePath(), fileList);
            } else if (f.getAbsolutePath().endsWith(".html")){
                //不是目录，若文件后缀是.html，就加入到fileList中
                fileList.add(f);
            }
        }
    }

    private static String convertLine(File f) throws IOException {
        String title = convertTitle(f);
        String url = convertUrl(f);
        String content = convertContent(f);
        //\3起到分割三个部分的作用，html这样的文本文件是不会出现\3这样的不可见字符
        return title+"\3"+url+"\3"+content+"\n";
    }

    //去掉文档的 html 标签 即文档正文
    private static String convertContent(File f) throws IOException {
        //去掉 html 标签
        FileReader fileReader = new FileReader(f);
        boolean isContent = true;
        StringBuilder output = new StringBuilder();
        while (true) {
            int ret = fileReader.read();
            if (ret == -1) {
                break;
            }
            char c = (char) ret;
            if (isContent) {
                if (c == '<') {
                    isContent = false;
                    continue;
                }
                if (c == '\n' || c == '\r') {
                    //\r \n 的区别
                    c = ' ';
                }
                output.append(c);
            } else {
                if (c == '>') {
                    isContent = true;
                }
            }
        }
        return output.toString();
    }

    private static String convertUrl(File f) {
        //
        String part1 = "http://docs.oracle.com/javase/8/docs/api";
        String part2 = f.getAbsolutePath().substring(INPUT_PATH.length());
        return part1+part2;
    }

    private static String convertTitle(File f) {
        String name = f.getName();
        return name.substring(0, name.length()-".html".length());
    }

}
