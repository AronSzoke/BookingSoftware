package hu.ak_akademia.shc.entities;

public class Equipment {

	private final Integer equipmentId;
	private final String name;

	private Equipment(Builder builder) {
		this.equipmentId = builder.equipmentId;
		this.name = builder.name;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer equipmentId;
		private String name;

		private Builder() {
		}

		public Builder withEquipmentId(Integer equipmentId) {
			this.equipmentId = equipmentId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Equipment build() {
			return new Equipment(this);
		}
	}

}