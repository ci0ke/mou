package org.cike.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cike.app.MyQiniu;


/**
 * Servlet implementation class ServletQiniu
 */
// @WebServlet(name="/ServletQiniu",urlPatterns="/ServletQiniu")
public class ServletQiniu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyQiniu qiniu = new MyQiniu();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletQiniu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		upForm(response);
	}

	public void upForm(HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html;charset=utf-8");
		String rs = "";
		rs = qiniu.upForm();
		out.print(rs);
	}

}
