package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.ansj.splitWord.analysis.ToAnalysis.*;

//完成核心的搜索过程
public class Searcher {
    private Index index = new Index();

    public Searcher() throws IOException {
        index.build("d:/raw_data.txt");
    }

    public List<Result> search(String query) {
        //1.分词 针对查询词进行分词
        List<Term> terms = parse(query).getTerms();

        //2.触发 针对分词结果一次查找倒排索引，得到 docId
        //ArrayList 保存针对每个分词得到的倒排拉链总和。
        //Index.Weight 就是一个倒排拉链？？？
        ArrayList<Index.Weight> allTokenResult = new ArrayList<>();
        for (Term term : terms) {
            String word = term.getName();
            List<Index.Weight> invertedList = index.getInverted(word);
            if (invertedList == null) {
                //在文档中未找到该词
                continue;
            }
            allTokenResult.addAll(invertedList);
        }

        //3.排序 按照权重进行降序排序
        allTokenResult.sort((o1, o2) -> o2.weight - o1.weight);

        //4.包装结果 weight.docId -> docInfo，包装成 Result 对象
        ArrayList<Result> res = new ArrayList<>();
        for (Index.Weight weight : allTokenResult) {
            //根据 weight 中包含的 docId 找到对应的 DocInfo 对象
            DocInfo docInfo = index.getDocInfo(weight.docId);
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setShowUrl(docInfo.getUrl());
            result.setClickUrl(docInfo.getUrl());
            result.setDesc(GenDesc(docInfo.getContent(), weight.word));
            res.add(result);
        }
        return res;
    }

    //获取正文的一部份内容作为描述
    private String GenDesc(String content, String word) {
        int firstPos = content.toLowerCase().indexOf(word);
        if (firstPos == -1) {
            //某个词只在标题中出现
            return "";
        }
        //描述开始：从 firstPos 开始往前找 60 个字符，若不足，则从正文开头开始
        int descBeg = firstPos < 60 ? 0 : firstPos - 60;
        //描述结束：从 firstPos 开始往后找 100 个字符，若不足，则以正文结尾结束
        if (descBeg + 160 > content.length()) {
            return content.substring(descBeg);
        }
        return content.substring(descBeg, descBeg + 160) + "...";
    }
}
