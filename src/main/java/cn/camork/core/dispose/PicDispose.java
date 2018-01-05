package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by camork on 24/12/2017.
 */
public class PicDispose implements IRecognize {

	private List<String> arrayList;

	private MultipartFile filePart;

	public PicDispose(MultipartFile filePart) {
		this.filePart = filePart;
	}

	@Override
	public List<String> getTexts() {

		try {
			arrayList = CoreUtils.getOcrData(filePart.getInputStream());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return arrayList;
	}
}
