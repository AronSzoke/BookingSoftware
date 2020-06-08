package hu.ak_akademia.shc.servlets.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.UserDao;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.resultsetreader.UserResultSetReader;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");

		User user = User.builder()
				.withUserName(userName)
				.withPassword(userPassword)
				.build();

		SelectUserByUserNameAndPasswordSqlBuilder sqlBuilder = new SelectUserByUserNameAndPasswordSqlBuilder();
		SelectUserByUserNameAndPasswordPreparedStatementWriter writer = new SelectUserByUserNameAndPasswordPreparedStatementWriter(user);
		UserResultSetReader resultSetReader = new UserResultSetReader();
		UserDao dao = new UserDao();
		List<User> resultSet = dao.retrieve(sqlBuilder, writer, resultSetReader);

		if (resultSet.isEmpty()) {
			request.setAttribute("errorMessage", "Invalid username or password !");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			user = resultSet.get(0);
			request.getSession().setAttribute("alma", user.getUserType());
			request.getSession()
					.setAttribute("loggedInUser", user);
			response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
		}
	}

}
