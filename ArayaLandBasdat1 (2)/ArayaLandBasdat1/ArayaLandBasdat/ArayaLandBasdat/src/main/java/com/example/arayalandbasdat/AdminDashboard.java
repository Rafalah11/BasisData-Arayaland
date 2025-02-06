package com.example.arayalandbasdat;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.HostServices;

import java.sql.*;

import static com.example.arayalandbasdat.MainLogin.*;


public class AdminDashboard extends Application {

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
    ImageView iconDashboard;
    ImageView iconManajemenPr;
    ImageView iconManajemenFs;
    ImageView iconManajemenKb;
    ImageView iconManajemenKm;
    GridPane navGridPane;
    StackPane contentkanan;
    StackPane navigasikiri;
    Text dashBoardtxt;
    Line garisdashBoardtxt;
    Text arayaLand;
    Circle lingkaran1;
    Circle lingkaran2;
    Circle lingkaran3;
    Circle lingkaran4;

    private static final String[] IMAGE_ARAYA = {
            "/com/example/arayalandbasdat/image/araya1.png",
            "/com/example/arayalandbasdat/image/araya2.png",
            "/com/example/arayalandbasdat/image/araya3.png",
            "/com/example/arayalandbasdat/image/araya4.png"
    };

    ImageView boardAraya;

    int current_image = 0;

    HBox circle;

    GridPane detailAraya;

    HBox instagram;
    HBox notelfon;
    HBox lokasi;

    ImageView ig;
    ImageView no;
    ImageView lok;
    Button namaig;
    Button alamatlokasi;
    Button nomoraraya;
    private HostServices hostServices;


    public void init() throws Exception {
        hostServices = getHostServices();
    }

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Sesuaikan dengan URL database Anda
    private static final String DB_USER = "SYSTEM"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "SYSTEM";

    @Override
    public void start(Stage stage) throws Exception {

        //navigasi kiri

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

        dashBoardtxt = new Text("Dashboard");
        dashBoardtxt.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 40px; "
                + "-fx-fill: #545454; -fx-font-weight: bold");
        dashBoardtxt.setTranslateX(-480);
        dashBoardtxt.setTranslateY(-430);

        garisdashBoardtxt = new Line();
        garisdashBoardtxt.setStartX(270);  // Koordinat awal garis
        garisdashBoardtxt.setEndX(1535);    // Koordinat akhir garis (sesuaikan panjang sesuai kebutuhan)
        garisdashBoardtxt.setTranslateY(-380);  // Sesuaikan posisi vertikal
        garisdashBoardtxt.setStroke(Color.web("#a6a6a6"));  // Warna garis
        garisdashBoardtxt.setStrokeWidth(5);  // Ketebalan garis
        garisdashBoardtxt.setTranslateX(0);

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

        arayaLand = new Text("ArayaLand");
        arayaLand.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 40px; "
                + "-fx-fill: #545454; -fx-font-weight: bold");
        arayaLand.setTranslateY(-330);
        arayaLand.setTextAlignment(TextAlignment.CENTER);

        boardAraya = new ImageView(new Image(getClass().getResourceAsStream(IMAGE_ARAYA[current_image])));
        boardAraya.setFitWidth(1200);
        boardAraya.setFitHeight(420);
        boardAraya.setTranslateY(-70);
        boardAraya.setTranslateX(0);


        Timeline timelineBoard = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> showNextImage())
        );
        timelineBoard.setCycleCount(Timeline.INDEFINITE);
        timelineBoard.play();

        lingkaran1 = new Circle(10, Color.LIGHTGRAY);
        lingkaran2 = new Circle(10, Color.LIGHTGRAY);
        lingkaran3 = new Circle(10, Color.LIGHTGRAY);
        lingkaran4 = new Circle(10, Color.LIGHTGRAY);

        circle = new HBox(30);
        circle.getChildren().addAll(lingkaran1,lingkaran2,lingkaran3,lingkaran4);
        circle.setAlignment(Pos.CENTER);
        circle.setTranslateY(180);

        PauseTransition pause1 = new PauseTransition(Duration.seconds(2));
        PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
        PauseTransition pause3 = new PauseTransition(Duration.seconds(2));
        PauseTransition pause4 = new PauseTransition(Duration.seconds(2));
        pause1.setOnFinished(event -> {
            lingkaran1.setFill(Color.LIGHTGRAY);
            lingkaran2.setFill(Color.YELLOW);
            lingkaran3.setFill(Color.LIGHTGRAY);
            lingkaran4.setFill(Color.LIGHTGRAY);
            pause2.play();
        });
        pause2.setOnFinished(event -> {
            lingkaran1.setFill(Color.LIGHTGRAY);
            lingkaran2.setFill(Color.LIGHTGRAY);
            lingkaran3.setFill(Color.YELLOW);
            lingkaran4.setFill(Color.LIGHTGRAY);
            pause3.play();
        });
        pause3.setOnFinished(event -> {
            lingkaran1.setFill(Color.LIGHTGRAY);
            lingkaran2.setFill(Color.LIGHTGRAY);
            lingkaran3.setFill(Color.LIGHTGRAY);
            lingkaran4.setFill(Color.YELLOW);
            pause4.play();
        });
        pause4.setOnFinished(event -> {
            lingkaran1.setFill(Color.YELLOW);
            lingkaran2.setFill(Color.LIGHTGRAY);
            lingkaran3.setFill(Color.LIGHTGRAY);
            lingkaran4.setFill(Color.LIGHTGRAY);
            pause1.play();
        });
        lingkaran1.setFill(Color.YELLOW);
        lingkaran2.setFill(Color.LIGHTGRAY);
        lingkaran3.setFill(Color.LIGHTGRAY);
        lingkaran4.setFill(Color.LIGHTGRAY);
        pause1.play();

        lok = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Lokasi.png")));
        lok.setFitWidth(50);
        lok.setFitHeight(50);
        lok.setOnMouseEntered(event -> lok.setCursor(Cursor.HAND));
        lok.setOnMouseExited(event -> lok.setCursor(Cursor.DEFAULT));


        ig = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Instagram.png")));
        ig.setFitWidth(50);
        ig.setFitHeight(50);
        ig.setOnMouseEntered(event -> ig.setCursor(Cursor.HAND));
        ig.setOnMouseExited(event -> ig.setCursor(Cursor.DEFAULT));


        no = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Whatsapp.png")));
        no.setFitWidth(50);
        no.setFitHeight(50);
        no.setOnMouseEntered(event -> no.setCursor(Cursor.HAND));
        no.setOnMouseExited(event -> no.setCursor(Cursor.DEFAULT));

        alamatlokasi = new Button("Jl. Telaga Golf Utama No.24,\n" +
                "Kabupaten Malang, Jawa Timur ");
        alamatlokasi.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 21px; "
                + "-fx-fill: #545454; -fx-background-color: transparent; -fx-border-color: transparent;");
        alamatlokasi.setOnMouseEntered(event -> alamatlokasi.setCursor(Cursor.HAND));
        alamatlokasi.setOnMouseExited(event -> alamatlokasi.setCursor(Cursor.DEFAULT));

        namaig = new Button("@ArayaLand_mlg");
        namaig.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 21px; "
                + "-fx-fill: #545454; -fx-background-color: transparent; -fx-border-color: transparent;");
        namaig.setOnMouseEntered(event -> namaig.setCursor(Cursor.HAND));
        namaig.setOnMouseExited(event -> namaig.setCursor(Cursor.DEFAULT));

        nomoraraya = new Button("+62 851 - 0013 - 143");
        nomoraraya.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 21px; "
                + "-fx-fill: #545454; -fx-background-color: transparent; -fx-border-color: transparent;");
        nomoraraya.setOnMouseEntered(event -> nomoraraya.setCursor(Cursor.HAND));
        nomoraraya.setOnMouseExited(event -> nomoraraya.setCursor(Cursor.DEFAULT));

        lokasi = new HBox(10);
        lokasi.getChildren().addAll(lok,alamatlokasi);
        instagram = new HBox(10);
        instagram.getChildren().addAll(ig,namaig);
        notelfon = new HBox(10);
        notelfon.getChildren().addAll(no,nomoraraya);

        detailAraya = new GridPane();
        detailAraya.setVgap(50);
        detailAraya.add(lokasi,0,0);
        detailAraya.add(instagram,0,1);
        detailAraya.add(notelfon,0,2);
        detailAraya.setTranslateY(710);
        detailAraya.setTranslateX(50);


        //main Layout

        navigasikiri = new StackPane();
        navigasikiri.getChildren().addAll(navigasi,logo,navGridPane, logout);

        contentkanan = new StackPane();
        contentkanan.getChildren().addAll(dashBoardtxt,garisdashBoardtxt,username123,lingkaranActive, arayaLand,boardAraya,circle,detailAraya);

        all = new HBox(navigasikiri,contentkanan);

        scrollPane = new ScrollPane();
        scrollPane.setContent(all);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane);

        stage.setTitle("Admin Dashboard");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        iconDashboard.setOnMouseClicked(mouseEvent -> {
            AdminDashboard adminDashboard = new AdminDashboard();
            showSucces("Already in there","Anda sudah berada dihalaman Dashboard");
            adminDashboard.setUsername(username);
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


        ig.setOnMouseClicked(mouseEvent -> {
            hostServices.showDocument("https://www.instagram.com/araya_familyclub/");
        });

        namaig.setOnAction(event -> {
            hostServices.showDocument("https://www.instagram.com/araya_familyclub/");
        });

        lok.setOnMouseClicked(mouseEvent -> {
            hostServices.showDocument("https://maps.app.goo.gl/pjkswYTfrVjUwv8r9");
        });

        alamatlokasi.setOnAction(event -> {
            hostServices.showDocument("https://maps.app.goo.gl/pjkswYTfrVjUwv8r9");
        });

        no.setOnMouseClicked(mouseEvent -> {
            String phoneNumber = "08510013143";
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(phoneNumber);
            clipboard.setContent(content);
            showSucces("Nomor Telepon","Nomor kontak ArayaLand berhasil dicopy");
        });

        nomoraraya.setOnAction(event -> {
            String phoneNumber = "08510013143";
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(phoneNumber);
            clipboard.setContent(content);
            showSucces("Nomor Telepon","Nomor kontak ArayaLand berhasil dicopy");
        });

    }

    private void showNextImage() {
        current_image = (current_image + 1) % IMAGE_ARAYA.length;
        boardAraya.setImage(new Image(getClass().getResourceAsStream(IMAGE_ARAYA[current_image])));
    }

    private void showSucces(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
