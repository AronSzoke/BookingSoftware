package hu.ak_akademia.shc.entities;

public class Services {

	private final Integer serviceId;
	private final String serviceName;
	private final Double price;

	private Services(Builder builder) {
		this.serviceId = builder.serviceId;
		this.serviceName = builder.serviceName;
		this.price = builder.price;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public Double getPrice() {
		return price;
	}

	public static final class Builder {
		private Integer serviceId;
		private String serviceName;
		private Double price;

		private Builder() {
		}

		public Builder withServiceId(Integer serviceId) {
			this.serviceId = serviceId;
			return this;
		}

		public Builder withServiceName(String serviceName) {
			this.serviceName = serviceName;
			return this;
		}

		public Builder withPrice(Double price) {
			this.price = price;
			return this;
		}

		public Services build() {
			return new Services(this);
		}
	}

}
