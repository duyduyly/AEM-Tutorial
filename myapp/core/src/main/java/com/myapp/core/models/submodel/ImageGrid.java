package com.myapp.core.models.submodel;

public class ImageGrid {
    
    private String horizontal1;
    private String vertical1;

    private String horizontal2;
    private String vertical2;

    private String horizontal3;
    private String vertical3;

    private String horizontal4;
    private String vertical4;

    public ImageGrid(String horizontal1, String vertical1, String horizontal2, String vertical2, String horizontal3, String vertical3, String horizontal4, String vertical4) {
        this.horizontal1 = horizontal1;
        this.vertical1 = vertical1;
        this.horizontal2 = horizontal2;
        this.vertical2 = vertical2;
        this.horizontal3 = horizontal3;
        this.vertical3 = vertical3;
        this.horizontal4 = horizontal4;
        this.vertical4 = vertical4;
    }

    public String getHorizontal1() {
        return horizontal1;
    }

    public void setHorizontal1(String horizontal1) {
        this.horizontal1 = horizontal1;
    }

    public String getVertical1() {
        return vertical1;
    }

    public void setVertical1(String vertical1) {
        this.vertical1 = vertical1;
    }

    public String getHorizontal2() {
        return horizontal2;
    }

    public void setHorizontal2(String horizontal2) {
        this.horizontal2 = horizontal2;
    }

    public String getVertical2() {
        return vertical2;
    }

    public void setVertical2(String vertical2) {
        this.vertical2 = vertical2;
    }

    public String getHorizontal3() {
        return horizontal3;
    }

    public void setHorizontal3(String horizontal3) {
        this.horizontal3 = horizontal3;
    }

    public String getVertical3() {
        return vertical3;
    }

    public void setVertical3(String vertical3) {
        this.vertical3 = vertical3;
    }

    public String getHorizontal4() {
        return horizontal4;
    }

    public void setHorizontal4(String horizontal4) {
        this.horizontal4 = horizontal4;
    }

    public String getVertical4() {
        return vertical4;
    }

    public void setVertical4(String vertical4) {
        this.vertical4 = vertical4;
    }
}
