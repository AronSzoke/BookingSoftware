package hu.ak_akademia.shc.servlets.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.ReservationDao;
import hu.ak_akademia.shc.sqlbuilder.update.SetReservationStatusToDeletedSqlBuilder;

public class CancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDao dao = new ReservationDao();
		Integer reservationId = Integer.parseInt(request.getParameter("reservationId"));
		dao.update(new SetReservationStatusToDeletedSqlBuilder(), new SetReservationStatusToDeletedPreparedStatementWriter(reservationId));
		response.sendRedirect(request.getContextPath() + "/admin/home.jsp?cancellationMessage=true");
	}
}
