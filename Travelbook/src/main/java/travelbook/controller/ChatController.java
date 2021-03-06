package main.java.travelbook.controller;
import java.util.List;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

import main.java.travelbook.model.dao.DaoFactory;
import main.java.travelbook.model.dao.DaoType;
import main.java.travelbook.model.dao.PersistanceDAO;
import main.java.travelbook.model.MessageEntity;
import main.java.travelbook.model.Entity;

public class ChatController {
	private static ChatController istance=null;
	private ChatController() {
		
	}
	public static ChatController getIstance() {
		if(istance==null) {
			istance=new ChatController();
		}
		return istance;
	}
	public List<MessageEntity> getNewMessage( int idUser, Instant time) throws Exception {
		PersistanceDAO dao=DaoFactory.getInstance().create(DaoType.MESSAGE);
		MessageEntity nuovaEntity=new MessageEntity(0,idUser);
		if(time!=null)
			nuovaEntity.setLastTimeStamp(time);
		nuovaEntity.setSoloNuovi(true);
		List<Entity> entities=dao.getData(nuovaEntity);
		List<MessageEntity> messaggi=new ArrayList<>();
		for(Entity entity: entities) {
			MessageEntity messaggio=(MessageEntity)entity;
			messaggi.add(messaggio);
		}
		return messaggi;
	}
	public void setReadMex(MessageEntity mex) {
		PersistanceDAO dao=DaoFactory.getInstance().create(DaoType.MESSAGE);
		try {
			dao.update(mex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
