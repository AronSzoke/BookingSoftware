package hu.ak_akademia.shc.preparedstatementwriter.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectEmptyPreparedStatementWriter<E> implements PreparedStatementWriter<E> {

	@Override
	public void write(PreparedStatement statement) throws SQLException {
	}

}
