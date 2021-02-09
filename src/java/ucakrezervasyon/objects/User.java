/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.objects;

/**
 *
 * @author tuğçe
 */

import java.sql.Date;

public class User {
	protected int id;
	protected String ad;
	protected String soyad;
	protected Integer sifre;
	protected String email;
	protected Long telefon;
	protected Integer cinsiyet;
	protected Boolean isManager;
	
        
	public User() {
	}
	
	public User(String ad, String soyad, Long telefon, String email, Integer sifre, Boolean isManager, Integer cinsiyet) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.telefon = telefon;
		this.email = email;
		this.sifre = sifre;
		this.isManager = isManager;
		this.cinsiyet = cinsiyet;
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

	public Long getTelefon() {
		return telefon;
	}

	public void setTelefon(Long telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSifre() {
		return sifre;
	}

	public void setSifre(Integer sifre) {
		this.sifre = sifre;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Integer getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Integer cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getIsManagerStr() {
		if(isManager == true) return "YONETICI";
		else return "KULLANICI";
	}

}
