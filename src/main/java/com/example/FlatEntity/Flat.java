package com.example.FlatEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String flatNumber;
    private String ownerName;
    private int floorNumber;
    private int isAvailable;
    private double squareFootage;
    private double price;
    private String furnishedStatus;
    private int numberOfBalconies;
    private String flatType;
    
    public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Flat(Long id, String flatNumber, String ownerName, int floorNumber, int isAvailable,
			double squareFootage, double price, String furnishedStatus, int numberOfBalconies, String flatType) {
		super();
		this.id = id;
		this.flatNumber = flatNumber;
		this.ownerName = ownerName;
		this.floorNumber = floorNumber;
		this.isAvailable = isAvailable;
		this.squareFootage = squareFootage;
		this.price = price;
		this.furnishedStatus = furnishedStatus;
		this.numberOfBalconies = numberOfBalconies;
		this.flatType = flatType;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFurnishedStatus() {
		return furnishedStatus;
	}

	public void setFurnishedStatus(String furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
	}

	public int getNumberOfBalconies() {
		return numberOfBalconies;
	}

	public void setNumberOfBalconies(int numberOfBalconies) {
		this.numberOfBalconies = numberOfBalconies;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	@Override
	public String toString() {
		return "Flat [id=" + id + ", flatNumber=" + flatNumber + ", ownerName=" + ownerName + ", floorNumber="
				+ floorNumber + ", isAvailable=" + isAvailable + ", squareFootage=" + squareFootage + ", price=" + price
				+ ", furnishedStatus=" + furnishedStatus + ", numberOfBalconies=" + numberOfBalconies + ", flatType="
				+ flatType + "]";
	}
    
    

}

