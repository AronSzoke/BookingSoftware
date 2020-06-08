package hu.ak_akademia.shc.servlets.search;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SearchRoomWithPricePreparedStatementWriter implements PreparedStatementWriter {

	private int priceFrom;
	private int priceTo;

	public SearchRoomWithPricePreparedStatementWriter(int priceFrom, int priceTo) {
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setDouble(1, priceFrom);
		statement.setDouble(2, priceTo);
	}

}
