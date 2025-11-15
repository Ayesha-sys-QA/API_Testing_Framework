package com.ayesha.db;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.test.utils.DBUtils;

public class test1 extends DBUtils {
	/*
	 * Use Backend6 project to merge orderDate from orders with paymentDate from
	 * payments. Make sure to include in the merged data column all dates, including
	 * duplicates. In your query, create an additional cloumn that distinguishes
	 * orderDate and paymentDate. Display all query results on the console.
	 */
	@Test
	public void mergeData() {
	String query = "SELECT orderDate, 'OD' from orders UNION ALL select paymentDate, 'ptD' from payments;";
	List<Map<String, String>> result = storeDataFromDb2(query);
	System.out.println(result);

}
}
