package feedback;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addFeedbackServlet")
public class addFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String comment=request.getParameter("comment");
		
boolean isTrue;
		
		isTrue=feedbackDBUtil.addFeedback(name,email,comment);
		
		if(isTrue==true) {
			
			RequestDispatcher dis= request.getRequestDispatcher("feedback.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2= request.getRequestDispatcher("unSuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
