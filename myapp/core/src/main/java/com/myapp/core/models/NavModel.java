package com.myapp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavModel {

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String url;

    @Inject
    private Resource resource;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NavModel> listNavModel(){
        Resource resource1 = resource.getChild("listNavModel");
        List<NavModel> navModels = new ArrayList<>();

        assert resource1 != null;
        for (Resource resource2:resource1.getChildren()) {
            NavModel navModel = new NavModel();
            navModel.setUrl(String.valueOf(resource2.getValueMap().get("url")));
            navModel.setName(String.valueOf(resource2.getValueMap().get("name")));

            navModels.add(navModel);
        }

        return navModels;
    }
}
