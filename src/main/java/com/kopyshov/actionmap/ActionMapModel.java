package com.kopyshov.actionmap;

import com.kopyshov.entities.EntityModel;
import com.kopyshov.entities.creatures.Carnivore;
import com.kopyshov.entities.creatures.Herbivore;
import com.kopyshov.entities.obstacles.Rock;
import com.kopyshov.entities.obstacles.Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class ActionMapModel {
    private int xAxis;
    private int yAxis;
    public ArrayList<EntityModel> obstaclesCurrentPosition = new ArrayList<>();
    public HashSet<Carnivore> carnivoresCurrentPosition = new HashSet<>();
    public HashSet<Herbivore> herbivoresCurrentPosition = new HashSet<>();
    public ActionMapModel(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    public void addObstaclesToModel() {
        int width = this.xAxis;
        int height = this.yAxis;
        boolean stone = true;
        for(int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (Math.random() < 0.2) {
                    if(stone) {
                        Rock rock = new Rock();
                        rock.setX(column);
                        rock.setY(row);
                        this.obstaclesCurrentPosition.add(rock);
                        stone = false;
                    } else {
                        Tree tree = new Tree();
                        tree.setX(column);
                        tree.setY(row);
                        this.obstaclesCurrentPosition.add(tree);
                        stone = true;
                    }
                }
            }
        }
    }


    //Геттеры и сеттеры
    public int getxAxis() {
        return xAxis;
    }
    public int getyAxis() {
        return yAxis;
    }
    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }
    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }
}
