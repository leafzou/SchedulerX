package org.springframework.schedulingX.listener;


import org.springframework.schedulingX.annotation.Task;

@FunctionalInterface
public interface TaskUpdateListener {
    void onUpdate(Task task);
}
