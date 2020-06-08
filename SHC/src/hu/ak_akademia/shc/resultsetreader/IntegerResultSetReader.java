package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntegerResultSetReader implements ResultSetReader<Integer> {

	private final String columnName;

	public IntegerResultSetReader(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public List<Integer> read(ResultSet resultSet) throws SQLException {
		List<Integer> results = new ArrayList<>();
		while (resultSet.next()) {
			Integer result = resultSet.getInt(columnName);
			results.add(result);
		}
		return results;
	}

}
