package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.PhonebookVO;

public class PhonebookDAOImpl implements PhonebookDAO {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@192.168.1.66:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##BITUSER", "1234");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 실패");
		}
		return conn;
	}

	@Override
	public List<PhonebookVO> getlist() {
		List<PhonebookVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, name, hp, tel " + " FROM Phonebook ORDER BY id";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				PhonebookVO vo = new PhonebookVO(id, name, hp, tel);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<PhonebookVO> search(String keyword) {
		List<PhonebookVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel FROM Phonebook "
					+ "WHERE name LIKE ? ORDER BY id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();

			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("Tel");

				PhonebookVO vo = new PhonebookVO(id, name, hp, tel);
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean insert(PhonebookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;

		try {
			conn = getConnection();
			String sql = "INSERT INTO Phonebook " + " VALUES(id.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());

			insertCount = pstmt.executeUpdate();

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
		return 1 == insertCount;
	}

	@Override
	public boolean update(PhonebookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateCount = 0;

		try {
			conn = getConnection();
			String sql = "UPDATE Phonebook SET name =?, hp=?, tel=? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			pstmt.setLong(4, vo.getId());
			updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1 == updateCount;
	}

	@Override
	public boolean delete(Long id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int deleteCount = 0;

		try {
			conn = getConnection();
			String sql = "DELETE FROM Phonebook WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			deleteCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1 == deleteCount;

	}

}