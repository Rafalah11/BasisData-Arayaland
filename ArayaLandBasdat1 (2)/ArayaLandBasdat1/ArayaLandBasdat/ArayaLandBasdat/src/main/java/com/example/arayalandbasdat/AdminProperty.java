package com.example.arayalandbasdat;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.TextField;

public class AdminProperty extends Application {


    Rectangle navigasi;
    HBox all;
    ScrollPane scrollPane;
    ImageView logo;
    ImageView logout;
    ImageView iconDashboard;
    ImageView iconManajemenPr;
    ImageView iconManajemenFs;
    ImageView iconManajemenKb;
    ImageView iconManajemenKm;
    GridPane navGridPane;
    StackPane contentkanan;
    StackPane navigasikiri;
    Text manajemenPrtxt;

    //usernameCalled
    Circle lingkaranActive;
    TextField username123;


    Line garisManajemenPrtxt;
    TextField searchProperti;
    ImageView search;
    ImageView L1;
    ImageView L2;
    ImageView L3;
    ImageView L4;
    ImageView L5;
    ImageView L6;
    ImageView L7;
    ImageView L8;
    ImageView L9;
    ImageView L10;
    ImageView L11;
    ImageView L12;

    ImageView G1;
    ImageView G2;
    ImageView G3;
    ImageView G4;
    ImageView G5;
    ImageView G6;
    ImageView G7;
    ImageView G8;
    ImageView G9;
    ImageView G10;
    ImageView G11;
    ImageView G12;

    ImageView highlightedImage;
    private Map<String, List<ImageView>> keywordObject;
    private int lastHighlightedIndex = -1;

    Rectangle R1;
    Rectangle R2;
    Rectangle R3;
    Rectangle R4;
    Rectangle R5;
    Rectangle R6;
    Rectangle R7;
    Rectangle Rppn;
    Rectangle R8;
    Rectangle R9;

    Text T1;
    Text T2;
    Text T3;
    Text T4;
    Text T5;
    Text T6;
    Text T7;
    Text Tppn;
    Text T8;
    Text T9;

    TextField TF1;
    TextField TF2;
    TextField TF3;
    TextField TF4;
    TextField TF5;
    TextField TF6;
    TextField TF7;
    TextField TFppn;
    TextField TF8;
    Button TF9;

    Rectangle borderfoto;
    ImageView properti;

    Button simpan;
    Button cancel;

    FileInputStream fileInputStream;

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Sesuaikan dengan URL database Anda
    private static final String DB_USER = "SYSTEM"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "SYSTEM"; // Ganti dengan password database Anda


    @Override
    public void start(Stage stage) throws Exception {
        MainLogin mainLogin = new MainLogin();

        logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logo.png")));
        logo.setFitWidth(200);
        logo.setFitHeight(200);
        logo.setTranslateX(-10);
        logo.setTranslateY(-660);

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

        iconDashboard = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Dashboard.png")));
        iconDashboard.setFitWidth(90);
        iconDashboard.setFitHeight(90);
        iconDashboard.setOnMouseEntered(event -> iconDashboard.setCursor(Cursor.HAND));
        iconDashboard.setOnMouseExited(event -> iconDashboard.setCursor(Cursor.DEFAULT));

        iconManajemenPr = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Manajemen_Properti.png")));
        iconManajemenPr.setFitWidth(100);
        iconManajemenPr.setFitHeight(100);
        iconManajemenPr.setOnMouseEntered(event -> iconManajemenPr.setCursor(Cursor.HAND));
        iconManajemenPr.setOnMouseExited(event -> iconManajemenPr.setCursor(Cursor.DEFAULT));

        iconManajemenFs = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Manajemen_Fasilitas.png")));
        iconManajemenFs.setFitWidth(100);
        iconManajemenFs.setFitHeight(100);
        iconManajemenFs.setOnMouseEntered(event -> iconManajemenFs.setCursor(Cursor.HAND));
        iconManajemenFs.setOnMouseExited(event -> iconManajemenFs.setCursor(Cursor.DEFAULT));

        iconManajemenKm = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Manajemen_Komunitas.png")));
        iconManajemenKm.setFitWidth(100);
        iconManajemenKm.setFitHeight(100);
        iconManajemenKm.setOnMouseEntered(event -> iconManajemenKm.setCursor(Cursor.HAND));
        iconManajemenKm.setOnMouseExited(event -> iconManajemenKm.setCursor(Cursor.DEFAULT));

        iconManajemenKb = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Manajemen_Kebersihan.png")));
        iconManajemenKb.setFitWidth(100);
        iconManajemenKb.setFitHeight(100);
        iconManajemenKb.setOnMouseEntered(event -> iconManajemenKb.setCursor(Cursor.HAND));
        iconManajemenKb.setOnMouseExited(event -> iconManajemenKb.setCursor(Cursor.DEFAULT));

        logout = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logout.png")));
        logout.setFitWidth(100);
        logout.setFitHeight(100);
        logout.setTranslateY(700);
        logout.setOnMouseEntered(event -> logout.setCursor(Cursor.HAND));
        logout.setOnMouseExited(event -> logout.setCursor(Cursor.DEFAULT));

        navGridPane = new GridPane();
        navGridPane.setVgap(80);
        navGridPane.add(iconDashboard,0,1);
        navGridPane.add(iconManajemenPr,0,2);
        navGridPane.add(iconManajemenFs,0,3);
        navGridPane.add(iconManajemenKm,0,4);
        navGridPane.add(iconManajemenKb,0,5);
        navGridPane.setAlignment(Pos.CENTER);
        navGridPane.setTranslateX(0);
        navGridPane.setTranslateY(-200);

        navigasi = new Rectangle(250,1500, Color.web("#316d18"));


        //content kanan

        manajemenPrtxt = new Text("Manajemen Properti");
        manajemenPrtxt.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 40px; "
                + "-fx-fill: #545454; -fx-font-weight: bold");
        manajemenPrtxt.setTranslateX(-380);
        manajemenPrtxt.setTranslateY(-430);

        //username

        lingkaranActive = new Circle(10,Color.LIMEGREEN);
        lingkaranActive.setTranslateY(-410);
        lingkaranActive.setTranslateX(450);


        username123 = new TextField(username);
        username123.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 17px;-fx-font-weight: bold; "
                + "-fx-prompt-text-fill: white; -fx-text-fill: white;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;"
                + "-fx-focus-color: transparent; "
                + "-fx-faint-focus-color: transparent; "
                + "-fx-highlight-fill: transparent; ");
        username123.setMaxWidth(200);
        username123.setTranslateX(530);
        username123.setTranslateY(-410);
        username123.setEditable(false);
        username123.setAlignment(Pos.CENTER);


        garisManajemenPrtxt = new Line();
        garisManajemenPrtxt.setStartX(270);  // Koordinat awal garis
        garisManajemenPrtxt.setEndX(1535);    // Koordinat akhir garis (sesuaikan panjang sesuai kebutuhan)
        garisManajemenPrtxt.setTranslateY(-380);  // Sesuaikan posisi vertikal
        garisManajemenPrtxt.setStroke(Color.web("#a6a6a6"));  // Warna garis
        garisManajemenPrtxt.setStrokeWidth(5);  // Ketebalan garis
        garisManajemenPrtxt.setTranslateX(0);

        searchProperti = new TextField();
        searchProperti.setPromptText("Cari Disini");
        searchProperti.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #316d18;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: white; -fx-text-fill: white;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        searchProperti.setMaxWidth(900);
        searchProperti.setTranslateY(-330);
        searchProperti.setTranslateX(-130);

        search = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/search.png")));
        search.setFitWidth(40);
        search.setFitHeight(40);
        search.setOnMouseEntered(event -> search.setCursor(Cursor.HAND));
        search.setOnMouseExited(event -> search.setCursor(Cursor.DEFAULT));
        search.setTranslateY(-330);
        search.setTranslateX(350);

        //OBJECT PRE-FORM
        L1 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti1.png")));
        L1.setFitWidth(200);
        L1.setFitHeight(40);
        L1.setTranslateY(-200);
        L1.setTranslateX(-450);

        Image imageG1 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR1.png"));
        G1 = new ImageView(imageG1);
        G1.setFitWidth(250);
        G1.setFitHeight(150);
        G1.setOnMouseEntered(event -> G1.setCursor(Cursor.HAND));
        G1.setOnMouseExited(event -> G1.setCursor(Cursor.DEFAULT));
        G1.setTranslateY(-100);
        G1.setTranslateX(-450);



        L2 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti2.png")));
        L2.setFitWidth(200);
        L2.setFitHeight(40);
        L2.setTranslateY(-200);
        L2.setTranslateX(0);


        Image imageG2 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR2.png"));
        G2 = new ImageView(imageG2);
        G2.setFitWidth(250);
        G2.setFitHeight(150);
        G2.setOnMouseEntered(event -> G2.setCursor(Cursor.HAND));
        G2.setOnMouseExited(event -> G2.setCursor(Cursor.DEFAULT));
        G2.setTranslateY(-100);
        G2.setTranslateX(0);


        L3 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti3.png")));
        L3.setFitWidth(200);
        L3.setFitHeight(40);
        L3.setTranslateY(-200);
        L3.setTranslateX(450);



        Image imageG3 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR3.png"));
        G3 = new ImageView(imageG3);
        G3.setFitWidth(250);
        G3.setFitHeight(150);
        G3.setOnMouseEntered(event -> G3.setCursor(Cursor.HAND));
        G3.setOnMouseExited(event -> G3.setCursor(Cursor.DEFAULT));
        G3.setTranslateY(-100);
        G3.setTranslateX(450);


        L4 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti4.png")));
        L4.setFitWidth(200);
        L4.setFitHeight(40);
        L4.setTranslateY(100);
        L4.setTranslateX(-450);


        Image imageG4 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR4.png"));
        G4 = new ImageView(imageG4);
        G4.setFitWidth(250);
        G4.setFitHeight(150);
        G4.setOnMouseEntered(event -> G4.setCursor(Cursor.HAND));
        G4.setOnMouseExited(event -> G4.setCursor(Cursor.DEFAULT));
        G4.setTranslateY(200);
        G4.setTranslateX(-450);


        L5 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti5.png")));
        L5.setFitWidth(200);
        L5.setFitHeight(40);
        L5.setTranslateY(100);
        L5.setTranslateX(0);


        Image imageG5 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR5.png"));
        G5 = new ImageView(imageG5);
        G5.setFitWidth(250);
        G5.setFitHeight(150);
        G5.setOnMouseEntered(event -> G5.setCursor(Cursor.HAND));
        G5.setOnMouseExited(event -> G5.setCursor(Cursor.DEFAULT));
        G5.setTranslateY(200);
        G5.setTranslateX(0);


        L6 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti6.png")));
        L6.setFitWidth(200);
        L6.setFitHeight(40);
        L6.setTranslateY(100);
        L6.setTranslateX(450);


        Image imageG6 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR6.png"));
        G6 = new ImageView(imageG6);
        G6.setFitWidth(250);
        G6.setFitHeight(150);
        G6.setOnMouseEntered(event -> G6.setCursor(Cursor.HAND));
        G6.setOnMouseExited(event -> G6.setCursor(Cursor.DEFAULT));
        G6.setTranslateY(200);
        G6.setTranslateX(450);


        L7 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti7.png")));
        L7.setFitWidth(200);
        L7.setFitHeight(40);
        L7.setTranslateY(400);
        L7.setTranslateX(-450);


        Image imageG7 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR7.png"));
        G7 = new ImageView(imageG7);
        G7.setFitWidth(250);
        G7.setFitHeight(150);
        G7.setOnMouseEntered(event -> G7.setCursor(Cursor.HAND));
        G7.setOnMouseExited(event -> G7.setCursor(Cursor.DEFAULT));
        G7.setTranslateY(500);
        G7.setTranslateX(-450);


        L8 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti8.png")));
        L8.setFitWidth(200);
        L8.setFitHeight(40);
        L8.setTranslateY(400);
        L8.setTranslateX(0);


        Image imageG8 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR8.png"));
        G8 = new ImageView(imageG8);
        G8.setFitWidth(250);
        G8.setFitHeight(150);
        G8.setOnMouseEntered(event -> G8.setCursor(Cursor.HAND));
        G8.setOnMouseExited(event -> G8.setCursor(Cursor.DEFAULT));
        G8.setTranslateY(500);
        G8.setTranslateX(0);


        L9 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti9.png")));
        L9.setFitWidth(200);
        L9.setFitHeight(40);
        L9.setTranslateY(400);
        L9.setTranslateX(450);


        Image imageG9 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR9.png"));
        G9 = new ImageView(imageG9);
        G9.setFitWidth(250);
        G9.setFitHeight(150);
        G9.setOnMouseEntered(event -> G9.setCursor(Cursor.HAND));
        G9.setOnMouseExited(event -> G9.setCursor(Cursor.DEFAULT));
        G9.setTranslateY(500);
        G9.setTranslateX(450);


        L10 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti10.png")));
        L10.setFitWidth(200);
        L10.setFitHeight(40);
        L10.setTranslateY(750);
        L10.setTranslateX(-450);


        Image imageG10 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR10.png"));
        G10 = new ImageView(imageG10);
        G10.setFitWidth(250);
        G10.setFitHeight(150);
        G10.setOnMouseEntered(event -> G10.setCursor(Cursor.HAND));
        G10.setOnMouseExited(event -> G10.setCursor(Cursor.DEFAULT));
        G10.setTranslateY(850);
        G10.setTranslateX(-450);


        L11 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti11.png")));
        L11.setFitWidth(200);
        L11.setFitHeight(40);
        L11.setTranslateY(750);
        L11.setTranslateX(0);


        Image imageG11 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR11.png"));
        G11 = new ImageView(imageG11);
        G11.setFitWidth(250);
        G11.setFitHeight(150);
        G11.setOnMouseEntered(event -> G11.setCursor(Cursor.HAND));G11.setOnMouseExited(event -> G11.setCursor(Cursor.DEFAULT));
        G11.setTranslateY(850);
        G11.setTranslateX(0);


        L12 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti12.png")));
        L12.setFitWidth(200);
        L12.setFitHeight(40);
        L12.setTranslateY(750);
        L12.setTranslateX(450);


        Image imageG12 = new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/GAMBAR12.png"));
        G12 = new ImageView(imageG12);
        G12.setFitWidth(250);
        G12.setFitHeight(150);
        G12.setOnMouseEntered(event -> G12.setCursor(Cursor.HAND));
        G12.setOnMouseExited(event -> G12.setCursor(Cursor.DEFAULT));
        G12.setTranslateY(850);
        G12.setTranslateX(450);

        ImageView[] imageViews = {G1, G2, G3, G4, G5, G6, G7, G8, G9, G10, G11, G12};

        // Start refreshing images
        refreshImages(imageViews);

        //FOR-FORM

        //fill 1
        R1 = new Rectangle();
        R1.setWidth(550);
        R1.setHeight(80);
        R1.setArcWidth(90);
        R1.setArcHeight(90);
        R1.setStyle("-fx-fill: #316d18;");
        R1.setTranslateX(-300);
        R1.setTranslateY(-280);


        T1 = new Text("NOMOR " +
                "\nPROPERTI");
        T1.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T1.setFill(Color.WHITE);
        T1.setTranslateX(-490);
        T1.setTranslateY(-280);


        TF1 = new TextField();
        TF1.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF1.setMaxWidth(350);
        TF1.setTranslateX(-210);
        TF1.setTranslateY(-280);
        TF1.setEditable(false);



        //fill2
        R2 = new Rectangle();
        R2.setWidth(550);
        R2.setHeight(80);
        R2.setArcWidth(90);
        R2.setArcHeight(90);
        R2.setStyle("-fx-fill: #316d18;");
        R2.setTranslateX(300);
        R2.setTranslateY(-280);


        T2 = new Text("NAMA " +
                "\nPROPERTI");
        T2.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T2.setTranslateX(110);
        T2.setTranslateY(-280);


        TF2 = new TextField();
        TF2.setPromptText("Masukkan Nama");
        TF2.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF2.setMaxWidth(350);
        TF2.setTranslateX(390);
        TF2.setTranslateY(-280);



        //fill3
        R3 = new Rectangle();
        R3.setWidth(550);
        R3.setHeight(80);
        R3.setArcWidth(90);
        R3.setArcHeight(90);
        R3.setStyle("-fx-fill: #316d18;");
        R3.setTranslateX(0);
        R3.setTranslateY(-80);


        T3 = new Text(" AREA");
        T3.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T3.setTranslateX(-190);
        T3.setTranslateY(-80);


        TF3 = new TextField();
        TF3.setPromptText("Masukkan Area");
        TF3.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF3.setMaxWidth(350);
        TF3.setTranslateX(90);
        TF3.setTranslateY(-80);



        //fill 4
        R4 = new Rectangle();
        R4.setWidth(550);
        R4.setHeight(80);
        R4.setArcWidth(90);
        R4.setArcHeight(90);
        R4.setStyle("-fx-fill: #316d18;");
        R4.setTranslateX(-300);
        R4.setTranslateY(150);


        T4 = new Text("LUAS TANAH");
        T4.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T4.setTranslateX(-490);
        T4.setTranslateY(150);


        TF4 = new TextField();
        TF4.setPromptText("Masukkan Luas (m\u00B2)");
        TF4.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF4.setMaxWidth(350);
        TF4.setTranslateX(-210);
        TF4.setTranslateY(150);
        TF4.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!TF4.getText().isEmpty()) {
                HitungHargaTanah();
                HitungPPN();
                HitungTotal();

            }else {
                TF5.setText("0");
            }
        });


        //fill5
        R5 = new Rectangle();
        R5.setWidth(550);
        R5.setHeight(80);
        R5.setArcWidth(90);
        R5.setArcHeight(90);
        R5.setStyle("-fx-fill: #316d18;");
        R5.setTranslateX(300);
        R5.setTranslateY(150);


        T5 = new Text("HARGA TANAH");
        T5.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T5.setTranslateX(110);
        T5.setTranslateY(150);


        TF5 = new TextField();
        TF5.setPromptText("Harga (Rp)");
        TF5.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF5.setMaxWidth(350);
        TF5.setTranslateX(390);
        TF5.setTranslateY(150);
        TF5.setEditable(false);



        //fill 6
        R6 = new Rectangle();
        R6.setWidth(550);
        R6.setHeight(80);
        R6.setArcWidth(90);
        R6.setArcHeight(90);
        R6.setStyle("-fx-fill: #316d18;");
        R6.setTranslateX(-300);
        R6.setTranslateY(380);


        T6 = new Text("LUAS " +
                "\nBANGUNAN");
        T6.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T6.setTranslateX(-490);
        T6.setTranslateY(380);


        TF6 = new TextField();
        TF6.setPromptText("Masukkan Luas (m\u00B2)");
        TF6.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF6.setMaxWidth(350);
        TF6.setTranslateX(-210);
        TF6.setTranslateY(380);
        TF6.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!TF6.getText().isEmpty()) {
                HitungHargaBangunan();
                HitungPPN();
                HitungTotal();

            }else {
                TF7.setText("0");
            }
        });



        //fill7
        R7 = new Rectangle();
        R7.setWidth(550);
        R7.setHeight(80);
        R7.setArcWidth(90);
        R7.setArcHeight(90);
        R7.setStyle("-fx-fill: #316d18;");
        R7.setTranslateX(300);
        R7.setTranslateY(380);


        T7 = new Text("HARGA " +
                "\nBANGUNAN");
        T7.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T7.setTranslateX(110);
        T7.setTranslateY(380);


        TF7 = new TextField();
        TF7.setPromptText("Masukkan Harga (Rp)");
        TF7.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF7.setMaxWidth(350);
        TF7.setTranslateX(390);
        TF7.setTranslateY(380);
        TF7.setEditable(false);



        //fillPPN(tambahan)
        Rppn = new Rectangle();
        Rppn.setWidth(550);
        Rppn.setHeight(80);
        Rppn.setArcWidth(90);
        Rppn.setArcHeight(90);
        Rppn.setStyle("-fx-fill: #316d18;");
        Rppn.setTranslateX(-300);
        Rppn.setTranslateY(610);


        Tppn = new Text("PPN (10%)");
        Tppn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        Tppn.setTranslateX(-490);
        Tppn.setTranslateY(610);


        TFppn = new TextField();
        TFppn.setPromptText("Masukkan PPN (10%)");
        TFppn.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TFppn.setMaxWidth(350);
        TFppn.setTranslateX(-210);
        TFppn.setTranslateY(610);
        TFppn.setEditable(false);






        //fill8
        R8 = new Rectangle();
        R8.setWidth(550);
        R8.setHeight(80);
        R8.setArcWidth(90);
        R8.setArcHeight(90);
        R8.setStyle("-fx-fill: #316d18;");
        R8.setTranslateX(300);
        R8.setTranslateY(610);


        T8 = new Text("HARGA TOTAL");
        T8.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T8.setTranslateX(110);
        T8.setTranslateY(610);


        TF8 = new TextField();
        TF8.setPromptText("Masukkan Harga (Rp)");
        TF8.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF8.setMaxWidth(350);
        TF8.setTranslateX(390);
        TF8.setTranslateY(610);
        TF8.setEditable(false);



        //fill 9
        R9 = new Rectangle();
        R9.setWidth(550);
        R9.setHeight(80);
        R9.setArcWidth(90);
        R9.setArcHeight(90);
        R9.setStyle("-fx-fill: #316d18;");
        R9.setTranslateX(-300);
        R9.setTranslateY(810);


        T9 = new Text("FOTO " +
                "\nPROPERTI");
        T9.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T9.setTranslateX(-490);
        T9.setTranslateY(810);


        TF9 = new Button("Upload Disini");
        TF9.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: green;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF9.setMaxWidth(350);
        TF9.setTranslateX(-210);
        TF9.setTranslateY(810);

        Text namaFoto = new Text("Belum memilih file .jpg/.png");
        namaFoto.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px;");
        namaFoto.setFill(Color.WHITE);
        namaFoto.setTranslateX(340);
        namaFoto.setTranslateY(898);

        properti = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/disini.png")));
        properti.setFitWidth(250);
        properti.setFitHeight(150);
        properti.setTranslateX(340);
        properti.setTranslateY(810);
        properti.setVisible(false);

        borderfoto = new Rectangle();
        borderfoto.setWidth(300);
        borderfoto.setHeight(200);
        borderfoto.setArcWidth(40);
        borderfoto.setArcHeight(40);
        borderfoto.setStyle("-fx-fill: #316d18;");
        borderfoto.setTranslateX(340);
        borderfoto.setTranslateY(810);



        TF9.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Gambar");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Gambar", "*.jpg", "*.png")
            );
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                try {
                    if (isValidImageSize(selectedFile)) {
                        //properti.setVisible(false);
                        namaFoto.setText(selectedFile.getName()+" ✅");
                        namaFoto.setFill(Color.WHITE);

                        fileInputStream = new FileInputStream(selectedFile);

                        Image img = new Image(new FileInputStream(selectedFile));
                        properti.setImage(img);
                        properti.setVisible(true);
                    } else {
                        namaFoto.setText("Ukuran gambar harus 250 x 150 piksel");
                    }
                } catch (IOException e) {
                    namaFoto.setText("Gagal membaca file");
                    e.printStackTrace();
                }
            }
        });

        TF9.setOnMouseEntered(event -> TF9.setCursor(Cursor.HAND));
        TF9.setOnMouseExited(event -> TF9.setCursor(Cursor.DEFAULT));


        simpan = new Button("Simpan");
        simpan.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #e2cf45;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: white;-fx-text-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        simpan.setPrefWidth(150);
        simpan.setTranslateY(950);
        simpan.setTranslateX(350);
        simpan.setOnMouseEntered(event -> simpan.setCursor(Cursor.HAND));
        simpan.setOnMouseExited(event -> simpan.setCursor(Cursor.DEFAULT));


        cancel = new Button("Batal");
        cancel.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #c40000;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: white;-fx-text-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        cancel.setPrefWidth(150);
        cancel.setTranslateY(950);
        cancel.setTranslateX(540);
        cancel.setOnMouseEntered(event -> cancel.setCursor(Cursor.HAND));
        cancel.setOnMouseExited(event -> cancel.setCursor(Cursor.DEFAULT));

        List<Node> fillButtonForm = Arrays.asList(simpan,cancel);
        for (Node node : fillButtonForm) {
            node.setVisible(false);
        }

        List<Node> fill = Arrays.asList(
                R1,T1,TF1,
                R2,T2,TF2,
                R3,T3,TF3,
                R4,T4,TF4,
                R5,T5,TF5,
                R6,T6,TF6,
                R7,T7,TF7,
                Rppn,Tppn,TFppn,
                R8,T8,TF8,
                R9,T9,TF9,
                borderfoto,
                namaFoto,
                properti,
                simpan,cancel);
        for (Node node : fill) {
            node.setVisible(false);
        }


        //main Layout
        navigasikiri = new StackPane();
        navigasikiri.getChildren().addAll(navigasi,logo,navGridPane, logout);

        contentkanan = new StackPane();
        contentkanan.getChildren().addAll(manajemenPrtxt,username123,lingkaranActive, garisManajemenPrtxt, searchProperti, search,
                L1,G1,
                L2,G2,
                L3,G3,
                L4,G4,
                L5,G5,
                L6,G6,
                L7,G7,
                L8,G8,
                L9,G9,
                L10,G10,
                L11,G11,
                L12,G12,

                R1,T1,TF1,
                R2,T2,TF2,
                R3,T3,TF3,
                R4,T4,TF4,
                R5,T5,TF5,
                R6,T6,TF6,
                R7,T7,TF7,
                Rppn,Tppn,TFppn,
                R8,T8,TF8,
                R9,T9,TF9,
                borderfoto,
                namaFoto,
                properti,
                simpan,cancel
        );
        contentkanan.setTranslateY(-250);

        all = new HBox(navigasikiri,contentkanan);


        scrollPane = new ScrollPane();
        scrollPane.setContent(all);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane);

        stage.setTitle("Admin Property");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        initializeKeywordObject();


        iconDashboard.setOnMouseClicked(mouseEvent -> {
            AdminDashboard adminDashboard = new AdminDashboard();
            try {
                Stage newStage = new Stage();
                adminDashboard.setUsername(username);
                adminDashboard.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        iconManajemenPr.setOnMouseClicked(mouseEvent -> {
            AdminProperty adminProperty = new AdminProperty();
            showSucces("Already in there","Anda sudah berada dihalaman Manajemen Properti");
            adminProperty.setUsername(username);
        });

        iconManajemenFs.setOnMouseClicked(mouseEvent -> {
            AdminFacility adminFacility = new AdminFacility();
            try {
                Stage newStage = new Stage();
                adminFacility.setUsername(username);
                adminFacility.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconManajemenKm.setOnMouseClicked(mouseEvent -> {
            AdminCommunity adminCommunity = new AdminCommunity();
            try {
                Stage newStage = new Stage();
                adminCommunity.setUsername(username);
                adminCommunity.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconManajemenKb.setOnMouseClicked(mouseEvent -> {
            AdminCS adminCS = new AdminCS();
            try {
                Stage newStage = new Stage();
                adminCS.setUsername(username);
                adminCS.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logout.setOnMouseClicked(mouseEvent -> {
            MainLogin mainLoginn = new MainLogin();
            try {
                Stage newStage = new Stage();
                mainLoginn.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        search.setOnMouseClicked(mouseEvent -> {
            String keyword = searchProperti.getText().toLowerCase();
            highlightImageByKeyword(keyword);
        });

        //form
        G1.setOnMouseClicked(mouseEvent -> {
            if (G1.getImage() == imageG1) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P001");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });



        G2.setOnMouseClicked(mouseEvent -> {
            if (G2.getImage() == imageG2) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P002");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G3.setOnMouseClicked(mouseEvent -> {
            if (G3.getImage() == imageG3) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P003");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G4.setOnMouseClicked(mouseEvent -> {
            if (G4.getImage() == imageG4) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P004");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G5.setOnMouseClicked(mouseEvent -> {
            if (G5.getImage() == imageG5) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P005");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G6.setOnMouseClicked(mouseEvent -> {
            if (G6.getImage() == imageG6) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P006");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G7.setOnMouseClicked(mouseEvent -> {
            if (G7.getImage() == imageG7) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P007");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        G8.setOnMouseClicked(mouseEvent -> {
            if (G8.getImage() == imageG8) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P008");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });



        G9.setOnMouseClicked(mouseEvent -> {
            if (G9.getImage() == imageG9) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P009");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });



        G10.setOnMouseClicked(mouseEvent -> {
            if (G10.getImage() == imageG10) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P010");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });

        G11.setOnMouseClicked(mouseEvent -> {
            if (G11.getImage() == imageG11) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P011");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });

        G12.setOnMouseClicked(mouseEvent -> {
            if (G12.getImage() == imageG12) {
                List<Node> obj = Arrays.asList(
                        searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4,
                        L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10,
                        L11, G11, L12, G12
                );

                // Menyembunyikan semua node dalam list obj
                for (Node node : obj) {
                    node.setVisible(false);
                }

                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        R6, T6, TF6,
                        R7, T7, TF7,
                        Rppn, Tppn, TFppn,
                        R8, T8, TF8,
                        R9, T9, TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel
                );

                // Menampilkan semua node dalam list fillShow
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF1.setText("P012");
            } else {
                showSucces("Uploaded", "Data sudah diupload di database");
            }
        });


        simpan.setOnAction((event -> {

            String nomor_properti = TF1.getText().trim();
            String nama_properti = TF2.getText().trim();
            String area_properti = TF3.getText().trim();

            if (nama_properti.isEmpty() || !isValidHuruf(nama_properti)  ){
                showAlert("NAMA PROPERTI","NAMA PROPERTI hanya boleh mengandung huruf dan minimal 3 karakter");
                TF2.clear();
                return;
            }

            if (area_properti.isEmpty() || !isValidHuruf(area_properti)  ){
                showAlert("AREA PROPERTI","AREA PROPERTI hanya boleh mengandung huruf dan minimal 3 karakter");
                TF3.clear();
                return;
            }


            String luas_tanahS = TF4.getText().trim();
            double luas_tanah = 0.0; // Default value jika input kosong atau tidak valid
            if (!luas_tanahS.isEmpty()) {
                try {
                    luas_tanah = Double.parseDouble(luas_tanahS.replace(",", ""));
                } catch (NumberFormatException e) {
                    showAlert("LUAS TANAH", "Format luas tanah tidak valid");
                    TF4.clear();
                    return;
                }
            } else {
                showAlert("LUAS TANAH", "LUAS TANAH harus diisi");
                return;
            }

            String harga1 = TF5.getText().replace(",", "").trim();
            double harga_tanah = 0.0; // Default value jika input kosong atau tidak valid
            if (!harga1.isEmpty()) {
                try {
                    harga_tanah = Double.parseDouble(harga1);
                } catch (NumberFormatException e) {
                    showAlert("HARGA TANAH", "Format harga tanah tidak valid");
                    TF5.clear();
                    return;
                }
            } else {
                showAlert("HARGA TANAH", "HARGA TANAH harus diisi");
                return;
            }

            String luas_bgnS = TF6.getText().trim();
            double luas_bgn = 0.0; // Default value jika input kosong atau tidak valid
            if (!luas_bgnS.isEmpty()) {
                try {
                    luas_bgn = Double.parseDouble(luas_bgnS.replace(",", ""));
                } catch (NumberFormatException e) {
                    showAlert("LUAS BANGUNAN", "Format luas bangunan tidak valid");
                    TF6.clear();
                    return;
                }
            } else {
                showAlert("LUAS BANGUNAN", "LUAS BANGUNAN harus diisi");
                return;
            }

            String harga2 = TF7.getText().replace(",", "").trim();
            double harga_bangunan = 0.0; // Default value jika input kosong atau tidak valid
            if (!harga2.isEmpty()) {
                try {
                    harga_bangunan = Double.parseDouble(harga2);
                } catch (NumberFormatException e) {
                    showAlert("HARGA BANGUNAN", "Format harga bangunan tidak valid");
                    TF7.clear();
                    return;
                }
            } else {
                showAlert("HARGA BANGUNAN", "HARGA BANGUNAN harus diisi");
                return;
            }

            String harga3 = TFppn.getText().replace(",", "").trim();
            double ppn = 0.0; // Default value jika input kosong atau tidak valid
            if (!harga3.isEmpty()) {
                try {
                    ppn = Double.parseDouble(harga3);
                } catch (NumberFormatException e) {
                    showAlert("PPN", "Format PPN tidak valid");
                    TFppn.clear();
                    return;
                }
            } else {
                showAlert("PPN", "PPN harus diisi");
                return;
            }

            String harga4 = TF8.getText().replace(",", "").trim();
            double harga_total = 0.0; // Default value jika input kosong atau tidak valid
            if (!harga4.isEmpty()) {
                try {
                    harga_total = Double.parseDouble(harga4);
                } catch (NumberFormatException e) {
                    showAlert("HARGA TOTAL", "Format harga total tidak valid");
                    TF8.clear();
                    return;
                }
            } else {
                showAlert("HARGA TOTAL", "HARGA TOTAL harus diisi");
                return;
            }

            if (luas_tanahS.isEmpty() || !isValidAngka(luas_tanahS)  ){
                showAlert("LUAS TANAH","LUAS TANAH hanya boleh mengandung angka dan minimal 3 digit");
                TF4.clear();
                return;
            }

            if (luas_bgnS.isEmpty() || !isValidAngka(luas_bgnS)  ){
                showAlert("LUAS BANGUNAN","LUAS BANGUNAN hanya boleh mengandung angka dan minimal 3 digit");
                TF6.clear();
                return;
            }

            if(namaFoto.getText().equals("Belum memilih file .jpg/.png")||namaFoto.getText().equals("Ukuran gambar harus 250 x 150 piksel")){
                showAlert("FOTO PROPERTI","FOTO PROPERTI belum diupload");
                return;
            }

            if(saveToDatabase(nomor_properti,nama_properti,area_properti,
                    luas_tanah,harga_tanah,luas_bgn,harga_bangunan,harga_total,ppn,fileInputStream)) {
                getImageFromDatabase(nomor_properti);
                showSucces("Success", "Data berhasil disimpan ke database");
                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
                for (Node node : obj) {
                    node.setVisible(true);
                }
                List<Node> fillShow = Arrays.asList(
                        R1,T1,TF1,
                        R2,T2,TF2,
                        R3,T3,TF3,
                        R4,T4,TF4,
                        R5,T5,TF5,
                        R6,T6,TF6,
                        R7,T7,TF7,
                        Rppn,Tppn,TFppn,
                        R8,T8,TF8,
                        R9,T9,TF9,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan,cancel);
                for (Node node : fillShow) {
                    node.setVisible(false);
                }
                TF1.clear();
                TF2.clear();
                TF3.clear();
                TF4.clear();
                TF5.clear();
                TF6.clear();
                TF7.clear();
                TFppn.clear();
                TF8.clear();
                properti.setImage(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/disini.png")));
                namaFoto.setText("Belum memilih file .jpg/.png");
            }


        }));

        cancel.setOnAction(event -> {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
            for (Node node : obj) {
                node.setVisible(true);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    R6,T6,TF6,
                    R7,T7,TF7,
                    Rppn,Tppn,TFppn,
                    R8,T8,TF8,
                    R9,T9,TF9,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(false);
            }
            TF1.clear();
            TF2.clear();
            TF3.clear();
            TF4.clear();
            TF5.clear();
            TF6.clear();
            TF7.clear();
            TFppn.clear();
            TF8.clear();

            properti.setImage(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/disini.png")));
            namaFoto.setText("Belum memilih file .jpg/.png");
        });
    }



    private void highlightImage(ImageView image) {
        resetHighlight();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.YELLOW);
        dropShadow.setRadius(50); // Adjusted for a thicker and more prominent shadow
        dropShadow.setSpread(0.7); // Increase spread to make the shadow more prominent
        dropShadow.setWidth(100); // Optional, adjusting width
        dropShadow.setHeight(100); // Optional, adjusting height

        image.setEffect(dropShadow);
        highlightedImage = image;
    }


    private void resetHighlight() {
        if (highlightedImage != null) {
            highlightedImage.setEffect(null);
        }
    }

    private void highlightImageByKeyword(String keyword) {
        List<ImageView> highlightedImages = keywordObject.get(keyword.toLowerCase());

        if (highlightedImages != null && !highlightedImages.isEmpty()) {
            resetHighlight();

            // Cari indeks objek terakhir yang di-highlight
            int currentIndex = lastHighlightedIndex;
            if (currentIndex == -1) {
                currentIndex = 0;
            } else {
                currentIndex = (currentIndex + 1) % highlightedImages.size();
            }

            ImageView highlightedImage = highlightedImages.get(currentIndex);
            highlightImage(highlightedImage);
            lastHighlightedIndex = currentIndex;

            // Scroll ke posisi gambar yang dicari
            scrollPaneToImage(highlightedImage);

            // Set nilai TextField sesuai dengan kata kunci
            searchProperti.setText(keyword);
        } else {
            searchProperti.clear();
            showAlert("Error","Pencarian Tidak Ditemukan");

        }
    }

    private void initializeKeywordObject() {
        keywordObject = new HashMap<>();


        keywordObject.put("properti 1",List.of(L1));
        keywordObject.put("properti 2",List.of(L2));
        keywordObject.put("properti 3",List.of(L3));
        keywordObject.put("properti 4",List.of(L4));
        keywordObject.put("properti 5",List.of(L5));
        keywordObject.put("properti 6",List.of(L6));
        keywordObject.put("properti 7",List.of(L7));
        keywordObject.put("properti 8",List.of(L8));
        keywordObject.put("properti 9",List.of(L9));
        keywordObject.put("properti 10",List.of(L10));
        keywordObject.put("properti 11",List.of(L11));
        keywordObject.put("properti 12",List.of(L12));


    }

    private double calculateScrollPosition(ImageView image) {
        double totalHeight = all.getBoundsInParent().getHeight();
        double imageY = image.getBoundsInParent().getMinY();
        double imageHeight = image.getBoundsInParent().getHeight();

        // Menghitung posisi relatif gambar pada ScrollPane
        return imageY / totalHeight + (imageHeight / (2 * totalHeight));
    }

    private void scrollPaneToImage(ImageView image) {
        double scrollPosition = calculateScrollPosition(image);
        scrollPane.setVvalue(scrollPosition);
    }

    private void showSucces(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean isValidHuruf(String huruf) {
        return huruf.matches("[a-zA-Z\\s]{3,}");
    }
    private boolean isValidAngka(String angka) {
        return angka.matches("\\d{3,}");
    }


    private void HitungHargaTanah() {
        final double hargaPerMeter = 10000000;
        String text = TF4.getText().trim();

        if (text.isEmpty() || text.equals("0")) {
            TF5.setText("Missing");
        } else {
            try {
                double a = Double.parseDouble(text);
                double hasil = a * hargaPerMeter;
                String formatTF = String.format("%,.0f", hasil);
                TF5.setText(formatTF);
            } catch (NumberFormatException e) {
                TF5.setText("Invalid Input");
                TF8.setText("Invalid Input");
                TFppn.setText("Invalid Input");
            }
        }

        // Jika pengguna menghapus teks setelah mengetik sesuatu
        TF4.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                TF5.setText("Missing");
                TF8.setText("Missing");
                TFppn.setText("Missing");
            }
        });
    }

    private void HitungHargaBangunan() {
        final double hargaPerMeter = 5000000;
        String text = TF6.getText().trim();

        if (text.isEmpty() || text.equals("0")) {
            TF7.setText("Missing");
        } else {
            try {
                double a = Double.parseDouble(text);
                double hasil = a * hargaPerMeter;
                String formatTF = String.format("%,.0f", hasil);
                TF7.setText(formatTF);
            } catch (NumberFormatException e) {
                TF7.setText("Invalid Input");
                TF8.setText("Invalid Input");
                TFppn.setText("Invalid Input");
            }
        }

        // Jika pengguna menghapus teks setelah mengetik sesuatu
        TF6.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                TF7.setText("Missing");
                TF8.setText("Missing");
                TFppn.setText("Missing");
            }
        });
    }


    private void HitungTotal() {
        String textA = TF5.getText().replace(",", "").trim();
        String textB = TF7.getText().replace(",", "").trim();
        String textC = TFppn.getText().replace(",", "").trim();

        if (TF4.getText().trim().isEmpty() || TF4.getText().trim().equals("0") ||
                TF6.getText().trim().isEmpty() || TF6.getText().trim().equals("0") ||
                textA.isEmpty() || textB.isEmpty()) {
            TF8.setText("Missing");
        } else {
            try {
                double a = Double.parseDouble(textA);
                double b = Double.parseDouble(textB);
                double c = Double.parseDouble(textC);
                double hasil = a + b + c;
                String formatTF = String.format("%,.0f", hasil);
                TF8.setText(formatTF);
            } catch (NumberFormatException e) {
                TF8.setText("Invalid input");
            }
        }
    }

    private void HitungPPN(){
        String textA = TF5.getText().replace(",", "").trim();
        String textB = TF7.getText().replace(",", "").trim();

        if (TF4.getText().trim().isEmpty() || TF4.getText().trim().equals("0") ||
                TF6.getText().trim().isEmpty() || TF6.getText().trim().equals("0") ||
                textA.isEmpty() || textB.isEmpty()) {
            TFppn.setText("Missing");
        } else {
            try {
                double a = Double.parseDouble(textA);
                double b = Double.parseDouble(textB);
                double hasil = (10*(a + b))/100;
                String formatTF = String.format("%,.0f", hasil);
                TFppn.setText(formatTF);
            } catch (NumberFormatException e) {
                TFppn.setText("Invalid input");
            }
        }
    }


    private boolean isValidImageSize(File file) throws IOException {
        javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
        return image.getWidth() == 250 && image.getHeight() == 150;
    }

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private boolean saveToDatabase(String noPr, String namaPr, String areaPr, double luasTanah, double hargaTanah,
                                   double luasBg, double hargaBangunan, double ppn, double hargaTotal, FileInputStream imgPr) {
        String insertSQL = "INSERT INTO ARAYALANDBASDAT.PROPERTI (NO_PR, NAMA_PR, AREA_PR, LUASTANAH, HARGATANAH, LUASBG, HARGABANGUNAN, PPN, HARGA_TOTAL, IMG_PR) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set parameter PreparedStatement dengan nilai properti
            pstmt.setString(1, noPr);
            pstmt.setString(2, namaPr);
            pstmt.setString(3, areaPr);
            pstmt.setDouble(4, luasTanah);
            pstmt.setDouble(5, hargaTanah);
            pstmt.setDouble(6, luasBg);
            pstmt.setDouble(7, hargaBangunan);
            pstmt.setDouble(8, ppn);
            pstmt.setDouble(9, hargaTotal);
            pstmt.setBinaryStream(10,imgPr,imgPr.available());

            // Eksekusi pernyataan SQL untuk menyimpan data
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void getImageFromDatabase(String noPr) {
        String selectSQL = "SELECT IMG_PR FROM ARAYALANDBASDAT.PROPERTI WHERE NO_PR = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setString(1, noPr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("IMG_PR");
                 InputStream inputStream = blob.getBinaryStream();
                 Image temp = new Image(inputStream);
                 if(noPr.equals("P001")){
                     G1.setImage(temp);
                 } else if (noPr.equals("P002")) {
                     G2.setImage(temp);
                 }else if (noPr.equals("P003")) {
                     G3.setImage(temp);
                 }else if (noPr.equals("P004")) {
                     G4.setImage(temp);
                 }else if (noPr.equals("P005")) {
                     G5.setImage(temp);
                 }else if (noPr.equals("P006")) {
                     G6.setImage(temp);
                 }else if (noPr.equals("P007")) {
                     G7.setImage(temp);
                 }else if (noPr.equals("P008")) {
                     G8.setImage(temp);
                 }else if (noPr.equals("P009")) {
                     G9.setImage(temp);
                 }else if (noPr.equals("P010")) {
                     G10.setImage(temp);
                 }else if (noPr.equals("P011")) {
                     G11.setImage(temp);
                 }else if (noPr.equals("P012")) {
                     G12.setImage(temp);
                 }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshImages(ImageView[] imageViews) {
        String[] propertyNumbers = {"P001", "P002", "P003", "P004", "P005", "P006", "P007", "P008", "P009", "P010", "P011", "P012"};
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            for (int i = 0; i < propertyNumbers.length; i++) {
                getImageFromDatabase(propertyNumbers[i]);
            }
        };

        executor.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS); // refresh every 5 seconds
    }
}
