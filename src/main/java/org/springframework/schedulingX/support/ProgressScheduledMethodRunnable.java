package org.springframework.schedulingX.support;

import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.schedulingX.annotation.Task;
import org.springframework.schedulingX.listener.ProgressListener;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class ProgressScheduledMethodRunnable extends ScheduledMethodRunnable {

    private final ProgressListener progressListener;

    private Task scheduler;

    public ProgressScheduledMethodRunnable(Object target, Method method, ProgressListener progressListener, Task scheduler) {
        super(target, method);
        this.progressListener = progressListener;
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(super.getMethod());
            System.out.println("----------------before method invoke, triggerName: " + scheduler.getTaskName());
            super.getMethod().invoke(super.getTarget(), progressListener);
        } catch (InvocationTargetException ex) {
            ReflectionUtils.rethrowRuntimeException(ex.getTargetException());
        } catch (IllegalAccessException ex) {
            throw new UndeclaredThrowableException(ex);
        }
    }

}

