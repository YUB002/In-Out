package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.In_OutDAO;
import dto.In_OutDTO;


@WebServlet("*.message")
public class In_OutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String writer = request.getParameter("writer");
		String message = request.getParameter("message");
		String uri=request.getRequestURI();
		try {
			In_OutDAO dao = In_OutDAO.getInstance();
			if(uri.equals("/input.message")) {

				dao.insert(writer, message);
				response.sendRedirect("index.html");

			}else if(uri.equals("/output.message")){

				List<In_OutDTO>list=dao.selectAll();
				if(list.size()>0) {
					for(In_OutDTO dto : list) {
						System.out.println(dto.getSeq()+"\t"+dto.getWriter()+"\t"+dto.getContents()+"\t"+dto.getWrite_date());
					}
				}
				System.out.println("출력완료");
				request.setAttribute("list", list);
				request.getRequestDispatcher("/OutputForm.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

