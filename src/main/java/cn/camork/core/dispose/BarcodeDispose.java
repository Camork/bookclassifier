package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import cn.camork.core.ISearch;
import cn.camork.core.search.ISBNSearch;

/**
 * Created by camork on 24/12/2017.
 */
public class BarcodeDispose implements IRecognize {

	private String isbnStr;

	public BarcodeDispose(String isbnStr) {
		this.isbnStr = isbnStr;
	}

	@Override
	public ISearch dispose() {

		CoreUtils.POSSIBLE_NAMES.add(isbnStr);

		return new ISBNSearch();
	}
}
