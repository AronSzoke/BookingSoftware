package hu.ak_akademia.shc.preparedstatementwriter.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import hu.ak_akademia.shc.entities.SearchParameters;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectSearchResultPreparedStatementWriter implements PreparedStatementWriter<SearchParameters> {

	private final SearchParameters params;

	public SelectSearchResultPreparedStatementWriter(SearchParameters params) {
		this.params = params;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		int i = 1;
		statement.setString(i++, params.getAddress());
		if (params.getPriceFrom() != null) {
			statement.setInt(i++, params.getPriceFrom());
		}
		if (params.getPriceTo() != null) {
			statement.setInt(i++, params.getPriceTo());
		}
		statement.setInt(i++, params.getAdults());
		String dateFrom = params.getDateFrom()
				.format(DateTimeFormatter.ISO_LOCAL_DATE);
		String dateTo = params.getDateTo()
				.format(DateTimeFormatter.ISO_LOCAL_DATE);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);

	}

}
