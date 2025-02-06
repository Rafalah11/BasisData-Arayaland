package com.example.arayalandbasdat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AdminCommunity extends Application {

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
    Line garisManajemenPrtxt;
    TextField searchProperti;
    ImageView search;

    Circle lingkaranActive;
    TextField username123;

    ImageView L1;
    ImageView L2;
    ImageView L3;
    ImageView L4;
    ImageView L5;
    ImageView L6;


    ImageView G1;
    ImageView G2;
    ImageView G3;
    ImageView G4;
    ImageView G5;
    ImageView G6;


    ImageView highlightedImage;
    private Map<String, List<ImageView>> keywordObject;
    private int lastHighlightedIndex = -1;

    Rectangle R1;
    Rectangle R2;
    Rectangle R3;
    Rectangle R4;
    Rectangle R5;

    Text T1;
    Text T2;
    Text T3;
    Text T4;
    Text T5;

    TextField TF1;
    TextField TF2;
    TextField TF3;
    TextField TF4;
    Button TF5;

    Rectangle borderfoto;
    ImageView properti;

    Button simpan;
    Button cancel;
    TextField TFtanda;

    FileInputStream fileInputStream;

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Sesuaikan dengan URL database Anda
    private static final String DB_USER = "SYSTEM"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "SYSTEM"; // Ganti dengan password database Anda


    @Override
    public void start(Stage stage) throws Exception {

        logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logo.png")));
        logo.setFitWidth(200);
        logo.setFitHeight(200);
        logo.setTranslateX(-10);
        logo.setTranslateY(-420);

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
        logout.setTranslateY(450);
        logout.setOnMouseEntered(event -> logout.setCursor(Cursor.HAND));
        logout.setOnMouseExited(event -> logout.setCursor(Cursor.DEFAULT));

        navGridPane = new GridPane();
        navGridPane.setVgap(40);
        navGridPane.add(iconDashboard,0,1);
        navGridPane.add(iconManajemenPr,0,2);
        navGridPane.add(iconManajemenFs,0,3);
        navGridPane.add(iconManajemenKm,0,4);
        navGridPane.add(iconManajemenKb,0,5);
        navGridPane.setAlignment(Pos.CENTER);
        navGridPane.setTranslateX(0);
        navGridPane.setTranslateY(-20);

        navigasi = new Rectangle(250,1000, Color.web("#316d18"));


        //content kanan

        manajemenPrtxt = new Text("Manajemen Komunitas");
        manajemenPrtxt.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 40px; "
                + "-fx-fill: #545454; -fx-font-weight: bold");
        manajemenPrtxt.setTranslateX(-380);
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

        //OBJECT PRE-FORM
        L1 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas1.png")));
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


        L2 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas2.png")));
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


        L3 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas3.png")));
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


        L4 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas4.png")));
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


        L5 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas5.png")));
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


        L6 = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/komunitas6.png")));
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

        ImageView[] imageViews = {G1, G2, G3, G4, G5,G6};

        // Start refreshing images
        refreshImages(imageViews);

        //OBJECT FOR-FORM
        //fill1
        R1 = new Rectangle();
        R1.setWidth(550);
        R1.setHeight(80);
        R1.setArcWidth(90);
        R1.setArcHeight(90);
        R1.setStyle("-fx-fill: #316d18;");
        R1.setTranslateX(-300);
        R1.setTranslateY(-280);


        T1 = new Text("NAMA " +
                "\nKOMUNITAS");
        T1.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T1.setFill(Color.WHITE);
        T1.setTranslateX(-490);
        T1.setTranslateY(-280);


        TF1 = new TextField();
        TF1.setPromptText("Masukkan Nama");
        TF1.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: WHITE; -fx-font-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF1.setMaxWidth(350);
        TF1.setTranslateX(-210);
        TF1.setTranslateY(-280);





        //fill2
        R2 = new Rectangle();
        R2.setWidth(550);
        R2.setHeight(80);
        R2.setArcWidth(90);
        R2.setArcHeight(90);
        R2.setStyle("-fx-fill: #316d18;");
        R2.setTranslateX(300);
        R2.setTranslateY(-280);


        T2 = new Text("TANGGAL " +
                "\nPENDIRIAN");
        T2.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T2.setTranslateX(130);
        T2.setTranslateY(-280);


        TF2 = new TextField();
        TF2.setPromptText("Masukkan Tanggal (MM-DD-YYYY)");
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
        R3.setTranslateX(300);
        R3.setTranslateY(40);


        T3 = new Text("AGENDA " +
                "\nKOMUNITAS");
        T3.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T3.setTranslateX(130);
        T3.setTranslateY(40);


        TF3 = new TextField();
        TF3.setPromptText("Masukkan Agenda");
        TF3.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF3.setMaxWidth(350);
        TF3.setTranslateX(390);
        TF3.setTranslateY(40);




        //fill4
        R4 = new Rectangle();
        R4.setWidth(550);
        R4.setHeight(80);
        R4.setArcWidth(90);
        R4.setArcHeight(90);
        R4.setStyle("-fx-fill: #316d18;");
        R4.setTranslateX(-300);
        R4.setTranslateY(40);


        T4 = new Text("SYARAT " +
                "\nBERGABUNG");
        T4.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T4.setTranslateX(-490);
        T4.setTranslateY(40);


        TF4 = new TextField();
        TF4.setPromptText("Masukkan Persyaratan");
        TF4.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: white;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF4.setMaxWidth(350);
        TF4.setTranslateX(-210);
        TF4.setTranslateY(40);

        //fill6
        R5 = new Rectangle();
        R5.setWidth(550);
        R5.setHeight(80);
        R5.setArcWidth(90);
        R5.setArcHeight(90);
        R5.setStyle("-fx-fill: #316d18;");
        R5.setTranslateX(-300);
        R5.setTranslateY(340);


        T5 = new Text("FOTO " +
                "\nKOMUNITAS");
        T5.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 19px; "
                + "-fx-font-weight: bold; "
                + "-fx-fill: white;");
        T5.setTranslateX(-490);
        T5.setTranslateY(340);


        TF5 = new Button("Upload Disini");
        TF5.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;-fx-font-weight: bold;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: green;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        TF5.setMaxWidth(350);
        TF5.setTranslateX(-210);
        TF5.setTranslateY(340);

        TFtanda = new TextField();

        Text namaFoto = new Text("Belum memilih file .jpg/.png");
        namaFoto.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px;");
        namaFoto.setFill(Color.WHITE);
        namaFoto.setTranslateX(340);
        namaFoto.setTranslateY(398);

        properti = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/disini.png")));
        properti.setFitWidth(250);
        properti.setFitHeight(150);
        properti.setTranslateX(340);
        properti.setTranslateY(310);
        properti.setVisible(false);

        borderfoto = new Rectangle();
        borderfoto.setWidth(300);
        borderfoto.setHeight(200);
        borderfoto.setArcWidth(40);
        borderfoto.setArcHeight(40);
        borderfoto.setStyle("-fx-fill: #316d18;");
        borderfoto.setTranslateX(340);
        borderfoto.setTranslateY(310);



        TF5.setOnAction(event -> {
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

        TF5.setOnMouseEntered(event -> TF5.setCursor(Cursor.HAND));
        TF5.setOnMouseExited(event -> TF5.setCursor(Cursor.DEFAULT));


        simpan = new Button("Simpan");
        simpan.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #e2cf45;"
                + "-fx-font-size: 22px; "
                + "-fx-text-fill: white;-fx-text-weight: bold;"
                + "-fx-background-radius: 40; "
                + "-fx-border-radius: 40;");
        simpan.setPrefWidth(150);
        simpan.setTranslateY(465);
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
        cancel.setTranslateY(465);
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
                borderfoto,
                namaFoto,
                properti,
                simpan,cancel, TFtanda);
        for (Node node : fill) {
            node.setVisible(false);
        }



        //main Layout
        navigasikiri = new StackPane();
        navigasikiri.getChildren().addAll(navigasi,logo,navGridPane,logout);

        contentkanan = new StackPane();
        contentkanan.getChildren().addAll(manajemenPrtxt, garisManajemenPrtxt,username123,lingkaranActive, searchProperti, search,
                L1,G1,
                L2,G2,
                L3,G3,
                L4,G4,
                L5,G5,
                L6,G6,

                R1,T1,TF1,
                R2,T2,TF2,
                R3,T3,TF3,
                R4,T4,TF4,
                R5,T5,TF5,
                borderfoto,
                namaFoto,
                properti,
                simpan,cancel,TFtanda

        );
        contentkanan.setTranslateY(0);

        all = new HBox(navigasikiri,contentkanan);


        scrollPane = new ScrollPane();
        scrollPane.setContent(all);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane);

        stage.setTitle("Admin Community");
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
            try {
                Stage newStage = new Stage();
                adminProperty.setUsername(username);
                adminProperty.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            showSucces("Already in there","Anda sudah berada dihalaman Manajemen Komunitas");
            adminCommunity.setUsername(username);
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
            if (G1.getImage() == imageG1) {
                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
                for (Node node : obj) {
                    node.setVisible(false);
                }
                List<Node> fillShow = Arrays.asList(
                        R1, T1, TF1,
                        R2, T2, TF2,
                        R3, T3, TF3,
                        R4, T4, TF4,
                        R5, T5, TF5,
                        borderfoto,
                        namaFoto,
                        properti,
                        simpan, cancel);
                for (Node node : fillShow) {
                    node.setVisible(true);
                }
                TFtanda.setText("1");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }

        });

        G2.setOnMouseClicked(mouseEvent -> {
            if (G2.getImage() == imageG2) {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(false);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(true);
            }
                TFtanda.setText("2");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }
        });


        G3.setOnMouseClicked(mouseEvent -> {
            if (G3.getImage() == imageG3) {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(false);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(true);
            }
                TFtanda.setText("3");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }
        });


        G4.setOnMouseClicked(mouseEvent -> {
            if (G4.getImage() == imageG4) {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(false);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(true);
            }
            TFtanda.setText("4");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }
        });


        G5.setOnMouseClicked(mouseEvent -> {
            if (G5.getImage() == imageG5) {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(false);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(true);
            }
                TFtanda.setText("5");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }
        });


        G6.setOnMouseClicked(mouseEvent -> {
            if (G6.getImage() == imageG6) {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(false);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
                    borderfoto,
                    namaFoto,
                    properti,
                    simpan,cancel);
            for (Node node : fillShow) {
                node.setVisible(true);
            }
                TFtanda.setText("6");
            }else {
                showSucces("Uploaded","Data sudah berada di database ");
            }
        });

        simpan.setOnAction((event -> {

            String penanda = TFtanda.getText().trim();
            String nama_Komunitas = TF1.getText().trim();
            String tanggal_Pendirian = TF2.getText().trim();
            String agenda_Komunitas = TF3.getText().trim();
            String syarat_Komunitas = TF4.getText().trim();



            if (nama_Komunitas.isEmpty() || !isValidHuruf(nama_Komunitas)  ){
                showAlert("NAMA KOMUNITAS","NAMA KOMUNITAS hanya boleh mengandung huruf dan minimal 3 karakter");
                TF1.clear();
                return;
            }

            if (tanggal_Pendirian.isEmpty() || !isValidAngkaKarakter(tanggal_Pendirian)  ){
                showAlert("TANGGAL PENDIRIAN","TANGGAL PENDIRIAN hanya boleh mengandung angka, karakter (\"-\"), dan minimal 10 karakter");
                TF2.clear();
                return;
            }


            if (agenda_Komunitas.isEmpty() || !isValidHuruf(agenda_Komunitas)  ){
                showAlert("AGENDA KOMUNITAS","AGENDA KOMUNITAS hanya boleh mengandung huruf dan minimal 3 karakter");
                TF3.clear();
                return;
            }

            if (syarat_Komunitas.isEmpty() || !isValidHuruf(syarat_Komunitas)  ){
                showAlert("SYARAT BERGABUNG","SYARAT BERGABUNG hanya boleh mengandung huruf dan minimal 3 karakter");
                TF4.clear();
                return;
            }

            if(namaFoto.getText().equals("Belum memilih file .jpg/.png")||namaFoto.getText().equals("Ukuran gambar harus 250 x 150 piksel")){
                showAlert("FOTO KOMUNITAS","FOTO KOMUNITAS belum diupload");
                return;
            }

            if(saveToDatabase(nama_Komunitas,tanggal_Pendirian,agenda_Komunitas,syarat_Komunitas,fileInputStream,penanda)) {
                getImageFromDatabase(penanda);
                showSucces("Success", "Data berhasil disimpan ke database");
                List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5,L6,G6);
                for (Node node : obj) {
                    node.setVisible(true);
                }
                List<Node> fillShow = Arrays.asList(
                        R1,T1,TF1,
                        R2,T2,TF2,
                        R3,T3,TF3,
                        R4,T4,TF4,
                        R5,T5,TF5,
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
                properti.setImage(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/disini.png")));
                namaFoto.setText("Belum memilih file .jpg/.png");
            }

        }));

        cancel.setOnAction(event -> {
            List<Node> obj = Arrays.asList(searchProperti, search, L1, G1, L2, G2, L3, G3, L4, G4, L5, G5, L6, G6);
            for (Node node : obj) {
                node.setVisible(true);
            }
            List<Node> fillShow = Arrays.asList(
                    R1,T1,TF1,
                    R2,T2,TF2,
                    R3,T3,TF3,
                    R4,T4,TF4,
                    R5,T5,TF5,
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


        keywordObject.put("komunitas 1",List.of(L1));
        keywordObject.put("komunitas 2",List.of(L2));
        keywordObject.put("komunitas 3",List.of(L3));
        keywordObject.put("komunitas 4",List.of(L4));
        keywordObject.put("komunitas 5",List.of(L5));
        keywordObject.put("komunitas 6",List.of(L6));

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
    private boolean isValidAngkaKarakter(String hurufKarakter) {
        return hurufKarakter.matches("[0-9\\-]{10,}");
    }


    private boolean isValidImageSize(File file) throws IOException {
        javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
        return image.getWidth() == 250 && image.getHeight() == 150;
    }

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean saveToDatabase(String nama, String tanggal, String agenda, String syarat, FileInputStream imgKM, String penanda) {
        String insertSQL = "INSERT INTO ARAYALANDBASDAT.KOMUNITAS (NAMA_KM, TGL_PDRN, AGENDA_KM, SYARAT_KM, IMG_KM, PENANDA) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set parameter PreparedStatement dengan nilai properti
            pstmt.setString(1, nama);

            // Convert input date from MM-DD-YYYY to java.sql.Date
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.util.Date parsedDate = inputFormat.parse(tanggal);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            pstmt.setDate(2, sqlDate);

            pstmt.setString(3, agenda);
            pstmt.setString(4, syarat);
            pstmt.setBinaryStream(5, imgKM, imgKM.available());
            pstmt.setString(6, penanda);

            // Eksekusi pernyataan SQL untuk menyimpan data
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException | IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void getImageFromDatabase(String noPr) {
        String selectSQL = "SELECT IMG_KM FROM ARAYALANDBASDAT.KOMUNITAS WHERE PENANDA = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setString(1, noPr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("IMG_KM");
                InputStream inputStream = blob.getBinaryStream();
                Image temp = new Image(inputStream);
                if(noPr.equals("1")){
                    G1.setImage(temp);
                } else if (noPr.equals("2")) {
                    G2.setImage(temp);
                }else if (noPr.equals("3")) {
                    G3.setImage(temp);
                }else if (noPr.equals("4")) {
                    G4.setImage(temp);
                }else if (noPr.equals("5")) {
                    G5.setImage(temp);
                }else if (noPr.equals("6")) {
                    G6.setImage(temp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshImages(ImageView[] imageViews) {
        String[] propertyNumbers = {"1", "2", "3", "4", "5","6"};
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            for (int i = 0; i < propertyNumbers.length; i++) {
                getImageFromDatabase(propertyNumbers[i]);
            }
        };

        executor.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS); // refresh every 5 seconds
    }
}
