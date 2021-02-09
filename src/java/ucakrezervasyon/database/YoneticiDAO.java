/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ucakrezervasyon.objects.Yonetici;

/**
 *
 * @author yAkAn
 */
public class YoneticiDAO {
        private String jdbcURL = "jdbc:mysql://localhost:3306/ucusrezervasyon?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT_YONETICI_SQL = "INSERT INTO yonetici" + "  (ad, soyad, email, telefon, cinsiyet, sifre) VALUES (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_YONETICI_BY_ID = "select id, ad, soyad, email, telefon, cinsiyet, sifre from yonetici where id =?";
	private static final String SELECT_ALL_YONETICI = "select * from yonetici";
	private static final String DELETE_YONETICI_SQL = "delete from yonetici where id = ?;";
	private static final String UPDATE_YONETICI_SQL = "update yonetici set ad = ?, soyad = ?, email = ?, telefon = ?, cinsiyet =?, sifre =? where id = ?;";
	private static final String LOGIN_YONETICI_QUERY = "select * from yonetici where email =? and sifre =?";
	
	public YoneticiDAO() {
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
            String dbDriver = "com.mysql.jdbc.Driver"; 
            Class.forName(dbDriver);
            Class.forName ( "com.mysql.jdbc.Driver" );
            return(Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }

	
	
	public Yonetici authtenticate(String e, String s) throws SQLException {
		Yonetici yonetici = null;
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_YONETICI_QUERY)) {
			preparedStatement.setString(1, e);
			preparedStatement.setString(2, s);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Integer id = Integer.valueOf(rs.getString("id"));
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));
                                String sifre =rs.getString("sifre");

				yonetici = new Yonetici(id, ad, soyad, email, telefon, cinsiyet, sifre);
			}
		 return yonetici;
		} catch (SQLException ex) {
			printSQLException(ex);   
		}catch (Exception ex) {}
                return yonetici;
	}
	public void insert(Yonetici yonetici) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_YONETICI_SQL);
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_YONETICI_SQL)) {
			statement.setString(1, yonetici.getAd());
			statement.setString(2, yonetici.getSoyad());
			statement.setString(3, yonetici.getEmail());
			statement.setString(4, yonetici.getTelefon());
			statement.setInt(5, yonetici.getCinsiyet());
                        statement.setString(6, yonetici.getSifre());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Yonetici select(int id) {
		Yonetici yonetici = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_YONETICI_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));
                                String sifre = rs.getString("sifre");

				yonetici = new Yonetici(id, ad, soyad, email, telefon, cinsiyet, sifre);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return yonetici;
	}

	public List<Yonetici> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Yonetici> yoneticiler = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_YONETICI);) {
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));
                                String sifre = rs.getString("sifre");

				yoneticiler.add(new Yonetici(id, ad, soyad, email, telefon, cinsiyet, sifre));
			}
		} catch (SQLException e) {
		printSQLException(e);
		}catch (Exception e) {}
		return yoneticiler;
	}
        public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_YONETICI_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
            }catch (Exception e) {
            rowDeleted = false;}
		return rowDeleted;
	}

	public boolean update(Yonetici yonetici) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_YONETICI_SQL);) {
			statement.setString(1, yonetici.getAd());
			statement.setString(2, yonetici.getSoyad());
                        statement.setString(3, yonetici.getEmail());
			statement.setString(4, yonetici.getTelefon());
			statement.setInt(5, yonetici.getCinsiyet());
                        statement.setString(6, yonetici.getSifre());
			statement.setInt(7, yonetici.getId());
                        rowUpdated = statement.executeUpdate() > 0;
                        
		}catch (Exception e) {
            rowUpdated = false;}
		return rowUpdated;
	}
       /* public boolean update(Sirket sirket) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_SIRKET_SQL);) {
			statement.setString(1, sirket.getAd());
			statement.setInt(2, sirket.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}catch (Exception e) {
            rowUpdated = false;}
		return rowUpdated;
	} */
        private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
