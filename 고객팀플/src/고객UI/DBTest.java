package ��UI;

import java.sql.*;
import java.util.ArrayList;

public class DBTest {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // ���ڵ� Ž��
	int index =1;
	ArrayList<AirportList> list = new ArrayList<AirportList>();
	
	private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "1234";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/airportdb?serverTimezone=UTC";
	
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
		sql.append("select * from airportInfo order by ���������� asc");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			pstmt.clearParameters();
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
//				pstmt.clearParameters();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
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
	public String[] getData(String target) {
		String[] data = new String[2000];
		int index=0;
		StringBuffer sql = new StringBuffer();
		sql.append("select DISTINCT " + target +" from airportInfo");
		try {
			//connn close �ؼ� �޼��� 2�� �̻� ���� ���� �־�����
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			pstmt.clearParameters();
			while(rs.next()) { 
				data[index] = rs.getString(1);
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( " getdata" + target+ "����" + e.getStackTrace());
		}finally {
			try {
//				pstmt.clearParameters();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return data;
	}

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
