package com.tima.tp1.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tima.tp1.model.Role;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;
	private String[] adminRoutes = { "auteur", "update", "delete", "edit", "add", "new" };
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		HttpSession session = req.getSession(false);
		
		if (uri.endsWith("login") || uri.endsWith("login.jsp")) {
			chain.doFilter(request, response);
			return;
		}

		if (session == null || session.getAttribute("role") == null) {
			// si aucune session n'est définie (utilisateur non connecté)
			// rediriger vers la page de login
			// sauf pour les routes de login qui redirigent déjà vers la page de login
			this.context.log("Utilisateur non connecté");
			res.sendRedirect("/gr1Tp1/login.jsp");
		} else {
			String role = session.getAttribute("role").toString();
			Boolean isVisiteur = role == Role.Visiteur.getValue();
			if (isVisiteur) {
				// si l'utilisateur connecté est un `Visiteur`, ne lui permettre d'accéder qu'à
				// ses routes autorisés
				Boolean isUriAllowedForVisiteur = true;
				
				for (String adminRoute : adminRoutes) {
					if (uri.contains(adminRoute)) {
						isUriAllowedForVisiteur = false;
					}
				}
				if (!isUriAllowedForVisiteur) {
					this.context.log("Demande d'accès non autorisé");
					req.setAttribute("message", "Demande d'accès non autorisée à la route: " + uri
							+ ", Veuillez vous connecter avec un utilisateur Admin pour accéder à cette route");
					req.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}
			request.setAttribute("loggedInUser", session.getAttribute("user"));
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
	}

}
