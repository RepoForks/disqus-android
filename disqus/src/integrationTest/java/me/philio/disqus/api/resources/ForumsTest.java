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

import android.test.suitebuilder.annotation.LargeTest;

import java.util.List;

import me.philio.disqus.api.exception.ApiException;
import me.philio.disqus.api.model.Response;
import me.philio.disqus.api.model.category.Category;
import me.philio.disqus.api.model.forums.Forum;
import me.philio.disqus.api.model.forums.Moderator;

public class ForumsTest extends ResourceTestCase {

    /**
     * Forums resource
     */
    private Forums mForums;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mForums = mApiClient.createForums();
    }

    /**
     * Test adding a moderator
     *
     * @throws ApiException
     */
    @LargeTest
    public void testAddModerator() throws ApiException {
        Response<Moderator> moderator = mForums.addModerator(1,
                "disqusforandroidintegrationtesting");
        assertNotNull(moderator);
        assertNotNull(moderator.data);
        assertTrue(moderator.data.id > 0);
    }

    /**
     * Test creating a forum
     *
     * @throws ApiException
     */
    @LargeTest
    public void testCreate() throws ApiException {
        String timestamp = Long.toString(System.currentTimeMillis());
        Response<Forum> forum = mForums.create("http://test.com/", "Integration test " + timestamp,
                "integration-test-" + timestamp);
        assertNotNull(forum);
        assertNotNull(forum.data);
        assertEquals("http://test.com/", forum.data.url);
        assertEquals("Integration test " + timestamp, forum.data.name);
        assertEquals("integration-test-" + timestamp, forum.data.id);
    }

    /**
     * Test creating a forum with guidelines
     *
     * @throws ApiException
     */
    @LargeTest
    public void testCreateGuidelines() throws ApiException {
        String timestamp = Long.toString(System.currentTimeMillis());
        Response<Forum> forum = mForums.create("http://test.com/", "Integration test " + timestamp,
                "integration-test-" + timestamp, "Forum guidelines");
        assertNotNull(forum);
        assertNotNull(forum.data);
        assertEquals("http://test.com/", forum.data.url);
        assertEquals("Integration test " + timestamp, forum.data.name);
        assertEquals("integration-test-" + timestamp, forum.data.id);
        assertEquals("Forum guidelines", forum.data.rawGuidelines);
        assertTrue(forum.data.guidelines.contains("Forum guidelines"));
    }

    /**
     * Test get details of a forum
     *
     * @throws ApiException
     */
    @LargeTest
    public void testDetails() throws ApiException {
        String timestamp = Long.toString(System.currentTimeMillis());
        mForums.create("http://test.com/", "Integration test " + timestamp,
                "integration-test-" + timestamp);
        Response<Forum> forum = mForums.details("integration-test-" + timestamp);
        assertNotNull(forum);
        assertNotNull(forum.data);
        assertEquals("http://test.com/", forum.data.url);
        assertEquals("Integration test " + timestamp, forum.data.name);
        assertEquals("integration-test-" + timestamp, forum.data.id);
    }

    /**
     * Test get details of a forum with related author
     *
     * @throws ApiException
     */
    @LargeTest
    public void testDetailsRelatedAuthor() throws ApiException {
        String timestamp = Long.toString(System.currentTimeMillis());
        mForums.create("http://test.com/", "Integration test " + timestamp,
                "integration-test-" + timestamp);
        Response<Forum> forum = mForums.details("integration-test-" + timestamp,
                new String[]{"author"});
        assertNotNull(forum);
        assertNotNull(forum.data);
        assertEquals("http://test.com/", forum.data.url);
        assertEquals("Integration test " + timestamp, forum.data.name);
        assertEquals("integration-test-" + timestamp, forum.data.id);
        assertNotNull(forum.data.author);
        assertEquals(forum.data.founder, forum.data.author.id);
    }

    /**
     * Test following a forum
     *
     * @throws ApiException
     */
    @LargeTest
    public void testFollow() throws ApiException {
        Response<List<Object>> response = mForums.follow("disqusforandroidintegrationtesting");
        assertNotNull(response);
        assertEquals(0, response.code);
        assertNotNull(response.data);
    }

    /**
     * Test list categories executes successfully
     *
     * @throws ApiException
     */
    @LargeTest
    public void testListCategories() throws ApiException {
        Response<List<Category>> categories = mForums.listCategories("disqusforandroidintegrationtesting");
        assertNotNull(categories);
        assertEquals(0, categories.code);
        assertNotNull(categories.data);
    }

}