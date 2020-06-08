package hu.ak_akademia.shc.servlets.create;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.ReservationDao;
import hu.ak_akademia.shc.entities.Reservation;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertReservationPreparedStatementWriter;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertUserSqlBuilder;

public class CreateReservation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String dateFrom = request.getParameter("date_from");
		String dateTo = request.getParameter("date_to");
		String totalPrice = request.getParameter("total_price");
		String status = request.getParameter("status");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Reservation reservation = Reservation.builder()
				.withUserId(Integer.parseInt(userId))
				.withDateFrom(LocalDate.parse(dateFrom, formatter))
				.withDateTo(LocalDate.parse(dateTo, formatter))
				.withTotalPrice(Double.parseDouble(totalPrice))
				.withStatus(status)
				.build();

		InsertUserSqlBuilder sqlBuilder = new InsertUserSqlBuilder();
		InsertReservationPreparedStatementWriter writer = new InsertReservationPreparedStatementWriter(List.of(reservation));
		ReservationDao dao = new ReservationDao();
		dao.create(sqlBuilder, writer);
	}

}
