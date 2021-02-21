package a;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
	void body() {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LibraryManage16201210";// ���ݿ����ָ���Ϊ���Լ������ݿ����֣���������
		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		try {
			Connection con = DriverManager.getConnection(connectDB, "java", "16201210");// �������ݿ����
			System.out.println("���ݿ������ɹ�");

				//Select(con);
				//Update(con);
				Insert(con);
				//Delete(con);
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	void Select(Connection con) throws SQLException {
		CallableStatement cs = con.prepareCall("{call S_book(?) }");
		System.out.println("����ͼ����:");
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
		System.out.println("����ͼ���ţ�ͼ�����ƣ��������ڣ�ͼ������磬ͼ����λ�ã�ͼ����������");
		Scanner input=new Scanner(System.in);
		String bno=input.nextLine();	cs.setString(1, bno);
		String bna=input.nextLine();	cs.setString(2, bna);
		String bda=input.nextLine();	cs.setString(3, bda);
		String bpu=input.nextLine();	cs.setString(4, bpu);
		String bpl=input.nextLine();	cs.setString(5, bpl);
		String bnu=input.nextLine();	cs.setString(6, bnu);
		cs.executeUpdate();
		System .out.println("���³ɹ���");
		input.close();
	}
	void Insert(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call I_book(?,?,?,?,?,?) }");
		System.out.println("����ͼ���ţ�ͼ�����ƣ��������ڣ�ͼ������磬ͼ����λ�ã�ͼ����������");
		Scanner input=new Scanner(System.in);
		String bno=input.nextLine();	cs.setString(1, bno);
		String bna=input.nextLine();	cs.setString(2, bna);
		String bda=input.nextLine();	cs.setString(3, bda);
		String bpu=input.nextLine();	cs.setString(4, bpu);
		String bpl=input.nextLine();	cs.setString(5, bpl);
		String bnu=input.nextLine();	cs.setString(6, bnu);
		cs.executeUpdate();
		System .out.println("����ɹ���");
		input.close();
	}
	void Delete(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call D_book(?) }");
		System.out.println("����ͼ����:");
		Scanner input = new Scanner(System.in);
		String bno = input.nextLine();
		cs.setString(1, bno);
		cs.executeUpdate();
		System .out.println("ɾ���ɹ���");
		input.close();
	}
}
