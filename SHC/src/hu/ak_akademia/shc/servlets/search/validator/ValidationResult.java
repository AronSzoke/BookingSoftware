package hu.ak_akademia.shc.servlets.search.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

	private boolean successful = true;
	private List<String> errorMessages = new ArrayList<>();

	public boolean isSuccessful() {
		return successful;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void addErrorMessage(String message) {
		errorMessages.add(message);
		successful = false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationResult [successful=");
		builder.append(successful);
		builder.append(", errorMessages=");
		builder.append(errorMessages);
		builder.append("]");
		return builder.toString();
	}

}
