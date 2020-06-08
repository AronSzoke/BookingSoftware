package hu.ak_akademia.shc.db;

import java.util.List;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.ResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public interface DataBaseDao<E> {

	void open();

	void close();

	void create(SqlBuilder builder, PreparedStatementWriter writer);

	List<E> retrieve(SqlBuilder builder, PreparedStatementWriter writer, ResultSetReader<E> reader);

	void update(SqlBuilder builder, PreparedStatementWriter writer);

	void updateBatch(SqlBuilder builder, PreparedStatementWriter writer);

	void delete(SqlBuilder builder, PreparedStatementWriter writer);

}
