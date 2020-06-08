package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetReader<E> {

	List<E> read(ResultSet resultSet) throws SQLException;
}
