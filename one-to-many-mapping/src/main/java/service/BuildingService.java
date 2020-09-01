package service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import data.model.Building;
import data.model.Room;
import repository.BuildingDao;
import service.model.BuildingResponse;
import service.model.Response;

@Service
public class BuildingService {

	private static final Logger logger = Logger.getLogger(BuildingService.class.getName());

	private final BuildingDao repository;

	public BuildingService(BuildingDao repository) {
		this.repository = repository;
	}

	public Response saveBuilding() {
		Set<Room> rooms = new HashSet<>();
		Response resp = new Response();
		try {
			Building building = new Building();
			building.setName("Jalsa");
			building.setCost((long) 1000);

			Room r1 = new Room();
			r1.setName("first");
			r1.setFacing("sea");

			Room r2 = new Room();
			r2.setName("second");
			r2.setFacing("kitchen");

			rooms.add(r1);
			rooms.add(r2);

			building.setRooms(rooms);

			repository.addBuilding(building);
			resp.setMessage("building saved successfully!");

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}
		return resp;
	}

	public Response getBuilding(int idBuilding) {
		BuildingResponse response = new BuildingResponse();
		try {
			Building building = repository.getBuilding(idBuilding);
			response.setBuilding(building);
		} catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}
		return response;
	}

	public Response updateBuilding() {
		Response response = new Response();
		try {
			Set<Room> rooms = new HashSet<Room>();
			Building building = new Building();
			building.setIdBuilding(1);
			building.setCost((long) 10000);
			building.setName("Manthan");

			Room room1 = new Room();
			room1.setIdRoom(1);
			room1.setName("drawing room");
			room1.setFacing("TV");

			Room room2 = new Room();
			room2.setName("store room");
			room2.setFacing("Junk");

			rooms.add(room1);
			rooms.add(room2);

			building.setRooms(rooms);

			repository.updateBuilding(building);
			response.setMessage("Building updated successfully!");

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}
		return response;
	}
}
