package hu.ak_akademia.shc.entities;

import java.util.Objects;

public class Room {

	private final Integer roomId;
	private final Integer hotelId;
	private final String roomType;
	private final Integer floor;
	private final Integer roomNumber;
	private final Integer roomSize;
	private final Integer roomPrice;
	private final String balcony;

	private Room(Builder builder) {
		this.roomId = builder.roomId;
		this.hotelId = builder.hotelId;
		this.roomType = builder.roomType;
		this.floor = builder.floor;
		this.roomNumber = builder.roomNumber;
		this.roomSize = builder.roomSize;
		this.roomPrice = builder.roomPrice;
		this.balcony = builder.balcony;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public Integer getFloor() {
		return floor;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Integer getRoomSize() {
		return roomSize;
	}

	public Integer getRoomPrice() {
		return roomPrice;
	}

	public String getBalcony() {
		return balcony;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer roomId;
		private Integer hotelId;
		private String roomType;
		private Integer floor;
		private Integer roomNumber;
		private Integer roomSize;
		private Integer roomPrice;
		private String balcony;

		private Builder() {
		}

		public Builder withRoomId(Integer roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder withHotelId(Integer hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public Builder withRoomType(String roomType) {
			this.roomType = roomType;
			return this;
		}

		public Builder withFloor(Integer floor) {
			this.floor = floor;
			return this;
		}

		public Builder withRoomNumber(Integer roomNumber) {
			this.roomNumber = roomNumber;
			return this;
		}

		public Builder withRoomSize(Integer roomSize) {
			this.roomSize = roomSize;
			return this;
		}

		public Builder withRoomPrice(Integer roomPrice) {
			this.roomPrice = roomPrice;
			return this;
		}

		public Builder withBalcony(String balcony) {
			this.balcony = balcony;
			return this;
		}

		public Room build() {
			return new Room(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Room)) {
			return false;
		}
		Room other = (Room) obj;
		return Objects.equals(roomId, other.roomId);
	}

}