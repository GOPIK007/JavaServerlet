

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDBServlet
 */
@WebServlet("/ViewDBServlet")
public class ViewDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		DBHelper helper = null;
		try {
			helper = new DBHelper();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<UserDetails> users = null;
		try {
			users  = helper.readDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.append("<html>" +
				"<body>" +
				"<table>");
		
		for (UserDetails x: users){
			String res_name = "<td>" + x.userName + "</td>";
			String res_phone = "<td>" + x.phNo + "</td>";
			String res_mail= "<td>" + x.mailId + "</td>";
			pw.append("<tr>"+ res_name + res_phone + res_mail + "</tr>");
		}
		pw.append("</table>" +
				"</body>" +
				"</html>");
		/*
		String data_responce = "<html>" +
				"<body>" +
				"<table>" +
				"<tr>" +
					"<td> Name </td>" +
					"<td> Phone </td>" +
					"<td> Email </td>" +
				"</tr>" +
				"</table>" +
				"</body>" +
				"</html>";
		*/
			//pw.write(data_responce);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
