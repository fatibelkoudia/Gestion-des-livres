package com.tima.tp1.controller.livre;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tima.tp1.dao.AuteurDao;
import com.tima.tp1.dao.LivreDao;
import com.tima.tp1.model.Auteur;
import com.tima.tp1.model.Editeur;
import com.tima.tp1.model.Livre;


@WebServlet("/livre/add")
public class AddLivreServlet extends HttpServlet {

	private static final long serialVersionUID = 6222474780768840224L;
	private LivreDao livreDao;
	private AuteurDao auteurDao;

	public AddLivreServlet() {
		super();
	}

	public void init() {
		livreDao = new LivreDao();
		auteurDao = new AuteurDao();
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long isbn = Long.parseLong(request.getParameter("isbn"));
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		LocalDate dateEdition = LocalDate.parse(request.getParameter("dateEdition"));
		Editeur editeur = Enum.valueOf(Editeur.class, request.getParameter("editeur"));
		Long auteurId = Long.parseLong(request.getParameter("auteur"));
		Auteur auteur = auteurDao.findOne(auteurId);
		Livre newLivre = new Livre(isbn, titre, description, dateEdition, editeur, auteur);
		livreDao.create(newLivre);
		response.sendRedirect("list");
	}


}
