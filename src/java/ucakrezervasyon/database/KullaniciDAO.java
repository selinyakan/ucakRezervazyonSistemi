
package ucakrezervasyon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ucakrezervasyon.objects.Kullanici;


public class KullaniciDAO {

    
        private String jdbcURL = "jdbc:mysql://localhost:3306/ucusrezervasyon?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT_KULLANICI_SQL = "INSERT INTO kullanici" + "  (ad, soyad, sifre, email, telefon, cinsiyet) VALUES (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_KULLANICI_BY_ID = "select id, ad, soyad, sifre, email, telefon, cinsiyet from kullanici where id =?";
	private static final String SELECT_ALL_KULLANICI = "select * from kullanici";
	private static final String DELETE_KULLANICI_SQL = "delete from kullanici where id = ?;";
	private static final String UPDATE_KULLANICI_SQL = "update kullanici set ad = ?, soyad = ?, sifre = ?, email = ?, telefon = ?, cinsiyet = ? where id = ?;";
	private static final String LOGIN_KULLANICI_QUERY = "select * from kullanici where email =? and sifre =?";
	
	public KullaniciDAO() {
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
            String dbDriver = "com.mysql.jdbc.Driver"; 
            Class.forName(dbDriver);
            Class.forName ( "com.mysql.jdbc.Driver" );
            return(Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }

	public void insert(Kullanici kullanici) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_KULLANICI_SQL);
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_KULLANICI_SQL)) {
			statement.setString(1, kullanici.getAd());
			statement.setString(2, kullanici.getSoyad());
                        statement.setString(3, kullanici.getTelefon());
                        statement.setString(4, kullanici.getEmail());
			statement.setString(5, kullanici.getSifre());
			statement.setInt(6, kullanici.getCinsiyet());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Kullanici authtenticate(String e, String s) throws SQLException {
		Kullanici kullanici = null;
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_KULLANICI_QUERY)) {
			preparedStatement.setString(1, e);
			preparedStatement.setString(2, s);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Integer id = Integer.valueOf(rs.getString("id"));
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String sifre = rs.getString("sifre");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));

				kullanici = new Kullanici(id, ad, soyad, sifre, email, telefon, cinsiyet);
			}
                    return kullanici;
		} catch (SQLException ex) {
			printSQLException(ex);   
		}catch (Exception ex) {}
                return kullanici;
	}
       
	
   
	public Kullanici select(int id) {
		Kullanici kullanici = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_KULLANICI_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String sifre = rs.getString("sifre");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));

				kullanici = new Kullanici(id, ad, soyad, sifre, email, telefon, cinsiyet);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return kullanici;
	}

	public List<Kullanici> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Kullanici> kullanicilar = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_KULLANICI);) {
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String sifre = rs.getString("sifre");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");
				Integer cinsiyet = Integer.valueOf(rs.getString("cinsiyet"));

				kullanicilar.add(new Kullanici(id, ad, soyad, sifre, email, telefon, cinsiyet));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return kullanicilar;
	}

	public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_KULLANICI_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}catch (Exception e) {
            rowDeleted = false;}
		return rowDeleted;
	}
	public boolean update(Kullanici kullanici) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_KULLANICI_SQL);) {
			statement.setString(1, kullanici.getAd());
			statement.setString(2, kullanici.getSoyad());
			statement.setString(3, kullanici.getSifre());
			statement.setString(4, kullanici.getEmail());
			statement.setString(5, kullanici.getTelefon());
			statement.setInt(6, kullanici.getCinsiyet());
			statement.setInt(7, kullanici.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}catch (Exception e) {
            rowUpdated = false;}
		return rowUpdated;
	}
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
