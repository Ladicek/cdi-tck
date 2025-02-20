package org.jboss.cdi.tck.tests.definition.stereotype.broken.multiplePriorities.inherited;

import jakarta.enterprise.inject.Stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Stereotype
@AnotherStereotypeWithPriority
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherDumbStereotype {
}
