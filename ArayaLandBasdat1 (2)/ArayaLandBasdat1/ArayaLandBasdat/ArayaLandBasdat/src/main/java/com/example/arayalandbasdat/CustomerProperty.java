package com.example.arayalandbasdat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomerProperty extends Application {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
    Circle lingkaranActive;
    TextField username123;
    Rectangle navigasi;
    HBox all;
    ScrollPane scrollPane;
    ImageView logo;
    ImageView logout;
    ImageView iconBeliProperti;
    ImageView iconMemberFasilitas;
    ImageView iconJoinKomunitas;
    ImageView iconLangganCS;
    ImageView iconOwnership;
    GridPane navGridPane;
    StackPane contentkanan;
    StackPane navigasikiri;
    Text manajemenPrtxt;
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
    Rectangle R8;
    Rectangle R9;
    Rectangle R10;
    Rectangle R11;
    Rectangle R12;
    Rectangle R13;
    Rectangle R14;
    Rectangle R15;
    Rectangle R16;
    Rectangle R17;

    Text T1;
    Text T2;
    Text T3;
    Text T4;
    Text T5;
    Text T6;
    Text T7;
    Text T8;
    Text T9;
    Text T10;
    Text T11;
    Text T12;
    Text T13;
    Text T14;
    Text T15;
    Text T16;
    Text T17;


    TextField TF1;
    TextField TF2;
    TextField TF3;
    TextField TF4;
    TextField TF5;
    TextField TF6;
    TextField TF7;
    TextField TF8;
    TextField TF9;
    TextField TF10;
    TextField TF11;
    TextField TF12;
    ComboBox<String> TF13;
    ComboBox<Integer> TF14;
    TextField TF15;
    TextField TF16;
    PasswordField TF17;

    Rectangle borderfoto;
    ImageView properti;

    Button simpan;
    Button cancel;

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Sesuaikan dengan URL database Anda
    private static final String DB_USER = "SYSTEM"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "SYSTEM"; // Ganti dengan password database Anda



    @Override
    public void start(Stage stage) throws Exception {
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

        iconBeliProperti = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Beli_Properti.png")));
        iconBeliProperti.setFitWidth(90);
        iconBeliProperti.setFitHeight(90);
        iconBeliProperti.setOnMouseEntered(event -> iconBeliProperti.setCursor(Cursor.HAND));
        iconBeliProperti.setOnMouseExited(event -> iconBeliProperti.setCursor(Cursor.DEFAULT));

        iconMemberFasilitas = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Akses_Fasilitas.png")));
        iconMemberFasilitas.setFitWidth(100);
        iconMemberFasilitas.setFitHeight(100);
        iconMemberFasilitas.setOnMouseEntered(event -> iconMemberFasilitas.setCursor(Cursor.HAND));
        iconMemberFasilitas.setOnMouseExited(event -> iconMemberFasilitas.setCursor(Cursor.DEFAULT));

        iconJoinKomunitas = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Bergabung_Komunitas.png")));
        iconJoinKomunitas.setFitWidth(100);
        iconJoinKomunitas.setFitHeight(100);
        iconJoinKomunitas.setOnMouseEntered(event -> iconJoinKomunitas.setCursor(Cursor.HAND));
        iconJoinKomunitas.setOnMouseExited(event -> iconJoinKomunitas.setCursor(Cursor.DEFAULT));

        iconOwnership = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Properti_Saya.png")));
        iconOwnership.setFitWidth(100);
        iconOwnership.setFitHeight(100);
        iconOwnership.setOnMouseEntered(event -> iconOwnership.setCursor(Cursor.HAND));
        iconOwnership.setOnMouseExited(event -> iconOwnership.setCursor(Cursor.DEFAULT));

        iconLangganCS = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Berlangganan_Kebersihan.png")));
        iconLangganCS.setFitWidth(100);
        iconLangganCS.setFitHeight(100);
        iconLangganCS.setOnMouseEntered(event -> iconLangganCS.setCursor(Cursor.HAND));
        iconLangganCS.setOnMouseExited(event -> iconLangganCS.setCursor(Cursor.DEFAULT));

        logout = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logout.png")));
        logout.setFitWidth(100);
        logout.setFitHeight(100);
        logout.setTranslateY(700);
        logout.setOnMouseEntered(event -> logout.setCursor(Cursor.HAND));
        logout.setOnMouseExited(event -> logout.setCursor(Cursor.DEFAULT));

        navGridPane = new GridPane();
        navGridPane.setVgap(80);
        navGridPane.add(iconBeliProperti,0,1);
        navGridPane.add(iconMemberFasilitas,0,2);
        navGridPane.add(iconJoinKomunitas,0,3);
        navGridPane.add(iconLangganCS,0,4);
        navGridPane.add(iconOwnership,0,5);
        navGridPane.setAlignment(Pos.CENTER);
        navGridPane.setTranslateX(0);
        navGridPane.setTranslateY(-200);

        navigasi = new Rectangle(250,1500, Color.web("#316d18"));


        //content kanan

        manajemenPrtxt = new Text("Beli Properti");
        manajemenPrtxt.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 40px; "
                + "-fx-fill: #545454; -fx-font-weight: bold");
        manajemenPrtxt.setTranslateX(-450);
        manajemenPrtxt.setTranslateY(-430);

        garisManajemenPrtxt = new Line();
        garisManajemenPrtxt.setStartX(270);  // Koordinat awal garis
        garisManajemenPrtxt.setEndX(1535);    // Koordinat akhir garis (sesuaikan panjang sesuai kebutuhan)
        garisManajemenPrtxt.setTranslateY(-380);  // Sesuaikan posisi vertikal
        garisManajemenPrtxt.setStroke(Color.web("#a6a6a6"));  // Warna garis
        garisManajemenPrtxt.setStrokeWidth(5);  // Ketebalan garis
        garisManajemenPrtxt.setTranslateX(0);

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

        //OBJECT
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

        //OBJECT FOR-FORM

        //FILL1
        R1 = new Rectangle();
        R1.setWidth(550);
        R1.setHeight(80);
        R1.setArcWidth(90);
        R1.setArcHeight(90);
        R1.setStyle("-fx-fill: #316d18;");
        R1.setTranslateX(-300);
        R1.setTranslateY(-260);


        T1 = new Text("USERNAME");
        T1.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T1.setFill(Color.WHITE);
        T1.setTranslateX(-490);
        T1.setTranslateY(-260);


        TF1 = new TextField(username);
        TF1.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF1.setMaxWidth(350);
        TF1.setTranslateX(-210);
        TF1.setTranslateY(-260);
        TF1.setEditable(false);



        //FILL2
        R2 = new Rectangle();
        R2.setWidth(550);
        R2.setHeight(80);
        R2.setArcWidth(90);
        R2.setArcHeight(90);
        R2.setStyle("-fx-fill: #316d18;");
        R2.setTranslateX(300);
        R2.setTranslateY(-260);


        T2 = new Text("NOMOR " +
                "\nPROPERTI");
        T2.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T2.setTranslateX(110);
        T2.setTranslateY(-260);


        TF2 = new TextField();
        TF2.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF2.setMaxWidth(350);
        TF2.setTranslateX(390);
        TF2.setTranslateY(-260);
        TF2.setEditable(false);



        //fill3
        R3 = new Rectangle();
        R3.setWidth(550);
        R3.setHeight(80);
        R3.setArcWidth(90);
        R3.setArcHeight(90);
        R3.setStyle("-fx-fill: #316d18;");
        R3.setTranslateX(-300);
        R3.setTranslateY(-140);

        T3 = new Text("NAMA " +
                "\nPROPERTI");
        T3.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T3.setFill(Color.WHITE);
        T3.setTranslateX(-490);
        T3.setTranslateY(-140);


        TF3 = new TextField();
        TF3.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF3.setMaxWidth(350);
        TF3.setTranslateX(-210);
        TF3.setTranslateY(-140);
        TF3.setEditable(false);


        //FILL4
        R4 = new Rectangle();
        R4.setWidth(550);
        R4.setHeight(80);
        R4.setArcWidth(90);
        R4.setArcHeight(90);
        R4.setStyle("-fx-fill: #316d18;");
        R4.setTranslateX(300);
        R4.setTranslateY(-140);


        T4 = new Text("AREA " +
                "\nPROPERTI");
        T4.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T4.setTranslateX(110);
        T4.setTranslateY(-140);


        TF4 = new TextField();
        TF4.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF4.setMaxWidth(350);
        TF4.setTranslateX(390);
        TF4.setTranslateY(-140);
        TF4.setEditable(false);


        //fill5
        R5 = new Rectangle();
        R5.setWidth(550);
        R5.setHeight(80);
        R5.setArcWidth(90);
        R5.setArcHeight(90);
        R5.setStyle("-fx-fill: #316d18;");
        R5.setTranslateX(-300);
        R5.setTranslateY(-20);

        T5 = new Text("LUAS TANAH");
        T5.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T5.setFill(Color.WHITE);
        T5.setTranslateX(-490);
        T5.setTranslateY(-20);


        TF5 = new TextField();
        TF5.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF5.setMaxWidth(350);
        TF5.setTranslateX(-210);
        TF5.setTranslateY(-20);
        TF5.setEditable(false);




        //FILL6
        R6 = new Rectangle();
        R6.setWidth(550);
        R6.setHeight(80);
        R6.setArcWidth(90);
        R6.setArcHeight(90);
        R6.setStyle("-fx-fill: #316d18;");
        R6.setTranslateX(300);
        R6.setTranslateY(-20);


        T6 = new Text("HARGA " +
                "\nTANAH");
        T6.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T6.setTranslateX(110);
        T6.setTranslateY(-20);


        TF6 = new TextField();
        TF6.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF6.setMaxWidth(350);
        TF6.setTranslateX(390);
        TF6.setTranslateY(-20);
        TF6.setEditable(false);



        //fill7
        R7 = new Rectangle();
        R7.setWidth(550);
        R7.setHeight(80);
        R7.setArcWidth(90);
        R7.setArcHeight(90);
        R7.setStyle("-fx-fill: #316d18;");
        R7.setTranslateX(-300);
        R7.setTranslateY(100);

        T7 = new Text("LUAS BANGUNAN");
        T7.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T7.setFill(Color.WHITE);
        T7.setTranslateX(-490);
        T7.setTranslateY(100);


        TF7 = new TextField();
        TF7.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF7.setMaxWidth(350);
        TF7.setTranslateX(-210);
        TF7.setTranslateY(100);
        TF7.setEditable(false);



        //FILL8
        R8 = new Rectangle();
        R8.setWidth(550);
        R8.setHeight(80);
        R8.setArcWidth(90);
        R8.setArcHeight(90);
        R8.setStyle("-fx-fill: #316d18;");
        R8.setTranslateX(300);
        R8.setTranslateY(100);


        T8 = new Text("HARGA " +
                "\nBANGUNAN");
        T8.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T8.setTranslateX(110);
        T8.setTranslateY(100);


        TF8 = new TextField();
        TF8.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF8.setMaxWidth(350);
        TF8.setTranslateX(390);
        TF8.setTranslateY(100);
        TF8.setEditable(false);



        //fill9
        R9 = new Rectangle();
        R9.setWidth(550);
        R9.setHeight(80);
        R9.setArcWidth(90);
        R9.setArcHeight(90);
        R9.setStyle("-fx-fill: #316d18;");
        R9.setTranslateX(-300);
        R9.setTranslateY(220);

        T9 = new Text("PPN (10%)");
        T9.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T9.setFill(Color.WHITE);
        T9.setTranslateX(-490);
        T9.setTranslateY(220);


        TF9 = new TextField();
        TF9.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF9.setMaxWidth(350);
        TF9.setTranslateX(-210);
        TF9.setTranslateY(220);
        TF9.setEditable(false);



        //FILL10
        R10 = new Rectangle();
        R10.setWidth(550);
        R10.setHeight(80);
        R10.setArcWidth(90);
        R10.setArcHeight(90);
        R10.setStyle("-fx-fill: #316d18;");
        R10.setTranslateX(300);
        R10.setTranslateY(220);


        T10 = new Text("HARGA " +
                "\nTOTAL");
        T10.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T10.setTranslateX(110);
        T10.setTranslateY(220);


        TF10 = new TextField();
        TF10.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF10.setMaxWidth(350);
        TF10.setTranslateX(390);
        TF10.setTranslateY(220);
        TF10.setEditable(false);
        TF10.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!TF10.getText().isEmpty()) {
                HitungCicilanBulanan();
            }
        });


        //fill11
        R11 = new Rectangle();
        R11.setWidth(550);
        R11.setHeight(80);
        R11.setArcWidth(90);
        R11.setArcHeight(90);
        R11.setStyle("-fx-fill: #316d18;");
        R11.setTranslateX(-300);
        R11.setTranslateY(340);

        T11 = new Text("ID " +
                "TRANSAKSI");
        T11.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T11.setFill(Color.WHITE);
        T11.setTranslateX(-490);
        T11.setTranslateY(340);


        TF11 = new TextField();
        TF11.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF11.setMaxWidth(350);
        TF11.setTranslateX(-210);
        TF11.setTranslateY(340);
        TF11.setEditable(false);


        //FILL12
        R12 = new Rectangle();
        R12.setWidth(550);
        R12.setHeight(80);
        R12.setArcWidth(90);
        R12.setArcHeight(90);
        R12.setStyle("-fx-fill: #316d18;");
        R12.setTranslateX(300);
        R12.setTranslateY(340);


        T12 = new Text("TANGGAL " +
                "\nTRANSAKSI");
        T12.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T12.setTranslateX(110);
        T12.setTranslateY(340);


        TF12 = new TextField();
        tanggalTerkiniTR();
        TF12.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF12.setMaxWidth(350);
        TF12.setTranslateX(390);
        TF12.setTranslateY(340);
        TF12.setEditable(false);


        //fill13 COMBO
        R13 = new Rectangle();
        R13.setWidth(550);
        R13.setHeight(80);
        R13.setArcWidth(90);
        R13.setArcHeight(90);
        R13.setStyle("-fx-fill: #316d18;");
        R13.setTranslateX(-300);
        R13.setTranslateY(470);

        T13 = new Text("METODE " +
                "\nPEMBAYARAN");
        T13.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T13.setFill(Color.WHITE);
        T13.setTranslateX(-490);
        T13.setTranslateY(470);


        TF13 = new ComboBox<>();
        TF13.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF13.getItems().addAll("Tunai", "Cicilan");
        TF13.setMaxWidth(350);
        TF13.setTranslateX(-210);
        TF13.setTranslateY(470);
        TF13.setEditable(false);
        TF13.setTooltip(new Tooltip("Pilih metode pembayaran yang diinginkan"));


        TF13.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold;");
                }
            }
        });
        TF13.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold;");
                }
            }
        });




        //FILL14 COMBO OPSIONAL
        R14 = new Rectangle();
        R14.setWidth(550);
        R14.setHeight(80);
        R14.setArcWidth(90);
        R14.setArcHeight(90);
        R14.setStyle("-fx-fill: #316d18;");
        R14.setTranslateX(300);
        R14.setTranslateY(470);


        T14 = new Text("MASA " +
                "\nCICILAN (KPR)");
        T14.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T14.setTranslateX(110);
        T14.setTranslateY(470);



        TF14 = new ComboBox<>();
        TF14.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-text-fill: green; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF14.getItems().addAll(10, 15, 20);

        TF14.setMaxWidth(350);
        TF14.setTranslateX(390);
        TF14.setTranslateY(470);
        TF14.setEditable(false);
        TF14.setTooltip(new Tooltip("Suku Bunga KPR 10% per tahun"));
        TF14.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                HitungCicilanBulanan();
            }
        });


        TF14.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(item));
                    setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold;");
                }
            }
        });
        TF14.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(item));
                    setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
                }
            }
        });




        //fill15
        R15 = new Rectangle();
        R15.setWidth(550);
        R15.setHeight(80);
        R15.setArcWidth(90);
        R15.setArcHeight(90);
        R15.setStyle("-fx-fill: #316d18;");
        R15.setTranslateX(-300);
        R15.setTranslateY(590);

        T15 = new Text("CICILAN " +
                "\nBULANAN");
        T15.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T15.setFill(Color.WHITE);
        T15.setTranslateX(-490);
        T15.setTranslateY(590);


        TF15 = new TextField();
        TF15.setPromptText("Biaya Cicilan per Bulan (Rp)");
        TF15.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF15.setMaxWidth(350);
        TF15.setTranslateX(-210);
        TF15.setTranslateY(590);
        TF15.setEditable(false);


        //FILL16
        R16 = new Rectangle();
        R16.setWidth(550);
        R16.setHeight(80);
        R16.setArcWidth(90);
        R16.setArcHeight(90);
        R16.setStyle("-fx-fill: #316d18;");
        R16.setTranslateX(300);
        R16.setTranslateY(590);


        T16 = new Text("STATUS " +
                "\nPEMBAYARAN");
        T16.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T16.setTranslateX(110);
        T16.setTranslateY(590);


        TF16 = new TextField();
        TF16.setPromptText("Status Kelunasan Properti");
        TF16.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;-fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF16.setMaxWidth(350);
        TF16.setTranslateX(390);
        TF16.setTranslateY(590);
        TF16.setEditable(false);
        TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if ("Tunai".equals(newValue)) {
                TF16.setText("Lunas");
            } else{
                TF16.setText("Belum Lunas");
            }
        });


        //fill17
        R17 = new Rectangle();
        R17.setWidth(550);
        R17.setHeight(80);
        R17.setArcWidth(90);
        R17.setArcHeight(90);
        R17.setStyle("-fx-fill: #316d18;");
        R17.setTranslateX(-300);
        R17.setTranslateY(740);

        T17 = new Text("PASSWORD");
        T17.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T17.setFill(Color.WHITE);
        T17.setTranslateX(-490);
        T17.setTranslateY(740);

        /**T15.setTranslateX(-490);
         T15.setTranslateY(590);**/


        TF17 = new PasswordField();
        TF17.setPromptText("Masukkan Password Akun");
        TF17.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF17.setMaxWidth(350);
        TF17.setTranslateX(-210);
        TF17.setTranslateY(740);
        TF17.setEditable(true);




        Text namaFoto = new Text("Belum memilih file .jpg/.png");
        namaFoto.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px;");
        namaFoto.setFill(Color.WHITE);
        namaFoto.setTranslateX(340);
        namaFoto.setTranslateY(900);

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


        simpan = new Button("Beli");
        simpan.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #e2cf45;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: white;-fx-text-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        simpan.setPrefWidth(150);
        simpan.setTranslateY(960);
        simpan.setTranslateX(330);
        simpan.setOnMouseEntered(event -> simpan.setCursor(Cursor.HAND));
        simpan.setOnMouseExited(event -> simpan.setCursor(Cursor.DEFAULT));


        cancel = new Button("Batal");
        cancel.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #c40000;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: white;-fx-text-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        cancel.setPrefWidth(150);
        cancel.setTranslateY(960);
        cancel.setTranslateX(500);
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
                R8,T8,TF8,
                R9,T9,TF9,
                R10,T10,TF10,
                R11,T11,TF11,
                R12,T12,TF12,
                R13,T13,TF13,
                R14,T14,TF14,
                R15,T15,TF15,
                R16,T16,TF16,
                R17,T17,TF17,
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
                R8,T8,TF8,
                R9,T9,TF9,
                R10,T10,TF10,
                R11,T11,TF11,
                R12,T12,TF12,
                R13,T13,TF13,
                R14,T14,TF14,
                R15,T15,TF15,
                R16,T16,TF16,
                R17,T17,TF17,
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

        stage.setTitle("Customer BuyProperty");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        initializeKeywordObject();


        iconBeliProperti.setOnMouseClicked(mouseEvent -> {
            CustomerProperty customerProperty = new CustomerProperty();
            showSucces("Already in there","Anda sudah berada dihalaman Beli Properti");
            customerProperty.setUsername(username);
        });


        iconMemberFasilitas.setOnMouseClicked(mouseEvent -> {
            CustomerFacility customerFacility = new CustomerFacility();
            try {
                Stage newStage = new Stage();
                customerFacility.setUsername(username);
                customerFacility.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconJoinKomunitas.setOnMouseClicked(mouseEvent -> {
            CustomerCommunity customerCommunity = new CustomerCommunity();
            try {
                Stage newStage = new Stage();
                customerCommunity.setUsername(username);
                customerCommunity.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconOwnership.setOnMouseClicked(mouseEvent -> {
            CustomerOwnership customerOwnership = new CustomerOwnership();
            try {
                Stage newStage = new Stage();
                customerOwnership.setUsername(username);
                customerOwnership.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconLangganCS.setOnMouseClicked(mouseEvent -> {
            CustomerCS customerCS = new CustomerCS();
            try {
                Stage newStage = new Stage();
                customerCS.setUsername(username);
                customerCS.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logout.setOnMouseClicked(mouseEvent -> {
            MainLogin mainLogin = new MainLogin();
            try {
                Stage newStage = new Stage();
                mainLogin.start(newStage);
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
            if (G1.getImage() != imageG1) {

                if(!isPropertiSudahDibeli("P001")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P001");
                    TF11.setText("TR01");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Properti Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });

        G2.setOnMouseClicked(mouseEvent -> {
            if (G2.getImage() != imageG2) {

                if(!isPropertiSudahDibeli("P002")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P002");
                    TF11.setText("TR02");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });

        G3.setOnMouseClicked(mouseEvent -> {
            if (G3.getImage() != imageG3) {

                if(!isPropertiSudahDibeli("P003")) {

                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                        R8, T8, TF8,
                        R9, T9, TF9,
                        R10, T10, TF10,
                        R11, T11, TF11,
                        R12, T12, TF12,
                        R13, T13, TF13,
                        R14, T14, TF14,
                        R15, T15, TF15,
                        R16, T16, TF16,
                        R17, T17, TF17,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel);
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF2.setText("P003");

                TF11.setText("TR03");

                String tf2 = TF2.getText().trim();

                getPropertyFromDatabase(tf2);
            } else {
                showAlert("Error","Properti sudah terjual");
            }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G4.setOnMouseClicked(mouseEvent -> {
            if (G4.getImage() != imageG4) {

                if(!isPropertiSudahDibeli("P004")) {

                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                        R8, T8, TF8,
                        R9, T9, TF9,
                        R10, T10, TF10,
                        R11, T11, TF11,
                        R12, T12, TF12,
                        R13, T13, TF13,
                        R14, T14, TF14,
                        R15, T15, TF15,
                        R16, T16, TF16,
                        R17, T17, TF17,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel);
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF2.setText("P004");
                TF11.setText("TR04");


                String tf2 = TF2.getText().trim();

                getPropertyFromDatabase(tf2);
            }else {
                showAlert("Error","Properti sudah terjual");
            }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });

        G5.setOnMouseClicked(mouseEvent -> {
            if (G5.getImage() != imageG5) {

                if(!isPropertiSudahDibeli("P005")) {

                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                        R8, T8, TF8,
                        R9, T9, TF9,
                        R10, T10, TF10,
                        R11, T11, TF11,
                        R12, T12, TF12,
                        R13, T13, TF13,
                        R14, T14, TF14,
                        R15, T15, TF15,
                        R16, T16, TF16,
                        R17, T17, TF17,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel);
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF2.setText("P005");
                TF11.setText("TR05");

                String tf2 = TF2.getText().trim();

                getPropertyFromDatabase(tf2);

            }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });

        G6.setOnMouseClicked(mouseEvent -> {
            if (G6.getImage() != imageG6) {

                if(!isPropertiSudahDibeli("P006")) {

                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                        R8, T8, TF8,
                        R9, T9, TF9,
                        R10, T10, TF10,
                        R11, T11, TF11,
                        R12, T12, TF12,
                        R13, T13, TF13,
                        R14, T14, TF14,
                        R15, T15, TF15,
                        R16, T16, TF16,
                        R17, T17, TF17,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel);
                for (Node node : fillShow) {
                    node.setVisible(true);
                }

                TF2.setText("P006");
                TF11.setText("TR06");

                String tf2 = TF2.getText().trim();

                getPropertyFromDatabase(tf2);
            }else {
                showAlert("Error","Properti sudah terjual");
            }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G7.setOnMouseClicked(mouseEvent -> {
            if (G7.getImage() != imageG7) {

                if(!isPropertiSudahDibeli("P007")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P007");
                    TF11.setText("TR07");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G8.setOnMouseClicked(mouseEvent -> {
            if (G8.getImage() != imageG8) {

                if(!isPropertiSudahDibeli("P008")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P008");
                    TF11.setText("TR08");
                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G9.setOnMouseClicked(mouseEvent -> {
            if (G9.getImage() != imageG9) {

                if(!isPropertiSudahDibeli("P009")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P009");
                    TF11.setText("TR09");
                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G10.setOnMouseClicked(mouseEvent -> {
            if (G10.getImage() != imageG10) {

                if(!isPropertiSudahDibeli("P010")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P010");
                    TF11.setText("TR10");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        G11.setOnMouseClicked(mouseEvent -> {
            if (G11.getImage() != imageG11) {
                if(!isPropertiSudahDibeli("P011")) {
                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P011");
                    TF11.setText("TR11");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });

        G12.setOnMouseClicked(mouseEvent -> {
            if (G12.getImage() != imageG12) {

                if(!isPropertiSudahDibeli("P012")) {

                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
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
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(true);
                    }

                    TF2.setText("P012");
                    TF11.setText("TR12");

                    String tf2 = TF2.getText().trim();

                    getPropertyFromDatabase(tf2);
                }else {
                    showAlert("Error","Properti sudah terjual");
                }
            }else {
                showAlert("Error","Data Kosong");
            }

            TF13.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if ("Tunai".equals(newValue)) {
                    TF14.setValue(0);
                    TF14.setDisable(true);
                    TF15.setText("0");
                } else {
                    TF14.setDisable(false);
                    TF14.setValue(0);
                    TF15.setText("Missing");
                }
            });
        });


        simpan.setOnAction((event -> {
            String username = TF1.getText().trim();
            String nomor_properti = TF2.getText().trim();
            String id_tr = TF11.getText().trim();
            String tanggal_tr = TF12.getText().trim();
            String metode_pembayaran = TF13.getValue();
            Integer masa = TF14.getValue();
            String status_tr = TF16.getText().trim();

            String password = TF17.getText().trim();
            String selectedOption13 = TF13.getValue(); // Mendapatkan nilai yang dipilih dari TF13
            Integer selectedOption14 = TF14.getValue(); // Mendapatkan nilai yang dipilih dari TF14

            // Memeriksa apakah TF13 dan TF14 telah memilih opsi
            if (selectedOption13 == null) {
                showAlert("Pilih Opsi", "Silakan pilih opsi pada Metode Pembayaran");
                return;
            }

            if(selectedOption13.equals("Cicilan")) {
                if (selectedOption14 == null) {
                    showAlert("Pilih Opsi", "Silakan pilih opsi pada Masa Cicilan");
                    return;
                }
            }

            String cicilan_bulananS = TF15.getText().replace(",","").trim();
            double cicilan_bulanan = 0.0; // Default value jika input kosong atau tidak valid
            if (!cicilan_bulananS.isEmpty()) {
                try {
                    cicilan_bulanan = Double.parseDouble(cicilan_bulananS.replace(",", ""));
                } catch (NumberFormatException e) {
                    showAlert("CICILAN BULANAN", "Format CICILAN BULANAN tanah tidak valid");
                    TF4.clear();
                    return;
                }
            } else {
                showAlert("LUAS TANAH", "LUAS TANAH harus diisi");
                return;
            }

            // Validasi password sesuai dengan aturan (hanya huruf, angka, dan minimal 8 karakter)
            if (!isValidPassword(password)) {
                showAlert("Password Tidak Valid", "Password harus mengandung huruf (wajib), angka (wajib), dan minimal 8 karakter.");
                TF2.clear();
                return;
            }

            String loggedInUsername = checkCredentials(username, password);
            if(loggedInUsername!=null) {
                if (saveToDatabaseTRANSAKSI(id_tr, tanggal_tr, metode_pembayaran, masa, cicilan_bulanan)&&
                        saveToDatabaseINFOPROPERTI(nomor_properti,username,id_tr,status_tr)) {
                    showSucces("Success", "Properti Berhasil Dibeli");
                    List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6, L7, G7, L8, G8, L9, G9, L10, G10, L11, G11, L12, G12);
                    for (Node node : obj) {
                        node.setVisible(true);
                    }
                    List<Node> fillShow = Arrays.asList(
                            R1, T1, TF1,
                            R2, T2, TF2,
                            R3, T3, TF3,
                            R4, T4, TF4,
                            R5, T5, TF5,
                            R6, T6, TF6,
                            R7, T7, TF7,
                            R8, T8, TF8,
                            R9, T9, TF9,
                            R10, T10, TF10,
                            R11, T11, TF11,
                            R12, T12, TF12,
                            R13, T13, TF13,
                            R14, T14, TF14,
                            R15, T15, TF15,
                            R16, T16, TF16,
                            R17, T17, TF17,
                            borderfoto,
                            namaFoto,
                            properti,
                            simpan, cancel);
                    for (Node node : fillShow) {
                        node.setVisible(false);
                    }
                }
            }else {
                showAlert("Login Gagal", "password tidak valid.");
                TF17.clear();
                return;
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
                    R8,T8,TF8,
                    R9,T9,TF9,
                    R10,T10,TF10,
                    R11,T11,TF11,
                    R12,T12,TF12,
                    R13,T13,TF13,
                    R14,T14,TF14,
                    R15,T15,TF15,
                    R16,T16,TF16,
                    R17,T17,TF17,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(false);
            }

            TF13.getSelectionModel().clearSelection();
            TF14.getSelectionModel().clearSelection();
            TF15.clear();
            TF16.clear();
            TF17.clear();

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

    private void tanggalTerkiniTR() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = currentDate.format(formatter);
        TF12.setText(formattedDate);
    }

    private void HitungCicilanBulanan() {
        String harga_total = TF10.getText().replace(",", "").trim();
        Integer tahun = TF14.getSelectionModel().getSelectedItem();

        if (TF10.getText().trim().isEmpty() || tahun == null) {
            TF15.setText("Missing");
        } else {
            try {
                double total = Double.parseDouble(harga_total);
                double bulan = tahun*12;
                double totalHargaBulanan = total / bulan;
                double totalBungaBulanan = (0.1/12) * total;
                double hasil = totalHargaBulanan + totalBungaBulanan;
                String formatTF = String.format("%,.0f", hasil);
                TF15.setText(formatTF);
            } catch (NumberFormatException e) {
                TF15.setText("Missing");
            }
        }
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}$");
    }


    public void refreshImages(ImageView[] imageViews) {
        String[] propertyNumbers = {"P001", "P002", "P003", "P004", "P005", "P006", "P007", "P008", "P009", "P010", "P011", "P012"};
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            for (int i = 0; i < propertyNumbers.length; i++) {
                String propertyNumber = propertyNumbers[i];
                ImageView imageView = imageViews[i];

                Image image = getImageFromDatabase(propertyNumber);
                if (image != null) {
                    Platform.runLater(() -> imageView.setImage(image));
                }
            }
        };

        executor.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS); // refresh every 5 seconds
    }

    public Image getImageFromDatabase(String propertyNumber) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
            String sql = "SELECT IMG_PR FROM ARAYALANDBASDAT.PROPERTI WHERE NO_PR = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, propertyNumber);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imgBytes = rs.getBytes("IMG_PR");
                if (imgBytes != null) {
                    InputStream is = new ByteArrayInputStream(imgBytes);
                    return new Image(is);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void getPropertyFromDatabase(String noPr) {
        String selectSQL = "SELECT NO_PR, NAMA_PR, AREA_PR, LUASTANAH, HARGATANAH, LUASBG, HARGABANGUNAN, PPN, HARGA_TOTAL, IMG_PR FROM ARAYALANDBASDAT.PROPERTI WHERE NO_PR = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setString(1, noPr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String namaPr = rs.getString("NAMA_PR");
                String areaPr = rs.getString("AREA_PR");
                double luasTanah = rs.getDouble("LUASTANAH");
                double hargaTanah = rs.getDouble("HARGATANAH");
                double luasBg = rs.getDouble("LUASBG");
                double hargaBangunan = rs.getDouble("HARGABANGUNAN");
                double ppn = rs.getDouble("PPN");
                double hargaTotal = rs.getDouble("HARGA_TOTAL");
                Blob imgBlob = rs.getBlob("IMG_PR");

                // Convert Blob to InputStream
                InputStream imgStream = imgBlob.getBinaryStream();
                Image image = new Image(imgStream);

                // Update UI components on JavaFX Application Thread
                Platform.runLater(() -> {
                    TF3.setText(namaPr);
                    TF4.setText(areaPr);
                    TF5.setText(String.format("%,.0f", luasTanah));
                    TF6.setText(String.format("%,.0f", hargaTanah));
                    TF7.setText(String.format("%,.0f", luasBg));
                    TF8.setText(String.format("%,.0f", hargaBangunan));
                    TF10.setText(String.format("%,.0f", ppn));
                    TF9.setText(String.format("%,.0f", hargaTotal));
                    properti.setImage(image);
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean saveToDatabaseTRANSAKSI(String ID_TR, String TANGGAL_TR, String METODE_PEMBAYARAN, Integer MASA_CICILAN, double CICILAN_BULANAN) {
        String insertSQL = "INSERT INTO ARAYALANDBASDAT.TRANSAKSI (ID_TR, TANGGAL_TR, METODE_TR, MASA_TR, CICILAN_TR) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set parameter PreparedStatement dengan nilai properti
            pstmt.setString(1, ID_TR);

            // Convert input date from MM-DD-YYYY to java.sql.Date
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.util.Date parsedDate = inputFormat.parse(TANGGAL_TR);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            pstmt.setDate(2, sqlDate);


            pstmt.setString(3, METODE_PEMBAYARAN);
            pstmt.setInt(4, MASA_CICILAN);
            pstmt.setDouble(5, CICILAN_BULANAN);


            // Eksekusi pernyataan SQL untuk menyimpan data
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    private boolean saveToDatabaseINFOPROPERTI(String PROPERTI_NO_PR, String ACCOUNT_USNM_AC, String TRANSAKSI_ID_TR, String STATUS_PR) {
        String insertSQL = "INSERT INTO ARAYALANDBASDAT.INFOPROPERTI (PROPERTI_NO_PR, ACCOUNT_USNM_AC, TRANSAKSI_ID_TR, STATUS_PR) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set parameter PreparedStatement dengan nilai properti
            pstmt.setString(1, PROPERTI_NO_PR);

            pstmt.setString(2, ACCOUNT_USNM_AC);

            pstmt.setString(3, TRANSAKSI_ID_TR);

            pstmt.setString(4, STATUS_PR);


            // Eksekusi pernyataan SQL untuk menyimpan data
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    private String checkCredentials(String username, String password) {
        String query = "SELECT usnm_AC FROM ARAYALANDBASDAT.ACCOUNT WHERE usnm_AC = ? AND pswd_AC = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("usnm_AC"); // Mengembalikan username jika ditemukan
            } else {
                return null; // Mengembalikan null jika tidak ditemukan
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isPropertiSudahDibeli(String propertiNoPr) {
        String query = "SELECT COUNT(*) FROM ARAYALANDBASDAT.INFOPROPERTI WHERE PROPERTI_NO_PR = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, propertiNoPr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Jika count lebih dari 0, properti sudah dibeli
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
