/*
 * Copyright 1999-2023 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.client.selector;

/**
 * Listener invoker.
 *
 * @param <E> the type of event received by the listener
 * @author lideyou
 */
public interface ListenerInvoker<E> {
    
    /**
     * Invoke inner listener.
     *
     * @param event event
     */
    void invoke(E event);
    
    /**
     * Mark the listener whether invoked once. It should return {@code true} after {@link #invoke(E)} called at lease once.
     *
     * @return {@code true} if this listener has invoked at least once, {@code false} otherwise
     */
    boolean isInvoked();
}
