/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucakrezervasyon.objects;
import java.sql.Date;
/**
 *
 * @author yAkAn
 */
public class Ucus {
        protected int id;
	protected Integer ucret;
	protected Sirket sirket;
	protected String ucusKodu;
	protected Date ucusTarihi;
	protected Date varisTarihi;
	protected Integer ucusSuresi;
	protected Float ucusSaati;
	
	public Ucus() {
	}
	
	public Ucus(Integer ucret, Sirket sirket, String ucusKodu, Date ucusTarihi, Date varisTarihi, Integer ucusSuresi, Float ucusSaati) {
		super();
		this.ucret = ucret;
		this.sirket = sirket;
		this.ucusKodu = ucusKodu;
		this.ucusTarihi = ucusTarihi;
		this.varisTarihi = varisTarihi;
		this.ucusSuresi = ucusSuresi;
		this.ucusSaati = ucusSaati;
	}

	public Ucus(int id, Integer ucret, Sirket sirket, String ucusKodu, Date ucusTarihi, Date varisTarihi, Integer ucusSuresi, Float ucusSaati) {
		super();
		this.id = id;
		this.ucret = ucret;
		this.sirket = sirket;
		this.ucusKodu = ucusKodu;
		this.ucusTarihi = ucusTarihi;
		this.varisTarihi = varisTarihi;
		this.ucusSuresi = ucusSuresi;
		this.ucusSaati = ucusSaati;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Integer getUcret() {
		return ucret;
	}

	public void setUcret(Integer ucret) {
		this.ucret = ucret;
	}

	public Sirket getSirket() {
		return sirket;
	}

	public void setSirket(Sirket sirket) {
		this.sirket = sirket;
	}

	public String getUcusKodu() {
		return ucusKodu;
	}

	public void setUcusKodu(String ucusKodu) {
		this.ucusKodu = ucusKodu;
	}

	public Date getUcusTarihi() {
		return ucusTarihi;
	}

	public void setUcusTarihi(Date ucusTarihi) {
		this.ucusTarihi = ucusTarihi;
	}

	public Date getVarisTarihi() {
		return varisTarihi;
	}

	public void setVarisTarihi(Date varisTarihi) {
		this.varisTarihi = varisTarihi;
	}

	public Integer getUcusSuresi() {
		return ucusSuresi;
	}

	public void setUcusSuresi(Integer ucusSuresi) {
		this.ucusSuresi = ucusSuresi;
	}

	public Float getUcusSaati() {
		return ucusSaati;
	}

	public void setUcusSaati(Float ucusSaati) {
		this.ucusSaati = ucusSaati;
	}
    
}
