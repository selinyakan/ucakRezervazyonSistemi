<%-- 
    Document   : ucus-list
    Created on : 14.Oca.2021, 21:41:43
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

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Uçuş Listesi</h3>
			<hr>
			<div class="container text-left">
                                <c:if test="${YONETICI_HESAP != null }">
				<a href="<%=request.getContextPath()%>/yeniUcus" class="btn btn-success">Yeni Uçuş Ekle</a>
                                </c:if>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Şirket</th>
						<th>Uçuş Kodu</th>
						<th>Kalkış</th>
						<th>Varış</th>
						<th>Uçuş Süresi(dk)</th>
						<th>Uçuş Saati</th>
						<th>Ücret(₺)</th>
                                                <c:if test="${YONETICI_HESAP != null }">
                                                <th>İşlemler</th> </c:if>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="ucus" items="${listUcus}">

						<tr>
							<td><c:out value="${ucus.id}" /></td>
							<td><c:out value="${ucus.sirket.ad}" /></td>
							<td><c:out value="${ucus.ucusKodu}" /></td>
							<td><c:out value="${ucus.ucusTarihi}" /></td>
							<td><c:out value="${ucus.varisTarihi}" /></td>
							<td><c:out value="${ucus.ucusSuresi}" /></td>
							<td><c:out value="${ucus.ucusSaati}" /></td>
							<td><c:out value="${ucus.ucret}" /></td>
							
							<td>
                                                        <c:if test="${YONETICI_HESAP != null }">
                                                            <a href="ucusDuzenle?id=<c:out value='${ucus.id}' />">Düzenle</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="ucusSil?id=<c:out value='${ucus.id}' />">Sil</a></td>
                                                        </c:if>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>

