package com.example.entities;


import jakarta.persistence.*;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Configura la estrategia de generación de identificadores
    private Long idFlights;

    @Column
    private Long idAirline;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private String departure_time;

    @Column
    private String arrival_time;

    @Column
    private Long departure_door;

    @Column
    private Long arrival_door;

	@Column
    private Long departure_LandingStrip;

    @Column
    private Long arrival_LandingStrip;

    @Column
    private Integer stateOrigin;

    @Column
    private Integer stateDestination;

    @Column
    private String code;

    @Column
    private Long idPlane;

	@Column
	private String boardingTime;

	@Column
	private String takeOffTime;

	@Column
	private String landingTime;

	public Flights(Long idAirline, String origin, String destination, String departure_time,
			String arrival_time,String code) {
		this.idAirline = idAirline;
		this.origin = origin;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.stateOrigin = 0;
		this.stateDestination = 0;
		this.code = code;

	}
	public Flights() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String Code) {
		this.code = Code;
	}

	public Long getIdFlights() {
		return this.idFlights;
	}

	public void setIdFlights(Long IdFlights) {
		this.idFlights = IdFlights;
	}

	public Long getIdAirline() {
		return this.idAirline;
	}

	public void setIdAirline(Long IdAirline) {
		this.idAirline = IdAirline;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String Origin) {
		this.origin = Origin;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String Destination) {
		this.destination = Destination;
	}

	public String getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(String Departure_time) {
		this.departure_time = Departure_time;
	}

	public String getArrival_time() {
		return this.arrival_time;
	}

	public void setArrival_time(String Arrival_time) {
		this.arrival_time = Arrival_time;
	}

	public Long getDeparture_door() {
		return this.departure_door;
	}

	public void setDeparture_door(Long Departure_door) {
		this.departure_door = Departure_door;
	}

	public Long getArrival_door() {
		return this.arrival_door;
	}

	public void setArrival_door(Long Arrival_door) {
		this.arrival_door = Arrival_door;
	}

	public Long getIdPlane() {
		return this.idPlane;
	}

	public void setIdPlane(Long IdPlane) {
		this.idPlane = IdPlane;
	}
	public int getStateOrigin() {
		return this.stateOrigin;
	}

	public void setStateOrigin(int StateOrigin) {
		this.stateOrigin = StateOrigin;
	}

	public int getStateDestination() {
		return this.stateDestination;
	}

	public void setStateDestination(int i) {
		this.stateDestination = i;
	}

	public String getBoardingTime() {
		return this.boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getTakeOffTime() {
		return this.takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getLandingTime() {
		return this.landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public Long getDeparture_LandingStrip() {
		return this.departure_LandingStrip;
	}

	public void setDeparture_LandingStrip(Long Departure_LandingStrip) {
		this.departure_LandingStrip = Departure_LandingStrip;
	}

	public Long getArrival_LandingStrip() {
		return this.arrival_LandingStrip;
	}

	public void setArrival_LandingStrip(Long Arrival_LandingStrip) {
		this.arrival_LandingStrip = Arrival_LandingStrip;
	}

	private String state;

	public String getState() {
		state = (stateDestination == 1 && stateOrigin == 1) ? "Aprobado" : "Pendiente";
        return state;
    }
}
