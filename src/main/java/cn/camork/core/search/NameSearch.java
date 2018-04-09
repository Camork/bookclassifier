package cn.camork.core.search;

import cn.camork.core.CoreUtils;
import cn.camork.core.ISearch;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;

/**
 * Created by camork on 2018/4/15.
 */
public class NameSearch implements ISearch {

	@Override
	public void search(PipelineFactory springPipelineFactory) {

		String[] urls = CoreUtils.POSSIBLE_NAMES.stream().map(
				url -> url = "https://api.douban.com/v2/book/search?q=" + url.replace(" ", "%20")
		).toArray(
				String[]::new
		);

		CoreUtils.log.debug(CoreUtils.POSSIBLE_NAMES);

		GeccoEngine.create()
				.classpath("cn.camork.crawler.search")
				.pipelineFactory(springPipelineFactory)
				.start(urls)
				.thread(4)
				.run();
	}

}
