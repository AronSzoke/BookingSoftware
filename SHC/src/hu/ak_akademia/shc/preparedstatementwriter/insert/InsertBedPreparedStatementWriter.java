package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Bed;

public class InsertBedPreparedStatementWriter implements PreparedStatementWriter<Bed> {

	private List<Bed> beds;

	public InsertBedPreparedStatementWriter(List<Bed> beds) {
		this.beds = beds;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Bed bed : beds) {
			try {
				statement.setString(1, bed.getBedType());
				statement.setInt(2, bed.getBedSpace());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set Bed parameters");
			}
		}
	}

}
