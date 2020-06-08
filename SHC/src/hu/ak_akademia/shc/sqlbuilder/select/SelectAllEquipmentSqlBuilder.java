package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectAllEquipmentSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM equipment";
	}

}
