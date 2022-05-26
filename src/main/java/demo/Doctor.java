package demo;

import org.springframework.stereotype.Component;
@Component
public class Doctor {
	private Hospital hospital;
	public Doctor(Hospital hospital) {
		this.hospital = hospital;
	}

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
