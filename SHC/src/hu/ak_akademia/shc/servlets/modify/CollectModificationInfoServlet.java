package hu.ak_akademia.shc.servlets.modify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.RoomDao;
import hu.ak_akademia.shc.entities.Room;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectEmptyPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.RoomResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllRoomsSqlBuilder;

public class CollectModificationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDao dao = new RoomDao();
		List<Room> rooms = dao.retrieve(new SelectAllRoomsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new RoomResultSetReader());
		request.setAttribute("rooms", rooms);
		String successValue = request.getParameter("success");
		request.setAttribute("success", successValue);
		String saveFailedValue = request.getParameter("saveFailed");
		request.setAttribute("saveFailed", saveFailedValue);
		request.getRequestDispatcher("room-modification-info.jsp")
				.forward(request, response);
		// response.sendRedirect(request.getContextPath() + "/admin/room-modification-info.jsp");
	}
}
