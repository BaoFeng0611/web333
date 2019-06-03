package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Team;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/teamServlet.do")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)||method==null){
			list(request,response);
		}else if("add".equals(method)){
			add(request,response);
		}else if("delete".equals(method)){
			delete(request,response);
		}else if("findOne".equals(method)){
			findOne(request,response);
		}else if("edit".equals(method)){
			edit(request,response);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String age = request.getParameter("age");
		String money = request.getParameter("money");
		Team t = new Team(Integer.parseInt(uid), uname, Integer.parseInt(age), Double.parseDouble(money));
		ServiceFactory.getServiceDAO().Update(t);
		list(request,response);
		
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		Team t = ServiceFactory.getServiceDAO().FindOne(Integer.parseInt(uid));
		request.setAttribute("t", t);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		ServiceFactory.getServiceDAO().Delete(Integer.parseInt(uid));
		list(request,response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String age = request.getParameter("age");
		String money = request.getParameter("money");
		Team t = new Team(null, uname, Integer.parseInt(age), Double.parseDouble(money));
		ServiceFactory.getServiceDAO().Save(t);
		list(request,response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Team> list = ServiceFactory.getServiceDAO().FindAll();
		System.out.println(list.isEmpty());
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
