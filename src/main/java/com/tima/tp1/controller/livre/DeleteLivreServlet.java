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

@WebServlet("/livre/delete")
public class DeleteLivreServlet extends HttpServlet {

	private static final long serialVersionUID = 6222474780768840224L;
	private LivreDao livreDao;

	public DeleteLivreServlet() {
		super();
	}

	public void init() {
		livreDao = new LivreDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		livreDao.delete(id);
		response.sendRedirect("list");
	}


}
