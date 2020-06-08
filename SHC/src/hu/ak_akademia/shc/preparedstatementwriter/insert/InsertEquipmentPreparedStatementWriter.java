package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Equipment;

public class InsertEquipmentPreparedStatementWriter implements PreparedStatementWriter {

	private List<Equipment> equipments;

	public InsertEquipmentPreparedStatementWriter(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Equipment equipment : equipments) {
			try {
				statement.setString(1, equipment.getName());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set equipment parameters");
			}
		}
	}

}
