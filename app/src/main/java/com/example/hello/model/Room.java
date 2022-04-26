package com.example.hello.model;

public class Room {
    private  String _id,name,cost;

    public Room(String id, String name, String cost) {
        this._id = id;
        this.name = name;
        this.cost = cost;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
