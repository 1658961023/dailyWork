package a;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
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
				Select(con);
				//Update(con);
				//Insert(con);
				//Delete(con);
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	void Select(Connection con) throws SQLException {
		CallableStatement cs = con.prepareCall("{call S_student(?) }");
		System.out.println("����ѧ��:");
		Scanner input = new Scanner(System.in);
		String sno = input.nextLine();
		cs.setString(1, sno);
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("sna") + "\t" + rs.getString("sde") + "\t" + rs.getString("ssp") + "\t"
					+ rs.getString("sup"));
		}
		input.close();
	}
	void Update(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call U_student(?,?,?,?,?) }");
		System.out.println("����ѧ�ţ�������ϵ��רҵ���������ޣ�");
		Scanner input=new Scanner(System.in);
		String sno=input.nextLine();	cs.setString(1, sno);
		String sna=input.nextLine();	cs.setString(2, sna);
		String sde=input.nextLine();	cs.setString(3, sde);
		String ssp=input.nextLine();	cs.setString(4, ssp);
		String sup=input.nextLine();	cs.setString(5, sup);
		cs.executeUpdate();
		System .out.println("���³ɹ���");
		input.close();
	}
	void Insert(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call I_student(?,?,?,?,?) }");
		System.out.println("����������ϵ��רҵ���������ޣ�ѧ�ţ�");
		Scanner input=new Scanner(System.in);
		String sno=input.nextLine();	cs.setString(1, sno);
		String sna=input.nextLine();	cs.setString(2, sna);
		String sde=input.nextLine();	cs.setString(3, sde);
		String ssp=input.nextLine();	cs.setString(4, ssp);
		String sup=input.nextLine();	cs.setString(5, sup);
		cs.executeUpdate();
		System .out.println("����ɹ���");
		input.close();
	}
	void Delete(Connection con) throws SQLException{
		CallableStatement cs = con.prepareCall("{call D_student(?) }");
		System.out.println("����ѧ��:");
		Scanner input = new Scanner(System.in);
		String sno = input.nextLine();
		cs.setString(1, sno);
		cs.executeUpdate();
		System .out.println("ɾ���ɹ���");
		input.close();
	}
}
