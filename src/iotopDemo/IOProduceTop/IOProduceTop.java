package iotopDemo.IOProduceTop;

import org.apache.activemq.ActiveMQConnection;

import util.ActiveMQutil;

public class IOProduceTop {
	
	private static final String userName = ActiveMQConnection.DEFAULT_USER;
	private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	public static void main(String[] args) {
		ActiveMQutil activeMQutil = ActiveMQutil.getActiveMQutil();
		activeMQutil.setConnectionFactory(userName, passWord, url);
		activeMQutil.setProducerTop("top测试12", "top数据测试123asdf");
	}
	
}
