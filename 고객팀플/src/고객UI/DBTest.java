package ��UI;

import java.sql.*;
import java.util.ArrayList;

public class DBTest {
	Connection conn = null;
	Statement stmt = null; // sql ����
	PreparedStatement pstmt = null;
	ResultSet rs = null; // ���ڵ� Ž��
	int index =1;
	ArrayList<AirportList> list = new ArrayList<AirportList>();
	
	private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "1234";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	
	public DBTest() {
		try {
            System.out.println("������");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB �ε� ����");
        } catch (Exception e) {
            System.out.println("DB �ε� ���� " + e.getStackTrace());
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
	public ArrayList<AirportList> getData() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from airportinfo order by ���������� asc");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				index = 1; 	//1���� ����
				String engName = rs.getString(index++);
				String korName = rs.getString(index++);
				String IATACode = rs.getString(index++);
				String ICAOCode = rs.getString(index++);
				String region = rs.getString(index++);
				String engNation = rs.getString(index++);
				String korNation = rs.getString(index++);
				String engCity = rs.getString(index++);

				list.add(new AirportList(engName, korName, IATACode, ICAOCode, region, engNation, korNation, engCity));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( " getData ����" + e.getStackTrace());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		//Ȯ�ο�
//		for(AirportList model : list) {
//			System.out.println(": "+model.getKorName());
//		}
		return list;
	}
	//�Ķ���͸� ������ �ֱ�
	public ArrayList<AirportList> getDatabyNearby() {
		
		return null;
	}

	//insert query
//	public int insert(String sql) {
//		int id = -1;
//
//		// SQL�� ���� ��������
//		Statement statement = null;
//		// SQL�� ������ ����
//		ResultSet rs = null;
//
//		try {
//			statement = conn.createStatement();
//			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//			rs = statement.getGeneratedKeys();
//			if (rs.next()) {
//				id = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			System.out.println("[INSERT ���� ����]\n" + e.getStackTrace());
//		}
//
//		try {
//			if (statement != null) {
//				statement.close();
//			}
//
//			if (rs != null) {
//				rs.close();
//			}
//		} catch (SQLException e) {
//			System.out.println("[INSERT ���� ����]\n" + e.getStackTrace());
//		}
//
//		return id;
//	}

	public void close() {
		try {
			if (conn!= null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("[�ݱ� ����]\n" + e.getStackTrace());
		}
	}
}
