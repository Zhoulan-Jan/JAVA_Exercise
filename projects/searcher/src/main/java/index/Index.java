package index;

import common.DocInfo;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//索引类 包括正排索引、倒排索引
//正排：根据文档 id 查到文档信息
//倒排：根据关键词找到 文档 id
public class Index {
        // word 这个词在 docId 文档中对应的权重是多少
        static public class Weight {
                public String word;
                public int docId;
                // weight 生成公式: 10 * 标题中出现的次数 + 正文中出现的次数
                public int weight;
        }

        // 正排索引是 docId => DocInfo 直接把 docId 作为数组下标就行了
        private ArrayList<DocInfo> forwardIndex = new ArrayList<>();
        // 倒排索引 词 => 一组 docId
        // 不光能得到每个词在哪些文档中出现过, 还想知道这个词在该文档中的权重是多少.
        private HashMap<String, ArrayList<Weight>> invertedIndex = new HashMap<>();

        //查正排
        public DocInfo getDocInfo(int docId) {
              return forwardIndex.get(docId);
        }

        //查倒排
        public ArrayList<Weight> getInverted(String term) {
                return invertedIndex.get(term);
        }

        //构建索引，把 raw_data.txt 文件内容读出来，加载到上述的数据结构中
        public void build(String inputPath) throws IOException {
                long startTime = System.currentTimeMillis();
                System.out.println("build start!");

                //1.打开文件，按行读取文件内容
                BufferedReader br = new BufferedReader(new FileReader(new File(inputPath)))
                //2.读取到的每一行，
                String line = "";
                while ((line = br.readLine()) != null) {
                        //3.构造正排：按照 \3 切分，并将结果构造成一个 DocInfo 对象，加入到正排索引
                        DocInfo docInfo = buildForward(line);
                        //4.构造倒排：把 DocInfo 对象里面内容进一步处理，构造倒排索引
                        buildInverted(docInfo);
                        System.out.println("Buil " + docInfo.getTitle() + " done!");
                }
                br.close();

                long finishTime = System.currentTimeMillis();
                System.out.println("build finish time = " + (finishTime - startTime) + " ms");
        }

        //构造正排：按照 \3 切分，并将结果构造成一个 DocInfo 对象，加入到正排索引
        private DocInfo buildForward(String line) {
                String[] tokens = line.split("\3");
                if (tokens.length != 3) {
                        System.out.println("文件格式存在问题 " + line);
                        return null;
                }
                DocInfo docInfo = new DocInfo();
                docInfo.setDocId(forwardIndex.size());
                docInfo.setTitle(tokens[0]);
                docInfo.setUrl(tokens[1]);
                docInfo.setContent(tokens[2]);
                forwardIndex.add(docInfo);
                return docInfo;
        }

        //构造倒排：把 DocInfo 对象里面内容（title、content）进一步处理，构造倒排索引
        private void buildInverted(DocInfo docInfo) {
                class WordCnt {
                        public int titleCnt;
                        public int contentCnt;

                        public WordCnt(int titleCnt, int contentCnt) {
                                this.titleCnt = titleCnt;
                                this.contentCnt = contentCnt;
                        }
                }

                //1.标题分词
                List<Term> titleTerms = ToAnalysis.parse(docInfo.getTitle()).getTerms();
                //2.遍历标题分词结果，统计每个词出现次数
                for (Term term : titleTerms) {
                        String word = 
                }
                //3.正文分词
                //4.遍历正文分词结果，统计每个词出现次数
                //5.把两部分结果整理到一个 HashMap 中，
                //6.遍历 HashMap，依次构建 Weight 对象并更新倒排索引的映射关系
        }
}
