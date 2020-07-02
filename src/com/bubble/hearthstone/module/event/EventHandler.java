package com.bubble.hearthstone.module.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
public @interface EventHandler {
    public HandlerType type() default HandlerType.DEFAULT;
}