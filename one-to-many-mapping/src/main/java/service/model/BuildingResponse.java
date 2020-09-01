package service.model;

import data.model.Building;

public class BuildingResponse extends Response {
	private Building building;

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}
