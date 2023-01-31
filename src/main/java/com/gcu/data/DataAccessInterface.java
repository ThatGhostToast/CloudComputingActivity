package com.gcu.data;

import java.util.List;

public interface DataAccessInterface <T>{
	
	/**
	 * Finds all the data in the database
	 * @return returns the data from the database
	 */
	public List<T> findAll();
	/**
	 * @param id id of the item we're looking for
	 * @return returns the specified item
	 */
	public T findById(int id);
	/**
	 * @param t Item being created in the database
	 * @return returns if it was successful
	 */
	public boolean create(T t);
	/**
	 * @param t Item being updated in the database
	 * @return returns if successful
	 */
	public boolean update(T t);
	/**
	 * @param t Item being deleted from the database
	 * @return returns if it was successful
	 */
	public boolean delete(T t);
}
