package topDemo.ProduceDemo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopProduce {

	private static final String userName = ActiveMQConnection.DEFAULT_USER;
	private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final Integer num = 10;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		
		connectionFactory = new ActiveMQConnectionFactory(TopProduce.userName, TopProduce.passWord, TopProduce.url);
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("TOP");
			producer = (MessageProducer) session.createProducer(destination);
			sendMessage(session, producer);
			session.commit();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void sendMessage(Session session, MessageProducer producer){
		for(int i=0; i<10; i++){
			try {
				TextMessage message = session.createTextMessage("订阅模式发送消息"+i);
				System.out.println("订阅模式："+"订阅模式发送消息"+i);
				producer.send(message);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
