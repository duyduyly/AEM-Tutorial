package com.myapp.core.models;

import com.myapp.core.models.submodel.ImageGrid;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GridImageModel {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ValueMapValue
    @Default(values = "title")
    private String title;

    @ValueMapValue
    private String imageTitle;

    @ValueMapValue
    private String id;


    public List<ImageGrid> imageGridList;


    @Inject
    private String createdTime;

    @Inject
    private Resource resource;


    public List<GridImageModel> getCollection() {
        List<GridImageModel> collectionList = new ArrayList<>();
        org.apache.sling.api.resource.Resource resource1 = resource.getChild("getCollection");

        if (Objects.nonNull(resource1)) {
            resource1.getChildren().forEach(item -> {
                List<ImageGrid> itemGridList = this.getImageGridList(item);
                GridImageModel collectionImageList = new GridImageModel();
                collectionImageList.setId(String.valueOf(item.getValueMap().get("id")));
                collectionImageList.setTitle(String.valueOf(item.getValueMap().get("title")));
                collectionImageList.setImageTitle(String.valueOf(item.getValueMap().get("imageTitle")));
                collectionImageList.setImageGridList(itemGridList);
                collectionList.add(collectionImageList);
                logger.info("Add Image into getCollection");
            });
        }

        return collectionList;
    }

    public List<ImageGrid> getImageGridList(org.apache.sling.api.resource.Resource itemResource) {
        List<ImageGrid> imageGrids = new ArrayList<>();
        org.apache.sling.api.resource.Resource getImageGrid = itemResource.getChild("getImageGridList");
        if (Objects.nonNull(getImageGrid)) {
            for (org.apache.sling.api.resource.Resource link : getImageGrid.getChildren()) {
                String horizontal1 = String.valueOf(link.getValueMap().get("horizontal1"));
                String vertical1 = String.valueOf(link.getValueMap().get("vertical1"));
                String horizontal2 = String.valueOf(link.getValueMap().get("horizontal2"));
                String vertical2 = String.valueOf(link.getValueMap().get("vertical2"));
                String horizontal3 = String.valueOf(link.getValueMap().get("horizontal3"));
                String vertical3 = String.valueOf(link.getValueMap().get("vertical3"));
                String horizontal4 = String.valueOf(link.getValueMap().get("horizontal4"));
                String vertical4 = String.valueOf(link.getValueMap().get("vertical4"));
                ImageGrid imageGrid = new ImageGrid(
                        horizontal1, vertical1,
                        horizontal2, vertical2,
                        horizontal3, vertical3,
                        horizontal4, vertical4
                );
                imageGrids.add(imageGrid);
            }
        }
        return imageGrids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public void setImageGridList(List<ImageGrid> imageGridList) {
        this.imageGridList = imageGridList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
