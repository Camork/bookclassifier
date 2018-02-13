package cn.camork.action;

import cn.camork.core.CoreUtils;
import cn.camork.core.IRecognize;
import cn.camork.core.dispose.BarcodeDispose;
import cn.camork.model.Order;
import cn.camork.service.OrderService;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Camork on 2017-05-26.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

	@Autowired
	private PipelineFactory springPipelineFactory;

	@Autowired
	private OrderService orderService;

	//@RequiresRoles("admin")
	@RequestMapping("adminCenter")
	public String adminCenter() {
		return "/admin/adminCenter";
	}

	//@RequiresRoles("admin")
	@RequestMapping("orderList")
	public String adminCenter(@RequestParam(required = false) String status, Map<String, List<Order>> m) {
		List<Order> orders = orderService.getMyOrders(null, status);
		m.put("orders", orders);
		return "/admin/orderList";
	}

	@ResponseBody
	@RequestMapping("/bookApi")
	public Map<String, String> bookApi(MultipartHttpServletRequest request) {
		CoreUtils.bookList.clear();

		Map<String, String> m = new HashMap<>();

		IRecognize recognize = CoreUtils.getRecognize(request);

		if (recognize != null) {
			List<String> arrayList = recognize.getTexts();

			for (String text : arrayList) {
				if (text.contains("ISBN") || text.contains("isbn")) {
					arrayList = new ArrayList<>();

					text = Pattern.compile("\\D").matcher(text).replaceAll("").trim();

					int length = text.length();
					if (length == 10 || length == 13) {
						BarcodeDispose barcode = new BarcodeDispose(text);
						barcode.putBook();
					}
					else {
						m.put("msg", "ISBN号长度不正确:" + text);
					}
				}
			}

			String[] urls=new String[arrayList.size()];

			for(int i=0;i<arrayList.size();i++){
				urls[i]="https://api.douban.com/v2/book/search?q="+arrayList.get(i).replace(" ","%20");
			}

			CoreUtils.log.debug(arrayList);

			GeccoEngine.create()
					.classpath("cn.camork.crawler.search")
					.pipelineFactory(springPipelineFactory)
					.start(urls)
					.thread(4)
					.run();

		}
		else {
			m.put("msg", "输入数据为空或错误");
		}

		if(m.isEmpty()){
			m.put("msg", "识别成功,请手动选择");
		}
		CoreUtils.log.debug(CoreUtils.bookList);

		return m;
	}

	@ResponseBody
	@RequestMapping("/updateType")
	public Map<String, String> updateType() {
		Map<String, String> m = new HashMap<>();

		HttpGetRequest start = new HttpGetRequest("https://book.douban.com/tag");

		try {
			GeccoEngine.create()
					.classpath("cn.camork.crawler.booktype")
					.pipelineFactory(springPipelineFactory)
					.start(start)
					.run();
			m.put("state", "ok");

		}
		catch (Exception e) {
			e.printStackTrace();
			m.put("state", "fail");
		}
		return m;
	}

	@ResponseBody
	@RequestMapping("/updateBookByType")
	public Map<String, String> updateBookByType(String type) {
		Map<String, String> m = new HashMap<>();

		if ("".equals(type)) {
			m.put("state", "fail");
		}
		else {
			HttpGetRequest start = new HttpGetRequest("https://book.douban.com/tag/" + type);
			GeccoEngine.create()
					.classpath("cn.camork.crawler")
					.pipelineFactory(springPipelineFactory)
					.thread(3)
					.start(start)
					.run();
			m.put("state", "ok");

		}
		return m;
	}

	@ResponseBody
	@RequestMapping("/updateNewBook")
	public Map<String, String> updateNewBook() {

		Map<String, String> m = new HashMap<>();

		HttpGetRequest start = new HttpGetRequest("https://book.douban.com/");

		try {
			GeccoEngine.create()
					.classpath("cn.camork.crawler")
					.pipelineFactory(springPipelineFactory)
					.thread(10)
					.start(start)
					.run();
			m.put("state", "ok");

		}
		catch (Exception e) {
			e.printStackTrace();
			m.put("state", "fail");
		}



		return m;
	}

	@ResponseBody
	@RequestMapping("/similarSearch")
	public void similarSearch(String name) {
		try {
			GeccoEngine.create()
					.classpath("cn.camork.crawler")
					.pipelineFactory(springPipelineFactory)
					.thread(3)
					.start(new HttpGetRequest("https://api.douban.com/v2/book/search?q=" + name))
					.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
