package ru.recipe.app.recipeapp.model;

import lombok.Data;

@Data
public class Ingredients {

    private String name;
    private int count;
    private String measure;

    public Ingredients(String name, int count, String measure) {
        setName(name);
        setCount(count);
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Default";
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        } else {
            this.count = -1;
        }
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        if (measure != null && !measure.isBlank()) {
            this.measure = measure;
        } else {
            this.measure = "Default";
        }
    }
}
