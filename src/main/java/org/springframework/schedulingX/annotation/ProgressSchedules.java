package org.springframework.schedulingX.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ProgressSchedules {
    ProgressScheduled[] value();
}
