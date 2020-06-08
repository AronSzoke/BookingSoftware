package hu.ak_akademia.shc.entities;

import java.sql.Date;
import java.time.LocalDate;

public class User {

	private final Integer userId;
	private final String userName;
	private final String userPassword;
	private final String userType;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final LocalDate dateOfBirth;

	private User(Builder builder) {
		this.userId = builder.userId;
		this.userName = builder.userName;
		this.userPassword = builder.userPassword;
		this.userType = builder.userType;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.dateOfBirth = builder.dateOfBirth;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserType() {
		return userType;
	}

	public String getEmail() {
		return email;
	}

	public Date getDateOfBirth() {
		return Date.valueOf(dateOfBirth.toString());
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer userId;
		private String userName;
		private String userPassword;
		private String userType;
		private String firstName;
		private String lastName;
		private String email;
		private LocalDate dateOfBirth;

		private Builder() {
		}

		public Builder withUserId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder withUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder withPassword(String userPassword) {
			this.userPassword = userPassword;
			return this;
		}

		public Builder withUserType(String userType) {
			this.userType = userType;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("User [userId=");
		builder2.append(userId);
		builder2.append(", userName=");
		builder2.append(userName);
		builder2.append(", userPassword=");
		builder2.append(userPassword);
		builder2.append(", userType=");
		builder2.append(userType);
		builder2.append(", firstName=");
		builder2.append(firstName);
		builder2.append(", lastName=");
		builder2.append(lastName);
		builder2.append(", email=");
		builder2.append(email);
		builder2.append(", dateOfBirth=");
		builder2.append(dateOfBirth);
		builder2.append("]");
		return builder2.toString();
	}

}
