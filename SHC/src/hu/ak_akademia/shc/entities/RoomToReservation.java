package hu.ak_akademia.shc.entities;

public class RoomToReservation {

	private final Integer roomToReservationID;
	private final Integer roomId;
	private final Integer reservationId;

	private RoomToReservation(Builder builder) {
		this.roomToReservationID = builder.roomToReservationID;
		this.roomId = builder.roomId;
		this.reservationId = builder.reservationId;
	}

	public Integer getRoomToReservationID() {
		return roomToReservationID;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer roomToReservationID;
		private Integer roomId;
		private Integer reservationId;

		private Builder() {
		}

		public Builder withRoomToReservationID(Integer roomToReservationID) {
			this.roomToReservationID = roomToReservationID;
			return this;
		}

		public Builder withRoomId(Integer roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder withReservationId(Integer reservationId) {
			this.reservationId = reservationId;
			return this;
		}

		public RoomToReservation build() {
			return new RoomToReservation(this);
		}
	}

}