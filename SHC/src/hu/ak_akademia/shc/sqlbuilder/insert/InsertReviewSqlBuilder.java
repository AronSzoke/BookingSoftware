package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertReviewSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO review ( ");
		sql.append("    review_id, ");
		sql.append("    reservation_id, ");
		sql.append("    review_score, ");
		sql.append("    review_text ");
		sql.append(") VALUES ( ");
		sql.append("    review_seq.NEXTVAL, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ? ");
		sql.append(") ");
		return sql.toString();
	}

}
