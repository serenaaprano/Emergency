package model;

import java.time.LocalTime;

public class Event implements Comparable<Event>{
	
	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", patient=" + patient + "]";
	}

	enum EventType {
		ARRIVAL, // arriva un nuovo paziente, entra in triage	
		TRIAGE, // è finito il triage, entro in sala d'attesa
		TIMEOUT, // passa un certo tempo di attesa
		FREE_STUDIO, // si è liberato uno studio, chiamiamo qualcuno
		TREATED, // paziente CURATO
		TICK, // timer per controllare se ci sono studi liberi
	} ;

	private LocalTime time ; //marcatura temporale dell'evento stesso 
	private EventType type ;
	private Patient patient ;
	
	public Event(LocalTime time, EventType type, Patient patient) {
		super();
		this.time = time;
		this.type = type;
		this.patient = patient;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * gli eventi sono comparati cronologicamente
	 */
	
	@Override
	public int compareTo(Event other) {
		return this.time.compareTo(other.time);
	}
	
	
}
