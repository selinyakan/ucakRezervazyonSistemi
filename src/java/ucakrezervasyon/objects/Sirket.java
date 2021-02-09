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
public class Sirket {
        protected int id;
	protected String ad;
	
	public Sirket() {
	}
	
	public Sirket(String ad) {
		super();
		this.ad = ad;
	}

	public Sirket(int id, String ad) {
		super();
		this.id = id;
		this.ad = ad;
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
}
