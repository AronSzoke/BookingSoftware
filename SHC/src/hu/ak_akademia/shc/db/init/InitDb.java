package hu.ak_akademia.shc.db.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import hu.ak_akademia.shc.connection.ConnectionFactory;
import hu.ak_akademia.shc.db.BedDao;
import hu.ak_akademia.shc.db.BedToRoomDao;
import hu.ak_akademia.shc.db.EquipmentDao;
import hu.ak_akademia.shc.db.EquipmentToRoomDao;
import hu.ak_akademia.shc.db.HotelDao;
import hu.ak_akademia.shc.db.HotelToServiceDao;
import hu.ak_akademia.shc.db.ReservationDao;
import hu.ak_akademia.shc.db.RoomDao;
import hu.ak_akademia.shc.db.RoomToReservationDao;
import hu.ak_akademia.shc.db.ServicesDao;
import hu.ak_akademia.shc.db.UserDao;
import hu.ak_akademia.shc.entities.Bed;
import hu.ak_akademia.shc.entities.BedToRoom;
import hu.ak_akademia.shc.entities.Equipment;
import hu.ak_akademia.shc.entities.EquipmentToRoom;
import hu.ak_akademia.shc.entities.Hotel;
import hu.ak_akademia.shc.entities.HotelToService;
import hu.ak_akademia.shc.entities.Reservation;
import hu.ak_akademia.shc.entities.Room;
import hu.ak_akademia.shc.entities.RoomToReservation;
import hu.ak_akademia.shc.entities.RoomToReservation.Builder;
import hu.ak_akademia.shc.entities.Services;
import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertBedPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertBedToRoomPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertEquipmentPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertEquipmentToRoomPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertHotelPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertHotelToServicePreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertReservationPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertRoomPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertRoomToReservationPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertServicesPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.insert.InsertUserPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectEmptyPreparedStatementWriter;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectSpecificRoomBetweenDatesPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.BedResultSetReader;
import hu.ak_akademia.shc.resultsetreader.EquipmentResultSetReader;
import hu.ak_akademia.shc.resultsetreader.HotelResultSetReader;
import hu.ak_akademia.shc.resultsetreader.ReservationResultSetReader;
import hu.ak_akademia.shc.resultsetreader.RoomResultSetReader;
import hu.ak_akademia.shc.resultsetreader.ServicesResultSetReader;
import hu.ak_akademia.shc.resultsetreader.UserResultSetReader;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertBedSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertBedToRoomSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertEquipmentSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertEquipmentToRoomSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertHotelSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertHotelToServiceSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertReservationSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertRoomSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertRoomToReservationSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertServicesSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.insert.InsertUserSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllBedsSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllEquipmentSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllHotelsSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllReservationSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllRoomsSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllServicesSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectAllUserSqlBuilder;
import hu.ak_akademia.shc.sqlbuilder.select.SelectSpecificRoomBetweenDatesSqlBuilder;

public class InitDb {
	public static void main(String[] args) throws IOException, SQLException {
		reInitDb();
		createHotels();
		createRooms();
		createBeds();
		createUsers();
		createServices();
		createBedToRoom();
		createReservations();
		createRoomToReservations();
		createHotelToServices();
		createEquipments();
		createEquipmentToRooms();
	}

	public static void importSQL(Connection conn, InputStream in) throws SQLException {
		try (Scanner s = new Scanner(in)) {
			s.useDelimiter("(;(\r)?\n)|(--\n)");
			Statement st = null;
			try {
				st = conn.createStatement();
				while (s.hasNext()) {
					String line = s.next();
					if (line.startsWith("/*!") && line.endsWith("*/")) {
						int i = line.indexOf(' ');
						line = line.substring(i + 1, line.length() - " */".length());
					}

					if (line.trim()
							.length() > 0) {
						System.out.println(line);
						System.out.println("-------------------------------");
						try {
							st.execute(line);
						} catch (Exception e) {
							System.out.println("There was a mistake!");
							e.printStackTrace();
						}
					}
				}
			} finally {
				if (st != null) {
					st.close();
				}
			}
		}
	}

	private static void reInitDb() throws IOException, SQLException {
		try (Connection connection = ConnectionFactory.open()) {
			importSQL(connection, new FileInputStream(new File("resources/db-init.sql")));
		}
	}

	private static void createHotels() {
		Hotel hotel1 = Hotel.builder()
				.withHotelType("chain hotel")
				.withHotelName("Hyatt")
				.withAddress("Budapest")
				.withStars(4)
				.withReview(8.2)
				.build();
		Hotel hotel2 = Hotel.builder()
				.withHotelType("chain hotel")
				.withHotelName("Ramadan")
				.withAddress("Szeged")
				.withStars(3)
				.withReview(7.1)
				.build();
		Hotel hotel3 = Hotel.builder()
				.withHotelType("chain hotel")
				.withHotelName("InterContinental")
				.withAddress("Pécs")
				.withStars(5)
				.withReview(8.8)
				.build();

		HotelDao dao = new HotelDao();
		dao.create(new InsertHotelSqlBuilder(), new InsertHotelPreparedStatementWriter(List.of(hotel1, hotel2, hotel3)));
	}

	private static void createRooms() {
		Random random = new Random();

		List<Hotel> hotels = new HotelDao().retrieve(new SelectAllHotelsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new HotelResultSetReader());
		List<String> roomTypes = List.of("standard", "deluxe", "suit", "studio", "family", "twin");
		List<Room> rooms = new ArrayList<>();
		for (Hotel hotel : hotels) {
			for (int floor = 0; floor < random.nextInt(6) + 5; floor++) {
				for (int roomNumber = 1; roomNumber < 20; roomNumber++) {
					Room room = Room.builder()
							.withHotelId(hotel.getHotelId())
							.withRoomType(roomTypes.get(random.nextInt(roomTypes.size())))
							.withFloor(floor)
							.withRoomNumber(floor * 100 + roomNumber)
							.withRoomSize(random.nextInt(74) + 25)
							.withRoomPrice(random.nextInt(100_000) + 10_000)
							.withBalcony(random.nextBoolean() ? "Y" : "N")
							.build();
					rooms.add(room);
				}
			}
		}
		RoomDao dao = new RoomDao();
		dao.create(new InsertRoomSqlBuilder(), new InsertRoomPreparedStatementWriter(rooms));
	}

	private static void createBeds() {
		List<Bed> beds = new ArrayList<>();
		List<String> bedTypes = List.of("single", "twin", "double", "king", "queen", "sofa");
		for (String bedType : bedTypes) {
			Bed bed = Bed.builder()
					.withBedType(bedType)
					.withBedSpace(bedType == "single" || bedType == "twin" ? 1 : 2)
					.build();
			beds.add(bed);
		}
		BedDao dao = new BedDao();
		dao.create(new InsertBedSqlBuilder(), new InsertBedPreparedStatementWriter(beds));
	}

	private static void createUsers() {
		List<User> users = new ArrayList<>();
		users.add(User.builder()
				.withUserName("aron")
				.withPassword("admin")
				.withUserType("ADMIN")
				.withFirstName("Aron")
				.withLastName("Szoke")
				.withEmail("aron.szoke@gmail.com")
				.withDateOfBirth(LocalDate.of(1991, 8, 1))
				.build());
		Random random = new Random();
		try (Scanner firstNamesScanner = new Scanner(new FileReader(new File("resources/firstnames.txt"))); Scanner lastNamesScanner = new Scanner(new FileReader(new File("resources/lastnames.txt")))) {
			while (firstNamesScanner.hasNext() && lastNamesScanner.hasNext()) {
				String firstName = firstNamesScanner.next();
				String lastName = lastNamesScanner.next();
				LocalDate date = LocalDate.of(random.nextInt(59) + 1960, random.nextInt(12) + 1, 1);
				int maximumDays = date.lengthOfMonth();
				User user = User.builder()
						.withUserName(firstName.substring(0, Math.min(firstName.length(), 4)) + lastName.substring(0, Math.min(lastName.length(), 4)) + (random.nextInt(999) + 1))
						.withPassword(Integer.toString(Math.abs((firstName + lastName).hashCode())))
						.withUserType("GUEST")
						.withFirstName(firstName)
						.withLastName(lastName)
						.withEmail(firstName + "." + lastName + "@gmail.com")
						.withDateOfBirth(date.withDayOfMonth(random.nextInt(maximumDays) + 1))
						.build();

				users.add(user);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Files were unable to opened!");
		}
		UserDao dao = new UserDao();
		dao.create(new InsertUserSqlBuilder(), new InsertUserPreparedStatementWriter(users));
	}

	private static void createServices() {
		Random random = new Random();
		List<Services> services = new ArrayList<>();
		List<String> serviceNames = new ArrayList<>(List.of("Early-Check-In", "Late-Check-Out", "Bed & Breakfast", "Room Service", "Spa", "Massage", "Transfer", "Parking", "Car Rental", "GYM", "Wellness", "Cruising", "Bowling", "Ironing", "Laundry", "Barber"));
		for (int i = 0; i < serviceNames.size(); i++) {
			Services service = Services.builder()
					.withServiceName(serviceNames.get(i))
					.withPrice(random.nextInt(35000) + 5000d)
					.build();

			services.add(service);
		}
		ServicesDao daoService = new ServicesDao();
		daoService.create(new InsertServicesSqlBuilder(), new InsertServicesPreparedStatementWriter(services));
	}

	private static void createBedToRoom() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		RoomDao roomDao = new RoomDao();
		List<Room> rooms = roomDao.retrieve(new SelectAllRoomsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new RoomResultSetReader());
		BedDao bedDao = new BedDao();
		List<Bed> beds = bedDao.retrieve(new SelectAllBedsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new BedResultSetReader());
		BedToRoomDao bedToRoomDao = new BedToRoomDao();
		List<BedToRoom> bedToRooms = new ArrayList<>();
		for (Room room : rooms) {
			int numberOfBeds = random.nextInt(1, 5);
			for (int i = 0; i < numberOfBeds; i++) {
				Bed bedToAssign = beds.get(random.nextInt(beds.size()));
				BedToRoom bedToRoom = BedToRoom.builder()
						.withRoomId(room.getRoomId())
						.withBedId(bedToAssign.getBedId())
						.build();
				bedToRooms.add(bedToRoom);
			}
		}
		bedToRoomDao.create(new InsertBedToRoomSqlBuilder(), new InsertBedToRoomPreparedStatementWriter(bedToRooms));
	}

	private static void createReservations() {
		List<Reservation> reservations = new ArrayList<>();
		ThreadLocalRandom random = ThreadLocalRandom.current();
		UserDao userDao = new UserDao();
		List<User> users = userDao.retrieve(new SelectAllUserSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new UserResultSetReader());
		ReservationDao reservationDao = new ReservationDao();
		for (int i = random.nextInt(0, users.size()); i < users.size(); i++) {
			for (int j = random.nextInt(1, 7); j < 7; j++) {
				double price = random.nextInt(25_000, 3_500_000);

				LocalDate date = LocalDate.of(random.nextInt(2) + 2019, random.nextInt(12) + 1, 1);
				int dateMaximumDays = date.lengthOfMonth();
				LocalDate dateFrom = date.withDayOfMonth(random.nextInt(dateMaximumDays) + 1);
				LocalDate dateTo = dateFrom.plusDays(random.nextInt(30) + 1);

				Reservation reservation = Reservation.builder()
						.withUserId(users.get(i)
								.getUserId())
						.withDateFrom(dateFrom)
						.withDateTo(dateTo)
						.withTotalPrice(price)
						.withStatus(random.nextBoolean() ? "ACTIVE" : "DELETED")
						.build();

				reservations.add(reservation);
			}
		}
		reservationDao.create(new InsertReservationSqlBuilder(), new InsertReservationPreparedStatementWriter(reservations));
	}

	private static void createRoomToReservations() {
		RoomToReservationDao roomToResevationDao = new RoomToReservationDao(true);
		roomToResevationDao.open();
		ThreadLocalRandom random = ThreadLocalRandom.current();

		RoomDao roomDao = new RoomDao(true);
		roomDao.open();
		List<Room> rooms = roomDao.retrieve(new SelectAllRoomsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new RoomResultSetReader());

		ReservationDao reservationDao = new ReservationDao();
		List<Reservation> reservations = reservationDao.retrieve(new SelectAllReservationSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new ReservationResultSetReader());

		for (int i = 0; i < reservations.size(); i++) {
			String dateFrom = reservations.get(i)
					.getDateFrom()
					.toString();
			String dateTo = reservations.get(i)
					.getDateTo()
					.toString();
			List<Room> specificRoomBetweenDates;
			Builder roomToReservationBuilder = RoomToReservation.builder();
			Integer potentialRoomId;
			int counter = 0;
			do {
				potentialRoomId = rooms.get(random.nextInt(rooms.size()))
						.getRoomId();
				specificRoomBetweenDates = roomDao.retrieve(new SelectSpecificRoomBetweenDatesSqlBuilder(), new SelectSpecificRoomBetweenDatesPreparedStatementWriter(potentialRoomId, dateFrom, dateTo), new RoomResultSetReader());
				if (specificRoomBetweenDates.size() > 2) {
					System.out.println(specificRoomBetweenDates.size());
				}
				counter++;
			} while (!specificRoomBetweenDates.isEmpty() && counter < 1000);
			if (counter < 1000) {
				RoomToReservation roomToReservation = roomToReservationBuilder.withReservationId(reservations.get(i)
						.getReservationId())
						.withRoomId(potentialRoomId)
						.build();
				roomToResevationDao.create(new InsertRoomToReservationSqlBuilder(), new InsertRoomToReservationPreparedStatementWriter(List.of(roomToReservation)));
			}
		}
		roomDao.close();
		roomToResevationDao.close();
	}

	private static void createHotelToServices() {
		List<HotelToService> hotelToServices = new ArrayList<>();
		Random random = new Random();
		HotelDao hotelDao = new HotelDao();
		List<Hotel> hotels = hotelDao.retrieve(new SelectAllHotelsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new HotelResultSetReader());
		ServicesDao servicesDao = new ServicesDao();
		List<Services> services = servicesDao.retrieve(new SelectAllServicesSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new ServicesResultSetReader());
		for (Hotel hotel : hotels) {
			Collections.shuffle(services);
			for (int i = random.nextInt(services.size() / 2); i < services.size(); i++) {
				HotelToService hotelToService = HotelToService.builder()
						.withHotelId(hotel.getHotelId())
						.withServiceId(services.get(i)
								.getServiceId())
						.build();
				hotelToServices.add(hotelToService);
			}
		}
		HotelToServiceDao hotelToServiceDao = new HotelToServiceDao();
		hotelToServiceDao.create(new InsertHotelToServiceSqlBuilder(), new InsertHotelToServicePreparedStatementWriter(hotelToServices));
	}

	private static void createEquipments() {
		List<String> equipmentNames = List.of("Tea/Coffee Maker", "Safety Deposit Box", "Telephone", "Air conditioning", "Wake Up Service/Alarm Clock", "Refrigerator", "Desk", "Ironing Facilities", "Seating Area", "Extra Long Beds (> 2 metres)", "Heating", "Satellite Channels", "Carpeted",
				"Laptop safe", "Flat-screen TV", "Private entrance", "Soundproofing", "Electric kettle", "Towels/Sheets (extra fee)", "Wardrobe or closet", "Cleaning products", "Linen", "Upper floors accessible by elevator", "Clothes rack", "Drying rack for clothing");

		List<Equipment> equipments = equipmentNames.stream()
				.map(name -> Equipment.builder()
						.withName(name)
						.build())
				.collect(Collectors.toList());
		EquipmentDao equipmentDao = new EquipmentDao();
		equipmentDao.create(new InsertEquipmentSqlBuilder(), new InsertEquipmentPreparedStatementWriter(equipments));
	}

	private static void createEquipmentToRooms() {
		List<EquipmentToRoom> equipmentToRooms = new ArrayList<>();
		ThreadLocalRandom random = ThreadLocalRandom.current();
		EquipmentDao equipmentDao = new EquipmentDao();
		List<Equipment> equipments = equipmentDao.retrieve(new SelectAllEquipmentSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new EquipmentResultSetReader());

		RoomDao roomDao = new RoomDao();
		List<Room> rooms = roomDao.retrieve(new SelectAllRoomsSqlBuilder(), new SelectEmptyPreparedStatementWriter(), new RoomResultSetReader());

		for (Room room : rooms) {
			Collections.shuffle(equipments);
			for (int i = random.nextInt(equipments.size()); i < equipments.size(); i++) {
				EquipmentToRoom equipmentToRoom = EquipmentToRoom.builder()
						.withEquipmentId(equipments.get(i)
								.getEquipmentId())
						.withRoomId(room.getRoomId())
						.build();

				equipmentToRooms.add(equipmentToRoom);
			}
		}
		EquipmentToRoomDao equipmentToRoomDao = new EquipmentToRoomDao();
		equipmentToRoomDao.create(new InsertEquipmentToRoomSqlBuilder(), new InsertEquipmentToRoomPreparedStatementWriter(equipmentToRooms));
	}
}
