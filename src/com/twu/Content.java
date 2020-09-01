package com.twu;

import java.util.Comparator;

public class Content{
    int ticket;
    String content;
    int rank = 10;
    int super_moderator;

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int nowTicket(int ticket){
        this.ticket = this.ticket + ticket;
        return ticket;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuper_moderator() {
        return super_moderator;
    }

    public void setSuper_moderator(int super_moderator) {
        this.super_moderator = super_moderator;
    }

    //    public int compareTo(Content value) {
//        return 0;
//    }
}
