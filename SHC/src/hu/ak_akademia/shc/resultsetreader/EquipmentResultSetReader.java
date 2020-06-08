package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Equipment;

public class EquipmentResultSetReader implements ResultSetReader<Equipment> {

	@Override
	public List<Equipment> read(ResultSet resultSet) throws SQLException {
		List<Equipment> equipments = new ArrayList<>();
		while (resultSet.next()) {
			Integer equipmentId = resultSet.getInt("equipment_id");
			String name = resultSet.getString("name");

			Equipment equipment = Equipment.builder()
					.withEquipmentId(equipmentId)
					.withName(name)
					.build();

			equipments.add(equipment);
		}
		return equipments;
	}

}
