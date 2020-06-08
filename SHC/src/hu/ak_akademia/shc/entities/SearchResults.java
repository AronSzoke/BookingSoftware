package hu.ak_akademia.shc.entities;

public class SearchResults {

	private final String hotelName;
	private final String address;
	private final Integer stars;
	private final Double review;
	private final Integer roomId;
	private final Integer roomNumber;
	private final String roomType;
	private final String roomPrice;
	private final String bedTypes;
	private final Integer adults;

	private SearchResults(Builder builder) {
		this.hotelName = builder.hotelName;
		this.address = builder.address;
		this.stars = builder.stars;
		this.review = builder.review;
		this.roomId = builder.roomId;
		this.roomNumber = builder.roomNumber;
		this.roomType = builder.roomType;
		this.roomPrice = builder.roomPrice;
		this.bedTypes = builder.bedTypes;
		this.adults = builder.adults;
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

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public String getBedTypes() {
		return bedTypes;
	}

	public Integer getAdults() {
		return adults;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String hotelName;
		private String address;
		private Integer stars;
		private Double review;
		private Integer roomId;
		private Integer roomNumber;
		private String roomType;
		private String roomPrice;
		private String bedTypes;
		private Integer adults;

		private Builder() {
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

		public Builder withRoomId(Integer roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder withRoomNumber(Integer roomNumber) {
			this.roomNumber = roomNumber;
			return this;
		}

		public Builder withRoomType(String roomType) {
			this.roomType = roomType;
			return this;
		}

		public Builder withRoomPrice(String roomPrice) {
			this.roomPrice = roomPrice;
			return this;
		}

		public Builder withBedTypes(String bedTypes) {
			this.bedTypes = bedTypes;
			return this;
		}

		public Builder withAdults(Integer adults) {
			this.adults = adults;
			return this;
		}

		public SearchResults build() {
			return new SearchResults(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("SearchResults [roomId=");
		builder2.append(roomId);
		builder2.append("]");
		return builder2.toString();
	}

}