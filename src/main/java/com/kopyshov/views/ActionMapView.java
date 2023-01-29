package com.kopyshov.views;

import com.kopyshov.actionmap.ActionMapModel;
import com.kopyshov.entities.EntityModel;
import com.kopyshov.entities.creatures.Carnivore;
import com.kopyshov.entities.creatures.Herbivore;
import com.kopyshov.entities.obstacles.Rock;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class ActionMapView extends GridPane {
    //Основное поле симуляции
    public ActionMapView(int xAxis, int yAxis) {
        this.setPadding(new Insets(5));
        for (int j = 0; j < xAxis; j++) {
            ColumnConstraints column = new ColumnConstraints(20, 20, Double.MAX_VALUE);
            column.setHgrow(Priority.ALWAYS);

            this.getColumnConstraints().add(column);
        }
        for (int i = 0; i < yAxis; i++) {
            RowConstraints row = new RowConstraints(20, 20, Double.MAX_VALUE);
            row.setVgrow(Priority.ALWAYS);
            this.getRowConstraints().add(row);
        }

        this.setGridLinesVisible(true);
    }

    public void updateView(ActionMapModel actionMapModel) {
        this.getChildren().clear();
        addObstacles(actionMapModel);
        addCarnivores(actionMapModel);
        addHerbivores(actionMapModel);
    }

    private void addObstacles(ActionMapModel actionMapModel) {
        for (EntityModel entityModel :
                actionMapModel.obstaclesCurrentPosition) {
            int x = entityModel.getX();
            int y = entityModel.getY();
            if(entityModel.getClass().equals(Rock.class)) {
                this.add(new RockView(), x, y);
            } else {
                this.add(new TreeView(), x, y);
            }
        }
    }

    private void addCarnivores(ActionMapModel actionMapModel) {
        for (Carnivore carnivore :
                actionMapModel.carnivoresCurrentPosition) {
            int x = carnivore.getX();
            int y = carnivore.getY();
            this.add(new CarnivoreView(), x, y);
        }
    }

    private void addHerbivores(ActionMapModel actionMapModel) {
        for (Herbivore herbivore :
                actionMapModel.herbivoresCurrentPosition) {
            int x = herbivore.getX();
            int y = herbivore.getY();
            this.add(new HerbivoreView(), x, y);
        }
    }

}
