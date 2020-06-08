package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Bed;

public class BedResultSetReader implements ResultSetReader<Bed> {

	@Override
	public List<Bed> read(ResultSet resultSet) throws SQLException {
		List<Bed> beds = new ArrayList<>();
		while (resultSet.next()) {
			Integer bedId = resultSet.getInt("bed_id");
			String bedType = resultSet.getString("bed_type");
			Integer bedSpace = resultSet.getInt("bed_space");

			Bed bed = Bed.builder()
					.withBedId(bedId)
					.withBedType(bedType)
					.withBedSpace(bedSpace)
					.build();

			beds.add(bed);
		}
		return beds;
	}

}
