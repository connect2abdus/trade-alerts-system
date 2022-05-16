package com.dbassignment.tradesurveillance.activemq;

import static com.dbassignment.tradesurveillance.activemq.ActiveMQConfig.REGULATOR_REPORT_QUEUE;

import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.dbassignment.tradesurveillance.model.TraderInfo;

@Component
public class MessageConsumer {
	private static Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = REGULATOR_REPORT_QUEUE)
    public void receiveMessage(@Payload TraderInfo traderInfo,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("---***** In MessageConsumer: Received reported TraderInfo message From  <" + traderInfo + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message);
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
