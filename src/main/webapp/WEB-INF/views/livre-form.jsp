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

					<li class="active"><a href="/gr1Tp1/livre/list">Liste des
							livres</a></li>
					<li><a href="/gr1Tp1/auteur/list">Liste des auteurs</a></li>
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

		<div class="panel ${livre != null ? 'panel-success' : 'panel-info'}">
			<div class="panel-heading">
				<h2>
					<c:if test="${livre != null}">Modifier le livre</c:if>
					<c:if test="${livre == null}">Ajouter un livre</c:if>
				</h2>
			</div>
			<div class="panel-body">
				<c:if test="${livre != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${livre == null}">
					<form action="add" method="post">
				</c:if>

				<c:if test="${livre != null}">
					<input type="hidden" name="isbn"
						value="<c:out value='${livre.isbn}' />" />
				</c:if>
				<c:if test="${livre == null}">
					<label>ISBN:</label>
					<input type="number" name="isbn"
						value="<c:out value='${livre.isbn}' />" class="form-control"
						required />

				</c:if>
				<div class="form-group">
					<label>Titre:</label> <input type="text" name="titre" size="45"
						value="<c:out value='${livre.titre}' />" class="form-control"
						required />

				</div>
				<div class="form-group">
					<label>Description:</label> <input type="text" name="description"
						value="<c:out value='${livre.description}'/>"
						class="form-control" required />

				</div>
				<div class="form-group">
					<label>Date edition:</label> <input type="date" name="dateEdition"
						value="<c:out value='${livre.dateEdition}' />"
						class="form-control" required />

				</div>
				<div class="form-group">
					<label>Editeur:</label> <select name="editeur" class="form-control" required>
						<c:forEach items="${editeurList}" var="e">
							<option value="${e}"
								${e == livre.editeur ? 'selected="selected"' : ''}>${e}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Auteur:</label> <select name="auteur" class="form-control" required>
						<c:forEach items="${auteurList}" var="a">
							<option value="${a.getMatricule()}"
								${a.getMatricule() == livre.auteur.getMatricule() ? 'selected="selected"' : ''}>${a.getPrenom()}
								${a.getNom()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" value="${livre != null ? 'Modifier' : 'Ajouter'}" class="btn ${livre != null ? 'btn-success' : 'btn-info'}" />
				</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>