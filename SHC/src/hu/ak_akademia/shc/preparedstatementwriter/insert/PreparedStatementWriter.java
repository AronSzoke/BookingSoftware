package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementWriter<E> {

	void write(PreparedStatement statement) throws SQLException;
}
