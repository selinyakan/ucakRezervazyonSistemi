<%-- 
    Document   : ucus-form
    Created on : 14.Oca.2021, 21:42:10
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
                
		<nav class="navbar navbar-expand-md navbar-dark "
			style="background-color: brown">
			<div class="col-3">
				<a href="#" class="navbar-brand"> Uçak Rezervasyon Sistemi</a>
			</div>
			
			<div class="col-6">
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/rezervasyonListele" class="nav-link">Rezervasyonlar</a></li>
					<li><a href="<%=request.getContextPath()%>/ucusListele" class="nav-link">Uçuşlar</a></li>
					<li><a href="<%=request.getContextPath()%>/sirketListele" class="nav-link">Şirketler</a></li>
                                        <li><a href="<%=request.getContextPath()%>/kullaniciListele" class="nav-link">Üyeler</a></li>
				</ul>
			</div>

			<div class="col-3">
				<ul class="nav navbar-nav navbar-righ">
                                        
                                        <li><a href="<%=request.getContextPath()%>/yoneticiListele" class="nav-link">Yöneticiler</a></li>
					<li><a href="<%=request.getContextPath()%>/yoneticiProfil" class="nav-link">Profil Sayfam</a></li>
					<li><a href="<%=request.getContextPath()%>/cikisYap" class="nav-link" style="float:right">Çıkış Yap <i class="fa fa-sign-out-alt"></i></a></li>
				</ul>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${ucus != null}">
					<form action="ucusGuncelle" method="post">
				</c:if>
				<c:if test="${ucus == null}">
					<form action="ucusEkle" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${ucus != null}">
            			Uçuş Bilgilerini Düzenle
            		</c:if>
						<c:if test="${ucus == null}">
            			Yeni Uçuş Ekle
            		</c:if>
					</h2>
				</caption>

				<c:if test="${ucus != null}">
					<input type="hidden" name="id" value="<c:out value='${ucus.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Şirket</label>
					<select name="sirket" id="sirket" class="form-control">
						<c:forEach var="sirket" items="${listSirket}">
							<option value="${sirket.id}">${sirket.ad}</option>
						</c:forEach>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Uçuş Kodu</label> <input type="text"
						value="<c:out value='${ucus.ucusKodu}' />" class="form-control"
						name="ucusKodu" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Kalkış Tarihi</label> <input type="date"
						value="<c:out value='${ucus.ucusTarihi}' />" class="form-control"
						name="ucusTarihi" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Varış Tarihi</label> <input type="date"
						value="<c:out value='${ucus.varisTarihi}' />" class="form-control"
						name="varisTarihi" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Ücret</label> <input type="number"
						value="<c:out value='${ucus.ucret}' />" class="form-control"
						name="ucret" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Uçuş Süresi</label> <input type="number"
						value="<c:out value='${ucus.ucusSuresi}' />" class="form-control"
						name="ucusSuresi" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Uçuş Saati</label> <input type="text"
						value="<c:out value='${ucus.ucusSaati}' />" class="form-control"
						name="ucusSaati" required="required">
				</fieldset>
				
				
				<button type="submit" class="btn btn-success">Kaydet</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	(function() {
		document.getElementById("sirket").value = ${ucus.sirket.id}
	})();
</script>
</html>
