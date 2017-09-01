/**
 * Black Duck Hub Plugin for SonarQube
 *
 * Copyright (C) 2017 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blackducksoftware.integration.hub.sonar.compute;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.MeasureComputer;

import com.blackducksoftware.integration.hub.sonar.metric.HubSonarMetrics;

public class ComputeComponentNames implements MeasureComputer {
    private static final String METRIC_KEY = HubSonarMetrics.COMPONENT_NAMES.getKey();

    @Override
    public MeasureComputerDefinition define(final MeasureComputerDefinitionContext defContext) {
        return defContext.newDefinitionBuilder().setOutputMetrics(METRIC_KEY).build();
    }

    @Override
    public void compute(final MeasureComputerContext context) {
        if (context.getComponent().getType() != Component.Type.FILE) {
            context.addMeasure(METRIC_KEY, "View Components");
        }
    }
}
