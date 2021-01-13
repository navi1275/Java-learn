package com.navi.adapter;

import java.lang.reflect.Constructor;

/**
 * LogFactory Class
 *
 * @author ganxf
 * @date 2019-11-12
 */
public final class LogFactory {

    private static Constructor<? extends Log> logConstructor;

    static {
        setImplementation(Log4jImpl.class);
    }

    private LogFactory(){

    }

    public static Log getLog(Class clazz){
        return getLog(clazz.getName());
    }

    public static Log getLog(String clazzName){

        try {
            return logConstructor.newInstance(clazzName);
        } catch (Exception e) {
            return null;
        }
    }


    private static void setImplementation(Class<? extends Log> implClass) {
        try {
            Constructor<? extends Log> candidate = implClass.getConstructor(String.class);
            Log log = candidate.newInstance(LogFactory.class.getName());
            if (log.isDebugEnabled()) {
                log.debug("Logging initialized using '" + implClass + "' adapter.");
            }
            logConstructor = candidate;
        } catch (Throwable t) {
        }
    }
}
