package hu.ak_akademia.shc.entities;

public class Bed {

	private final Integer bedId;
	private final String bedType;
	private final Integer bedSpace;

	private Bed(Builder builder) {
		this.bedId = builder.bedId;
		this.bedType = builder.bedType;
		this.bedSpace = builder.bedSpace;
	}

	public Integer getBedId() {
		return bedId;
	}

	public String getBedType() {
		return bedType;
	}

	public Integer getBedSpace() {
		return bedSpace;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer bedId;
		private String bedType;
		private Integer bedSpace;

		private Builder() {
		}

		public Builder withBedId(Integer bedId) {
			this.bedId = bedId;
			return this;
		}

		public Builder withBedType(String bedType) {
			this.bedType = bedType;
			return this;
		}

		public Builder withBedSpace(Integer bedSpace) {
			this.bedSpace = bedSpace;
			return this;
		}

		public Bed build() {
			return new Bed(this);
		}
	}
}
