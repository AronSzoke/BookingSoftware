package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Bed;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class BedIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<Bed> beds;

	public BedIdPreparedStatementWriter(List<Bed> beds) {
		this.beds = beds;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Bed bed : beds) {
			statement.setInt(1, bed.getBedId());
		}
	}

}
