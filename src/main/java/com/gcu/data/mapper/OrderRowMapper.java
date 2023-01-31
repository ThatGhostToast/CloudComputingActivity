package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import org.springframework.jdbc.core.RowMapper;
import com.gcu.data.entity.OrderEntity;

/*
 * Row mapper is an interface that is used by our jdbc template for mapping rows of a result set
 * on a per row basis. implementation of this interface perform the actual work of mapping each row to a result object
 */

//public class OrderRowMapper implements RowMapper<OrderEntity> {

	/**
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new OrderEntity(rs.getLong("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"),
				rs.getFloat("PRICE"), rs.getInt("QUANTITY"));
	}
	**/


