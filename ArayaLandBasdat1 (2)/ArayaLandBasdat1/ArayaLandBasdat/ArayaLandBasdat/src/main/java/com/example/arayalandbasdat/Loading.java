package com.example.arayalandbasdat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Loading extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/LogoLoading.png")));
        logo.setFitWidth(500);
        logo.setFitHeight(500);



        logo.setBlendMode(BlendMode.ADD);


        Timeline timelineLogo = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(logo.opacityProperty(), 0.2)),
                new KeyFrame(Duration.seconds(2), new KeyValue(logo.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(4), new KeyValue(logo.opacityProperty(), 0.2))
        );
        timelineLogo.setCycleCount(Animation.INDEFINITE);
        timelineLogo.play();

        Glow glow = new Glow(0.8);
        logo.setEffect(glow);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(500);
        progressBar.setStyle("-fx-accent: #316d18; -fx-control-inner-background: #333333; -fx-border-radius: 50px;");
        Duration duration = Duration.seconds(3);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
                new KeyFrame(duration, new KeyValue(progressBar.progressProperty(), 1))
        );
        timeline.play();


        VBox main = new VBox(20);
        main.getChildren().addAll(logo,progressBar);
        main.setAlignment(Pos.CENTER);
        main.setStyle("-fx-background-color: black;");
        Scene scene = new Scene(main, Color.BLACK);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();

        Timeline closeTimeline = new Timeline(
                new KeyFrame(Duration.seconds(3.5), event -> stage.close())
        );
        closeTimeline.play();
    }
}
