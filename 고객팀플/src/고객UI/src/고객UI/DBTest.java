package 고객UI;

import java.sql.*;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class DBTest {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // 레코드 탐색
	int index =1;
	
	private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "1234";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/airportdb?serverTimezone=UTC";
	
	public DBTest() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB 로딩 성공");
        } catch (Exception e) {
            System.out.println("DB 로딩 실패 " + e.getStackTrace());
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
	//파라미터에 country airport continent 넣기
	public ArrayList<AirportList> getData() {
		ArrayList<AirportList> list = new ArrayList<AirportList>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from airportInfo order by 영문국가명 asc");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				index = 1; 	//1부터 시작
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
			System.out.println( " getData 오류" + e.getStackTrace());
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
		//확인용
//		for(AirportList model : list) {
//			System.out.println(": "+model.getKorName());
//		}
		return list;
	}
	public ArrayList<AirportList> getDataByCountry(String country , boolean isInternational) {
		ArrayList<AirportList> list = new ArrayList<AirportList>();
		StringBuffer sql = new StringBuffer();
		if( isInternational == true) {			
			sql.append("select * from airportInfo where 한글국가명 = \'"+ country + "\' AND 한글공항명 LIKE '%국제%' order by 한글공항명 asc");
		}else {
			sql.append("select * from airportInfo where 한글국가명 = \'"+ country + "\' order by 한글공항명 asc");
		}
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				index = 1; 	//1부터 시작
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
			System.out.println( " getData 오류" + e.getStackTrace());
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
		//확인용
//		for(AirportList model : list) {
//			System.out.println(": "+model.getKorName());
//		}
		return list;
	}
	public ArrayList<AirportList> getDataByNearby(String code) {
		ArrayList<AirportList> list = new ArrayList<AirportList>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from airportInfo where 공항코드2 LIKE \'"+ code.charAt(0) + "%%\' order by 한글국가명 asc");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				index = 1; 	//1부터 시작
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
			System.out.println( " getData 오류" + e.getStackTrace());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return list;
	}
	public String[] getData(String target) {
		String[] data = new String[500];
		int index=0;
		StringBuffer sql = new StringBuffer();
		sql.append("select DISTINCT " + target +" from airportInfo order by "+target + " asc");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				data[index] = rs.getString(1);
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( " getdata" + target+ "오류" + e.getStackTrace());
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
			System.out.println("[닫기 오류]\n" + e.getStackTrace());
		}
	}
}
