/**
 * 
 */
package com.dgstack.jee7.jsf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author digvijayb
 *
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml", "*.jsf", "*.faces", "*.html" })
public class AuthenticateFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse resp = (HttpServletResponse) response;
		final HttpSession session = req.getSession(false);
		String reqURI = req.getRequestURI();
		System.out.println("uri >> " + reqURI);
		if (reqURI.equals(req.getContextPath()+"/")  ) {
			filterChain.doFilter(request, response);
		} else if (reqURI.indexOf("/login.xhtml") >= 0 || reqURI.indexOf("/index.xhtml") >= 0
				|| reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource")
				|| (session != null && session.getAttribute("username") != null)) {
			filterChain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login.xhtml");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
