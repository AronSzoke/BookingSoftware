package hu.ak_akademia.shc.entities;

public class Review {

	private final Integer reviewId;
	private final Integer reservationId;
	private final Integer reviewScore;
	private final String reviewText;

	private Review(Builder builder) {
		this.reviewId = builder.reviewId;
		this.reservationId = builder.reservationId;
		this.reviewScore = builder.reviewScore;
		this.reviewText = builder.reviewText;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public Integer getReviewScore() {
		return reviewScore;
	}

	public String getReviewText() {
		return reviewText;
	}

	public static final class Builder {
		private Integer reviewId;
		private Integer reservationId;
		private Integer reviewScore;
		private String reviewText;

		private Builder() {
		}

		public Builder withReviewId(Integer reviewId) {
			this.reviewId = reviewId;
			return this;
		}

		public Builder withReservationId(Integer reservationId) {
			this.reservationId = reservationId;
			return this;
		}

		public Builder withReviewScore(Integer reviewScore) {
			this.reviewScore = reviewScore;
			return this;
		}

		public Builder withReviewText(String reviewText) {
			this.reviewText = reviewText;
			return this;
		}

		public Review build() {
			return new Review(this);
		}
	}

}