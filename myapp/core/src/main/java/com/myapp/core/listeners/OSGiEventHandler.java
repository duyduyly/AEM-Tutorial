package com.myapp.core.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

import static com.myapp.core.constant.Constant.*;

@Component(
        service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=" + RESOURCE_EVENT_ADD,
                EventConstants.EVENT_TOPIC + "=" + RESOURCE_EVENT_CHANGED,
                EventConstants.EVENT_TOPIC + "=" + RESOURCE_EVENT_REMOVED,
                EventConstants.EVENT_FILTER + "=" + "(path=/content/myapp/us/en/*)" //path of resource (take from content)
        }
)
public class OSGiEventHandler implements EventHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handleEvent(Event event) {
        Map<String,Object> propertiesMap = new HashMap<>();
        for (String key :event.getPropertyNames()) {
            Object property = event.getProperty(key);
            propertiesMap.put(key, property);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("PropertiesName", propertiesMap);
        map.put("TOPIC",event.getTopic());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(map);
            logger.info("=========================== Modifier in (content/myapp/us/en/) resource =============================");
            logger.info(json);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
