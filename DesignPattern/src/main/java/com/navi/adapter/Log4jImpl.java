package com.navi.adapter;

import org.apache.log4j.Logger;

/**
 * Log4jImpl Class
 *
 * @author ganxf
 * @date 2019-11-12
 */
public class Log4jImpl implements Log {


    private Logger logger;


    public Log4jImpl(String clazzName) {
        this.logger = Logger.getLogger(clazzName);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        logger.debug(msg);
    }
}
