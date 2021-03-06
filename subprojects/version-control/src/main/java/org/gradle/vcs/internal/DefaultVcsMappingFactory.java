/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.vcs.internal;

import org.gradle.api.artifacts.component.ComponentSelector;
import org.gradle.internal.reflect.Instantiator;

public class DefaultVcsMappingFactory implements VcsMappingFactory {
    private final Instantiator instantiator;
    private final VersionControlSpecFactory specFactory;

    public DefaultVcsMappingFactory(Instantiator instantiator, VersionControlSpecFactory specFactory) {
        this.instantiator = instantiator;
        this.specFactory = specFactory;
    }

    @Override
    public VcsMappingInternal create(ComponentSelector selector) {
        return instantiator.newInstance(DefaultVcsMapping.class, selector, specFactory);
    }
}
