package cn.camork.core;

import cn.camork.action.AipOcrClient;
import cn.camork.core.dispose.BarcodeDispose;
import cn.camork.core.dispose.NameDispose;
import cn.camork.core.dispose.PicDispose;
import cn.camork.core.dispose.UrlDispose;
import cn.camork.model.BookBean;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liferay on 2018/1/10.
 */
public class CoreUtils {

	public static Set<BookBean> BOOK_LIST = new LinkedHashSet<>();
	public static Set<String> POSSIBLE_NAMES = new HashSet<>();

	public static final Logger log = Logger.getLogger("mylogger");

	public static IRecognize getRecognize(MultipartHttpServletRequest request) {

		try {
			Map<String, String[]> parameterMap = request.getParameterMap();

			int index = Integer.parseInt(parameterMap.get("index")[0]);

			switch (index) {
				case 1:
					return new UrlDispose(parameterMap.get("imageUrl")[0]);
				case 2:
					MultipartFile filePart = request.getFile("imageFile");

					return new PicDispose(filePart);
				case 3:
					return new NameDispose(parameterMap.get("bookName")[0]);
				case 4:
					return new BarcodeDispose(parameterMap.get("bookISBN")[0]);
			}
		}
		catch (Exception e) {
			return null;
		}

		return null;
	}

	public static Set<String> getOcrData(InputStream inputStream, String url) throws Exception {
		Set<String> hashSet = new HashSet<>();

		JSONObject jsonObject;

		if (inputStream != null) {
			jsonObject = AipOcrClient.webImageOCR(inputStream);
		}
		else {
			jsonObject = AipOcrClient.webImageOCR(url);
		}

		try {
			JSONArray jsonArray = jsonObject.getJSONArray("words_result");

			CoreUtils.log.debug(jsonArray);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject item = jsonArray.getJSONObject(i);
				hashSet.add(item.getString("words"));
			}
		}
		catch (Exception e) {
			hashSet.add(jsonObject.getString("error_msg"));
		}

		return hashSet;
	}

	public static Object[] getDateAndPrice(String[] data) {
		Object[] newData = new Object[2];
		String tempDate = data[0];
		String tempPrice = data[1];
		try {
			SimpleDateFormat format = new SimpleDateFormat();
			if (tempDate.length() == 4) {
				format = new SimpleDateFormat("yyyy");
			}
			else {
				String[] strs = tempDate.split("-");
				if (strs.length == 2) {
					format = new SimpleDateFormat("yyyy-MM");
				}
				else if (strs.length == 3) {
					format = new SimpleDateFormat("yyyy-MM-dd");
				}
			}
			newData[0] = format.parse(tempDate);
		}
		catch (ParseException e) {
			newData[0] = new Date();
		}

		if (tempPrice.equals("")) {
			newData[1] = 50.0f;
		}
		else {
			newData[1] = Float.parseFloat(tempPrice.replaceAll("[^.\\d]", ""));
		}

		return newData;
	}

}
