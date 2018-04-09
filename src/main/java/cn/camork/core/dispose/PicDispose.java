package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import cn.camork.core.ISearch;
import cn.camork.core.search.NameSearch;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by camork on 24/12/2017.
 */
public class PicDispose implements IRecognize {

	private MultipartFile filePart;

	public PicDispose(MultipartFile filePart) {
		this.filePart = filePart;
	}

	@Override
	public ISearch dispose() {
		try {
			Set<String> arraySet=CoreUtils.getOcrData(filePart.getInputStream(),null);

			String ISBNWord = arraySet.stream()
					.map(
							word -> Pattern.compile("\\D").matcher(word).replaceAll("").trim()
					).filter(
							word -> word.length() == 10 || word.length() == 13
					).findFirst(

					).orElse(
							null
					);

			if (ISBNWord != null) {
				BarcodeDispose barcode = new BarcodeDispose(ISBNWord);

				return barcode.dispose();
			}else {
				CoreUtils.POSSIBLE_NAMES.addAll(arraySet);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return new NameSearch();
	}

}
