package com.myapp.core.models;

import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class NavModelTest {
    private NavModel navModel;
    private Page page;
    private Resource resource;

    private String name;
    private String url;

    @BeforeEach
    public void setup(AemContext context) throws Exception {
        name = "name";
        url = "myapp/components/navModel";

        Map<String, Object> map = new HashMap<>();
        map.put("sling:resourceType", "myapp/components/navModel");
        map.put("name", name);
        map.put("url", url);
        // prepare a page with a test resource
        page = context.create().page("/content/mypage");
        resource = context.create().resource(page,"navModel", map);

        // create sling model
        navModel = resource.adaptTo(NavModel.class);
    }

    @Test
    void testGetMessage() throws Exception {
        assertNotNull(navModel);
        // some very basic junit tests
        String nameEqual = navModel.getName();
        String urlEqual = navModel.getUrl();
        assertNotNull(name);
        assertNotNull(url);
        assertEquals(nameEqual, name);
        assertEquals(urlEqual, url);
    }
}