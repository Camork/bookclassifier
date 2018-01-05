package cn.camork.core;

import cn.camork.action.AipOcrClient;
import cn.camork.core.dispose.PicDispose;
import cn.camork.core.dispose.UrlDispose;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liferay on 2018/1/10.
 */
public class CoreUtils {

	public static IRecognize getRecognize(MultipartHttpServletRequest request) {

		try {
			String imageUrl = request.getParameterMap().get("imageUrl")[0];

			MultipartFile filePart = request.getFile("imageFile");

			if (imageUrl != null && imageUrl.length() != 0) {
				return new UrlDispose(imageUrl);
			}
			else if (!filePart.isEmpty()) {
				return new PicDispose(filePart);
			}
		}
		catch (Exception e) {
			return null;
		}

		return null;
	}

	public static List<String> getOcrData(InputStream inputStream) throws Exception {
		List<String> arrayList = new ArrayList<>();

		JSONObject jsonObject=AipOcrClient.webImageOCR(inputStream);

		try{
			JSONArray jsonArray= jsonObject.getJSONArray("words_result");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject item = jsonArray.getJSONObject(i);
				arrayList.add(item.getString("words"));
			}
		}
		catch (Exception e){
			arrayList.add(jsonObject.getString("error_msg"));
		}

		return arrayList;
	}


}
