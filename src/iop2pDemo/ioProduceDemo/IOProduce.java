package iop2pDemo.ioProduceDemo;

import org.apache.activemq.ActiveMQConnection;

import util.ActiveMQutil;

public class IOProduce {

	private static final String userName = ActiveMQConnection.DEFAULT_USER;
	private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	public static void main(String[] rge){
		ActiveMQutil activeMQutil = ActiveMQutil.getActiveMQutil();
		activeMQutil.setConnectionFactory(userName, passWord, url);
		activeMQutil.setProducerP2p("测试", "测试序列化");
	}
}
