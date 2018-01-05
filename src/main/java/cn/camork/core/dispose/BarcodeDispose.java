package cn.camork.core.dispose;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by camork on 24/12/2017.
 */
public class BarcodeDispose extends PicDispose {

	public BarcodeDispose(MultipartFile filePart) {
		super(filePart);
	}
}
