package hu.ak_akademia.shc.servlets.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.EquipmentDao;
import hu.ak_akademia.shc.db.RoomDao;
import hu.ak_akademia.shc.db.ServicesDao;
import hu.ak_akademia.shc.entities.Equipment;
import hu.ak_akademia.shc.entities.Room;
import hu.ak_akademia.shc.entities.Services;
import hu.ak_akademia.shc.preparedstatementwriter.by_id.RoomIdPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.EquipmentResultSetReader;
import hu.ak_akademia.shc.resultsetreader.RoomResultSetReader;
import hu.ak_akademia.shc.resultsetreader.ServicesResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.select.SelectEquipmentByRoomIdSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectRoomByIdSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectServiceNamesByRoomId;

public class RoomDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomId");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		Room room = Room.builder()
				.withRoomId(Integer.parseInt(roomId))
				.build();

		ServicesDao servicesDao = new ServicesDao();
		List<Services> services = servicesDao.retrieve(new SelectServiceNamesByRoomId(), new RoomIdPreparedStatementWriter(List.of(room)), new ServicesResultSetReader());
		request.setAttribute("services", services);

		EquipmentDao equipmentDao = new EquipmentDao();
		List<Equipment> equipments = equipmentDao.retrieve(new SelectEquipmentByRoomIdSqlBuilder(), new RoomIdPreparedStatementWriter(List.of(room)), new EquipmentResultSetReader());
		request.setAttribute("equipments", equipments);

		RoomDao roomDao = new RoomDao();
		List<Room> rooms = roomDao.retrieve(new SelectRoomByIdSqlBuilder(), new RoomIdPreparedStatementWriter(List.of(room)), new RoomResultSetReader());
		request.setAttribute("room", rooms.get(0));
		request.setAttribute("dateFrom", dateFrom);
		request.setAttribute("dateTo", dateTo);

		request.getRequestDispatcher("roomdetails.jsp")
				.forward(request, response);
	}
}
