/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.jspservlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level; 
import java.util.logging.Logger;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucakrezervasyon.database.KullaniciDAO;
import ucakrezervasyon.database.RezervasyonDAO;
import ucakrezervasyon.database.SirketDAO;
import ucakrezervasyon.database.UcusDAO;
import ucakrezervasyon.database.YoneticiDAO;
import ucakrezervasyon.objects.Kullanici;
import ucakrezervasyon.objects.Rezervasyon;
import ucakrezervasyon.objects.Sirket;
import ucakrezervasyon.objects.Ucus;
import ucakrezervasyon.objects.Yonetici;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final String YONETICI = "YONETICI_HESAP";
	private static final String KULLANICI = "KULLANICI_HESAP";
	private static final long serialVersionUID = 1L;
	
	public void init() {
	}
	

	protected Kullanici getKullanici(HttpServletRequest request) {
		Kullanici kullanici = (Kullanici)request.getSession().getAttribute(KULLANICI);
		return kullanici;
	}
	
	protected Yonetici getYonetici(HttpServletRequest request) {
		Yonetici yonetici = (Yonetici)request.getSession().getAttribute(YONETICI);
		return yonetici;
	}
	
	
	protected boolean girisYapilanHesapVarmi(HttpServletRequest request) {
		Kullanici kullanici = getKullanici(request);
		Yonetici yonetici = getYonetici(request);
		if(kullanici!= null || yonetici != null) {
			if(kullanici!= null)
				request.setAttribute(KULLANICI, kullanici);

			if(yonetici!= null)
				request.setAttribute(YONETICI, yonetici);
			return true;
		}
		else {
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			if(girisYapilanHesapVarmi(request) == false) {
                            System.out.println(action);
				switch (action) {
					case "/kullaniciGiris":
						kullaniciGiris(request, response);
						break;
                                        case "/uyeOl":
						showUyeOl(request, response);
						break;
					case "/insertUyeOl":
                                                insertUyeOl(request, response);
						break;
					case "/yoneticiGiris":
						yoneticiGiris(request, response);
						break;
                                        
					default:
						girisSayfasiniGoster(request, response);
						break;
				}
			}
			else {
				request.setAttribute(KULLANICI, getKullanici(request));
				request.setAttribute(YONETICI, getYonetici(request));
				switch (action) {
					case "/cikisYap":
						cikisYap(request, response);
						break;
					case "/yoneticiProfil":
						yoneticiProfil(request, response);
						break;
					case "/kullaniciProfil":
						kullaniciProfil(request, response);
						break;
                                        case "/yeniYonetici":
						showNewYoneticiForm(request, response);
						break;
                                        case "/yoneticiEkle":
						insertYonetici(request, response);
						break;        
                                        case "/yoneticiDuzenle":
						showEditYoneticiForm(request, response);
						break;
					case "/yoneticiGuncelle":
						updateYonetici(request, response);
						break;
                                        case "/yoneticiListele":
						listYonetici(request, response);
						break;
                                        case "/yeniKullanici":
						showNewKullaniciForm(request, response);
						break;
                                        case "/kullaniciDuzenle":
						showEditKullaniciForm(request, response);
						break;
					case "/kullaniciGuncelle":
						updateKullanici(request, response);
						break;
					case "/kullaniciListele":
						listKullanici(request, response);
						break;
					case "/yeniSirket":
						showNewSirketForm(request, response);
						break;
					case "/sirketEkle":
						insertSirket(request, response);
						break;
					case "/sirketSil":
						deleteSirket(request, response);
						break;
					case "/sirketDuzenle":
						showEditSirketForm(request, response);
						break;
					case "/sirketGuncelle":
						updateSirket(request, response);
						break;
					case "/sirketListele":
						listSirket(request, response);
						break;
					case "/yeniUcus":
						showNewUcusForm(request, response);
						break;
					case "/ucusEkle":
						insertUcus(request, response);
						break;
					case "/ucusSil":
						deleteUcus(request, response);
						break;
					case "/ucusDuzenle":
						showEditUcusForm(request, response);
						break;
					case "/ucusGuncelle":
						updateUcus(request, response);
						break;
					case "/ucusListele":
						listUcus(request, response);
						break;
					case "/yeniRezervasyon":
						showNewRezervasyonForm(request, response);
						break;
					case "/rezervasyonEkle":
						insertRezervasyon(request, response);
						break;
					case "/rezervasyonSil":
						deleteRezervasyon(request, response);
						break;
					case "/rezervasyonDuzenle":
						showEditRezervasyonForm(request, response);
						break;
					case "/rezervasyonGuncelle":
						updateRezervasyon(request, response);
						break;
					case "/rezervasyonListele":
						listRezervasyon(request, response);
						break;
					default:
						if(getYonetici(request) != null)
							yoneticiProfil(request, response);
						else
							kullaniciProfil(request, response);
						break;
				}
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	private void girisSayfasiniGoster(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
		dispatcher.forward(request, response);
	}


	private void kullaniciGiris(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String email = request.getParameter("email");
		String sifre = request.getParameter("sifre");
		Kullanici kullanici = new KullaniciDAO().authtenticate(email, sifre);
		if(kullanici == null) {
			request.setAttribute("error", "Kullanıcı adınız veya parolanız yanlış! Lütfen tekrar deneyiniz.");
			girisSayfasiniGoster(request, response);
		}
		else {
			request.getSession().setAttribute(KULLANICI, kullanici);
			request.removeAttribute("error");
                        response.sendRedirect("kullaniciProfil");
		}
	}

	private void yoneticiGiris(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String email = request.getParameter("email");
		String sifre = request.getParameter("sifre");
		Yonetici yonetici = new YoneticiDAO().authtenticate(email, sifre);
		if(yonetici == null) {
			request.setAttribute("error", "Kullanıcı adınız veya parolanız yanlış! Lütfen tekrar deneyiniz.");
			girisSayfasiniGoster(request, response);
		}
		else {
			request.getSession().setAttribute(YONETICI, yonetici);
                        request.removeAttribute("error");
			response.sendRedirect("yoneticiProfil");
		}
	}
        
        private void yoneticiProfil(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Yonetici yoneti = getYonetici(request);
		request.setAttribute("user", yoneti);
		RequestDispatcher dispatcher = request.getRequestDispatcher("yonetici-profil-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void kullaniciProfil(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Kullanici kullanici = getKullanici(request);
		request.setAttribute("user", kullanici);
		RequestDispatcher dispatcher = request.getRequestDispatcher("kullanici-profil-form.jsp");
		dispatcher.forward(request, response);
	}
        
        private void insertYonetici(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
                Integer cinsiyet = Integer.valueOf(request.getParameter("cinsiyet"));
                String sifre = request.getParameter("sifre");
	
		Yonetici newUser = new Yonetici(ad, soyad, email, telefon, cinsiyet, sifre);
		
		new YoneticiDAO().insert(newUser);;
		response.sendRedirect("yoneticiListele");
	}
        private void showNewYoneticiForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("yonetici-profil-duzenle.jsp");
		dispatcher.forward(request, response);
	}

        private void showEditYoneticiForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Yonetici existingUser = new YoneticiDAO().select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("yonetici-profil-duzenle.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
        
        }
	
        
	private void updateYonetici(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
                Integer cinsiyet = Integer.valueOf(request.getParameter("cinsiyet"));
                String sifre = request.getParameter("sifre");

		Yonetici newUser = new Yonetici(id,ad, soyad, email, telefon,cinsiyet,sifre);
		
		new YoneticiDAO().update(newUser);
		response.sendRedirect("yoneticiListele");
	}
        
         private void listYonetici(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Yonetici> listYonetici = new YoneticiDAO().selectAll();
		request.setAttribute("listYonetici", listYonetici);
		RequestDispatcher dispatcher = request.getRequestDispatcher("yonetici-list.jsp"); // bu eksik yapıcam
		dispatcher.forward(request, response);
	} 
         
        private void insertUyeOl(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
                String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");
                String sifre = request.getParameter("sifre");
		Integer cinsiyet = Integer.parseInt(request.getParameter("cinsiyet"));
               
		Kullanici kullanici = new Kullanici(ad, soyad,telefon,email,sifre,cinsiyet);
		new KullaniciDAO().insert(kullanici);
                
		response.sendRedirect("kullaniciProfil");
	} 
    
        private void showUyeOl(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("uye-ol.jsp");
		dispatcher.forward(request, response);
	}

        private void listKullanici(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Kullanici> listKullanici = new KullaniciDAO().selectAll();
		request.setAttribute("listKullanici", listKullanici);
		RequestDispatcher dispatcher = request.getRequestDispatcher("kullanici-list.jsp");
		dispatcher.forward(request, response);
	} 
        private void showNewKullaniciForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("kullanici-profil-duzenle.jsp");
		dispatcher.forward(request, response);
	}
        
        private void showEditKullaniciForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Kullanici existingKullanici = new KullaniciDAO().select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("kullanici-profil-duzenle.jsp");
		request.setAttribute("kullanici", existingKullanici);
		dispatcher.forward(request, response);

	}
        
        private void updateKullanici(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ad = request.getParameter("ad");
                String soyad = request.getParameter("soyad");
                String email = request.getParameter("email");
		String sifre = request.getParameter("sifre");
		String telefon = request.getParameter("telefon");
		Integer cinsiyet = Integer.parseInt(request.getParameter("cinsiyet"));

		Kullanici newKullanici = new Kullanici(ad,soyad,email,sifre,telefon,cinsiyet);
		new KullaniciDAO().update(newKullanici);
		response.sendRedirect("kullaniciListele");
	}
        
        private void deleteKullanici(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new KullaniciDAO().delete(id);
		response.sendRedirect("kullaniciListele");

	}
	private void cikisYap(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {

		request.getSession().setAttribute(KULLANICI, null);
		request.getSession().setAttribute(YONETICI, null);
		girisSayfasiniGoster(request, response);
	}
	

	private void listSirket(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Sirket> listSirket = new SirketDAO().selectAll();
		request.setAttribute("listSirket", listSirket);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sirket-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewSirketForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("sirket-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditSirketForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Sirket existingSirket = new SirketDAO().select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sirket-form.jsp");
		request.setAttribute("sirket", existingSirket);
		dispatcher.forward(request, response);

	}

	private void insertSirket(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String ad = request.getParameter("ad");
                
		Sirket newSirket = new Sirket(ad);
		new SirketDAO().insert(newSirket);
		response.sendRedirect("sirketListele");
	}

	private void updateSirket(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ad = request.getParameter("ad");

		Sirket newSirket = new Sirket(id, ad);
		new SirketDAO().update(newSirket);
		response.sendRedirect("sirketListele");
	}

	private void deleteSirket(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new SirketDAO().delete(id);
		response.sendRedirect("sirketListele");

	}
	
	private void listUcus(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Ucus> listUcus = new UcusDAO().selectAll();
		request.setAttribute("listUcus", listUcus);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ucus-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewUcusForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Sirket> sirket = new SirketDAO().selectAll();
		request.setAttribute("listSirket", sirket);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ucus-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditUcusForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Sirket> sirket = new SirketDAO().selectAll();
		request.setAttribute("listSirket", sirket);
		int id = Integer.parseInt(request.getParameter("id"));
		Ucus existingUcus = new UcusDAO().select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ucus-form.jsp");
		request.setAttribute("ucus", existingUcus);
		dispatcher.forward(request, response);

	}

	private void insertUcus(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String ucusKodu = request.getParameter("ucusKodu");
		Float ucusSaati = Float.valueOf(request.getParameter("ucusSaati"));
		Date ucusTarihi = Date.valueOf(request.getParameter("ucusTarihi"));
		Date varisTarihi = Date.valueOf(request.getParameter("varisTarihi"));
		Integer ucret = Integer.valueOf(request.getParameter("ucret"));
		Integer sirketId = Integer.parseInt(request.getParameter("sirket"));
		Integer ucusSuresi = Integer.parseInt(request.getParameter("ucusSuresi"));

		Sirket sirket  = new SirketDAO().select(sirketId);
		Ucus newUcus = new Ucus(ucret, sirket, ucusKodu, ucusTarihi, varisTarihi,ucusSuresi, ucusSaati);
		new UcusDAO().insert(newUcus);
		
		response.sendRedirect("ucusListele");
	}

	private void updateUcus(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ucusKodu = request.getParameter("ucusKodu");
		Float ucusSaati = Float.valueOf(request.getParameter("ucusSaati"));
		Date ucusTarihi = Date.valueOf(request.getParameter("ucusTarihi"));
		Date varisTarihi = Date.valueOf(request.getParameter("varisTarihi"));
		Integer ucret = Integer.valueOf(request.getParameter("ucret"));
		Integer sirketId = Integer.parseInt(request.getParameter("sirket"));
		Integer ucusSuresi = Integer.parseInt(request.getParameter("ucusSuresi"));

		Sirket sirket  = new SirketDAO().select(sirketId);
		Ucus newUcus = new Ucus(id, ucret, sirket, ucusKodu, ucusTarihi, varisTarihi,ucusSuresi, ucusSaati);
		new UcusDAO().update(newUcus);
		response.sendRedirect("ucusListele");
	}

	private void deleteUcus(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new UcusDAO().delete(id);
		response.sendRedirect("ucusListele");

	}

	private void listRezervasyon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Rezervasyon> listRezervasyon = new RezervasyonDAO().selectAll();
		request.setAttribute("listRezervasyon", listRezervasyon);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezervasyon-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewRezervasyonForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Ucus> ucusList = new UcusDAO().selectAll();
		request.setAttribute("listUcus", ucusList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezervasyon-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditRezervasyonForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Ucus> ucusList = new UcusDAO().selectAll();
		request.setAttribute("listUcus", ucusList);
                
		int id = Integer.parseInt(request.getParameter("id"));
		Rezervasyon rezervasyon = new RezervasyonDAO().select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezervasyon-form.jsp");
		request.setAttribute("rezervasyon", rezervasyon);
		dispatcher.forward(request, response);

	}
              
                private void insertRezervasyon(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
                Integer cinsiyet = Integer.parseInt(request.getParameter("cinsiyet"));
                String nereden = request.getParameter("nereden");
                String nereye = request.getParameter("nereye");
		Integer kgHakki = Integer.valueOf(request.getParameter("kgHakki"));
                String rezervasyonKodu = request.getParameter("rezervasyonKodu");
                Integer yolcuTipi = Integer.parseInt(request.getParameter("yolcuTipi"));
		Boolean iptalDurumu = Boolean.valueOf(request.getParameter("iptalDurumu"));
               
		Integer ucusId = Integer.parseInt(request.getParameter("ucus"));
		
		
		//Kullanici kullanici = new KullaniciDAO().select(kullaniciId);
		Ucus ucus  = new UcusDAO().select(ucusId);
		Rezervasyon newRezervasyon = new Rezervasyon(ad, soyad, email, telefon, cinsiyet, nereden, nereye, kgHakki, String.valueOf(new java.util.Date().getTime()), yolcuTipi, iptalDurumu, ucus);
		new RezervasyonDAO().insert(newRezervasyon);
		
		response.sendRedirect("rezervasyonListele");
	}

	private void updateRezervasyon(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
                Integer cinsiyet = Integer.parseInt(request.getParameter("cinsiyet"));
                String nereden = request.getParameter("nereden");
                String nereye = request.getParameter("nereye");
		Integer kgHakki = Integer.valueOf(request.getParameter("kgHakki"));
                String rezervasyonKodu = request.getParameter("rezervasyonKodu");
		
		Integer yolcuTipi = Integer.parseInt(request.getParameter("yolcuTipi"));
		
		Boolean iptalDurumu = Boolean.valueOf(request.getParameter("iptalDurumu"));
                Integer ucusId = Integer.parseInt(request.getParameter("ucus"));
		
		Ucus ucus  = new UcusDAO().select(ucusId);
		Rezervasyon newRezervasyon = new Rezervasyon(id,ad, soyad, email, telefon, cinsiyet, nereden, nereye, kgHakki, String.valueOf(new java.util.Date().getTime()), yolcuTipi, iptalDurumu, ucus);
		new RezervasyonDAO().update(newRezervasyon);
		response.sendRedirect("rezervasyonListele");
	}

	private void deleteRezervasyon(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new RezervasyonDAO().delete(id);
		response.sendRedirect("rezervasyonListele");

	}

}

