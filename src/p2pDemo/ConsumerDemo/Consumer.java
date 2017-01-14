package p2pDemo.ConsumerDemo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	
	private static final String userName = ActiveMQConnection.DEFAULT_USER;
	private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer messageConsumer = null;
		
		try {
			connectionFactory = new ActiveMQConnectionFactory(Consumer.userName, Consumer.passWord, Consumer.url);
			connection = connectionFactory.createConnection();
			connection.start();//启动连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("FiretQuery");
			messageConsumer = session.createConsumer(destination);
			/*while(true){
				TextMessage message = (TextMessage) messageConsumer.receive(1000);
				if(message != null){
					System.out.println(message);
				}else{
					break;
				}
			}*/
			messageConsumer.setMessageListener(new Listener());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
