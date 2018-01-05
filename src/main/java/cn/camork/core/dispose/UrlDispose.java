package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by camork on 24/12/2017.
 */
public class UrlDispose implements IRecognize {

	private String urlStr;
	private List<String> arrayList;

	public UrlDispose(String urlStr) {
		this.urlStr = urlStr;
	}

	@Override
	public List<String> getTexts() {

		try {
			URL url = new URL(urlStr);

			URLConnection con = url.openConnection();

			InputStream inputStream = con.getInputStream();

			arrayList = CoreUtils.getOcrData(inputStream);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return arrayList;
	}
}
