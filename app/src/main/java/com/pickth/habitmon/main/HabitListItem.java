package com.pickth.habitmon.main;

/**
 * Created by Kim on 2017-02-11.
 */

public class HabitListItem {
    private String title;
    private String explanation;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public HabitListItem(String title, String explanation) {
        this.title = title;
        this.explanation = explanation;
    }
}
