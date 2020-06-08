package hu.ak_akademia.shc.servlets.search.validator;

import java.util.Collections;
import java.util.Set;

public class AddressValidator implements SearchValidator {

	private String address;
	private static final Set<String> CITIES = Collections.unmodifiableSet(Set.of("BUDAPEST", "TIHANY"));

	public AddressValidator(String address) {
		this.address = address;
	}

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (address == null || address.isEmpty()) {
			result.addErrorMessage("This is a required field!");
			return result;
		}
		if (!CITIES.contains(address.trim()
				.toUpperCase())) {
			result.addErrorMessage("The following city is not availabe!");
		}
		return result;

	}

}
