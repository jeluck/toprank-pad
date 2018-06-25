package cc.toprank.byd.jms;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//连接rabbitMQ的基本配置
@Configuration
public class RabbitConfig {
	private Properties properties = new Properties();

	private final String CONF_NAME = "config.properties";
	 	@Bean
	    public ConnectionFactory connectionFactory() {

			try {
				InputStream in = RabbitConfig.class.getClassLoader().getResourceAsStream(CONF_NAME);
				properties.load(in);
			} catch (IOException e) {
				throw new RuntimeException("Load config[" + CONF_NAME + "] error ", e);
			}
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory( properties.getProperty("mq.host"));
			connectionFactory.setUsername(properties.getProperty("mq.username"));
			connectionFactory.setPassword(properties.getProperty("mq.password"));
			connectionFactory.setPort(Integer.parseInt(properties.getProperty("mq.port")));
	 		return connectionFactory;
	    }

	    @Bean
	    public AmqpAdmin amqpAdmin() {
	        return new RabbitAdmin(connectionFactory());
	    }

	    @Bean
	    public RabbitTemplate rabbitTemplate() {
	        return new RabbitTemplate(connectionFactory());
	    }

	   
}
