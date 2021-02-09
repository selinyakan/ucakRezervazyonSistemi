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

import ucakrezervasyon.objects.Kullanici;
import ucakrezervasyon.objects.Rezervasyon;
import ucakrezervasyon.objects.Ucus;

/**
 *
 * @author yAkAn
 */
public class RezervasyonDAO {
        private String jdbcURL = "jdbc:mysql://localhost:3306/ucusrezervasyon?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT_REZERVASYON_SQL = "INSERT INTO rezervasyon" + "  (ad, soyad, email, telefon, cinsiyet, nereden, nereye, kg_hakki, rezervasyon_kodu, yolcu_tipi, iptal_durumu, ucus) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_REZERVASYON_BY_ID = "select id, ad, soyad, email, telefon, cinsiyet, nereden, nereye, kg_hakki, rezervasyon_kodu, yolcu_tipi, iptal_durumu,  ucus from rezervasyon where id =?";
	private static final String SELECT_ALL_REZERVASYON = "select * from rezervasyon";
	private static final String DELETE_REZERVASYON_SQL = "delete from rezervasyon where id = ?;";
	private static final String UPDATE_REZERVASYON_SQL = "update rezervasyon set ad =?, soyad =?, email =?, telefon =?, cinsiyet =?,nereden =?, nereye =?, kg_hakki =?, rezervasyon_kodu =?, yolcu_tipi =?, iptal_durumu =?, ucus =? where id = ?;";
	
	public RezervasyonDAO() {
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
            String dbDriver = "com.mysql.jdbc.Driver"; 
            Class.forName(dbDriver);
            return(Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
	public void insert(Rezervasyon rezervasyon) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_REZERVASYON_SQL);
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_REZERVASYON_SQL)) {
			statement.setString(1, rezervasyon.getAd());
			statement.setString(2, rezervasyon.getSoyad());
			statement.setString(3, rezervasyon.getEmail());
			statement.setString(4, rezervasyon.getTelefon());
			statement.setInt(5, rezervasyon.getCinsiyet());
                        statement.setString(6, rezervasyon.getNereden());
                        statement.setString(7, rezervasyon.getNereye());
			statement.setInt(8, rezervasyon.getKgHakki());
			statement.setString(9, rezervasyon.getRezervasyonKodu());
			statement.setInt(10, rezervasyon.getYolcuTipi());
			statement.setBoolean(11, rezervasyon.getIptalDurumu());
			
			statement.setInt(12, rezervasyon.getUcus().getId());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Rezervasyon select(int id) {
		Rezervasyon rezervasyon = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_REZERVASYON_BY_ID);) {
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
				Integer cinsiyet = rs.getInt("cinsiyet");
                                String nereden = rs.getString("nereden");
                                String nereye = rs.getString("nereye");
				Integer kgHakki = rs.getInt("kg_hakki");
				String rezervasyonKodu = rs.getString("rezervasyon_kodu");
				Integer yolcuTipi = rs.getInt("yolcu_tipi");
				Boolean iptalDurumu = rs.getBoolean("iptal_durumu");
				
				Integer ucusId = rs.getInt("ucus");

				
                                Ucus u = new UcusDAO().select(ucusId);
				rezervasyon = new Rezervasyon(id, ad, soyad, email, telefon, cinsiyet, nereden, nereye, kgHakki, rezervasyonKodu, yolcuTipi, iptalDurumu, u);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return rezervasyon;
	}

	public List<Rezervasyon> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Rezervasyon> rezervasyonlar = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_REZERVASYON);) {
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
				Integer cinsiyet = rs.getInt("cinsiyet");
                                String nereden = rs.getString("nereden");
                                String nereye = rs.getString("nereye");
				Integer kgHakki = rs.getInt("kg_hakki");
				String rezervasyonKodu = rs.getString("rezervasyon_kodu");
				Integer yolcuTipi = rs.getInt("yolcu_tipi");
				Boolean iptalDurumu = rs.getBoolean("iptal_durumu");
				Integer ucusId = rs.getInt("ucus");

				
				Ucus u = new UcusDAO().select(ucusId);
				rezervasyonlar.add(new Rezervasyon(id, ad, soyad, email, telefon, cinsiyet, nereden, nereye, kgHakki, rezervasyonKodu, yolcuTipi, iptalDurumu, u));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}catch (Exception e) {}
		return rezervasyonlar;
	}

	public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_REZERVASYON_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}catch (Exception e) {
            rowDeleted = false;}
		return rowDeleted;
	}
        
	public boolean update(Rezervasyon rezervasyon) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_REZERVASYON_SQL);) {
			statement.setString(1, rezervasyon.getAd());
			statement.setString(2, rezervasyon.getSoyad());
			statement.setString(3, rezervasyon.getEmail());
			statement.setString(4, rezervasyon.getTelefon());
			statement.setInt(5, rezervasyon.getCinsiyet());
                        statement.setString(6, rezervasyon.getNereden());
                        statement.setString(7, rezervasyon.getNereye());
			statement.setInt(8, rezervasyon.getKgHakki());
			statement.setString(9, rezervasyon.getRezervasyonKodu());
			statement.setInt(10, rezervasyon.getYolcuTipi());
			statement.setBoolean(11, rezervasyon.getIptalDurumu());
			
			statement.setInt(12, rezervasyon.getUcus().getId());
			statement.setInt(13, rezervasyon.getId());

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
