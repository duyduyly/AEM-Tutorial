package com.myapp.core.models;

import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class NavModelTest {
    private NavModel navModel;

    private Page page;
    private Resource resource;

    @BeforeEach
    public void setup(AemContext context) throws Exception {

        // prepare a page with a test resource
        page = context.create().page("/content/mypage");
        resource = context.create().resource(page, "name",
                "sling:resourceType", "myapp/components/content/navModel");

        // create sling model
        navModel = resource.adaptTo(NavModel.class);
    }

    @Test
    void testGetMessage() throws Exception {
        // some very basic junit tests
        String name = navModel.getName();
        assertNotNull(name);
        assertTrue(StringUtils.contains(name, resource.getResourceType()));
        assertTrue(StringUtils.contains(name, page.getPath()));
    }
}