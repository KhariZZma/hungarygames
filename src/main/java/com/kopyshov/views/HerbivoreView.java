package com.kopyshov.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HerbivoreView extends Pane {
    static boolean changePicture = true;
    private Image image;
    public HerbivoreView() {
        if(changePicture) {
            image = new Image("com/kopyshov/icons/deer.png");
            changePicture = false;
        } else {
            image = new Image("com/kopyshov/icons/herbivore.png");
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
