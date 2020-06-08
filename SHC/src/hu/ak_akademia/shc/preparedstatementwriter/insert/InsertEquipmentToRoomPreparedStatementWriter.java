package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.EquipmentToRoom;

public class InsertEquipmentToRoomPreparedStatementWriter implements PreparedStatementWriter {

	private List<EquipmentToRoom> equipmentToRooms;

	public InsertEquipmentToRoomPreparedStatementWriter(List<EquipmentToRoom> equipmentToRooms) {
		this.equipmentToRooms = equipmentToRooms;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (EquipmentToRoom equipmentToRoom : equipmentToRooms) {
			try {
				statement.setInt(1, equipmentToRoom.getEquipmentId());
				statement.setInt(2, equipmentToRoom.getRoomId());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set equipment_to_room parameters");
			}
		}
	}

}
