<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gestion des livres</title>

<link href="<c:url value="/resources/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/icon.css" />" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<nav class="navbar navbar-default">

		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Gestion des livres</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li><a href="/gr1Tp1/livre/list">Liste des
							livres</a></li>
					<li class="active"><a href="/gr1Tp1/auteur/list">Liste des auteurs</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><div class="alert alert-success" role="alert">
							Bienvenue<strong><c:out value=' ${loggedInUser}' /></strong>

						</div></li>
					<li><form class="navbar-form navbar-left"
							action="/gr1Tp1/logout" method="post">
							<input class="btn btn-danger" type="submit" value="Logout">
						</form></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="panel ${auteur != null ? 'panel-success' : 'panel-info'}">
			<div class="panel-heading">
				<h2>
					<c:if test="${auteur != null}">Modifier l'auteur</c:if>
					<c:if test="${auteur == null}">Ajouter un auteur</c:if>
				</h2>
			</div>
			<div class="panel-body">
				<c:if test="${auteur != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${auteur == null}">
					<form action="add" method="post">
				</c:if>

				<c:if test="${auteur != null}">
					<input type="hidden" name="matricule"
						value="<c:out value='${auteur.matricule}' />" />
				</c:if>
				<c:if test="${auteur == null}">
					<label>Matricule:</label>
					<input type="number" name="matricule"
						value="<c:out value='${auteur.matricule}' />" class="form-control"
						required />

				</c:if>
				<div class="form-group">
					<label>Nom:</label> <input type="text" name="nom"
						 value="<c:out value='${auteur.nom}'/>"
						class="form-control" required />

				</div>
				<div class="form-group">
					<label>Prenom:</label> <input type="text" name="prenom"
						value="<c:out value='${auteur.prenom}' />"
						class="form-control" required />

				</div>
				<div class="form-group">
					<label>Genre:</label> <select name="genre" class="form-control" required>
						<c:forEach items="${genreList}" var="g">
							<option value="${g}"
								${g == auteur.genre ? 'selected="selected"' : ''}>${g}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" value="${auteur != null ? 'Modifier' : 'Ajouter'}" class="btn ${auteur != null ? 'btn-success' : 'btn-info'}" />
				</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>