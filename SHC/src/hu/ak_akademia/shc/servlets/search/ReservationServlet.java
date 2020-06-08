package hu.ak_akademia.shc.servlets.search;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.IntegerDao;
import hu.ak_akademia.shc.db.ReservationDao;
import hu.ak_akademia.shc.db.RoomDao;
import hu.ak_akademia.shc.db.RoomToReservationDao;
import hu.ak_akademia.shc.entities.Reservation;
import hu.ak_akademia.shc.entities.Room;
import hu.ak_akademia.shc.entities.RoomToReservation;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertReservationPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertRoomToReservationPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectEmptyPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectFreeRoomsPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.IntegerResultSetReader;
import hu.ak_akademia.shc.resultsetreader.RoomResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertReservationWithIdSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertRoomToReservationSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectFreeRoomsBetweenDatesSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectNextReservationIdSqlBuilder;

public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomId");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		Room roomToBeReserved = Room.builder()
				.withRoomId(Integer.parseInt(roomId))
				.build();

		RoomDao dao = new RoomDao();
		Set<Room> freeRoomsId = new HashSet<>(dao.retrieve(new SelectFreeRoomsBetweenDatesSqlBuilder(), new SelectFreeRoomsPreparedStatementWriter(dateFrom, dateTo), new RoomResultSetReader()));

		if (freeRoomsId.contains(roomToBeReserved)) {
			ReservationDao reservationDao = new ReservationDao();
			User loggedInUser = (User) request.getSession()
					.getAttribute("loggedInUser");
			LocalDate localDateTo = LocalDate.parse(dateTo);
			LocalDate localDateFrom = LocalDate.parse(dateFrom);
			Integer reservationId = new IntegerDao().retrieve(new SelectNextReservationIdSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new IntegerResultSetReader("reservation_id"))
					.get(0);
			Reservation reservation = Reservation.builder()
					.withUserId(loggedInUser.getUserId())
					.withDateFrom(localDateFrom)
					.withDateTo(localDateTo)
					.withTotalPrice((double) (ChronoUnit.DAYS.between(localDateFrom, localDateTo) * freeRoomsId.stream()
							.filter(room -> room.getRoomId()
									.equals(Integer.parseInt(roomId)))
							.collect(Collectors.toList())
							.get(0)
							.getRoomPrice()))
					.withReservationId(reservationId)
					.build();
			reservationDao.create(new InsertReservationWithIdSqlBuilder(), new InsertReservationPreparedStatementWriter(List.of(reservation)));

			RoomToReservationDao roomToReservationDao = new RoomToReservationDao();
			RoomToReservation roomToReservation = RoomToReservation.builder()
					.withRoomId(Integer.parseInt(roomId))
					.withReservationId(reservation.getReservationId())
					.build();
			roomToReservationDao.create(new InsertRoomToReservationSqlBuilder(), new InsertRoomToReservationPreparedStatementWriter(List.of(roomToReservation)));
			DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("MMM dd, yyyy");
			request.setAttribute("reservationTime", LocalDate.now()
					.format(datePattern));
			String formattedDateFrom = reservation.getDateFrom()
					.format(datePattern);
			request.setAttribute("dateFrom", formattedDateFrom);
			request.setAttribute("reservationId", reservationId);
			request.getRequestDispatcher("reservation-details.jsp")
					.forward(request, response);
		} else {
			response.sendRedirect("room-not-available.jsp");
		}
	}
}
