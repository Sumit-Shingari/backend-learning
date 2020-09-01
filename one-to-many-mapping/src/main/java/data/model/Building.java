package data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class Building {

	@Id
	@Column(name = "id_building")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBuilding;

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private Long cost;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(name = "building_room", joinColumns = {
			@JoinColumn(name = "id_building", referencedColumnName = "id_building") }, inverseJoinColumns = {
					@JoinColumn(name = "id_room", referencedColumnName = "id_room") })
	private Set<Room> rooms = new HashSet<>();

	public Integer getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(Integer idBuilding) {
		this.idBuilding = idBuilding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
}
