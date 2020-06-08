package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertBedSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO bed (bed_id, bed_type, bed_space) VALUES (bed_seq.nextval, ?, ?)";
	}

}
