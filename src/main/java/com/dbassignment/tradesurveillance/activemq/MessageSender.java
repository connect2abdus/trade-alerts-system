package com.dbassignment.tradesurveillance.activemq;

import static com.dbassignment.tradesurveillance.activemq.ActiveMQConfig.REGULATOR_REPORT_QUEUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.dbassignment.tradesurveillance.model.TraderInfo;

@Service
public class MessageSender {
	private static Logger log = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(TraderInfo treaderInfo) {
        log.info("sending with convertAndSend() to queue <" + treaderInfo + ">");
        jmsTemplate.convertAndSend(REGULATOR_REPORT_QUEUE, treaderInfo);
    }
}
