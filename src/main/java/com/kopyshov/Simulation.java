package com.kopyshov;

import java.net.URL;
import java.util.ResourceBundle;

import com.kopyshov.actionmap.ActionMapModel;
import com.kopyshov.entities.EntityModel;
import com.kopyshov.entities.creatures.Carnivore;
import com.kopyshov.entities.creatures.Herbivore;
import com.kopyshov.views.ActionMapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class Simulation implements Initializable {
    @FXML
    public BorderPane mainView;
    public ActionMapView actionMapView;
    public ActionMapModel actionMapModel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actionMapModel = new ActionMapModel(15,8);
        actionMapView = new ActionMapView(actionMapModel.getxAxis(), actionMapModel.getyAxis());
        mainView.setCenter(actionMapView);
        actionMapModel.addObstaclesToModel();
        addSomeTestCreatures(3);
        actionMapView.updateView(actionMapModel);
    }

    private void addSomeTestCreatures(int count) {
        addCarnivores(count);
        addHerbivores(count);

    }

    private void addCarnivores(int count) {
        while (actionMapModel.carnivoresCurrentPosition.size() < count) {
            int x = (int) (Math.random() * (actionMapModel.getxAxis() - 1));
            int y = (int) (Math.random() * (actionMapModel.getyAxis() - 1));
            if(checkBusyNodes(x, y)){
                Carnivore carnivore = new Carnivore();
                carnivore.setX(x);
                carnivore.setY(y);
                actionMapModel.carnivoresCurrentPosition.add(carnivore);
            }
        }
    }

    private void addHerbivores(int count) {
        while (actionMapModel.herbivoresCurrentPosition.size() < count) {
            int x = (int) (Math.random() * (actionMapModel.getxAxis() - 1));
            int y = (int) (Math.random() * (actionMapModel.getyAxis() - 1));
            if(checkBusyNodes(x, y)){
                Herbivore herbivore = new Herbivore();
                herbivore.setX(x);
                herbivore.setY(y);
                actionMapModel.herbivoresCurrentPosition.add(herbivore);
            }
        }
    }

    private boolean checkBusyNodes(int x, int y) {
        boolean getToTheArray = true;
        for (EntityModel obstacle : actionMapModel.obstaclesCurrentPosition) {
            if ((x == obstacle.getX()) && (y == obstacle.getY())) {
                getToTheArray = false;
            }
        }
        for (Carnivore carn : actionMapModel.carnivoresCurrentPosition) {
            if ((x == carn.getX()) && (y == carn.getY())) {
                getToTheArray = false;
            }
        }
        for (Herbivore herb : actionMapModel.herbivoresCurrentPosition) {
            if ((x == herb.getX()) && (y == herb.getY())) {
                getToTheArray = false;
            }
        }

        return getToTheArray;
    }


    public void moveRight(ActionEvent actionEvent) {
    }
    public void moveLeft(ActionEvent actionEvent) {

    }
    public void moveUp(ActionEvent actionEvent) {

    }
    public void moveDown(ActionEvent actionEvent) {

    }


}
