package com.kopyshov.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TreeView extends Pane {
    Image image = new Image("com/kopyshov/icons/tree.png");
    public TreeView() {
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(this.widthProperty());
        imageView.fitHeightProperty().bind(this.heightProperty());
        this.setMaxWidth(Double.MAX_VALUE);
        this.getChildren().add(imageView);
    }
}
