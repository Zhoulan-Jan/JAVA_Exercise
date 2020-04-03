package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.ansj.splitWord.analysis.ToAnalysis.*;

//完成核心的搜索过程
public class Searcher {
    private Index index = new Index();

    public Searcher() throws IOException {
        index.build("d:/raw_data.txt");
    }

    public List<Result> search(String query) {
        //1.分词
        List<Term> terms = parse(query).getTerms();
        //2.触发
        //ArrayList 保存针对每个分词得到的结果
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
        //3.排序
        allTokenResult.sort((o1, o2) -> o1.weight - o2.weight);
        //4.包装结果
        ArrayList<Result> res = new ArrayList<>();
        for (Index.Weight weight : allTokenResult) {
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
            return "";
        }
        int descBeg = firstPos;
        return "";
    }


}
