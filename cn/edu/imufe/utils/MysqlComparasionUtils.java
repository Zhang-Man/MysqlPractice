package edu.imufe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.imufe.entity.Table;

public class MysqlComparasionUtils {
	public static String MysqlComparasion(String s1, String s2) {
		boolean flag = false;
		String ReturnMessage = "different sql";
		Connection connection = DbUtil.getInstance().getConnection();
		Table table = new Table();
		Table table2 = new Table();
		// 比较开始
		// 答案结果
		// s1="select Sname as name,Sage as age from student where Sage >=20";
		try {
			PreparedStatement pstat = connection.prepareStatement(s1);
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
//				s2="select Sname as name,Sage as age from student where Sage <20"; 
		System.out.println("用户结果查询开始");
		try {
			PreparedStatement pstat = connection.prepareStatement(s2);
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
			flag = false;
			ReturnMessage = e.getMessage();
			System.err.println(ReturnMessage);
		}
		if (flag == true) {
			if (table.equals(table2))
				ReturnMessage = "Same sql";
			else {

				ReturnMessage = "different sql";
				System.out.println(ReturnMessage);
			}
		}
		return ReturnMessage;
	}
	public static void main(String[] args) {
		String s1="select Sname as name,Sage as age from student where Sage >=20";
		String s2="select Sname as name,Sage as age from student where Sage >=20";
		System.out.println(MysqlComparasion(s1,s2));
	}
}
