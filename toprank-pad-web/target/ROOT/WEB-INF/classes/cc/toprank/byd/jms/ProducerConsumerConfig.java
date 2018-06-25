package cc.toprank.byd.jms;

import cc.toprank.byd.constant.PrintConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConsumerConfig {
		@Autowired(required = false)
		RabbitConfig rabbitconfig;
	
	 	@Bean
	    public Queue myQueue() {
	       return new Queue(PrintConstants.PrintConfig.PRINT_UP_QUEUE);
	    }
	    
	    //消费者监听器
	    @Bean
	    public QueueListener queueListener() {
	    	return new QueueListener();
	    }
	    
	    @Bean
	    public MessageListenerAdapter mailListenerAdapter() {
		    MessageListenerAdapter adapter = new MessageListenerAdapter();
		    adapter.setDelegate(queueListener());
		    adapter.setDefaultListenerMethod("displayMsgInfo");
		    return adapter;
	    }
	    
	    @Bean
	    public SimpleMessageListenerContainer messageListenerContainer() {
		    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		    container.setConnectionFactory(rabbitconfig.connectionFactory());
		    container.setMessageListener(mailListenerAdapter());
		    container.setQueues(myQueue());
		    return container;
	    }
	    

}
