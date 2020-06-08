package hu.ak_akademia.shc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.connection.ConnectionFactory;
import hu.ak_akademia.shc.exceptions.ShcRuntimeException;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.ResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public abstract class AbstractDataBaseDao<E> implements DataBaseDao<E> {

	private Connection connection;
	private final boolean manualConnectionManagement;

	public AbstractDataBaseDao() {
		this.manualConnectionManagement = false;
	}

	public AbstractDataBaseDao(boolean manualConnectionManagement) {
		this.manualConnectionManagement = manualConnectionManagement;
	}

	@Override
	public void open() {
		this.connection = ConnectionFactory.open();
	}

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
		}
	}

	@Override
	public void create(SqlBuilder builder, PreparedStatementWriter writer) {
		if (manualConnectionManagement) {
			try (PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeBatch();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		} else {
			try (Connection connection = ConnectionFactory.open(); PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeBatch();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		}
	}

	@Override
	public List<E> retrieve(SqlBuilder builder, PreparedStatementWriter writer, ResultSetReader<E> reader) {
		if (manualConnectionManagement) {
			try (PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				ResultSet resultSet = statement.executeQuery();
				return reader.read(resultSet);
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to retrieve new record from database", e);
			}
		} else {
			try (Connection connection = ConnectionFactory.open(); PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				ResultSet resultSet = statement.executeQuery();
				return reader.read(resultSet);
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to retrieve new record from database", e);
			}
		}
	}

	@Override
	public void update(SqlBuilder builder, PreparedStatementWriter writer) {
		if (manualConnectionManagement) {
			try (PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		} else {
			try (Connection connection = ConnectionFactory.open(); PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		}
	}
	@Override
	public void updateBatch(SqlBuilder builder, PreparedStatementWriter writer) {
		if (manualConnectionManagement) {
			try (PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeBatch();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		} else {
			try (Connection connection = ConnectionFactory.open(); PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeBatch();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to insert new record into database", e);
			}
		}
	}

	@Override
	public void delete(SqlBuilder builder, PreparedStatementWriter writer) {
		if (manualConnectionManagement) {
			try (PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to delete record from database", e);
			}
		} else {
			try (Connection connection = ConnectionFactory.open(); PreparedStatement statement = connection.prepareStatement(builder.build())) {
				writer.write(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new ShcRuntimeException("Unable to delete record from database", e);
			}
		}
	}
}
