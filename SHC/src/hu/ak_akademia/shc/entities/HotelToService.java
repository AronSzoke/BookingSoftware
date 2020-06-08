package hu.ak_akademia.shc.entities;

public class HotelToService {

	private final Integer hotelToServiceId;
	private final Integer hotelId;
	private final Integer serviceId;

	private HotelToService(Builder builder) {
		this.hotelToServiceId = builder.hotelToServiceId;
		this.hotelId = builder.hotelId;
		this.serviceId = builder.serviceId;
	}

	public Integer getHotelToServiceId() {
		return hotelToServiceId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer hotelToServiceId;
		private Integer hotelId;
		private Integer serviceId;

		private Builder() {
		}

		public Builder withHotelToServiceId(Integer hotelToServiceId) {
			this.hotelToServiceId = hotelToServiceId;
			return this;
		}

		public Builder withHotelId(Integer hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public Builder withServiceId(Integer serviceId) {
			this.serviceId = serviceId;
			return this;
		}

		public HotelToService build() {
			return new HotelToService(this);
		}
	}

}