package com.tima.tp1.controller.auteur;

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
import com.tima.tp1.model.Genre;
import com.tima.tp1.model.Livre;


@WebServlet("/auteur/edit")
public class FormEditAuteurServlet extends HttpServlet {

	private static final long serialVersionUID = 6222474780768840224L;
	private AuteurDao auteurDao;

	public FormEditAuteurServlet() {
		super();
	}

	public void init() {
		auteurDao = new AuteurDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Auteur existingAuteur = auteurDao.findOne(id);
		request.setAttribute("genreList", Genre.values());
        request.setAttribute("auteur", existingAuteur);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/auteur-form.jsp");
		
		dispatcher.forward(request, response);
	}


}
