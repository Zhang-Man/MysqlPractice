package edu.imufe.servlet;

import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import edu.imufe.entity.Table;
import edu.imufe.utils.DbUtil;
import edu.imufe.utils.ResultSetUtil;

public class ActivitiesServiceTest {
//	@Autowired
//	private SqlService sqlService;
	public String ReturnMessage;

	public String getReturnMessage() {
		return ReturnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		ReturnMessage = returnMessage;
	}
	
	/**
	 * 修改发布任务信息
	 */
	@Test
	public void testsql() {
		Connection connection = DbUtil.getInstance().getConnection();
		try {
			PreparedStatement pstat = connection.prepareStatement("select Sname as namec,Sage as age from student where Sage >=20");
			ResultSet rs = pstat.executeQuery();
			System.out.println(rs.getRow());
			ResultSetUtil rsu = new ResultSetUtil(rs);

			System.out.println("行数:" + rsu.getRowSize());
			System.out.println("列数:" + rsu.getColumnSize());

			System.out.println("字段名:" + rsu.getTableColumnNameSet());
			System.out.println("字段类型:" + rsu.getColumnTypeSet());

			System.out.println("首行ascii的列表" + rsu.getFirstRowSet());
			System.out.println("首行ascii的和:" + rsu.getFirstRowSum());

			System.out.println("首列ascii的列表:" + rsu.getFirstColumnSet());
			System.out.println("首列ascii的和:" + rsu.getFirstColumnSum());
			System.out.println("每行和的列表:" + rsu.getRowSet());
			System.out.println("表总和:" + rsu.getAllTableSum());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 如果出现错误，那么就不用进行比较，直接返回（打印）错误的原因 如果没有出现错误，那么才进行比较
	 */
	@Test
	public void testentity() {
		// 判断是否是语法错误抛出去的原因
		boolean flag = false;

		Connection connection = DbUtil.getInstance().getConnection();
		Table table = new Table();
		Table table2 = new Table();
		System.out.println("开始");
		// 答案结果
		try {
			PreparedStatement pstat = connection.prepareStatement("select Sname as name,Sage as age from student where Sage >=20");
			ResultSet rs = pstat.executeQuery();
			ResultSetUtil rsu = new ResultSetUtil(rs);
			System.out.println("获取第二个(答案结果)table");
			table2.setRows(rsu.getRowSize());// 获取总行数
			table2.setColumns(rsu.getColumnSize());// 获取总列数
			table2.setAllnum(rsu.getAllTableSum());// 获取总和
			table2.setFrownum(rsu.getFirstRowSum());// 获取首行和
			table2.setFrow(rsu.getFirstRowSet());// 获取首行首列数组
			table2.setFrow(rsu.getFirstColumnSet());
			table2.setErow(rsu.getRowSet());// 获取每行数组
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 用户结果
		System.out.println("用户结果查询开始");
		try {
			PreparedStatement pstat = connection.prepareStatement("select Sname as name,Sage as age from student where Sage <20");
			ResultSet rs = pstat.executeQuery();
			ResultSetUtil rsu = new ResultSetUtil(rs);
			table.setRows(rsu.getRowSize());// 获取总行数
			// 1:查询无结果 错误
			if (table.getRows().equals(0)) {
				System.out.println("no " + "行数:" + table.getRows());
			}
			System.out.println("获取第一个(用户结果)table");
			table.setColumns(rsu.getColumnSize());// 获取总列数
			table.setAllnum(rsu.getAllTableSum());// 获取总和
			table.setFrownum(rsu.getFirstRowSum());// 获取首行和
			table.setFrow(rsu.getFirstRowSet());// 获取首行首列数组
			table.setFrow(rsu.getFirstColumnSet());
			table.setErow(rsu.getRowSet());// 获取每行数组
			flag = true;
		} catch (SQLException e) {
			flag=false;
			ReturnMessage=e.getMessage();
			System.err.println(ReturnMessage);
		}
		if (flag == true) {
			if (table.equals(table2))
				ReturnMessage="Same sql";
			else {
				
			
				ReturnMessage="different sql";
			System.out.println(ReturnMessage);
			}
		}
		
	}
}
