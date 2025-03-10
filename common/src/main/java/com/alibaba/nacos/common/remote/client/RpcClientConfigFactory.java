/*
 * Copyright 1999-$toady.year Alibaba Group Holding Ltd.
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

package com.alibaba.nacos.common.remote.client;

import com.alibaba.nacos.common.remote.client.grpc.DefaultGrpcClientConfig;
import com.alibaba.nacos.common.remote.client.grpc.GrpcClientConfig;

import java.util.Map;
import java.util.Properties;

/**
 * RpcClientConfigFactory.
 *
 * @author Nacos
 */
public class RpcClientConfigFactory implements RpcConfigFactory {
    
    private static volatile RpcClientConfigFactory rpcClientConfigFactory;
    
    private RpcClientConfigFactory() {
    }
    
    public static RpcClientConfigFactory getInstance() {
        if (rpcClientConfigFactory == null) {
            synchronized (RpcClientConfigFactory.class) {
                if (rpcClientConfigFactory == null) {
                    rpcClientConfigFactory = new RpcClientConfigFactory();
                }
            }
        }
        return rpcClientConfigFactory;
    }
    
    @Override
    public GrpcClientConfig createGrpcClientConfig(Properties properties, Map<String, String> labels) {
        return DefaultGrpcClientConfig.newBuilder().setLabels(labels).buildSdkFromProperties(properties).build();
    }
}