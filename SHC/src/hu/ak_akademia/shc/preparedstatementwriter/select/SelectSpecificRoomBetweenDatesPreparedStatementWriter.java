package hu.ak_akademia.shc.preparedstatementwriter.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectSpecificRoomBetweenDatesPreparedStatementWriter<E> implements PreparedStatementWriter<E> {

	private final Integer roomId;
	private final String dateFrom;
	private final String dateTo;

	public SelectSpecificRoomBetweenDatesPreparedStatementWriter(Integer roomId, String dateFrom, String dateTo) {
		this.roomId = roomId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		int i = 1;
		statement.setInt(i++, roomId);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);
		statement.setString(i++, dateFrom);
		statement.setString(i++, dateTo);

	}

}
