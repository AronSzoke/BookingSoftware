package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Services;

public class InsertServicesPreparedStatementWriter implements PreparedStatementWriter<Services> {

	private List<Services> services;

	public InsertServicesPreparedStatementWriter(List<Services> services) {
		this.services = services;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Services service : services) {
			try {
				statement.setString(1, service.getServiceName());
				statement.setDouble(2, service.getPrice());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set Services parameters");
			}
		}
	}

}
