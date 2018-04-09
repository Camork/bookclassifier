package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import cn.camork.core.ISearch;
import cn.camork.core.search.NameSearch;

import java.util.Set;

/**
 * Created by camork on 24/12/2017.
 */
public class UrlDispose implements IRecognize {

	private String urlStr;

	public UrlDispose(String urlStr) {
		this.urlStr = urlStr;
	}

	@Override
	public ISearch dispose() {
		try {
			Set<String> arraySet = CoreUtils.getOcrData(null, urlStr);

			CoreUtils.POSSIBLE_NAMES.addAll(arraySet);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return new NameSearch();
	}
}
