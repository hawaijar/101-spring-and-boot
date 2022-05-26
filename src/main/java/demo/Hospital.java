package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Hospital {
	private String name;

	public Hospital(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
