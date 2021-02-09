/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.objects;


/**
 *
 * @author yAkAn
 */
public class Rezervasyon {
        protected int id;
	protected String ad;
	protected String soyad;
	protected String email;
	protected String telefon;
	protected Integer cinsiyet;
        protected String nereden;
        protected String nereye;
	protected Integer kgHakki;
	protected String rezervasyonKodu;
	protected Integer yolcuTipi;
	protected Boolean iptalDurumu;
	protected Ucus ucus;
	
	
	
	public Rezervasyon() {
	}
	
	public Rezervasyon(String ad, String soyad, String email, String telefon, Integer cinsiyet, String nereden,String nereye, Integer kgHakki, String rezervasyonKodu, Integer yolcuTipi, Boolean iptalDurumu, Ucus ucus) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
                this.nereden = nereden;
                this.nereye = nereye;
		this.kgHakki = kgHakki;
		this.rezervasyonKodu = rezervasyonKodu;
		this.yolcuTipi = yolcuTipi;
                this.iptalDurumu = iptalDurumu;
		this.ucus = ucus;
	}

	public Rezervasyon(int id, String ad, String soyad, String email, String telefon, Integer cinsiyet,String nereden,String nereye, Integer kgHakki, String rezervasyonKodu, Integer yolcuTipi, Boolean iptalDurumu, Ucus ucus) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
                this.telefon = telefon;
		this.cinsiyet = cinsiyet;
                this.nereden = nereden;
                this.nereye = nereye;
		this.kgHakki = kgHakki;
		this.rezervasyonKodu = rezervasyonKodu;
		this.yolcuTipi = yolcuTipi;
                this.iptalDurumu = iptalDurumu;
		this.ucus = ucus;
	}
        
        public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Integer getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Integer cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
        
        public String getNereden() {
		return nereden;
	}

	public void setNereden(String nereden) {
		this.nereden = nereden;
	}
        
         public String getNereye() {
		return nereye;
	}

	public void setNereye(String nereye) {
		this.nereye = nereye;
	}

	public Integer getKgHakki() {
		return kgHakki;
	}

	public void setKgHakki(Integer kgHakki) {
		this.kgHakki = kgHakki;
	}

	public String getRezervasyonKodu() {
		return rezervasyonKodu;
	}

	public void setRezervasyonKodu(String rezervasyonKodu) {
		this.rezervasyonKodu = rezervasyonKodu;
	}

	public Integer getYolcuTipi() {
		return yolcuTipi;
	}

	public void setYolcuTipi(Integer yolcuTipi) {
		this.yolcuTipi = yolcuTipi;
	}

	public Boolean getIptalDurumu() {
		return iptalDurumu;
	}

	public void setIptalDurumu(Boolean iptalDurumu) {
		this.iptalDurumu = iptalDurumu;
	}

	public Ucus getUcus() {
		return ucus;
	}

	public void setUcus(Ucus ucus) {
		this.ucus = ucus;
	}
	
}
