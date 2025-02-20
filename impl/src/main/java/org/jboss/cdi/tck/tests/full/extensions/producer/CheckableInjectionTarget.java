/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.cdi.tck.tests.full.extensions.producer;

import java.util.Set;

import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.enterprise.inject.spi.InjectionTarget;

public class CheckableInjectionTarget<T> implements InjectionTarget<T> {
    private InjectionTarget<T> wrappedInjectionTarget;
    private static boolean injectCalled;

    public CheckableInjectionTarget(InjectionTarget<T> originalInjectionTarget) {
        this.wrappedInjectionTarget = originalInjectionTarget;
    }

    public void inject(T instance, CreationalContext<T> ctx) {
        injectCalled = true;
        wrappedInjectionTarget.inject(instance, ctx);
    }

    public void postConstruct(T instance) {
        wrappedInjectionTarget.postConstruct(instance);
    }

    public void preDestroy(T instance) {
        wrappedInjectionTarget.preDestroy(instance);
    }

    public void dispose(T instance) {
        wrappedInjectionTarget.dispose(instance);
    }

    public Set<InjectionPoint> getInjectionPoints() {
        return wrappedInjectionTarget.getInjectionPoints();
    }

    public T produce(CreationalContext<T> ctx) {
        return wrappedInjectionTarget.produce(ctx);
    }

    public static boolean isInjectCalled() {
        return injectCalled;
    }

    public static void setInjectCalled(boolean injectCalled) {
        CheckableInjectionTarget.injectCalled = injectCalled;
    }

}
