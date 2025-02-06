package com.example.arayalandbasdat;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;


public class MainLogin extends Application {

    //All Properties
    ImageView backgroundLogin;
    ImageView logo;

    Text ArayaLandAppLogin;
    Text ArayaLandAppSignIn;

    Text StartLogin;
    Text StartSignIn;

    Text loginYourAcc;

    Text createAnAcc;

    Text dontAcc;

    Text AlreadyAcc;

    Button clickHereSignUp;

    Button clickHereLogin;

    Button signUpLine;

    Button signInLine;

    TextField usernameLog;

    PasswordField passLog;
    TextField visiblepassLog;

    TextField usernameCreate;

    TextField namaCreate;

    PasswordField passCreate;
    TextField visiblepassCreate;

    Button login;

    Button signUp;

    ImageView eyeKeyLog;
    ImageView uneyeKeyLog;
    ImageView eyeKeySignIn;
    ImageView uneyeKeySignIn;

    GridPane LoginNode;
    GridPane SignUpNode;
    HBox headLogin;
    HBox headSignIn;

    HBox dont;

    HBox have;

    HBox passwordLog;

    HBox passwordCrt;
    HBox vpasswordLog;
    HBox vpasswordCrt;

    Text usernameValidLog;
    Text usernameInvalidLog;
    Text passwordValidLog;
    Text passwordInvalidLog;
    Text namaValidSignIn;
    Text namaInvalidSignIn;
    Text usernameValidSignIn;
    Text usernameInvalidSignIn;
    Text passwordValidSignIn;
    Text passwordInvalidSignIn;

    String username;


    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Sesuaikan dengan URL database Anda
    private static final String DB_USER = "SYSTEM"; // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "SYSTEM"; // Ganti dengan password database Anda



    @Override
    public void start(Stage stage) throws Exception {

        //Inisialisasi Properties

        backgroundLogin = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/Login.png")));
        backgroundLogin.setFitWidth(1536);
        backgroundLogin.setFitHeight(820);

        ArayaLandAppLogin = new Text("ArayaLand App");
        ArayaLandAppLogin.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 32px; "
                + "-fx-fill: white;");
        ArayaLandAppSignIn = new Text("ArayaLand App");
        ArayaLandAppSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 32px; "
                + "-fx-fill: white;");

        StartLogin = new Text("Start to see our properties");
        StartLogin.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-fill: white;");
        StartSignIn = new Text("Start to see our properties");
        StartSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-fill: white;");

        signUpLine = new Button("Sign up");
        signUpLine.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 32px; "
                + "-fx-background-color: transparent; " +
                "-fx-border-color: transparent;");
        signUpLine.setTextFill(Color.WHITE);
        signUpLine.setTranslateY(-15);

        // Menambahkan event handler untuk mengubah kursor
        signUpLine.setOnMouseEntered(event -> signUpLine.setCursor(Cursor.HAND));
        signUpLine.setOnMouseExited(event -> signUpLine.setCursor(Cursor.DEFAULT));

        signInLine = new Button("Sign in");
        signInLine.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 32px; "
                + "-fx-background-color: transparent; " +
                "-fx-border-color: transparent;");
        signInLine.setTextFill(Color.WHITE);
        signInLine.setTranslateY(-15);

        // Menambahkan event handler untuk mengubah kursor
        signInLine.setOnMouseEntered(event -> signInLine.setCursor(Cursor.HAND));
        signInLine.setOnMouseExited(event -> signInLine.setCursor(Cursor.DEFAULT));


        loginYourAcc = new Text("Login your account.");
        loginYourAcc.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 48px; "
                + "-fx-fill: white;");

        createAnAcc = new Text("Create an account.");
        createAnAcc.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 48px; "
                + "-fx-fill: white;");

        dontAcc = new Text("Don't have an account?");
        dontAcc.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-fill: white;");

        AlreadyAcc = new Text("Already have an account?");
        AlreadyAcc.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-fill: white;");

        clickHereSignUp = new Button("Click Here");
        clickHereSignUp.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-background-color: transparent; "
                + "-fx-border-color: transparent;");
        clickHereSignUp.setTextFill(Color.DEEPSKYBLUE);
        clickHereSignUp.setTranslateY(-10);

        // Menambahkan event handler untuk mengubah kursor
        clickHereSignUp.setOnMouseEntered(event -> clickHereSignUp.setCursor(Cursor.HAND));
        clickHereSignUp.setOnMouseExited(event -> clickHereSignUp.setCursor(Cursor.DEFAULT));


        clickHereLogin = new Button("Click Here");
        clickHereLogin.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-background-color: transparent; " +
                "-fx-border-color: transparent;");
        clickHereLogin.setTextFill(Color.DEEPSKYBLUE);
        clickHereLogin.setTranslateY(-10);

        // Menambahkan event handler untuk mengubah kursor
        clickHereLogin.setOnMouseEntered(event -> clickHereLogin.setCursor(Cursor.HAND));
        clickHereLogin.setOnMouseExited(event -> clickHereLogin.setCursor(Cursor.DEFAULT));

        usernameLog = new TextField();
        usernameLog.setPromptText("Username");
        usernameLog.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 24px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        usernameLog.setPrefWidth(460);


        passLog = new PasswordField();
        passLog.setPromptText("Password");
        passLog.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 24px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        passLog.setPrefWidth(460);

        visiblepassLog = new TextField();
        visiblepassLog.setPromptText("Password");
        visiblepassLog.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 24px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        visiblepassLog.setPrefWidth(460);


        login = new Button("Login");
        login.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-text-fill: green; "
                + "-fx-background-color: yellow; "
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30; "
                + "-fx-alignment: center;");
        login.setPrefWidth(460);

        // Menambahkan event handler untuk mengubah kursor
        login.setOnMouseEntered(event -> login.setCursor(Cursor.HAND));
        login.setOnMouseExited(event -> login.setCursor(Cursor.DEFAULT));

        usernameCreate = new TextField();
        usernameCreate.setPromptText("Username");
        usernameCreate.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        usernameCreate.setPrefWidth(460);
        usernameCreate.setTranslateY(-10);

        namaCreate = new TextField();
        namaCreate.setPromptText("Nama Asli");
        namaCreate.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        namaCreate.setPrefWidth(460);
        namaCreate.setTranslateY(-10);

        passCreate = new PasswordField();
        passCreate.setPromptText("Password");
        passCreate.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        passCreate.setPrefWidth(460);
        passCreate.setTranslateY(-10);

        visiblepassCreate = new TextField();
        visiblepassCreate.setPromptText("Password");
        visiblepassCreate.setStyle("-fx-font-family: 'Montserrat'; -fx-background-color: #a6a6a6;"
                + "-fx-font-size: 20px; "
                + "-fx-prompt-text-fill: green; -fx-text-fill: green;"
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30;");
        visiblepassCreate.setPrefWidth(460);
        visiblepassCreate.setTranslateY(-10);

        eyeKeyLog = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/eyeKey.png")));
        eyeKeyLog.setFitWidth(30);
        eyeKeyLog.setFitHeight(30);

        uneyeKeyLog = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/uneyeKey.png")));
        uneyeKeyLog.setFitWidth(30);
        uneyeKeyLog.setFitHeight(30);

        uneyeKeySignIn = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/uneyeKey.png")));
        uneyeKeySignIn.setFitWidth(30);
        uneyeKeySignIn.setFitHeight(30);

        eyeKeySignIn = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/eyeKey.png")));
        eyeKeySignIn.setFitWidth(30);
        eyeKeySignIn.setFitHeight(30);

        passLog.textProperty().bindBidirectional(visiblepassLog.textProperty());

        passCreate.textProperty().bindBidirectional(visiblepassCreate.textProperty());



        signUp = new Button("Sign Up");
        signUp.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 24px; "
                + "-fx-text-fill: green; "
                + "-fx-background-color: yellow; "
                + "-fx-background-radius: 30; "
                + "-fx-border-radius: 30; "
                + "-fx-alignment: center;");
        signUp.setPrefWidth(460);
        signUp.setTranslateY(-10);

        // Menambahkan event handler untuk mengubah kursor
        signUp.setOnMouseEntered(event -> signUp.setCursor(Cursor.HAND));
        signUp.setOnMouseExited(event -> signUp.setCursor(Cursor.DEFAULT));

        headLogin = new HBox(100);
        headLogin.getChildren().addAll(ArayaLandAppLogin,signUpLine);
        headLogin.setTranslateY(35);
        headLogin.setTranslateX(90);
        headLogin.setVisible(true);

        headSignIn = new HBox(100);
        headSignIn = new HBox(100);
        headSignIn.getChildren().addAll(ArayaLandAppSignIn,signInLine);
        headSignIn.setTranslateY(35);
        headSignIn.setTranslateX(90);
        headSignIn.setVisible(false);

        dont = new HBox(-10);
        dont.getChildren().addAll(dontAcc,clickHereSignUp);

        have = new HBox(-10);
        have.getChildren().addAll(AlreadyAcc,clickHereLogin);

        passwordLog = new HBox(-40);
        passwordLog.getChildren().addAll(passLog,eyeKeyLog);
        eyeKeyLog.setTranslateY(10);
        passwordLog.setVisible(true);

        eyeKeyLog.setOnMouseEntered(event -> eyeKeyLog.setCursor(Cursor.HAND));
        eyeKeyLog.setOnMouseExited(event -> eyeKeyLog.setCursor(Cursor.DEFAULT));

        passwordCrt = new HBox(-40);
        passwordCrt.getChildren().addAll(passCreate,eyeKeySignIn);
        passwordCrt.setVisible(true);

        eyeKeySignIn.setOnMouseEntered(event -> eyeKeySignIn.setCursor(Cursor.HAND));
        eyeKeySignIn.setOnMouseExited(event -> eyeKeySignIn.setCursor(Cursor.DEFAULT));

        vpasswordLog = new HBox(-40);
        vpasswordLog.getChildren().addAll(visiblepassLog,uneyeKeyLog);
        uneyeKeyLog.setTranslateY(10);
        vpasswordLog.setVisible(false);

        uneyeKeyLog.setOnMouseEntered(event -> uneyeKeyLog.setCursor(Cursor.HAND));
        uneyeKeyLog.setOnMouseExited(event -> uneyeKeyLog.setCursor(Cursor.DEFAULT));

        vpasswordCrt = new HBox(-40);
        vpasswordCrt.getChildren().addAll(visiblepassCreate,uneyeKeySignIn);
        vpasswordCrt.setVisible(false);

        uneyeKeySignIn.setOnMouseEntered(event -> uneyeKeySignIn.setCursor(Cursor.HAND));
        uneyeKeySignIn.setOnMouseExited(event -> uneyeKeySignIn.setCursor(Cursor.DEFAULT));

        usernameValidLog = new Text("Username sudah sesuai ✅");
        usernameValidLog.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 14px; "
                + "-fx-fill: white;");
        usernameValidLog.setVisible(false);
        usernameValidLog.setTranslateX(-580);
        usernameValidLog.setTranslateY(158);


        usernameInvalidLog = new Text("Username tidak sesuai ❌ (huruf, angka, dan tidak kurang dari 5 karakter)");
        usernameInvalidLog.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 14px; "
                + "-fx-fill: white;");
        usernameInvalidLog.setVisible(false);
        usernameInvalidLog.setTranslateX(-440);
        usernameInvalidLog.setTranslateY(158);

        passwordValidLog = new Text("Password sudah sesuai ✅") ;
        passwordValidLog.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 14px; "
                + "-fx-fill: white;");
        passwordValidLog.setVisible(false);
        passwordValidLog.setTranslateX(-580);
        passwordValidLog.setTranslateY(245);


        passwordInvalidLog = new Text("Password tidak sesuai ❌ (huruf, angka, dan tidak kurang dari 8 karakter)");
        passwordInvalidLog.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 14px; "
                + "-fx-fill: white;");
        passwordInvalidLog.setVisible(false);
        passwordInvalidLog.setTranslateX(-440);
        passwordInvalidLog.setTranslateY(245);

        namaValidSignIn = new Text("Nama sudah sesuai ✅");
        namaValidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 15px; "
                + "-fx-fill: white;");
        namaValidSignIn.setVisible(false);
        namaValidSignIn.setTranslateX(-588);
        namaValidSignIn.setTranslateY(105);

        namaInvalidSignIn =  new Text("Nama tidak sesuai ❌ Nama hanya mengandung huruf dan spasi");
        namaInvalidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 15px; "
                + "-fx-fill: white;");
        namaInvalidSignIn.setVisible(false);
        namaInvalidSignIn.setTranslateX(-454);
        namaInvalidSignIn.setTranslateY(105);

        usernameValidSignIn = new Text("Username sudah sesuai ✅");
        usernameValidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 15px; "
                + "-fx-fill: white;");
        usernameValidSignIn.setVisible(false);
        usernameValidSignIn.setTranslateX(-588);
        usernameValidSignIn.setTranslateY(179);

        usernameInvalidSignIn = new Text("Username tidak sesuai ❌ (huruf, angka, dan tidak kurang dari 5 karakter)");
        usernameInvalidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 14px; "
                + "-fx-fill: white;");
        usernameInvalidSignIn.setVisible(false);
        usernameInvalidSignIn.setTranslateX(-445);
        usernameInvalidSignIn.setTranslateY(179);

        passwordValidSignIn = new Text("Password sudah sesuai ✅") ;
        passwordValidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 15px; "
                + "-fx-fill: white;");
        passwordValidSignIn.setVisible(false);
        passwordValidSignIn.setTranslateX(-581);
        passwordValidSignIn.setTranslateY(251);

        passwordInvalidSignIn = new Text("Password tidak sesuai ❌ (huruf, angka, dan tidak kurang dari 8 karakter)");
        passwordInvalidSignIn.setStyle("-fx-font-family: 'Montserrat'; "
                + "-fx-font-size: 15px; "
                + "-fx-fill: white;");
        passwordInvalidSignIn.setVisible(false);
        passwordInvalidSignIn.setTranslateX(-432);
        passwordInvalidSignIn.setTranslateY(251);


        LoginNode = new GridPane();
        LoginNode.setTranslateX(90);
        LoginNode.setTranslateY(215);
        LoginNode.setVgap(40);


        LoginNode.add(StartLogin,0,0);
        LoginNode.add(loginYourAcc,0,1);
        LoginNode.add(dont,0,2);
        LoginNode.add(usernameLog,0,3);
        LoginNode.add(passwordLog,0,4);
        LoginNode.add(vpasswordLog,0,4);
        LoginNode.add(login,0,5);
        LoginNode.setVisible(true);

        SignUpNode = new GridPane();
        SignUpNode.setTranslateX(90);
        SignUpNode.setTranslateY(215);
        SignUpNode.setVgap(30);


        SignUpNode.add(StartSignIn,0,0);
        SignUpNode.add(createAnAcc,0,1);
        SignUpNode.add(have,0,2);
        SignUpNode.add(namaCreate,0,3);
        SignUpNode.add(usernameCreate,0,4);
        SignUpNode.add(passwordCrt,0,5);
        SignUpNode.add(vpasswordCrt,0,5);
        SignUpNode.add(signUp,0,6);
        SignUpNode.setVisible(false);


        logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/arayalandbasdat/image/logo.png")));
        logo.setFitWidth(450);
        logo.setFitHeight(450);
        logo.setTranslateY(280);
        logo.setTranslateX(600);

        //Animasi Logo

        logo.setBlendMode(BlendMode.ADD);


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(logo.opacityProperty(), 0.2)),
                new KeyFrame(Duration.seconds(2), new KeyValue(logo.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(4), new KeyValue(logo.opacityProperty(), 0.2))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Glow glow = new Glow(0.8); // Atur level intensitas glow di sini (0-1)
        logo.setEffect(glow);



        StackPane stack1 = new StackPane(backgroundLogin, headLogin, headSignIn, LoginNode, SignUpNode,logo,
                usernameValidLog,usernameInvalidLog,passwordValidLog,passwordInvalidLog,
                namaValidSignIn,namaInvalidSignIn,usernameValidSignIn,usernameInvalidSignIn,passwordValidSignIn,passwordInvalidSignIn);
        Scene scene = new Scene(stack1);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Login App");
        stage.show();

        //EventHandler

        login.setOnAction(event -> {
            String inputUsername = usernameLog.getText().trim();
            String password = visiblepassLog.getText().trim();

            // Validasi username hanya huruf dan angka
            if (!isValidUsername(inputUsername)) {
                showAlert("Username Tidak Valid", "Username hanya boleh mengandung huruf (wajib), angka (opsional) dan tidak kurang dari 5 karakter.");
                usernameLog.clear();
                return;
            }

            // Validasi password sesuai dengan aturan (hanya huruf, angka, dan minimal 8 karakter)
            if (!isValidPassword(password)) {
                showAlert("Password Tidak Valid", "Password harus mengandung huruf (wajib), angka (wajib), dan minimal 8 karakter.");
                visiblepassLog.clear();
                return;
            }

            // Memeriksa kredensial
            String loggedInUsername = checkCredentials(inputUsername, password);
            if (loggedInUsername != null) {
                // Mengisi variabel global username dengan nilai dari database
                username = loggedInUsername;
                usernameLog.clear();
                visiblepassLog.clear();
                showSucces("Login Succeeded","Login Berhasil!");

                // Memeriksa apakah login sebagai admin
                if (username.equals("admin")) {
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
                } else {
                    CustomerProperty customerProperty = new CustomerProperty();
                    try {
                        Stage newStage = new Stage();
                        customerProperty.setUsername(username); // Set username untuk halaman CustomerProperty
                        customerProperty.start(newStage);
                        newStage.setResizable(true);
                        stage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                showAlert("Login Gagal", "Username atau password tidak valid.");
                usernameLog.clear();
                visiblepassLog.clear();
            }
        });



        signUp.setOnAction(event -> {
            String username = usernameCreate.getText().trim();
            String realName = namaCreate.getText().trim();
            String password = visiblepassCreate.getText().trim();

            // Validasi realName hanya huruf dan spasi
            if (!isValidRealName(realName)) {
                showAlert("Nama Tidak Valid", "Nama hanya boleh mengandung huruf dan spasi.");
                namaCreate.clear();
                return;
            }

            // Validasi username hanya huruf dan angka
            if (!isValidUsername(username)) {
                showAlert("Username Tidak Valid", "Username hanya boleh mengandung huruf (wajib), angka (opsional) dan tidak kurang dari 5 karakter.");
                usernameCreate.clear();
                return;
            }

            // Validasi password sesuai dengan aturan (hanya huruf, angka, dan minimal 8 karakter)
            if (!isValidPassword(password)) {
                showAlert("Password Tidak Valid", "Password harus mengandung huruf (wajib), angka (wajib), dan minimal 8 karakter.");
                visiblepassCreate.clear();
                return;
            }

            //SQL
            if(saveToDatabase(username,password,realName)){
                showSucces("Sign in Succed","Akun Anda Berhasil Terdaftar! (Silahkan login)");
                usernameCreate.clear();
                namaCreate.clear();
                visiblepassCreate.clear();
            }

            SignUpNode.setVisible(false);
            LoginNode.setVisible(true);
            headLogin.setVisible(true);
            headSignIn.setVisible(false);
            passwordCrt.setVisible(false);
            vpasswordCrt.setVisible(true);
            namaInvalidSignIn.setVisible(false);
            usernameInvalidSignIn.setVisible(false);
            passwordInvalidSignIn.setVisible(false);
        });

        clickHereSignUp.setOnAction(event -> {
            SignUpNode.setVisible(true);
            LoginNode.setVisible(false);
            headLogin.setVisible(false);
            headSignIn.setVisible(true);

            usernameValidLog.setVisible(false);
            usernameInvalidLog.setVisible(false);
            passwordValidLog.setVisible(false);
            passwordInvalidLog.setVisible(false);

        });

        signUpLine.setOnAction(event -> {
            SignUpNode.setVisible(true);
            LoginNode.setVisible(false);
            headLogin.setVisible(false);
            headSignIn.setVisible(true);
        });

        clickHereLogin.setOnAction(event -> {
            SignUpNode.setVisible(false);
            LoginNode.setVisible(true);
            headLogin.setVisible(true);
            headSignIn.setVisible(false);

            namaValidSignIn.setVisible(false);
            namaInvalidSignIn.setVisible(false);
            usernameValidSignIn.setVisible(false);
            usernameInvalidSignIn.setVisible(false);
            passwordValidSignIn.setVisible(false);
            passwordInvalidSignIn.setVisible(false);


        });

        signInLine.setOnAction(event -> {
            SignUpNode.setVisible(false);
            LoginNode.setVisible(true);
            headLogin.setVisible(true);
            headSignIn.setVisible(false);
        });

        eyeKeyLog.setOnMouseClicked(mouseEvent -> {
            passwordLog.setVisible(false);
            vpasswordLog.setVisible(true);
        });
        uneyeKeyLog.setOnMouseClicked(mouseEvent -> {
            passwordLog.setVisible(true);
            vpasswordLog.setVisible(false);
        });
        eyeKeySignIn.setOnMouseClicked(mouseEvent -> {
            passwordCrt.setVisible(false);
            vpasswordCrt.setVisible(true);
        });

        uneyeKeySignIn.setOnMouseClicked(mouseEvent -> {
            passwordCrt.setVisible(true);
            vpasswordCrt.setVisible(false);
        });

        usernameLog.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidUsername(newValue)) {
                usernameValidLog.setVisible(true);
                usernameInvalidLog.setVisible(false);
            } else {
                usernameValidLog.setVisible(false);
                usernameInvalidLog.setVisible(true);
            }
        });

        passLog.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidPassword(newValue)) {
                passwordValidLog.setVisible(true);
                passwordInvalidLog.setVisible(false);
            } else {
                passwordValidLog.setVisible(false);
                passwordInvalidLog.setVisible(true);
            }
        });

        visiblepassLog.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidPassword(newValue)) {
                passwordValidLog.setVisible(true);
                passwordInvalidLog.setVisible(false);
            } else {
                passwordValidLog.setVisible(false);
                passwordInvalidLog.setVisible(true);
            }
        });


        usernameCreate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidUsername(newValue)) {
                usernameValidSignIn.setVisible(true);
                usernameInvalidSignIn.setVisible(false);
            } else {
                usernameValidSignIn.setVisible(false);
                usernameInvalidSignIn.setVisible(true);
            }
        });

        namaCreate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidRealName(newValue)) {
                namaValidSignIn.setVisible(true);
                namaInvalidSignIn.setVisible(false);
            } else {
                namaValidSignIn.setVisible(false);
                namaInvalidSignIn.setVisible(true);
            }
        });

        passCreate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidPassword(newValue)) {
                passwordValidSignIn.setVisible(true);
                passwordInvalidSignIn.setVisible(false);
            } else {
                passwordValidSignIn.setVisible(false);
                passwordInvalidSignIn.setVisible(true);
            }
        });

        visiblepassCreate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidPassword(newValue)) {
                passwordValidSignIn.setVisible(true);
                passwordInvalidSignIn.setVisible(false);
            } else {
                passwordValidSignIn.setVisible(false);
                passwordInvalidSignIn.setVisible(true);
            }
        });

    }
    private boolean isValidRealName(String realName) {
        return realName.matches("[a-zA-Z\\s]+");
    }
    private boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z][a-zA-Z0-9]{4,}");
    }
    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}$");
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSucces(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        alert.getDialogPane().setStyle(
                "-fx-background-color: linear-gradient(to bottom, #84d2e1, #6fb8de);" + // Background color
                        "-fx-border-color: derive(-fx-base, 20%);" + // Border color
                        "-fx-border-width: 2px;" + // Border width
                        "-fx-border-radius: 5px;" + // Border radius
                        "-fx-background-insets: 0, 1, 2;" + // Insets
                        "-fx-background-radius: 5px;"
        );
    }

    private boolean saveToDatabase(String username, String password, String realname) {
        String insertSQL = "INSERT INTO ARAYALANDBASDAT.ACCOUNT (usnm_AC, pswd_AC, Nama_AC) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, realname);

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
}