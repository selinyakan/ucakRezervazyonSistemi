/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ucakrezervasyon.objects.Sirket;
import ucakrezervasyon.objects.Ucus;

/**
 *
 * @author yAkAn
 */
public class UcusDAO {
        private String jdbcURL = "jdbc:mysql://localhost:3306/ucusrezervasyon?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT_UCUS_SQL = "INSERT INTO ucus" + "  (ucret, sirket, ucus_kodu, ucus_tarihi, varis_tarihi, ucus_suresi, ucus_saati) VALUES (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_UCUS_BY_ID = "select id, ucret, sirket, ucus_kodu, ucus_tarihi, varis_tarihi, ucus_suresi, ucus_saati from ucus where id =?";
	private static final String SELECT_ALL_UCUS = "select * from ucus";
	private static final String DELETE_UCUS_SQL = "delete from ucus where id = ?;";
	private static final String UPDATE_UCUS_SQL = "update ucus set ucret =?, sirket =?, ucus_kodu =?, ucus_tarihi =?, varis_tarihi =?, ucus_suresi =?, ucus_saati =? where id = ?;";
	
	public UcusDAO() {
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
            String dbDriver = "com.mysql.jdbc.Driver"; 
            Class.forName(dbDriver);
            Class.forName ( "com.mysql.jdbc.Driver" );
            return(Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
	public void insert(Ucus ucus) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_UCUS_SQL);
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_UCUS_SQL)) {
			statement.setInt(1, ucus.getUcret());
			statement.setInt(2, ucus.getSirket().getId());
			statement.setString(3, ucus.getUcusKodu());
			statement.setDate(4, ucus.getUcusTarihi());
			statement.setDate(5, ucus.getVarisTarihi());
			statement.setInt(6, ucus.getUcusSuresi());
			statement.setFloat(7, ucus.getUcusSaati());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}


	public Ucus select(int id) {
		Ucus ucus = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_UCUS_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer ucret = rs.getInt("ucret");
				Integer sirket = rs.getInt("sirket");
				String ucusKodu = rs.getString("ucus_kodu");
				Date ucusTarihi = rs.getDate("ucus_tarihi");
				Date varisTarihi = rs.getDate("varis_tarihi");
				Integer ucusSuresi = rs.getInt("ucus_suresi");
				Float ucusSaati = rs.getFloat("ucus_saati");

				Sirket s = new SirketDAO().select(sirket);

				ucus = new Ucus(id, ucret, s, ucusKodu, ucusTarihi, varisTarihi, ucusSuresi,ucusSaati);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return ucus;
	}
	public List<Ucus> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Ucus> ucuslar = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_UCUS);) {
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				Integer ucret = rs.getInt("ucret");
				Integer sirket = rs.getInt("sirket");
				String ucusKodu = rs.getString("ucus_kodu");
				Date ucusTarihi = rs.getDate("ucus_tarihi");
				Date varisTarihi = rs.getDate("varis_tarihi");
				Integer ucusSuresi = rs.getInt("ucus_suresi");
				Float ucusSaati = rs.getFloat("ucus_saati");

				Sirket s = new SirketDAO().select(sirket);
				ucuslar.add(new Ucus(id, ucret, s, ucusKodu, ucusTarihi, varisTarihi, ucusSuresi,ucusSaati));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return ucuslar;
	}
        public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_UCUS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}catch (Exception e) {
            rowDeleted = false;}
		return rowDeleted;
	}
	public boolean update(Ucus ucus) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_UCUS_SQL);) {
			statement.setInt(1, ucus.getUcret());
			statement.setInt(2, ucus.getSirket().getId());
			statement.setString(3, ucus.getUcusKodu());
			statement.setDate(4, ucus.getUcusTarihi());
			statement.setDate(5, ucus.getVarisTarihi());
			statement.setInt(6, ucus.getUcusSuresi());
			statement.setFloat(7, ucus.getUcusSaati());
			statement.setInt(8, ucus.getId());

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
