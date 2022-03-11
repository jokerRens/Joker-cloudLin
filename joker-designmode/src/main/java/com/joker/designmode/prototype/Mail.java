package com.joker.designmode.prototype;

import java.util.Map;

/**
 * Mail
 *
 * @author joker
 * @version 1.0
 * 2022/3/10 16:56
 **/

public class Mail  implements Cloneable{

    private String title;

    private String subject;

    public Mail(EventTemplate event) {
        this.title = event.getEventContent();
        this.subject = event.getEventSubject();
        try {
            //模拟创建对象耗时1s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        Mail mail = (Mail)super.clone();
        return mail;
    }

    public Mail(String title, String subject) {
        this.title = title;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
