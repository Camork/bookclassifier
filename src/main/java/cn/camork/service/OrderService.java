package cn.camork.service;


import cn.camork.crawler.Book;
import cn.camork.model.Order;
import cn.camork.model.OrderDetail;

import java.util.List;

public interface OrderService {

	int addOrder(Order order, List<OrderDetail> orderDetails);

	void changeOrderStatus(String orderId, int orderPaid);

	List<Order> getMyOrders(String username, String status);

	List<Book> getOrderById(int orderId);

	int getOrderStatusById(String orderId);

	void delOrder(int orderId);
}
