package com.codingshuttle.TestingApp.entities;

import jakarta.persistence.*;

@Entity
public class Department {
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDptTitle() {
		return dptTitle;
	}

	public void setDptTitle(String dptTitle) {
		this.dptTitle = dptTitle;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dptTitle;
}
