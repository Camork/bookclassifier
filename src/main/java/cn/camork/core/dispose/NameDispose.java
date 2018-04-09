package cn.camork.core.dispose;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import cn.camork.core.ISearch;
import cn.camork.core.search.NameSearch;

/**
 * Created by camork on 2018/4/14.
 */
public class NameDispose implements IRecognize {

	private String name;

	public NameDispose(String name) {
		this.name = name;
	}

	@Override
	public ISearch dispose() {
		CoreUtils.POSSIBLE_NAMES.add(name);

		return new NameSearch();
	}
}
