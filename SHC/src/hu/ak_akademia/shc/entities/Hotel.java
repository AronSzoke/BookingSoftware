package hu.ak_akademia.shc.entities;

public class Hotel {

	private final Integer hotelId;
	private final String hotelType;
	private final String hotelName;
	private final String address;
	private final Integer stars;
	private final Double review;

	private Hotel(Builder builder) {
		this.hotelId = builder.hotelId;
		this.hotelType = builder.hotelType;
		this.hotelName = builder.hotelName;
		this.address = builder.address;
		this.stars = builder.stars;
		this.review = builder.review;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public String getHotelType() {
		return hotelType;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getAddress() {
		return address;
	}

	public Integer getStars() {
		return stars;
	}

	public Double getReview() {
		return review;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer hotelId;
		private String hotelType;
		private String hotelName;
		private String address;
		private Integer stars;
		private Double review;

		private Builder() {
		}

		public Builder withHotelId(Integer hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public Builder withHotelType(String hotelType) {
			this.hotelType = hotelType;
			return this;
		}

		public Builder withHotelName(String hotelName) {
			this.hotelName = hotelName;
			return this;
		}

		public Builder withAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder withStars(Integer stars) {
			this.stars = stars;
			return this;
		}

		public Builder withReview(Double review) {
			this.review = review;
			return this;
		}

		public Hotel build() {
			return new Hotel(this);
		}
	}

}