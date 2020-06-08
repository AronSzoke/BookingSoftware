package hu.ak_akademia.shc.entities;

import java.time.LocalDate;

public class Reservation {

	private final Integer reservationId;
	private final Integer userId;
	private final LocalDate dateFrom;
	private final LocalDate dateTo;
	private final Double totalPrice;
	private final String status;

	private Reservation(Builder builder) {
		this.reservationId = builder.reservationId;
		this.userId = builder.userId;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
		this.totalPrice = builder.totalPrice;
		this.status = builder.status;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public static final class Builder {
		private Integer reservationId;
		private Integer userId;
		private LocalDate dateFrom;
		private LocalDate dateTo;
		private Double totalPrice;
		private String status;

		private Builder() {
		}

		public Builder withReservationId(Integer reservationId) {
			this.reservationId = reservationId;
			return this;
		}

		public Builder withUserId(Integer userId) {
			this.userId = userId;
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

		public Builder withTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public Builder withStatus(String status) {
			this.status = status;
			return this;
		}

		public Reservation build() {
			return new Reservation(this);
		}
	}

}
