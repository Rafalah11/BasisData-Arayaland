package com.example.arayalandbasdat;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
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

public class CustomerOwnership extends Application {
    Rectangle navigasi;
    HBox all;
    ScrollPane scrollPane;
    ImageView logo;
    ImageView logout;
    ImageView iconBeliProperti;
    ImageView iconAksesFasilitas;
    ImageView iconJoinKomunitas;
    ImageView iconBerlanggananCS;
    ImageView iconOwnership;
    GridPane navGridPane;
    StackPane contentkanan;
    StackPane navigasikiri;
    Text dashBoardtxt;
    Line garisdashBoardtxt;
    Text texttotal;

    TextField totalProperti;
    TextField searchProperti;
    ImageView search;

    Circle lingkaranActive;
    TextField username123;



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

        iconBeliProperti = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Beli_Properti.png")));
        iconBeliProperti.setFitWidth(90);
        iconBeliProperti.setFitHeight(90);
        iconBeliProperti.setOnMouseEntered(event -> iconBeliProperti.setCursor(Cursor.HAND));
        iconBeliProperti.setOnMouseExited(event -> iconBeliProperti.setCursor(Cursor.DEFAULT));

        iconAksesFasilitas = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Akses_Fasilitas.png")));
        iconAksesFasilitas.setFitWidth(100);
        iconAksesFasilitas.setFitHeight(100);
        iconAksesFasilitas.setOnMouseEntered(event -> iconAksesFasilitas.setCursor(Cursor.HAND));
        iconAksesFasilitas.setOnMouseExited(event -> iconAksesFasilitas.setCursor(Cursor.DEFAULT));

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

        iconBerlanggananCS = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Berlangganan_Kebersihan.png")));
        iconBerlanggananCS.setFitWidth(100);
        iconBerlanggananCS.setFitHeight(100);
        iconBerlanggananCS.setOnMouseEntered(event -> iconBerlanggananCS.setCursor(Cursor.HAND));
        iconBerlanggananCS.setOnMouseExited(event -> iconBerlanggananCS.setCursor(Cursor.DEFAULT));

        logout = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logout.png")));
        logout.setFitWidth(100);
        logout.setFitHeight(100);
        logout.setTranslateY(450);
        logout.setOnMouseEntered(event -> logout.setCursor(Cursor.HAND));
        logout.setOnMouseExited(event -> logout.setCursor(Cursor.DEFAULT));

        navGridPane = new GridPane();
        navGridPane.setVgap(40);
        navGridPane.add(iconBeliProperti,0,1);
        navGridPane.add(iconAksesFasilitas,0,2);
        navGridPane.add(iconJoinKomunitas,0,3);
        navGridPane.add(iconOwnership,0,5);
        navGridPane.add(iconBerlanggananCS,0,4);
        navGridPane.setAlignment(Pos.CENTER);
        navGridPane.setTranslateX(0);
        navGridPane.setTranslateY(-20);

        navigasi = new Rectangle(250,1000, Color.web("#316d18"));


        //content kanan

        dashBoardtxt = new Text("Properti Saya");
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

        searchProperti = new TextField();
        searchProperti.setPromptText("Cari Disini");
        searchProperti.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #316d18;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: white; -fx-text-fill: white;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        searchProperti.setMaxWidth(900);
        searchProperti.setTranslateY(-330);
        searchProperti.setTranslateX(-150);

        search = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/search.png")));
        search.setFitWidth(40);
        search.setFitHeight(40);
        search.setOnMouseEntered(event -> search.setCursor(Cursor.HAND));
        search.setOnMouseExited(event -> search.setCursor(Cursor.DEFAULT));
        search.setTranslateY(-330);
        search.setTranslateX(330);

        texttotal = new Text("TOTAL PROPERTI : ");
        texttotal.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 36px; "
                + "-fx-fill: #3D3A3B; -fx-font-weight: bold");
        texttotal.setTranslateX(-440);
        texttotal.setTranslateY(80);

        totalProperti = new TextField("0");
        totalProperti.setStyle("-fx-background-color: #316d18; -fx-font-size: 36px; "
                + "-fx-text-fill: white; "
                + "-fx-background-radius: 50; "
                + "-fx-border-radius: 50; "
                + "-fx-focus-color: transparent; "
                + "-fx-faint-focus-color: transparent; "
                + "-fx-highlight-fill: transparent; "
                + "-fx-highlight-text-fill: white;");
        totalProperti.setTranslateY(80);
        totalProperti.setTranslateX(-190);
        totalProperti.setMaxWidth(100);
        totalProperti.setEditable(false);
        totalProperti.setAlignment(Pos.CENTER);




        //main Layout

        navigasikiri = new StackPane();
        navigasikiri.getChildren().addAll(navigasi,logo,navGridPane, logout);

        contentkanan = new StackPane();
        contentkanan.getChildren().addAll(dashBoardtxt,garisdashBoardtxt,username123,lingkaranActive,searchProperti,search,texttotal,totalProperti);

        all = new HBox(navigasikiri,contentkanan);

        scrollPane = new ScrollPane();
        scrollPane.setContent(all);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane);

        stage.setTitle("Customer Ownership");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        iconBeliProperti.setOnMouseClicked(mouseEvent -> {
            CustomerProperty customerProperty = new CustomerProperty();
            try {
                Stage newStage = new Stage();
                customerProperty.setUsername(username);
                customerProperty.start(newStage);
                newStage.setResizable(true);
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iconAksesFasilitas.setOnMouseClicked(mouseEvent -> {
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
            showSucces("Already in there","Anda sudah berada dihalaman Properti Saya");
            customerOwnership.setUsername(username);
        });

        iconBerlanggananCS.setOnMouseClicked(mouseEvent -> {
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
    }

    private void showSucces(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
}
