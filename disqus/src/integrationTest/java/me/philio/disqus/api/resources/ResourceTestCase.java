/*
 * Copyright 2014 Phil Bayfield
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.philio.disqus.api.resources;

import junit.framework.TestCase;

import me.philio.disqus.api.ApiClient;
import me.philio.disqus.api.ApiConfig;

import static retrofit.RestAdapter.LogLevel;

/**
 * Resource test abstract class
 */
public abstract class ResourceTestCase extends TestCase {

    /**
     * ApiClient instance
     */
    protected ApiClient mApiClient;

    @Override
    protected void setUp() throws Exception {
        ApiConfig apiConfig =
                new ApiConfig("VOyNG8ABoNFyMj7KbAEyvPuQB6tvTPQb6hy4fK5U6kkluH1RePMEKfQw9EdLnaez",
                        "91ee5737b5b04465bc244ad036e3e3b2", "http://localhost/", LogLevel.FULL);
        mApiClient = new ApiClient(apiConfig);
    }

}
