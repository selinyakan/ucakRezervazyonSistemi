<%-- 
    Document   : uye-ol
    Created on : 19.Oca.2021, 17:55:47
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
                    <div class="navbar-header">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/home">Uçak Rezervasyon Sistemi</a>
                   </div>
                  </div>
</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
						<form action="insertUyeOl" method="post">

				<caption>
					<h2>
						<c:if test="${user == null}">
            			Üye Ol
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
                                        
				<fieldset class="form-group">
					<label>Ad</label> <input type="text"
						value="<c:out value='${user.ad}' />" class="form-control"
						name="ad">
				</fieldset>
                                                
				<fieldset class="form-group">
					<label>Soyadı</label> <input type="text"
						value="<c:out value='${user.soyad}' />" class="form-control"
						name="soyad">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>Telefon</label> <input type="text"
						value="<c:out value='${user.telefon}' />" class="form-control"
						name="telefon">
				</fieldset>
                                                
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>
                                                
				<fieldset class="form-group">
					<label>Şifre</label> <input type="text"
						value="<c:out value='${user.sifre}' />" class="form-control"
						name="sifre">
				</fieldset>
                                                
                             	<fieldset class="form-group">
					<label>Cinsiyet</label>
					<c:if test="${user != null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
							<c:if test="${user.cinsiyet == 0}">
							    <option value="0">Erkek</option>
							    <option value="1"selected>Kadın</option>
		            		</c:if>
		            		<c:if test="${user.cinsiyet == 1}">
							    <option value="0">Erkek</option>
							    <option value="1"selected>Kadın</option>
		            		</c:if>
						</select>
	            	</c:if>
	            	<c:if test="${user == null}">
						<select name="cinsiyet" id="cinsiyet" class="form-control">
						    <option value="0" selected>Erkek</option>
						    <option value="1">Kadın</option>
						</select>
	            	</c:if>
				</fieldset>
					<button type="submit" class="btn btn-success">Üye Ol</button>
					<c:if test="${error != null}">
						<label class="text-danger">${error}</label>
					</c:if>
				</form>
<a class="text-secondary" href="<%=request.getContextPath()%>/login" style="cursor:pointer"><i class="fa fa-arrow-left"> </i>Giriş Yap</a>

			</div>
		</div>
	</div>
</body>
</html>

