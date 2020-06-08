package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertEquipmentSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO equipment (equipment_id, name) VALUES (equipment_seq.nextval, ?)";
	}

}
