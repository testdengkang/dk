package com.aop.p2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 定义 aspect
 * 为Performance 添加新功能 非侵入
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.aop.p2.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
