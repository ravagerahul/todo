package com.example.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    private int id;
    private String description;
    private String priority;

    public Todo(){

    }
    public Todo(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
