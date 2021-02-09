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
				<c:if test="${user != null}">
					<form action="yoneticiGuncelle" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="yoneticiEkle" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
				Yönetici Bilgileri Düzenle
            		</c:if>
						<c:if test="${user == null}">
            			Yeni Yönetici Ekle
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Adı</label> <input type="text"
						value="<c:out value='${user.ad}' />" class="form-control"
						name="ad" required="required">
				</fieldset>
                                             
                                <fieldset class="form-group">
					<label>Soyadı</label> <input type="text"
						value="<c:out value='${user.soyad}' />" class="form-control"
						name="soyad" required="required">
				</fieldset>
                                                
                                 <fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
                                                
                                 
                                 <fieldset class="form-group">
					<label>Telefon</label> <input type="text"
						value="<c:out value='${user.telefon}' />" class="form-control"
						name="telefon" required="required">
				</fieldset>
                                                <fieldset class="form-group">
					<label>Cinsiyet</label>
					<c:if test="${user != null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
							<c:if test="${user.cinsiyet == 0}">
							    <option value="0" selected>Erkek</option>
							    <option value="1">Kadın</option>
		            		</c:if>
		            		<c:if test="${user.cinsiyet == 1}">
							    <option value="0">Erkek</option>
							    <option value="1" selected>Kadın</option>
		            		</c:if>
                                                            </c:if>
                                                            <c:if test="${user == null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
						    <option value="0" selected>Erkek</option>
						    <option value="1">Kadın</option>
						</select>
	            	</c:if>
						</select>
                                        </fieldset>
                                <fieldset class="form-group">
					<label>Şifre</label> <input type="text"
						value="<c:out value='${user.sifre}' />" class="form-control"
						name="sifre">
				</fieldset>
                                                
                                          <button type="submit" class="btn btn-success">Kaydet</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


<%--
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
                                    
                                        <li><a href="<%=request.getContextPath()%>/rezervasyonListele" class="nav-link">Rezervasyonlar</a></li>
                                        <li><a href="<%=request.getContextPath()%>/ucusListele" class="nav-link">Uçuşlar</a></li>
                                        <li><a href="<%=request.getContextPath()%>/sirketListele" class="nav-link">Şirketler</a></li>
                                  
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
                                <c:if test="${Yonetici != null}">
					<form action="yoneticiGuncelle" method="post">
				</c:if>
				<c:if test="${Yonetici == null}">
					<form action="yoneticiEkle" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${Yonetici != null}">
            			Bilgilerini Düzenle
            		</c:if>
						<c:if test="${Yonetici == null}">
            			Yeni Yönetici Ekle
            		</c:if>
                             
						
					</h2>
				</caption>

				<c:if test="${Yonetici != null}">
					<input type="hidden" name="id" value="<c:out value='${Yonetici.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Ad</label> <input type="text"
						value="<c:out value='${Yonetici.ad}' />" class="form-control"
						name="ad" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Soyad</label> <input type="text"
						value="<c:out value='${Yonetici.soyad}' />" class="form-control"
						name="soyad" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${Yonetici.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Telefon</label> <input type="text"
						value="<c:out value='${Yonetici.telefon}' />" class="form-control"
						name="telefon" required="required">
				</fieldset>
			
				<fieldset class="form-group">
					<label>Cinsiyet</label>
					<c:if test="${Yonetici != null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
							<c:if test="${Yonetici.cinsiyet == 0}">
							    <option value="0" selected>Erkek</option>
							    <option value="1">Kadın</option>
		            		</c:if>
		            		<c:if test="${Yonetici.cinsiyet == 1}">
							    <option value="0">Erkek</option>
							    <option value="1" selected>Kadın</option>
		            		</c:if>
						</select>
	            	</c:if>
	            	<c:if test="${Yonetici == null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
						    <option value="0" selected>Erkek</option>
						    <option value="1">Kadın</option>
						</select>
	            	</c:if>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Şifre</label> <input type="password"
						value="<c:out value='${Yonetici.sifre}' />" class="form-control"
						name="sifre">
				</fieldset>

				<button type="submit" class="btn btn-success">Güncelle</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	(function() {
		document.getElementById("Yonetici").value = ${Yonetici.id}
})();
</script>
</html>
--%>