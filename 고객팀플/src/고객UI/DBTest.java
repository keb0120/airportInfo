package 고객UI;

import java.sql.*;
import java.util.ArrayList;

public class DBTest {
	Connection conn = null;
	Statement stmt = null; // sql 실행
	PreparedStatement pstmt = null;
	ResultSet rs = null; // 레코드 탐색
	int index =1;
	ArrayList<AirportList> list = new ArrayList<AirportList>();
	
	private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "1234";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	
	public DBTest() {
		try {
            System.out.println("생성자");
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
	public ArrayList<AirportList> getData() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from airportinfo order by 영문국가명 asc");
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
				if(conn != null) conn.close();
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
	//파라미터를 쿼리에 넣기
	public ArrayList<AirportList> getDatabyNearby() {
		
		return null;
	}

	//insert query
//	public int insert(String sql) {
//		int id = -1;
//
//		// SQL을 적는 문서파일
//		Statement statement = null;
//		// SQL의 실행결과 보고서
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
//			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
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
//			System.out.println("[INSERT 종료 오류]\n" + e.getStackTrace());
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
			System.out.println("[닫기 오류]\n" + e.getStackTrace());
		}
	}
}
