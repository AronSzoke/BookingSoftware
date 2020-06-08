package hu.ak_akademia.shc.servlets.create;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.UserDao;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertUserPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.UserResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertUserSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectUserByUserNamePreparedStatementWriter;
import hu.ak_akademia.shc.sqlbuilder.select.SelectUserByUserNameSqlBuilder;

public class CreateUser extends HttpServlet {

	private Integer numberOfUsers = 1;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		User user = User.builder()
				.withUserId(numberOfUsers++)
				.withUserName(userName)
				.withPassword(password)
				.withUserType(userType)
				.withFirstName(firstName)
				.withLastName(lastName)
				.withEmail(email)
				.withDateOfBirth(LocalDate.parse(dateOfBirth, formatter))
				.build();

		UserDao dao = new UserDao();
		SelectUserByUserNameSqlBuilder selectSqlBuilder = new SelectUserByUserNameSqlBuilder();
		SelectUserByUserNamePreparedStatementWriter selectPreparedStatementWriter = new SelectUserByUserNamePreparedStatementWriter(user);

		UserResultSetReader resultSetReader = new UserResultSetReader();
		List<User> retrievedUser = dao.retrieve(selectSqlBuilder, selectPreparedStatementWriter, resultSetReader);
		if (retrievedUser.isEmpty()) {
			InsertUserSqlBuilder insertUserSqlBuilder = new InsertUserSqlBuilder();
			InsertUserPreparedStatementWriter insertUserPreparedStatementWriter = new InsertUserPreparedStatementWriter(List.of(user));
			dao.create(insertUserSqlBuilder, insertUserPreparedStatementWriter);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			request.setAttribute("errorMessage", "Username already exists, choose another one!");
			request.getRequestDispatcher("registration.jsp")
					.forward(request, response);
		}
	}

}
