package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달되는 데이터를 뽑아내서 서비스 객체한테 전달, 회원 정보 조회
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		Member loginUser = new MemberServiceImpl().loginMember(m);
		// 로그인 성공 -> session 영역에 로그인한 회원 정보를 저장. 메인페이지 응답
		// 로그인 실패 -> request 영역에 '로그인 실패'
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",loginUser);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
