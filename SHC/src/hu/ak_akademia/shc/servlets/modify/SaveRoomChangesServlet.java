package hu.ak_akademia.shc.servlets.modify;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.RoomDao;
import hu.ak_akademia.shc.sqlbuilder.update.UpdateRoomPriceSqlBuilder;

public class SaveRoomChangesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDao roomDao = new RoomDao(false);
		roomDao.open();
		Map<Integer, Integer> roomIdToRoomPriceMap = new HashMap<>();
		Map<String, String[]> roomChanges = request.getParameterMap();
		Set<Entry<String, String[]>> validRoomChanges = roomChanges.entrySet()
				.stream()
				.filter(entry -> entry.getKey()
						.startsWith("roomPrice"))
				.collect(Collectors.toSet());
		try {
			for (Entry<String, String[]> validRoomChange : validRoomChanges) {
				Integer roomId = Integer.parseInt(validRoomChange.getKey()
						.replace("roomPrice_", ""));
				Integer newRoomPrice = Integer.parseInt(validRoomChange.getValue()[0].replace(",", ""));
				roomIdToRoomPriceMap.put(roomId, newRoomPrice);

			}
			roomDao.updateBatch(new UpdateRoomPriceSqlBuilder(), new UpdateRoomPricePreparedStatementWriter(roomIdToRoomPriceMap));
			roomDao.close();
			response.sendRedirect(request.getContextPath() + "/admin/collectModificationInfo?success=true");
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/collectModificationInfo?saveFailed=true");
		}
	}
}
