package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StringResultSetReader implements ResultSetReader<String> {

	private final String columnName;

	public StringResultSetReader(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public List<String> read(ResultSet resultSet) throws SQLException {
		List<String> results = new ArrayList<>();
			while (resultSet.next()) {
				String result = resultSet.getString(columnName);
				results.add(result);
			}
		return results;
	}

}
