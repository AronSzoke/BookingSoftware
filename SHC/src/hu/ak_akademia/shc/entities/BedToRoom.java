package hu.ak_akademia.shc.entities;

public class BedToRoom {

	private final Integer bedToRoomId;
	private final Integer roomId;
	private final Integer bedId;

	private BedToRoom(Builder builder) {
		this.bedToRoomId = builder.bedToRoomId;
		this.roomId = builder.roomId;
		this.bedId = builder.bedId;
	}

	public Integer getBedToRoomId() {
		return bedToRoomId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getBedId() {
		return bedId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer bedToRoomId;
		private Integer roomId;
		private Integer bedId;

		private Builder() {
		}

		public Builder withBedToRoomId(Integer bedToRoomId) {
			this.bedToRoomId = bedToRoomId;
			return this;
		}

		public Builder withRoomId(Integer roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder withBedId(Integer bedId) {
			this.bedId = bedId;
			return this;
		}

		public BedToRoom build() {
			return new BedToRoom(this);
		}
	}
}
