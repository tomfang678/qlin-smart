package com.qlin.smart.common.mq;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 作者：tomfang
 * 日期：2017-11-22
 * 描述：
 */
public class JmsUtil {

    public static MessageCreator createMsg(final Object o) {
        if (null == o) return null;
        return new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String str;
                if (o instanceof String) {
                    str = o.toString();
                } else {
                    str = JSON.toJSONString(o);
                }
                return session.createTextMessage(str);
            }
        };
    }

    public static void sendMessage(String destination, Object msg, JmsTemplate jmsTemplate) {
        if (null == destination || null == msg) throw new RuntimeException("destination or message  is null");
        MessageCreator messageCreator = createMsg(msg);
        jmsTemplate.send(new ActiveMQQueue(destination), messageCreator);
    }
}
