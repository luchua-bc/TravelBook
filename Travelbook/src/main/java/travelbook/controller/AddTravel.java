package main.java.travelbook.controller;
import java.util.List;
import java.util.ArrayList;
import main.java.travelbook.model.dao.DaoFactory;
import main.java.travelbook.model.dao.DaoType;
import main.java.travelbook.model.TravelEntity;
import main.java.travelbook.model.bean.StepBean;
import main.java.travelbook.model.bean.TravelBean;
import main.java.travelbook.model.StepEntity;
import main.java.travelbook.model.CityEntity;
import main.java.travelbook.view.MenuBar;
import main.java.travelbook.model.Entity;
import java.io.FileInputStream;
import java.sql.Date;

import main.java.travelbook.model.dao.PersistanceDAO;
import main.java.travelbook.util.DateUtil;
public class AddTravel {
	private static AddTravel istance=null;
	private AddTravel() {
		
	}
	public static AddTravel getIstance() {
		if(istance==null)
			istance=new AddTravel();
		return istance;
	}
	public void saveTravel(TravelBean travel) throws Exception{
		PersistanceDAO dao=DaoFactory.getInstance().create(DaoType.TRAVEL);
		TravelEntity myTravel=new TravelEntity();
		myTravel.setDescriptionTravel(travel.getDescriptionTravel());
		if(travel.getPathFile()!=null)
			myTravel.setBackground(new FileInputStream(travel.getPathFile()));
		if(travel.getCostTravel()!=null)
			myTravel.setCostTravel(travel.getCostTravel());
		myTravel.setCreatorTravel(MenuBar.getInstance().getLoggedUser().getId());
		DateUtil util=new DateUtil();
		myTravel.setEndTravelDate(Date.valueOf(util.toLocalDate(travel.getEndDate())));
		myTravel.setStartTravelDate(Date.valueOf(util.toLocalDate(travel.getStartDate())));
		if(travel.getShare())
			myTravel.setShare(1);
		else
			myTravel.setShare(0);
		myTravel.setNameTravel(travel.getNameTravel());
		myTravel.setStepNumber(travel.getListStep().size());
		StringBuilder string=new StringBuilder();
		string.append("#");
		for(String type: travel.getTypeTravel()) {
			string.append(type);
			string.append("#");
		}
		List<Entity> steps=new ArrayList<>();
		List<CityEntity> cities=new ArrayList<>();
		int i=1;
		for(StepBean step: travel.getListStep()) {
			StepEntity stepE=new StepEntity();
			stepE.setDescriptionStep(step.getDescriptionStep());
			stepE.setGroupDay(step.getGroupDay());
			stepE.setNumberOfDay(step.getNumberInDay());
			stepE.setPlace(step.getPlace());
			stepE.setUserId(MenuBar.getInstance().getLoggedUser().getId());
			stepE.setListPhoto(step.getImageFile());
			stepE.setNumber(i);
			CityEntity city=null;
			if(step.getFullPlace()!=null) {
				city=new CityEntity();
			city.setNameC(step.getFullPlace().getCity());
			city.setState(step.getFullPlace().getCountry());
			if(!(cities.contains(city)))
				cities.add(city);
			}
			steps.add(stepE);
			i++;	
		}
		myTravel.setListStep(steps);
		myTravel.setCityView(cities);
		dao.setMyEntity((Entity)myTravel);
		dao.setData();
	}
	public TravelBean getTravelById(Integer id) throws Exception {
		PersistanceDAO dao=DaoFactory.getInstance().create(DaoType.TRAVEL);
		TravelEntity myTravel=new TravelEntity();
		myTravel.setIdTravel(id);
		List<Entity> entities=dao.getData(myTravel);
		return new TravelBean((TravelEntity)entities.get(0));
	}
}
