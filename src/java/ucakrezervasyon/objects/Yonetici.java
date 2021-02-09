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
public class Yonetici {
        protected int id;
	protected String ad;
	protected String soyad;
	protected String sifre;
	protected String email;
	protected String telefon;
	protected Integer cinsiyet;
	
	public Yonetici() {
	}
	
	public Yonetici(String ad, String soyad, String sifre, String email, String telefon, Integer cinsiyet) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.sifre = sifre;
		this.email = email;
		this.soyad = soyad;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
	}

	public Yonetici(int id, String ad, String soyad, String sifre, String email, String telefon, Integer cinsiyet) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.sifre = sifre;
		this.email = email;
		this.soyad = soyad;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
	}

    public Yonetici(Integer id, String ad, String soyad, String email, String telefon, Integer cinsiyet, String sifre) {
                this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.soyad = soyad;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
                this.sifre = sifre;  
    }

    public Yonetici(String ad, String soyad, String email, String telefon, Integer cinsiyet, String sifre) {
                this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.soyad = soyad;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
                this.sifre = sifre;  
    }

    public Yonetici(int id, String ad, String soyad, String email, String telefon) {
                this.id = id;
                this.ad = ad;
                this.soyad = soyad;
                this.email = email;
                this.telefon = telefon;
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
        
        public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
