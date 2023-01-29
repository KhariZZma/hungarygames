package com.kopyshov.entities.creatures;

import com.kopyshov.entities.EntityModel;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Creature extends EntityModel {
    private final Integer id;
    private String name;
    public int moveSpeed;
    public int hitPoints;
    public Creature() {
        AtomicInteger idCounter = new AtomicInteger(0);
        this.id = idCounter.addAndGet(1);
        moveSpeed = 3;
        hitPoints = 2;
    }
    public void makeMove(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
