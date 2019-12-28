package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DbManager;
import pojo.LoginUser;

public class LoginUserDbUtil {
	
	private static DbManager dbManager;
	
	public LoginUserDbUtil(DbManager thedbManager) {
		dbManager = thedbManager;
	}

	public LoginUser authenticateUser(String username, String encryptedPass) {
		
		LoginUser user = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			
			String sql = "select * from users where BINARY userName=? and BINARY passWord=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, encryptedPass);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new LoginUser(rs.getInt("userId"),rs.getString("userName"),rs.getString("passWord"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getClass().getName()+": "+e.getMessage());
		}
		finally {
			close(conn,stmt,rs);
		}
		
		return user;
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
}
