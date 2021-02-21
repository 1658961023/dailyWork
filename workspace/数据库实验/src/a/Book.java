package a;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
	void body() {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LibraryManage16201210";// 数据库名字更改为你自己的数据库名字！！！！！
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		try {
			Connection con = DriverManager.getConnection(connectDB, "java", "16201210");// 连接数据库对象
			System.out.println("数据库驱动成功");

				//Select(con);
				//Update(con);
				Insert(con);
				//Delete(con);
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	void Select(Connection con) throws SQLException {
		CallableStatement cs = con.prepareCall("{call S_book(?) }");
		System.out.println("输入图书编号:");
		Scanner input = new Scanner(System.in);
		String sno = input.nextLine();
		cs.setString(1, sno);
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("bna") + "\t" + rs.getString("bda") + "\t" + rs.getString("bpu") + "\t"
					+ rs.getString("bpl")+"\t"+rs.getString("bnu"));
		}
		input.close();
	}
	void Update(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call U_book(?,?,?,?,?,?) }");
		System.out.println("输入图书编号，图书名称，出版日期，图书出版社，图书存放位置，图书总数量：");
		Scanner input=new Scanner(System.in);
		String bno=input.nextLine();	cs.setString(1, bno);
		String bna=input.nextLine();	cs.setString(2, bna);
		String bda=input.nextLine();	cs.setString(3, bda);
		String bpu=input.nextLine();	cs.setString(4, bpu);
		String bpl=input.nextLine();	cs.setString(5, bpl);
		String bnu=input.nextLine();	cs.setString(6, bnu);
		cs.executeUpdate();
		System .out.println("更新成功！");
		input.close();
	}
	void Insert(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call I_book(?,?,?,?,?,?) }");
		System.out.println("输入图书编号，图书名称，出版日期，图书出版社，图书存放位置，图书总数量：");
		Scanner input=new Scanner(System.in);
		String bno=input.nextLine();	cs.setString(1, bno);
		String bna=input.nextLine();	cs.setString(2, bna);
		String bda=input.nextLine();	cs.setString(3, bda);
		String bpu=input.nextLine();	cs.setString(4, bpu);
		String bpl=input.nextLine();	cs.setString(5, bpl);
		String bnu=input.nextLine();	cs.setString(6, bnu);
		cs.executeUpdate();
		System .out.println("插入成功！");
		input.close();
	}
	void Delete(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call D_book(?) }");
		System.out.println("输入图书编号:");
		Scanner input = new Scanner(System.in);
		String bno = input.nextLine();
		cs.setString(1, bno);
		cs.executeUpdate();
		System .out.println("删除成功！");
		input.close();
	}
}
