package com.myapp.core.listeners;

import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;


@Component(immediate = true, service = EventListener.class)
public class JCREventHandler implements EventListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Session session;

    @Reference
    private SlingRepository slingRepository;

    @Override
    public void onEvent(EventIterator eventIterator) {
        try{
            session = slingRepository.loginService("admin", null);

            session.getWorkspace().getObservationManager().addEventListener(
                    this,
                    Event.PROPERTY_ADDED | Event.PROPERTY_CHANGED,
                    "/content/myapp/us/en",
                    true,
                    null,
                    null,
                    false
            );

            logger.info("JCR Event Handler Listener");
        }catch (RepositoryException e){
            logger.info("Error while adding Event Listener");
        }
    }
}
