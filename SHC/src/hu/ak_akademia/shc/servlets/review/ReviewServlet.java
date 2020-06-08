package hu.ak_akademia.shc.servlets.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.DoubleDao;
import hu.ak_akademia.shc.db.HotelDao;
import hu.ak_akademia.shc.db.ReviewDao;
import hu.ak_akademia.shc.entities.Hotel;
import hu.ak_akademia.shc.entities.Review;
import hu.ak_akademia.shc.resultsetreader.DoubleResultSetReader;
import hu.ak_akademia.shc.resultsetreader.HotelResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertReviewSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectCurrentAverageReviewScoreForHotelSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectHotelByReservationIdSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.update.UpdateReviewForHotelSqlBuilder;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDao reviewDao = new ReviewDao();
		Integer reservationId = Integer.parseInt(request.getParameter("reservationId"));
		Integer reviewScore = Integer.parseInt(request.getParameter("reviewScore"));
		String reviewText = request.getParameter("reviewText");
		Review review = Review.builder()
				.withReservationId(reservationId)
				.withReviewScore(reviewScore)
				.withReviewText(reviewText)
				.build();
		reviewDao.create(new InsertReviewSqlBuilder(), new InsertReviewPreparedStatementWriter(List.of(review)));
		HotelDao hotelDao = new HotelDao();
		List<Hotel> specificHotelToBeUpdated = hotelDao.retrieve(new SelectHotelByReservationIdSqlBuilder(), new SelectHotelByReservationIdPreparedStatementWriter(reservationId), new HotelResultSetReader());
		DoubleDao doubleDao = new DoubleDao();
		List<Double> currerntReviewScore = doubleDao.retrieve(new SelectCurrentAverageReviewScoreForHotelSqlBuilder(), new SelectCurrentAverageReviewScoreForHotelPreparedStatementWriter(specificHotelToBeUpdated.get(0)
				.getHotelId()), new DoubleResultSetReader("review_score"));

		hotelDao.update(new UpdateReviewForHotelSqlBuilder(), new UpdaterReviewForHotelPreparedStatementWriter(currerntReviewScore.get(0), specificHotelToBeUpdated.get(0)
				.getHotelId()));

		response.sendRedirect("home.jsp?message=Thanks for your feedback");
	}
}
