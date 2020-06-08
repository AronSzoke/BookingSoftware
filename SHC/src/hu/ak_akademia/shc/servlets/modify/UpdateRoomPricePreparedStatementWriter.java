package hu.ak_akademia.shc.servlets.modify;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class UpdateRoomPricePreparedStatementWriter implements PreparedStatementWriter<Map<Integer, Integer>> {

	private Map<Integer, Integer> roomIdToRoomPriceMap;

	public UpdateRoomPricePreparedStatementWriter(Map<Integer, Integer> roomIdToRoomPriceMap) {
		this.roomIdToRoomPriceMap = roomIdToRoomPriceMap;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		Set<Entry<Integer, Integer>> entrySet = roomIdToRoomPriceMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			try {
				statement.setInt(1, entry.getValue());
				statement.setInt(2, entry.getKey());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set room price");
			}
		}
	}

}
