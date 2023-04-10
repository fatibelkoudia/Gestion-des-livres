package com.tima.tp1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tima.tp1.dao.UserDao;
import com.tima.tp1.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4924026457338044684L;
	private UserDao userDao;
	
	public LoginServlet() {
		super();
	}
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = userDao.checkLogin(login, password);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getLogin());
			session.setAttribute("role", user.getRole());
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user.getLogin());
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("/gr1Tp1/livre/list");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			request.setAttribute("message", "Nom d'utilisateur ou mot de passe incorrect!");
			rd.include(request, response);
		}

	}

}
