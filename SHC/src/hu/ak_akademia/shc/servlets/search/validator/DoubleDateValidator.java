package hu.ak_akademia.shc.servlets.search.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DoubleDateValidator implements SearchValidator {

	private LocalDate dateFrom;
	private LocalDate dateTo;

	public DoubleDateValidator(LocalDate dateFrom, LocalDate dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		long numberOfNights = ChronoUnit.DAYS.between(dateFrom, dateTo);
		if (dateFrom.isAfter(dateTo)) {
			result.addErrorMessage("Date From cannot be after Date To!");
		}
		else if (numberOfNights <= 0) {
			result.addErrorMessage("Date range too small!");
		} else if (numberOfNights > 30) {
			result.addErrorMessage("Date range too large!");
		}
		return result;
	}

}
