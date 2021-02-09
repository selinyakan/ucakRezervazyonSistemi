<%-- 
    Document   : rezervasyon
    Created on : 14.Oca.2021, 21:32:06
    Author     : yAkAn
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Uçak Rezervasyon Sistemi</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
<style> 
    body{
		background-color: #F0FFFF;
                font-family: 'Roboto', sans-serif;
    }
    </style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: brown">
			<div class="col-3">
				<a href="#" class="navbar-brand"> Uçak Rezervasyon Sistemi</a>
			</div>
			
			<div class="col-6">
				<ul class="navbar-nav">
                                     <c:if test="${YONETICI_HESAP != null }">
                                        <li><a href="<%=request.getContextPath()%>/rezervasyonListele" class="nav-link">Rezervasyonlar</a></li>
                                        <li><a href="<%=request.getContextPath()%>/ucusListele" class="nav-link">Uçuşlar</a></li>
                                        <li><a href="<%=request.getContextPath()%>/sirketListele" class="nav-link">Şirketler</a></li>
                                        <li><a href="<%=request.getContextPath()%>/kullaniciListele" class="nav-link">Üyeler</a></li>
                                     </c:if>
                        
                                     <c:if test="${KULLANICI_HESAP != null }">
                                        <li><a href="<%=request.getContextPath()%>/rezervasyonListele" class="nav-link">Rezervasyonlarım</a></li>
                                        <li><a href="<%=request.getContextPath()%>/ucusListele" class="nav-link">Uçuşlar</a></li>
                                     </c:if>	
			
				</ul>
			</div>

			<div class="col-3">
				<ul class="nav navbar-nav navbar-righ">
                                    <c:if test="${YONETICI_HESAP != null}">
                                        
                                        <li><a href="<%=request.getContextPath()%>/yoneticiListele" class="nav-link">Yöneticiler</a></li>
					<li><a href="<%=request.getContextPath()%>/yoneticiProfil" class="nav-link">Profil Sayfam</a></li>
					<li><a href="<%=request.getContextPath()%>/cikisYap" class="nav-link" style="float:right">Çıkış Yap <i class="fa fa-sign-out-alt"></i></a></li>
                                    </c:if>
                                        
                                    <c:if test="${KULLANICI_HESAP != null}">
					<li><a href="<%=request.getContextPath()%>/kullaniciProfil" class="nav-link">Profil Sayfam</a></li>
					<li><a href="<%=request.getContextPath()%>/cikisYap" class="nav-link" style="float:right">Çıkış Yap <i class="fa fa-sign-out-alt"></i></a></li>
                                    </c:if>
                                    </ul>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${rezervasyon != null}">
					<form action="rezervasyonGuncelle" method="post">
				</c:if>
				<c:if test="${rezervasyon == null}">
					<form action="rezervasyonEkle" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${rezervasyon != null}">
            			Rezervasyon Bilgilerini Düzenle
            		</c:if>
						<c:if test="${rezervasyon == null}">
            			Yeni Rezervasyon Ekle
            		</c:if>
					</h2>
				</caption>

				<c:if test="${rezervasyon != null}">
					<input type="hidden" name="id" value="<c:out value='${rezervasyon.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Ad</label> <input type="text"
						value="<c:out value='${rezervasyon.ad}' />" class="form-control"
						name="ad" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Soyad</label> <input type="text"
						value="<c:out value='${rezervasyon.soyad}' />" class="form-control"
						name="soyad" required="required">
				</fieldset>
                                   
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${rezervasyon.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Telefon</label> <input type="text"
						value="<c:out value='${rezervasyon.telefon}' />" class="form-control"
						name="telefon" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Cinsiyet</label>
					<c:if test="${rezervasyon != null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
							<c:if test="${rezervasyon.cinsiyet == 0}">
							    <option value="0" selected>Erkek</option>
							    <option value="1">Kadın</option>
		            		</c:if>
		            		<c:if test="${rezervasyon.cinsiyet == 1}">
							    <option value="0">Erkek</option>
							    <option value="1" selected>Kadın</option>
		            		</c:if>
						</select>
	            	</c:if>
	            	<c:if test="${rezervasyon == null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
						    <option value="0" selected>Erkek</option>
						    <option value="1">Kadın</option>
						</select>
	            	</c:if>
				</fieldset>
                                         
                                <fieldset class="form-group">
					<label>Nereden</label>
					<select name="nereden" id="nereden" class="form-control">
						<option value="Istanbul">İstanbul(IST)</option>
						<option value="Istanbul">İstanbul(SAW)</option>
						<option value="Tekirdag">Tekirdağ(TEQ)</option>
                                                <option value="Kocaeli">Kocaeli(KCO)</option>
                                                <option value="Ankara">Ankara(ESB)</option>
                                                <option value="Canakkale">Çanakkale(ÇKZ)</option>
                                                <option value="Amasya">Amasya(MZH)</option>
                                                <option value="Samsun">Samsun(SZF)</option>
					</select>
				</fieldset>
                                                
				<fieldset class="form-group">
					<label>Nereye</label>
					<select name="nereye" id="nereye" class="form-control">
						<option value="Ankara">Ankara(ESB)</option>
						<option value="Izmir">İzmir(ADB)</option>
						<option value="Sivas">Sivas(VAS)</option>
                                                <option value="Kocaeli">Kocaeli(KCO)</option>
                                                <option value="Bodrum">Bodrum(BJV)</option>
                                                <option value="Canakkale">Çanakkale(ÇKZ)</option>
                                                <option value="Amasya">Amasya(MZH)</option>
                                                <option value="Samsun">Samsun(SZF)</option>
                                                <option value="Istanbul">İstanbul(IST)</option>
                                                <option value="Istanbul">İstanbul(SAW)</option>

					</select>
				</fieldset> 
                                                
				<fieldset class="form-group">
					<label>Uçuş</label>
					<select name="ucus" id="ucus" class="form-control">
						<c:forEach var="ucus" items="${listUcus}">
							<option value="${ucus.id}">${ucus.sirket.ad} : ${ucus.ucusTarihi}-${ucus.varisTarihi}</option>
						</c:forEach>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Bagaj(kg)</label>
					<select name="kgHakki" id="kgHakki" class="form-control">
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
					</select>
				</fieldset>
				
                                <fieldset class="form-group">
					<label>Yolcu Tipi</label>
					<select name="yolcuTipi" id="yolcuTipi" class="form-control">
						<option value="0">Ekonomi</option>
						<option value="1">Business</option>
					</select>
				</fieldset>
                                                
				<fieldset class="form-group">
					<label>İptal Durumu</label>
					<select name="iptalDurumu" id="iptalDurumu" class="form-control">
						<option value="0">Geçerli</option>
						<option value="1">Geçersiz</option>
					</select>
				</fieldset>				
				
				<button type="submit" class="btn btn-success">Kaydet</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	(function() {
                
		document.getElementById("ucus").value = ${rezervasyon.ucus.id}
		document.getElementById("kgHakki").value = ${rezervasyon.kgHakki}
		document.getElementById("iptalDurumu").value = ${rezervasyon.iptalDurumu}
	})();
</script>
</html>

