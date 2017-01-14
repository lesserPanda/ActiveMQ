package iop2pDemo.ioConsumerDemo;

import org.apache.activemq.ActiveMQConnection;

import util.ActiveMQutil;

public class IOConsumer {

	private static final String userName = ActiveMQConnection.DEFAULT_USER;
	private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	public static void main(String[] args) {
		ActiveMQutil activeMQutil = ActiveMQutil.getActiveMQutil();
		activeMQutil.setConnectionFactory(userName, passWord, url);
		activeMQutil.setCustomerP2p("测试");
	}

}
