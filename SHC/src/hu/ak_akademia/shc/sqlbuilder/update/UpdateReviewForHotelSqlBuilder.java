package hu.ak_akademia.shc.sqlbuilder.update;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class UpdateReviewForHotelSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE hotel SET review = ? WHERE hotel_id = ? ";
	}

}
