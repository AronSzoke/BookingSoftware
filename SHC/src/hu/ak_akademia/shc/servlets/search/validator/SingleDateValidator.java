package hu.ak_akademia.shc.servlets.search.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class SingleDateValidator implements SearchValidator {

	private String date;

	public SingleDateValidator(String date) {
		this.date = date;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (date == null || date.isEmpty()) {
			result.addErrorMessage("This is a required field!");
			return result;
		}
		try {
			LocalDate dateToCheck = LocalDate.parse(date);
			LocalDate today = LocalDate.now();
			LocalDate upperBound = today.plusYears(1L)
					.withMonth(12)
					.withDayOfMonth(31);
			if (!today.isBefore(dateToCheck)) {
				result.addErrorMessage("The cannot be in the past");
			}
			if (dateToCheck.isAfter(upperBound)) {
				result.addErrorMessage("The date provided exceeds the latest possible date!");
			}
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date expression");
			result.addErrorMessage("Invalid date expression");
		}
		return result;
	}

}
