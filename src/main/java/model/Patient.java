package model;

import java.time.LocalTime;

public class Patient implements Comparable<Patient> {
	
	public enum ColorCode {
		NEW, // in triage
		WHITE, YELLOW, RED, BLACK,  // in sala d'attesa
		TREATING, // dentro studio medico
		OUT // a casa (abbandonato o curato)
	} ;
	
	private int num ;
	private LocalTime arrivalTime ;
	private ColorCode color ;
	
	public Patient(int num, LocalTime arrivalTime, ColorCode color) {
		super();
		this.num = num ;
		this.arrivalTime = arrivalTime;
		this.color = color;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ColorCode getColor() {
		return color;
	}

	public void setColor(ColorCode color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Patient [num=" + num + ", arrivalTime=" + arrivalTime + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (num != other.num)
			return false;
		return true;
	}
	/*
	 * 
	 * criterio con cui stabilisco chi, fra due pazienti, ha priorita maggiore
	 * se il colore dei due p è lo stesso, si confronta chi è arrivato prima
	 * se uno dei due è rosso, vince il rosso
	 * 
	 * numero negativo: this ha priorità
	 * numero positivo:other ha priorita
	 * questo perche nella coda primaria ha priorità di uscire prima chi è prima nella lista
	 */

	@Override
	public int compareTo(Patient other) {
		if(this.color.equals(other.color))
			return this.arrivalTime.compareTo(other.arrivalTime) ;
		else if(this.color.equals(Patient.ColorCode.RED))
			return -1 ;
		else if(other.color.equals(Patient.ColorCode.RED))
			return +1 ;
		else if(this.color.equals(Patient.ColorCode.YELLOW))  // Y - W
			return -1 ;
		else  // W - Y
			return +1 ;
	}
	
	

}
