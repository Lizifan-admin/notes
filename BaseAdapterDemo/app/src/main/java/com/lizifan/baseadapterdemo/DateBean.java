package com.lizifan.baseadapterdemo;

public class DateBean {
    private String news;
    private String content;

    public DateBean(String news, String content) {
        this.news = news;
        this.content = content;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
