package cn.camork.action;

import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by liferay on 2017/12/14.
 */
public class AipOcrClient {

	public static final String APP_ID = "10534376";
	public static final String API_KEY = "CGEdTIAsvAagZao1qGSh1IWU";
	public static final String SECRET_KEY = "kf05zPQn7OGSAZkvb5kGBCEql5lgR0lg";
	private static AipOcr client = null;

	private AipOcrClient() {
	}

	public static AipOcr getInstance() {
		if (client == null) {
			synchronized (AipOcrClient.class) {
				if (client == null) {
					client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
				}
			}
		}
		return client;
	}

	public static void webImageOCR(InputStream input) throws Exception {
		JSONObject response = getInstance().webImage(IOUtils.toByteArray(input), new HashMap<>());
		System.out.println(response.toString());
	}
}
