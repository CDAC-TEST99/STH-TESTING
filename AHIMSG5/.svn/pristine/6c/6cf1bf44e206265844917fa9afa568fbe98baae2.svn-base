package hisglobal.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcConnection {

	private static Connection getConnection() {

		Connection conn = null;
		try {
			DataSource source = (DataSource) new InitialContext()
					.lookup(HisUtil.getParameterFromHisPathXML("JNDI_LOOKUP"));
			conn = source.getConnection();
			// use connection
		} catch (SQLException e) {
			// log error
		} catch (NamingException e) {
			// DataSource wasn't found in JNDI
		}

		return conn;
	}

	public static List<Object[]> executeNativeQuery(String nativeQuery, Map<Integer, Object> params) throws Exception {

		if (nativeQuery == null || (nativeQuery != null && nativeQuery.trim().length() == 0))
			throw new Exception("Query value is null or empty");

		List<Object[]> list = null;

		Connection conn = getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(nativeQuery);

			for (Map.Entry<Integer, Object> entry : params.entrySet()) {

				st.setInt(entry.getKey(), Integer.valueOf(String.valueOf(entry.getValue())));

			}

			rs = st.executeQuery();

			int colCount = rs.getMetaData().getColumnCount();

			if (rs != null) {

				list = new ArrayList<Object[]>();

				while (rs.next()) {
					Object[] obj = new Object[colCount];

					for (int i = 1; i <= colCount; i++) {

						obj[i - 1] = rs.getString(i);

					}

					list.add(obj);

				}

			}

			rs.close();
			st.close();
			conn.close();

		} catch (Exception e) {

			throw e;
		} finally {

			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(st != null) {
				st.close();
				st = null;
			}
			
			if(conn != null) {
				conn.close();
				conn = null;
			}
			 

		}

		return list;

	}

	/**
	 * Gets the qry result.
	 * 
	 * @param qry
	 *            the qry
	 * @return the qry result
	 * @throws Exception
	 *             the exception
	 */

	public static List<Object[]> getSQLQryResult(String qry) throws Exception {

		List<Object[]> list = null;

		Connection conn = getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(qry);

			rs = st.executeQuery();

			int colCount = rs.getMetaData().getColumnCount();

			if (rs != null) {

				list = new ArrayList<Object[]>();

				while (rs.next()) {
					Object[] obj = new Object[colCount];

					for (int i = 1; i <= colCount; i++) {

						obj[i - 1] = rs.getString(i);

					}

					list.add(obj);

				}

			}

			rs.close();
			st.close();
			conn.close();

		} catch (Exception e) {

			throw e;
		}finally {

			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(st != null) {
				st.close();
				st = null;
			}
			
			if(conn != null) {
				conn.close();
				conn = null;
			}
			 

		}

		return list;
	}

	
	
	/**
	 * Gets the qry result.
	 * 
	 * @param qry
	 *            the qry
	 * @param values
	 *            the values
	 * @return the qry result
	 * @throws Exception
	 *             the exception
	 */

	public static List<Object[]> getQryResultList(String qry, String[] values) throws Exception {

		List<Object[]> list = null;

		Connection conn = null;

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			st = conn.prepareStatement(qry);

			int id = 1;
			if (values != null)
				for (String value : values) {
					st.setString(id, value);
					id++;
				}

		 
			
			rs = st.executeQuery();

			int colCount = rs.getMetaData().getColumnCount();

			if (rs != null) {

				list = new ArrayList<Object[]>();

				while (rs.next()) {
					Object[] obj = new Object[colCount];

					for (int i = 1; i <= colCount; i++) {

						obj[i - 1] = rs.getString(i);

					}

					list.add(obj);

				}

			}

			
			 

		} catch (Exception e) {

			throw e;
		} finally {

			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(st != null) {
				st.close();
				st = null;
			}
			
			if(conn != null) {
				conn.close();
				conn = null;
			}
			 

		}

		return list;
	}

	public static ResultSet getQryResultWs(String qry, String[] values) throws Exception {

		Connection conn = null;

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			st = conn.prepareStatement(qry);

			int id = 1;
			
			if(values != null)
			for (String value : values) {
				st.setString(id, value);
				id++;
			}

			rs = st.executeQuery();

			st.close();
			conn.close();

		} catch (Exception e) {

			throw e;
		} finally {

			 
			
			if(st != null) {
				st.close();
				st = null;
			}
			
			if(conn != null) {
				conn.close();
				conn = null;
			}
			 

		}

		return rs;
	}

	public static void executeUpdate(String query) throws Exception {

		Connection conn = null;

		Statement st = null;
		
		if(query == null || query.trim().length() == 0)
			throw new Exception("Query cannot be null or Empty");
		
		try {

			conn = getConnection();
			st = conn.createStatement();
			 st.executeUpdate(query);
			  
			st.close();
			conn.close();

		} catch (Exception e) {

			throw e;
		} finally {

			 
			
			if(st != null) {
				st.close();
				st = null;
			}
			
			if(conn != null) {
				conn.close();
				conn = null;
			}
			 

		}

	}

}
