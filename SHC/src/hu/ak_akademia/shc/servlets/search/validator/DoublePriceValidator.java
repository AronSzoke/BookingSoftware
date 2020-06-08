package hu.ak_akademia.shc.servlets.search.validator;

public class DoublePriceValidator implements SearchValidator {

	private Integer priceFrom;
	private Integer priceTo;

	public DoublePriceValidator(Integer priceFrom, Integer priceTo) {
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		boolean validPriceRange = priceFrom <= priceTo;
		if (!validPriceRange) {
			result.addErrorMessage("Invalid price search!");
		}
		return result;
	}

	public static void main(String[] args) {
		new DoublePriceValidator(1, 1000).validate();

	}
}
