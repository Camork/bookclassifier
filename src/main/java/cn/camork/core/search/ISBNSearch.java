package cn.camork.core.search;

import cn.camork.core.CoreUtils;
import cn.camork.core.ISearch;
import cn.camork.model.BookBean;
import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by camork on 2018/4/15.
 */
public class ISBNSearch implements ISearch{
	@Override
	public void search(PipelineFactory springPipelineFactory) {
		String isbnStr= (String) CoreUtils.POSSIBLE_NAMES.toArray()[0];

		HttpGet get = new HttpGet("https://api.douban.com/v2/book/isbn/"+isbnStr);

		CloseableHttpResponse response;

		try {
			response = HttpClients.createDefault().execute(get);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity, "utf-8");
			response.close();

			BookBean book= JSON.parseObject(content,BookBean.class);

			CoreUtils.BOOK_LIST.add(book);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
