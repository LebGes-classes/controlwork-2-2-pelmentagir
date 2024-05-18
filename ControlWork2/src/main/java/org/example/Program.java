package org.example;

public class Program {
    String channel;
    BroadcastsTime time;
    String name;

    public Program(String channel, String time, String name) {
        this.channel = channel;
        this.time = new BroadcastsTime(time);
        this.name = name;
    }

    @Override
    public String toString() {
        return channel + ';' + time + ';' + name;
    }
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }
}