package demo;

import org.springframework.stereotype.Component;

public class Doctor {
	public Doctor(Hospital hospital) {
		this.hospital = hospital;
	}
	private Hospital hospital;
	public void assist() {
		System.out.println("Doctor is assisting...please wait!!!");
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
