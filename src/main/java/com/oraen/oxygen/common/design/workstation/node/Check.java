package com.oraen.oxygen.common.design.workstation.node;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Check {

    String value() default "";

    /** 字段的值要遵循的正则表达式 只对String类型的字段有效 */
    String norm() default ".*";

    /** 指明该对象的这个字段是否应该是唯一的 用于数据查重 */
    boolean unique() default false;

    /** 指明该对字段是否必须不为空 */
    boolean necessity() default  false;

    /** 通过该字段允许空 即necessity为false 可以指定默认值 */
    String lack() default "";

}
