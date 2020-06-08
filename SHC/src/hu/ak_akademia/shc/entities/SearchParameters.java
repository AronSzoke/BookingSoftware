package hu.ak_akademia.shc.entities;

import java.time.LocalDate;

public class SearchParameters {

	private final Integer priceFrom;
	private final Integer priceTo;
	private final String address;
	private final LocalDate dateFrom;
	private final LocalDate dateTo;
	private final Integer adults;

	private SearchParameters(Builder builder) {
		this.priceFrom = builder.priceFrom;
		this.priceTo = builder.priceTo;
		this.address = builder.address;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
		this.adults = builder.adults;
	}

	public Integer getPriceFrom() {
		return priceFrom;
	}

	public Integer getPriceTo() {
		return priceTo;
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

	public Integer getAdults() {
		return adults;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer priceFrom;
		private Integer priceTo;
		private String address;
		private LocalDate dateFrom;
		private LocalDate dateTo;
		private Integer adults;

		private Builder() {
		}

		public Builder withPriceFrom(Integer priceFrom) {
			this.priceFrom = priceFrom;
			return this;
		}

		public Builder withPriceTo(Integer priceTo) {
			this.priceTo = priceTo;
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

		public Builder withAdults(Integer adults) {
			this.adults = adults;
			return this;
		}

		public SearchParameters build() {
			return new SearchParameters(this);
		}
	}

}