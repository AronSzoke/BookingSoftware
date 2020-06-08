package hu.ak_akademia.shc.preparedstatementwriter.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.entities.SearchParameters;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectFreeRoomsPreparedStatementWriter implements PreparedStatementWriter<SearchParameters> {

	private final String dateFrom;
	private final String dateTo;

	public SelectFreeRoomsPreparedStatementWriter(String dateFrom, String dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		int i = 1;
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);

	}

}
