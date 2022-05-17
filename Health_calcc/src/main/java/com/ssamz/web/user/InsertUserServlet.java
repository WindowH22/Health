package com.ssamz.web.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;

@WebServlet(urlPatterns = "/insertUser.do", 
			initParams = @WebInitParam(name = "boardEncoding", value = "UTF-8"))
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//반드시 사용자 입력정보를 추출하기 전에 인코딩 설정을 추가한다.

		ServletContext context = getServletContext();
		encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + password);
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);

		// 2. DB 연동 처리 (추출한 회원 정보를 USERS 테이블에 등록하는 코드를 완성하시오. 
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setGender(gender);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(vo);

		// 3. 화면 이동
		response.sendRedirect("login.html");
		
		// 4.
		
	}
	
	
	
}
