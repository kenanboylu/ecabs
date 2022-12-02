package com.ecabs.booking.conf;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.ApplicationRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitMQConfiguration {
	
	private static final Logger Logger = LoggerFactory.getLogger(RabbitMQConfiguration.class);
	
	
	@Bean
	Queue bookingAddQueue() {
		return new Queue("BookingAddQueue", false);
	}
	
	@Bean
	Queue bookingEditQueue() {
		return new Queue("BookingEditQueue", false);
	}
	
	@Bean
	Queue bookingDeleteQueue() {
		return new Queue("BookingDeleteQueue", false);
	}
	
	@Bean
	Queue messageAuditQueue() {
		return new Queue("MessageAuditQueue", false);
	}
	
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("booking-exchange");	
	}
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("message-exchange");	
	}
	
	@Bean
	Binding queueBookAddBinding(Queue bookingAddQueue, DirectExchange directExchange){
		return BindingBuilder.bind(bookingAddQueue).to(directExchange).with("add");
	}
	
	@Bean
	Binding queueBookEditBinding(Queue bookingEditQueue, DirectExchange directExchange){
		return BindingBuilder.bind(bookingEditQueue).to(directExchange).with("edit");
	}
	
	@Bean
	Binding queueBookDeleteBinding(Queue bookingDeleteQueue, DirectExchange directExchange){
		return BindingBuilder.bind(bookingDeleteQueue).to(directExchange).with("delete");
	}
	
	@Bean
	Binding messageAuditBinding(Queue messageAuditQueue, FanoutExchange fanoutExchange){
		return BindingBuilder.bind(messageAuditQueue).to(fanoutExchange);
	}
	
	@Bean
	Binding exchangeBinding(DirectExchange directExchange, FanoutExchange fanoutExchange){
		return BindingBuilder.bind(directExchange).to(fanoutExchange);
	}
	
	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	ApplicationRunner runner(ConnectionFactory cf) {
		Logger.info("Host:" + cf.getHost());
		Logger.info("Port:" + cf.getPort());
		Logger.info("Username:" + cf.getUsername());
		return args -> {
	        boolean open = false;
	        while(!open) {
	            try {
	                cf.createConnection().close();
	                open = true;
	            }
	            catch (Exception e) {
	                Thread.sleep(5000);
	            }
	        }
	        Logger.info("connected." );
	    };
		
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
}
