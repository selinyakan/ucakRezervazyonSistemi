
CREATE DATABASE ucusrezervasyon;
USE ucusrezervasyon;

create table yonetici (
	id  int(3) NOT NULL AUTO_INCREMENT,
	ad varchar(255) NOT NULL,
	soyad varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	telefon varchar(255) NOT NULL,
	cinsiyet int NOT NULL,
	sifre varchar(255) NOT NULL,	 
	PRIMARY KEY (id)
);

create table kullanici (
	id  int(3) NOT NULL AUTO_INCREMENT,
	ad varchar(255) NOT NULL,
	soyad varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	telefon varchar(255) NOT NULL,
	cinsiyet int NOT NULL,
	sifre varchar(255) NOT NULL,	 
	PRIMARY KEY (id)
);

create table sirket (
	id  int(3) NOT NULL AUTO_INCREMENT,
	ad varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

create table ucus (
	id  int(3) NOT NULL AUTO_INCREMENT,
	ucret int NOT NULL,
	sirket int NOT NULL,
	ucus_kodu varchar(255) NOT NULL,
	ucus_tarihi TIMESTAMP NOT NULL,
	varis_tarihi TIMESTAMP NOT NULL,
	ucus_suresi int NOT NULL,
	ucus_saati varchar(255) NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (sirket) REFERENCES sirket(id)
);

create table rezervasyon (
	id  int(3) NOT NULL AUTO_INCREMENT,
	ad varchar(255) NOT NULL,
	soyad varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	telefon varchar(255) NOT NULL,
	cinsiyet int NOT NULL,
    nereden varchar(255) NOT NULL,
    nereye varchar(255) NOT NULL,
	kg_hakki int NOT NULL,
	rezervasyon_kodu varchar(255) NOT NULL,
	yolcu_tipi int NOT NULL,
	iptal_durumu int NOT NULL DEFAULT 0,
	kullanici int, 
	ucus int NOT NULL, 
	PRIMARY KEY (id),
    FOREIGN KEY (kullanici) REFERENCES kullanici(id),
    FOREIGN KEY (ucus) REFERENCES ucus(id)
);