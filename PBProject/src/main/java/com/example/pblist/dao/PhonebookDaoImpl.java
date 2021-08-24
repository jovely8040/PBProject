package com.example.pblist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.pblist.vo.PhonebookVo;

public class PhonebookDaoImpl implements PhonebookDao {
	private Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection 가져오기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // DBURL
					"C##BITUSER", // DB User
					"1234"); // DB Pass
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	@Override
	public List<PhonebookVo> getList() {
		
		List<PhonebookVo> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel " +
						" FROM phonebook ORDER BY id";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				PhonebookVo vo = new PhonebookVo();
				vo.setId(id);
				vo.setName(name);
				vo.setHp(hp);
				vo.setTel(tel);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhonebookVo> search(String keyword) {
		
		List<PhonebookVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel" + 
						" FROM phonebook " +
						" WHERE name LIKE ?" + 
						" ORDER BY id";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 데이터 받기
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				// VO 객체생성
				PhonebookVo vo = new PhonebookVo();
				vo.setId(id);
				vo.setName(name);
				vo.setHp(hp);
				vo.setTel(tel);
				
				// 리스트에 추가
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원정리
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int insert(PhonebookVo vo ) {
		int insertedCount = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            // 실행계획 PK , name , email , password
            String sql = "INSERT INTO phonebook" +
            			"VALUES (id.NEXTVAL, ?, ?, ?)";
 
            // 파라미터 바인딩
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getHp());
            pstmt.setString(3, vo.getTel());
            
            // 쿼리 수행
            insertedCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
	            try {
	                if( conn != null ) {
	                    conn.close();
	                }
	                if( pstmt != null ) {
	                    pstmt.close();
	                }
	            } catch(SQLException e) {
	                e.printStackTrace();
	            }
        }

        return insertedCount;
    }

	@Override
	public int delete(Long id) {
		int deletedCount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM phonebook " + 
						" WHERE id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return deletedCount;
	}
}	