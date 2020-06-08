package hu.ak_akademia.shc.entities;

import java.time.LocalDate;

public class ReservationToReview {

	private final String hotelName;
	private final String address;
	private final LocalDate dateFrom;
	private final LocalDate dateTo;
	private final String roomType;
	private final Integer totalPrice;
	private final Integer reservationId;

	private ReservationToReview(Builder builder) {
		this.hotelName = builder.hotelName;
		this.address = builder.address;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
		this.roomType = builder.roomType;
		this.totalPrice = builder.totalPrice;
		this.reservationId = builder.reservationId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public String getRoomType() {
		return roomType;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public static final class Builder {
		private String hotelName;
		private String address;
		private LocalDate dateFrom;
		private LocalDate dateTo;
		private String roomType;
		private Integer totalPrice;
		private Integer reservationId;

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

		public Builder withDateFrom(LocalDate dateFrom) {
			this.dateFrom = dateFrom;
			return this;
		}

		public Builder withDateTo(LocalDate dateTo) {
			this.dateTo = dateTo;
			return this;
		}

		public Builder withRoomType(String roomType) {
			this.roomType = roomType;
			return this;
		}

		public Builder withTotalPrice(Integer totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public Builder withReservationId(Integer reservationId) {
			this.reservationId = reservationId;
			return this;
		}

		public ReservationToReview build() {
			return new ReservationToReview(this);
		}
	}

}