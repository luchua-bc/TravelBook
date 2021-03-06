package main.java.travelbook.util;
import main.java.travelbook.controller.ChatController;
import java.time.Instant;
import main.java.travelbook.view.MenuBar;
import java.util.List;
import main.java.travelbook.model.MessageEntity;
import main.java.travelbook.model.bean.MessageBean;
import java.util.ArrayList;
public class MessagePollingThread extends Thread {
	private Instant lastTime=null;
	private boolean goOn=true;
	public void kill() {
		this.goOn=false;
	}
	@Override
	public void run() {
		Instant lastLocalTime;
		boolean found=false;
		System.out.println("Run");
		while(goOn) {
		try {
			//Non c'e' bisogno di sincronizzarsi sulla chat perche' il thread che scrive e' uno solo
			lastLocalTime=lastTime;
		List<MessageEntity> messages=ChatController.getIstance().getNewMessage( MenuBar.getInstance().getLoggedUser().getId(),lastLocalTime);
		List<Chat> chats=MenuBar.getInstance().getMyChat();
		if(!messages.isEmpty())
			lastTime=Instant.now();
		for(MessageEntity message: messages) {
			found=false;
			for(int i=0;i<chats.size();i++) {
				Chat chat=chats.get(i);
				if(chat.getIdUser()==message.getIdMittente()) {
					chat.getReceive().add(new MessageBean(message));
					chat.setChanged();
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("Nuova chat creata");
				List<MessageBean> messaggi=new ArrayList<>();
				messaggi.add(new MessageBean(message));
				Chat nuovaChat=new Chat(message.getIdMittente(),messaggi);
				MenuBar.getInstance().newChat(nuovaChat);
				nuovaChat.setChanged();
			}
		}
		Thread.sleep(3000);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
		
	}
}
