package cn.camork.crawler.search;

import cn.camork.core.CoreUtils;
import cn.camork.model.BookBean;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.springframework.stereotype.Service;

@Service("similarPipeline")
public class SimilarPipeline implements Pipeline<SimilarSearchSpider> {

	@Override
	public void process(SimilarSearchSpider bean) {
		for(JSONObject object:bean.getBooks()){
			CoreUtils.BOOK_LIST.add(object.toJavaObject(BookBean.class));
		}
	}

}