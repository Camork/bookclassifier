package cn.camork.action;

import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by liferay on 2017/12/14.
 */
public class Ai {

	//设置APPID/AK/SK
	public static final String APP_ID = "10534376";
	public static final String API_KEY = "CGEdTIAsvAagZao1qGSh1IWU";
	public static final String SECRET_KEY = "kf05zPQn7OGSAZkvb5kGBCEql5lgR0lg";

	public AipOcr getInstance(){
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		return client;
	}

	public void webImageOCR(AipOcr client, InputStream input) throws Exception{

		JSONObject response = client.webImage(IOUtils.toByteArray(input),new HashMap<>());
		System.out.println(response.toString());


	}
}
