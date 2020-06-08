package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Services;

public class ServicesResultSetReader implements ResultSetReader<Services> {

	@Override
	public List<Services> read(ResultSet resultSet) throws SQLException {
		List<Services> services = new ArrayList<>();
			while (resultSet.next()) {
				Integer serviceId = resultSet.getInt("service_id");
				String serviceName = resultSet.getString("service_name");
				Double price = resultSet.getDouble("price");

				Services service = Services.builder()
						.withServiceId(serviceId)
						.withServiceName(serviceName)
						.withPrice(price)
						.build();

				services.add(service);

			}
		return services;
	}

}
