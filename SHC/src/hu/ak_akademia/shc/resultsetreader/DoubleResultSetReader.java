package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoubleResultSetReader implements ResultSetReader<Double> {

	private final String columnName;

	public DoubleResultSetReader(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public List<Double> read(ResultSet resultSet) throws SQLException {
		List<Double> results = new ArrayList<>();
		while (resultSet.next()) {
			Double result = resultSet.getDouble(columnName);
			results.add(result);
		}
		return results;
	}

}
