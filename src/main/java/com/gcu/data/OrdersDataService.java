package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {
	Logger logger = LoggerFactory.getLogger(OrdersDataService.class);
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	public OrdersDataService(OrdersRepository ordRepo, DataSource datasource) {
		logger.info("ENTERING: OrdersDataService Constructor");
		this.ordersRepository = ordRepo;
		this.dataSource = datasource;
		//this.jdbcTemplateObject = new JdbcTemplate(datasource);
		logger.info("EXITING: OrdersDataService Constructor");
	}

	public List<OrderEntity> findAll() {
		logger.info("ENTERING: findAll() inside OrdersDataService");
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		/**
		
		OrderEntity order1 = new OrderEntity(1, "00001", "Product 1", 100, 100);
		orders.add(order1);
		
		OrderEntity order2 = new OrderEntity(2, "00002", "Product 2", 100, 100);
		orders.add(order2);
		
		OrderEntity order3 = new OrderEntity(3, "00003", "Product 3", 100, 100);
		orders.add(order3);
		
		OrderEntity order4 = new OrderEntity(4, "00004", "Product 4", 100, 100);
		orders.add(order4);
		
		OrderEntity order5 = new OrderEntity(5, "00005", "Product 5", 100, 100);
		orders.add(order5);
		
		OrderEntity order6 = new OrderEntity(6, "00006", "Product 6", 100, 100);
		orders.add(order6);
		
		OrderEntity order7 = new OrderEntity(7, "00007", "Product 7", 100, 100);
		orders.add(order7);
		
		**/
		
		try {
			logger.info("Querying the database...");
			Iterable<OrderEntity> orderIterable = ordersRepository.findAll();

			orders = new ArrayList<OrderEntity>();
			orderIterable.forEach(orders::add);
			logger.info("Data retrieved from database.");
		} catch (Exception e) {
			logger.error("Something went wrong collecting data from the database. Check findAll() inside OrdersDataService or OdersRepository");
			e.printStackTrace();
		}

		logger.info("EXITING: findAll() inside OrdersDataService");
		return orders;
	}

	public OrderEntity findById(int id) {
		logger.info("ENTERING: findById() inside OrdersDataService");
		logger.info("EXITING: findById() inside OrdersDataService");
		return null;
	}

	public boolean create(OrderEntity order) {
		logger.info("ENTERING: create() inside OrdersDataService");
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY)VALUES(?, ?, ?, ?)";
		try {
			logger.info("Querying database. SQL statement: " + sql);
			jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(),
					order.getQuantity());
		} catch (Exception e) {
			logger.error("SOMETHING WENT WRONG ADDING TO THE DATABASE. Check create() in OrdersDataService");
			e.printStackTrace();
			logger.info("EXITING: create() in OrdersDataService");
			return false;
		}
		logger.info("Data added to the database successfully");
		logger.info("EXITING: create() in OrdersDataService");
		return true;
	}

	public boolean update(OrderEntity t) {
		logger.info("ENTERING: update() in OrdersDataService");
		logger.info("EXITING: update() in OrdersDataService");
		return true;
	}

	public boolean delete(OrderEntity t) {
		logger.info("ENTERING: delete() in OrdersDataService");
		logger.info("EXITING: delete() in OrdersDataService");
		return true;
	}

}
