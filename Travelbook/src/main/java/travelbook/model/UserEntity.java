package main.java.travelbook.model;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import main.java.travelbook.model.bean.MessageBean;
import main.java.travelbook.model.bean.RegistrationBean;



public class UserEntity implements Entity{
	private String username=null;
	private String password=null;
	private String name=null;
	private String surname=null;
	private String email=null;
	private String description=null;
	private String gender=null;
	private InputStream photo=null;
	private Date birthDate=null;
	private int  id=0;
	private int nFollower=0;
	private int nFollowing=0;
	private int nTrip=0;
	private int nPlace=0;
	private String nation;
	private List<Integer> favorite = null;
	private List<Integer> follower = null;
	private List<Integer> following = null;
 	private List <Integer> travel = null;
	private List <MessageBean> message = null;
	
	public UserEntity(RegistrationBean user) {
		this.name=user.getName();
		this.surname=user.getSurname();
		this.email=user.getEmail();
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.birthDate=user.getBirtdate();
		this.gender=user.getGender();
	}
	public UserEntity(int codice)
	{
		this.id=codice;
	}
	public UserEntity() {}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setEmail(String mail) {
		this.email=mail;
	}
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public void setPhoto(InputStream photo)
	{
		this.photo=photo;
	}
	public void setPhoto(File photo)
	{
		if(photo!=null)
			try {
				this.photo=new FileInputStream(photo);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		else this.photo=null;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public void setFollower(int nfollower)
	{
		this.nFollower=nfollower;
	}
	public void setFollowing(int nfollowing)
	{
		this.nFollowing=nfollowing;
	}
	public void setNTravel(int ntrip)
	{
		this.nTrip=ntrip;
	}
	public void setBirthDate(Date birthdate) {
		this.birthDate=birthdate;
	}
	public void setNation(String nation) {
		this.nation=nation;
	}
	
	public void setTravel(List <Integer> t)
	{
		if(!t.isEmpty())this.travel= t;
	}
	public void setMessagge(List <MessageBean> m) {
		this.message=m;
	}
	public void setFavoriteList(List<Integer> list)
	{
		if(!list.isEmpty())this.favorite=list;
	}
	public int getId()
	{
		return this.id;
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getName()
	{
		return this.name;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public String getDescription()
	{
		return this.description;
	}
	public InputStream getPhoto()
	{
		return this.photo;
	}
	public String getGender()
	{
		return this.gender;
	}
	public int getNFollower()
	{
		return this.nFollower;
	}
	public int getNFollowing()
	{
		return this.nFollowing;
	}
	public int getNTrip()
	{
		return this.nTrip;
	}
	public Date getBirthDate() {
		return this.birthDate;
	}
	public String	getNation() {
		return this.nation;
	}
	public String getEmail() {
		return this.email;
	}
	public List <Integer>  getTravel() {
		return this.travel;
	}
	public List <MessageBean> getMessage(){
		return this.message;
	}
	public List<Integer> getFavoriteList()
	{
		return this.favorite;
	}
	
	public List<Integer> getListFollower() {
		return follower;
	}
	public void setListFollower(List<Integer> follower) {
		if(!follower.isEmpty())this.follower = follower;
	}
	
	public List<Integer> getListFollowing() {
		return following;
	}
	public void setListFollowing(List<Integer> following) {
		if(!following.isEmpty())this.following = following;
	}
	public int getnPlace() {
		return nPlace;
	}
	public void setnPlace(int nPlace) {
		this.nPlace = nPlace;
	}

	
}

