package hu.ak_akademia.shc.servlets.search.validator;

public class SinglePriceValidator implements SearchValidator {

	private String price;

	public SinglePriceValidator(String price) {
		this.price = price;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		boolean isDigitOnly = price.matches("[0-9]+");
		if (price == null || price.isEmpty()) {
			return result;
		}
		if (!isDigitOnly) {
			result.addErrorMessage("The price contains other characters than digits!");
		}
		if (Integer.MAX_VALUE < Long.parseLong(price)) {
			result.addErrorMessage("Too large price!");
		}
		return result;
	}
}
