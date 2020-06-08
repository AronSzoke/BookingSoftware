package hu.ak_akademia.shc.servlets.search.validator;

public class NumberOfGuestsValidator implements SearchValidator {

	private String numberOfGuests;

	public NumberOfGuestsValidator(String numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (numberOfGuests == null || numberOfGuests.isEmpty()) {
			result.addErrorMessage("This field is required!");
			return result;
		}
		try {
			int numberOfAdults = Integer.parseInt(numberOfGuests);
			if (numberOfAdults < 1 || numberOfAdults > 4) {
				result.addErrorMessage("Invalid number of guests");
			}
		} catch (NumberFormatException e) {
			result.addErrorMessage("Invalid number format!");
		}
		return result;
	}
}
