package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.HotelToService;

public class InsertHotelToServicePreparedStatementWriter implements PreparedStatementWriter {

	private List<HotelToService> hotelToServices;

	public InsertHotelToServicePreparedStatementWriter(List<HotelToService> hotelToServices) {
		this.hotelToServices = hotelToServices;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (HotelToService hotelToService : hotelToServices) {
			try {
				statement.setInt(1, hotelToService.getHotelId());
				statement.setInt(2, hotelToService.getServiceId());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set hotel_to_service parameters");
			}
		}
	}

}
