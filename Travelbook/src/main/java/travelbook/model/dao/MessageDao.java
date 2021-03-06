package main.java.travelbook.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.travelbook.controller.AllQuery;
import main.java.travelbook.model.Entity;
import java.util.List;
import java.util.ArrayList;
import main.java.travelbook.model.dao.PersistanceDAO;
import main.java.travelbook.model.MessageEntity;
public class MessageDao implements PersistanceDAO {
	private MessageEntity myEntity;
	private Connection connection;

	@Override
	public List<Entity> getData(Entity message)throws SQLException{
		MessageEntity messaggio=(MessageEntity) message;
		List<Entity> results=new ArrayList<>();
		
		this.connection = AllQuery.getInstance().getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=AllQuery.getInstance().getMessage(stmt, messaggio);
			while(rs.next()) {
				MessageEntity newM=new MessageEntity(rs.getInt("Mittente"),rs.getInt("Destinatario"));
				newM.setText(rs.getString("Testo"));
				newM.setTime(rs.getTimestamp("data").toInstant());
				newM.setType(rs.getString("NomeViaggio"));
				results.add((Entity)newM);
			}
		
		return results;
	}
	@Override
	public void setData() throws SQLException {
		if(this.myEntity!=null) {
			this.connection = AllQuery.getInstance().getConnection();
			AllQuery.getInstance().sendMessage(this.connection, this.myEntity);
		}
	}
	@Override
	public void delete(Entity obj) {
		
	}
	@Override
	public void update(Entity obj)  {
		MessageEntity entityToBeUpdated=(MessageEntity) obj;
		try {
			this.connection = AllQuery.getInstance().getConnection();
		AllQuery.getInstance().setReadMex(this.connection.createStatement(), entityToBeUpdated);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Entity getMyEntity() {
		return (Entity)this.myEntity;
	}
	@Override
	public void setMyEntity(Entity entity) {
		this.myEntity=(MessageEntity) entity;
	}
}
