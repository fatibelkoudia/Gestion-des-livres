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


@WebServlet("/livre/edit")
public class FormEditLivreServlet extends HttpServlet {

	private static final long serialVersionUID = 6222474780768840224L;
	private LivreDao livreDao;
	private AuteurDao auteurDao;

	public FormEditLivreServlet() {
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
		List<Auteur> auteurList = auteurDao.findAll();
		Long id = Long.parseLong(request.getParameter("id"));
		Livre existingLivre = livreDao.findOne(id);
		request.setAttribute("editeurList", Editeur.values());
        request.setAttribute("auteurList", auteurList);
        request.setAttribute("livre", existingLivre);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/livre-form.jsp");
		
		dispatcher.forward(request, response);
	}


}
