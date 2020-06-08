package hu.ak_akademia.shc.servlets.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.ReservationToReviewDao;
import hu.ak_akademia.shc.entities.ReservationToReview;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.by_id.UserByIdPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.ReservationToReviewResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.select.SelectActiveReservationsInThePastSqlBuilder;

public class CollectPastActiveReservationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationToReviewDao dao = new ReservationToReviewDao();

		User user = (User) request.getSession()
				.getAttribute("loggedInUser");

		List<ReservationToReview> reservationsToReview = dao.retrieve(new SelectActiveReservationsInThePastSqlBuilder(), new UserByIdPreparedStatementWriter(List.of(user)), new ReservationToReviewResultSetReader());
		request.setAttribute("reservationsToReview", reservationsToReview);
		request.getRequestDispatcher("review-info.jsp").forward(request, response);
	}
}
