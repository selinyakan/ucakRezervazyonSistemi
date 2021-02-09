<%-- 
    Document   : kullanici-profil-form
    Created on : 14.Oca.2021, 21:31:06
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
				<a href="#" class="navbar-brand"> Uçak Rezervasyon Sistemi </a>
			</div>
						
			<div class="col-6">
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/rezervasyonListele" class="nav-link">Rezervasyonlarım</a></li>
                                        <li><a href="<%=request.getContextPath()%>/ucusListele" class="nav-link">Uçuşlar</a></li>
                                </ul>
			</div>

			<div class="col-3">
				<ul class="nav navbar-nav navbar-righ">
					<li><a href="<%=request.getContextPath()%>/kullaniciProfil" class="nav-link">Profil Sayfam</a></li>
					<li><a href="<%=request.getContextPath()%>/cikisYap" class="nav-link" style="float:right">Çıkış Yap <i class="fa fa-sign-out-alt"></i></a></li>
				</ul>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
					<h2>
           				Profil Bilgilerim
					</h2>
				</caption>

				<div class="row pt-3">
					<div class="col">
						<label><strong>Ad :</strong> </label>
						<label>${user.ad}</label>
					</div>
					<div class="col">
						<label><strong>Soyad :</strong> </label>
						<label>${user.soyad}</label>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label><strong>Email :</strong> </label>
						<label>${user.email}</label>
					</div>
					<div class="col">
						<label><strong>Telefon :</strong> </label>
						<label>${user.telefon}</label>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label><strong>Hesap Tipi :</strong> </label>
						<label>Kullanıcı</label>
					</div>
					<div class="col">
						<label><strong>Cinsiyet :</strong> </label>
						<c:if test="${user.cinsiyet == 0}">
							<label>Erkek</label>
						</c:if>
						<c:if test="${user.cinsiyet != 0}">
							<label>Kadın</label>
						</c:if>
					</div>
				</div>
                                        
			</div>
		</div>
	</div>
</body>
<script>
	(function() {
})();
</script>
</html>

