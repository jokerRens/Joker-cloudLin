package com.joker.designmode.prototype;

/**
 * EventTemplate
 *
 * @author joker
 * @version 1.0
 * 2022/3/10 16:57
 **/

public class EventTemplate {

    private String eventContent;

    private String eventSubject;

    public EventTemplate(String eventContent, String eventSubject) {
        this.eventContent = eventContent;
        this.eventSubject = eventSubject;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventSubject() {
        return eventSubject;
    }

    public void setEventSubject(String eventSubject) {
        this.eventSubject = eventSubject;
    }
}
