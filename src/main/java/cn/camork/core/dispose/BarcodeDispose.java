package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.model.BookBean;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by camork on 24/12/2017.
 */
public class BarcodeDispose{

	private String isbnStr;

	public BarcodeDispose(String isbnStr) {
		this.isbnStr = isbnStr;
	}

	public void putBook() {
		HttpGet get = new HttpGet("https://api.douban.com/v2/book/isbn/"+isbnStr);

		CloseableHttpResponse response;

		try {
			response = HttpClients.createDefault().execute(get);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity, "utf-8");
			response.close();
			System.out.println(content);

			BookBean book= JSON.parseObject(content,BookBean.class);

			CoreUtils.bookList.add(book);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
