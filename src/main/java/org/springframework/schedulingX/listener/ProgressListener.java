package org.springframework.schedulingX.listener;

@FunctionalInterface
public interface ProgressListener {
    void progress(int p);
}
