<%-- 
    Document   : login-form
    Created on : 14.Oca.2021, 21:31:41
    Author     : yAkAn
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Uçak Rezervasyon Sistemi Giriş</title>
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
			<div>
				<a href="<%=request.getContextPath()%>/kullaniciListele" class="navbar-brand" > Uçak Rezervasyon Sistemi </a>
			</div>

			<ul class="navbar-nav">
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form id="loginForm" action="kullaniciGiris" method="post">

					<caption>
						<h2> Giriş </h2>
					</caption>
		
					<fieldset class="form-group">
						<label>Hesap Tipi</label>
							<select name="kullaniciTipi" id="kullaniciTipi" class="form-control" onchange="updateLogin()">
							    <option value="0" selected>Kullanıcı</option>
							    <option value="1">Yönetici</option>
							</select>
					</fieldset>
					
					<fieldset class="form-group">
						<label>E-Posta</label> <input type="text" class="form-control"
							name="email" required="required">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Şifre</label> <input type="password" class="form-control"
							name="sifre" required="required">
					</fieldset>
	
					<button type="submit" class="btn btn-success">Giriş Yap</button>
					<c:if test="${error != null}">
						<label class="text-danger">${error}</label>
					</c:if>
				</form>
                            <a class="text-secondary" href="<%=request.getContextPath()%>/uyeOl" style="cursor:pointer"><i class="fa fa-arrow-left"> </i>Üye Ol</a>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
        function updateLogin(){
	if(document.getElementById("kullaniciTipi").value == 0){
		document.getElementById("loginForm").action = "kullaniciGiris";
	}
	else{
		document.getElementById("loginForm").action = "yoneticiGiris";
	}
}

        (function() {
	document.getElementById("loginForm").action = action;
})();

</script>
</html>
