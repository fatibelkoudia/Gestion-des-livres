<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link href="<c:url value="/resources/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/icon.css" />" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
<title>Gestion des livres</title>
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

					<li><a href="/gr1Tp1/livre/list">Liste des livres</a></li>
					<li class="active"><a href="/gr1Tp1/auteur/list">Liste des
							auteurs</a></li>
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
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Liste des auteurs</h2>
					</div>
					<div class="col-sm-6">
						<a href="new" class="btn btn-success"><i
							class="material-icons">&#xE147;</i> <span>Ajouter un
								auteur</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Matricule</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Genre</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="auteur" items="${listAuteur}">
						<tr>
							<td><c:out value="${auteur.matricule}" /></td>
							<td><c:out value="${auteur.nom}" /></td>
							<td><c:out value="${auteur.prenom}" /></td>
							<td><c:out value="${auteur.genre}" /></td>

							<td><a href="edit?id=<c:out value='${auteur.matricule}' />"
								class="edit"><i class="material-icons" data-toggle="tooltip"
									title="Modifier">&#xE254;</i></a> <a
								href="delete?id=<c:out value='${auteur.matricule}' />"
								class="delete"><i class="material-icons"
									data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

	</div>
</body>
</html>