package hu.ak_akademia.shc.entities;

import java.time.LocalDate;

public class ValidReservation {

	private final Integer reservationId;
	private final String hotelName;
	private final String address;
	private final LocalDate dateFrom;
	private final LocalDate dateTo;
	private final Integer totalPrice;

	private ValidReservation(Builder builder) {
		this.reservationId = builder.reservationId;
		this.hotelName = builder.hotelName;
		this.address = builder.address;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
		this.totalPrice = builder.totalPrice;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Integer getReservationId() {
		return reservationId;
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

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public static final class Builder {
		private Integer reservationId;
		private String hotelName;
		private String address;
		private LocalDate dateFrom;
		private LocalDate dateTo;
		private Integer totalPrice;

		private Builder() {
		}

		public Builder withReservationId(Integer reservationId) {
			this.reservationId = reservationId;
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

		public Builder withDateFrom(LocalDate dateFrom) {
			this.dateFrom = dateFrom;
			return this;
		}

		public Builder withDateTo(LocalDate dateTo) {
			this.dateTo = dateTo;
			return this;
		}

		public Builder withTotalPrice(Integer totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public ValidReservation build() {
			return new ValidReservation(this);
		}
	}

}