package main.java.travelbook.model.bean;

import java.util.List;

import javafx.scene.image.Image;
import main.java.travelbook.util.PlaceAdapter;
public class StepBean {
	private int number;
	private int iDTravel;
	private int iDCreator;
	private int groupDay;
	private int numberInDay;
	private String descriptionStep;
	private String place;
	private String day;
	private List <Image> photo;
	private PlaceAdapter fullPlace;
	public  StepBean(){}
	public  StepBean(int number,int idtravel,int idcreator){
		this.number=number;
		this.iDCreator=idcreator;
		this.iDTravel=idtravel;
	}
	
	public PlaceAdapter getFullPlace() {
		return fullPlace;
	}
	public void setFullPlace(PlaceAdapter fullPlace) {
		this.fullPlace = fullPlace;
	}
	public int getNumberInDay() {
		return numberInDay;
	}
	public void setNumberInDay(int numberInDay) {
		this.numberInDay = numberInDay;
	}
	public int getNumber()
	{
		return this.number;
	}
	public int getIDTravel() {
		return this.iDTravel;
	}
	public int getIDCreator() {
		return this.iDCreator;
	}
	public int getGroupDay() {
		return this.groupDay;
	}
	public String getDescriptionStep() {
		return this.descriptionStep;
	}
	public String getPlace() {
		return this.place;
	}
	public String getDay()
	{
		return this.day;
	}
	public List<Image> getListPhoto(){
		return this.photo;
	}
	
	public void setDescriptionStep(String description)
	{
		this.descriptionStep=description;
	}
	public void setPlace(String location)
	{
		this.place=location;
	}
	public void setDay(String day)
	{
		this.day=day;
	}
	public void setGroupDay(int number) {
		this.groupDay=number;
	}
	public void setListPhoto(List <Image> photo) {
		this.photo=photo;
	}
	
}