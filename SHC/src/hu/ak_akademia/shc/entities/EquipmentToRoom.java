package hu.ak_akademia.shc.entities;

public class EquipmentToRoom {

	private final Integer equipmentToRoomId;
	private final Integer equipmentId;
	private final Integer roomId;

	private EquipmentToRoom(Builder builder) {
		this.equipmentToRoomId = builder.equipmentToRoomId;
		this.equipmentId = builder.equipmentId;
		this.roomId = builder.roomId;
	}

	public Integer getEquipmentToRoomId() {
		return equipmentToRoomId;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer equipmentToRoomId;
		private Integer equipmentId;
		private Integer roomId;

		private Builder() {
		}

		public Builder withEquipmentToRoomId(Integer equipmentToRoomId) {
			this.equipmentToRoomId = equipmentToRoomId;
			return this;
		}

		public Builder withEquipmentId(Integer equipmentId) {
			this.equipmentId = equipmentId;
			return this;
		}

		public Builder withRoomId(Integer roomId) {
			this.roomId = roomId;
			return this;
		}

		public EquipmentToRoom build() {
			return new EquipmentToRoom(this);
		}
	}

}