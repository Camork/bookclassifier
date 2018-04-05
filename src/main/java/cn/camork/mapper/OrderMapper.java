package cn.camork.mapper;


import cn.camork.crawler.Book;
import cn.camork.model.Order;
import cn.camork.model.OrderDetail;

import java.util.List;

public interface OrderMapper {

	void saveOrder(Order order);

	void saveOrderDetail(OrderDetail od);

	int getOrderId(String orderCode);

	void changeOrderStatus(String orderId, int status);

	List<Order> getMyOrders(String username, String status);

	List<Book> getOrderById(int orderId);

	int getOrderStatusById(int parseInt);

	void delOrder(int orderId);

}
