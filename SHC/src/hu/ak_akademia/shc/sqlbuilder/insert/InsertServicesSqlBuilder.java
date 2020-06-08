package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertServicesSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO services (service_id, service_name, price) VALUES (services_seq.nextval, ?, ?)";
	}

}
