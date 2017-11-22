package com.qlin.smart.controller;

import com.qlin.smart.common.MessageInfo;
import com.qlin.smart.common.MessageStatus;
import com.qlin.smart.common.model.CommonParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：tomfang
 * 日期：2017-11-22
 * 描述：统一访问入口
 */
@RestController
@RequestMapping("shop")
public class UnifyEntryController implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(UnifyEntryController.class);

    private ApplicationContext applicationContext;

    @RequestMapping(value = "{interface}/{method}")
    public MessageInfo jsonPortal(@PathVariable("interface") String inf, @PathVariable("method") String method, @RequestBody CommonParam param, HttpServletRequest request) {
        MessageInfo msg = new MessageInfo();
        if (null == inf || null == method) {
            msg.setStatusAndMessage(MessageStatus.ERROR.getStatus(), "接口访问连接有误");
            return msg;
        }
        try {
            String user = param.getUser();
            if (null == user) {
                //从缓存重新取一下用户
            }
            Object bean = applicationContext.getBean(inf);
            if (null == bean) {
                msg.setStatusAndMessage(MessageStatus.DATA_NOT_EXISTS.getStatus(), "接口不存在");
                return msg;
            }
            Method m = bean.getClass().getDeclaredMethod(method, CommonParam.class);
            if (null == m) {
                msg.setStatusAndMessage(MessageStatus.DATA_NOT_EXISTS.getStatus(), "方法不存在");
                return msg;
            }
            Object result = m.invoke(bean, param);
            if (null != request) {
                msg = (MessageInfo) result;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.error("接口{}调用{}失败，没有对应方法：" + e.getCause(), inf, method);
            msg.setStatusAndMessage(MessageStatus.SYS_ERROR.getStatus(), (String.format("接口%s调用%s失败，反射调用异常：%s", inf, method, e.getCause())));
            return msg;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logger.error("接口{}调用{}失败，反射调用异常：" + e.getCause(), inf, method);
            msg.setStatusAndMessage(MessageStatus.SYS_ERROR.getStatus(), (String.format("接口%s调用%s失败，反射调用异常：%s", inf, method, e.getCause())));
            return msg;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            logger.error("接口{}调用{}失败，反射调用异常：" + e.getCause(), inf, method);
            msg.setStatusAndMessage(MessageStatus.SYS_ERROR.getStatus(), (String.format("接口%s调用%s失败，反射调用异常：%s", inf, method, e.getCause())));
            return msg;
        }
        return msg;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
