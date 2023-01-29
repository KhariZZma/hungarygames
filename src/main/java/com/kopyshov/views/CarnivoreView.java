package com.kopyshov.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CarnivoreView extends Pane {
    static boolean changePicture = true;
    private Image image;
    public CarnivoreView() {
        if(changePicture) {
            image = new Image("com/kopyshov/icons/carnivoreview.png");
            changePicture = false;
        } else {
            image = new Image("com/kopyshov/icons/catview.png");
            changePicture = true;
        }
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.widthProperty());
        imageView.fitHeightProperty().bind(this.heightProperty());
        this.setMaxWidth(Double.MAX_VALUE);
        this.getChildren().add(imageView);
    }
}
