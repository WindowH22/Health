package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 응답화면 구성
//		//출력 스트림을 얻기 전에 항상 인코딩을 처리한다.
//		response.setContentType("text/html; charset=UTF-8");
//		
//		//HTTP 응답 프로토콜 Message-Body와 연결된 출력스트림을 획득한다.
//		PrintWriter out = response.getWriter();
		
		if(user != null) { // 아이디를 이용한 검색 결과가 있는 경우
			if(user.getPassword().equals(vo.getPassword())) {
				response.sendRedirect("index.html");
				System.out.println("로그인  성공");
			}else {
				response.sendRedirect("login.html");
				System.out.println("값이 다름.");
			}	
		}else { //아이디에 해당하는 회원이 없는 경우
			response.sendRedirect("login.html");
			System.out.println("회원이 없음");
		}
		
	}
	
	
	
}
