package hu.ak_akademia.shc.servlets.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.ValidReservationDao;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.entities.ValidReservation;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectValidReservationForUserPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.ValidReservationResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.select.SelectValidReservationForUserSqlBuilder;

public class CollectCancellationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidReservationDao dao = new ValidReservationDao();
		User loggedInUser = (User) request.getSession()
				.getAttribute("loggedInUser");
		List<ValidReservation> validReservations = dao.retrieve(new SelectValidReservationForUserSqlBuilder(), new SelectValidReservationForUserPreparedStatementWriter(loggedInUser.getUserId()), new ValidReservationResultSetReader());
		request.setAttribute("validReservations", validReservations);
		request.getRequestDispatcher("reservation-cancellation.jsp")
				.forward(request, response);
	}
}
