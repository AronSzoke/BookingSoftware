package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Services;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class ServicesIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<Services> services;

	public ServicesIdPreparedStatementWriter(List<Services> services) {
		this.services = services;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Services service : services) {
			statement.setInt(1, service.getServiceId());
		}

	}

}
