package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {
	
	Scene loginScene, regiScene, forgotScene;
	
	Stage window;
	
	Customer c1 = new Customer();
	
	//Login
	
	Button bLogin;
	Button bRegi;
	Button bForg;
	
	Label username;
	Label password;
	
	TextField usnText;
	TextField pswText;
	
	//Registration
	
	Button bCreate;
	Button bBack;
	
	Label username1;
	Label password1;
	Label firstName;
	Label lastName;
	Label email;
	Label address;
	Label zip;
	Label state;
	Label ssn;
	Label securityQ;
	Label securityA;
	
	Label regiConfirm;
	
	TextField usnText1;
	TextField pswText1;
	TextField fnameText;
	TextField lnameText;
	TextField emText;
	TextField addText;
	TextField zipText;
	TextField stateText;
	TextField ssnText;
	TextField sqText;
	TextField saText;
	
	//forgot
	Button forgot;
	Button btBack2;
	
	Label id;
	Label c1Id;
	Label q;
	Label c1Q;
	Label a;
	Label retrievedPsw;
	Label yourPsw;
	
	TextField answer;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("ENM Airline Login");
		
		username = new Label("Login ID:");
		username.setStyle("-fx-text-fill: Black;");
		usnText = new TextField();
		usnText.setPromptText("ex: cbrown11");
		usnText.setPrefSize(300,25);
		
		username1 = new Label("Login ID:");
		username1.setStyle("-fx-text-fill: Black;");
		usnText1 = new TextField();
		usnText1.setPromptText("ex: jdoe78");
		usnText1.setPrefSize(300,25);

		password = new Label("Password:");
		password.setStyle("-fx-text-fill: Black;");
		pswText = new PasswordField();
		pswText.setPromptText("ex: coolduck123");
		pswText.setPrefSize(300,25);

		password1 = new Label("Password:");
		password1.setStyle("-fx-text-fill: Black;");
		pswText1 = new TextField();
		pswText1.setPromptText("ex: coolduck123");
		pswText1.setPrefSize(300,25);

		firstName = new Label("First Name:");
		firstName.setStyle("-fx-text-fill: Black;");
		fnameText = new TextField();
		fnameText.setPromptText("ex: Chris");
		fnameText.setPrefSize(300,25);

		lastName = new Label("Last Name:");
		lastName.setStyle("-fx-text-fill: Black;");
		lnameText = new TextField();
		lnameText.setPromptText("ex: Brown");
		lnameText.setPrefSize(300,25);

		email = new Label("Email:");
		email.setStyle("-fx-text-fill: Black;");
		emText = new TextField();
		emText.setPromptText("ex: cbrown123@gmail.com");
		emText.setPrefSize(300,25);

		address = new Label("Address:");
		address.setStyle("-fx-text-fill: Black;");
		addText = new TextField();
		addText.setPromptText("ex: 25 Park Place");
		addText.setPrefSize(300,25);

		zip = new Label("ZIP Code:");
		zip.setStyle("-fx-text-fill: Black;");
		zipText = new TextField();
		zipText.setPromptText("ex: 12345");
		zipText.setPrefSize(150,25);

		state = new Label("State:");
		state.setStyle("-fx-text-fill: Black;");
		stateText = new TextField();
		stateText.setPromptText("ex: GA");
		stateText.setPrefSize(50,25);

		ssn = new Label("SSN:");
		ssn.setStyle("-fx-text-fill: Black;");
		ssnText = new TextField();
		ssnText.setPromptText("ex: 123456789");
		ssnText.setPrefSize(300,25);

		securityQ = new Label("Security Question:");
		securityQ.setStyle("-fx-text-fill: Black;");
		sqText = new TextField();
		sqText.setPromptText("ex: What is the name of your college");
		sqText.setPrefSize(300,25);

		securityA = new Label("Security Answer:");
		securityA.setStyle("-fx-text-fill: Black;");
		saText = new TextField();
		saText.setPromptText("ex: Georgia State University");
		saText.setPrefSize(300,25);

		bLogin = new Button("Login");
		bLogin.setOnAction(e-> {
			login(usnText.getText(), pswText.getText());
			window.setTitle("ENM Airline Login");
		});
		
		//Register
		bRegi = new Button("Register");
		bRegi.setOnAction(e-> {

			window.setScene(regiScene);
			window.setTitle("ENM Air Registration");

		});

		//Forgot
		bForg = new Button("Forgot Password");
		bForg.setOnAction(e-> {
			c1.setUserName(usnText.getText());
			c1.setSecurityQ(retrieveQ(usnText.getText()));

			c1Id.setText(c1.getUserName());
			c1Q.setText(c1.getSecurityQ());

			window.setTitle("ENM Password Retrieval");
			window.setScene(forgotScene);
		});
		bCreate = new Button("Create");
		bCreate.setOnAction(e-> {
			
			if (usnText1.getText().isBlank() && pswText1.getText().isBlank() && fnameText.getText().isBlank() &&
					lnameText.getText().isBlank() && emText.getText().isBlank() && addText.getText().isBlank() &&
					zipText.getText().isBlank() && stateText.getText().isBlank() && ssnText.getText().isBlank() &&
					sqText.getText().isBlank() && saText.getText().isBlank()) {
				regiConfirm.setText("All fields required.");
				regiConfirm.setStyle("-fx-text-fill: Red;");
			} else {
				regiInput(usnText1.getText(),pswText1.getText(),fnameText.getText(),
						lnameText.getText(),emText.getText(),addText.getText(),zipText.getText(),
						stateText.getText(), ssnText.getText(), sqText.getText(), saText.getText());
				regiConfirm.setText("User has been registered.");
				regiConfirm.setStyle("-fx-text-fill: Green;");

			}
		});
		bBack = new Button("Back");
		bBack.setOnAction(e-> {
			window.setScene(loginScene);
			regiConfirm.setText("");
		});
		
		Pane loginLayout = new Pane();
		username.setLayoutX(20);
		username.setLayoutY(150);
		password.setLayoutX(10);
		password.setLayoutY(190);
		usnText.setLayoutX(85);
		usnText.setLayoutY(150);
		pswText.setLayoutX(85);
		pswText.setLayoutY(190);
		bLogin.setLayoutX(145);
		bLogin.setLayoutY(230);
		bLogin.setPrefSize(150,30);
		bForg.setLayoutX(145);
		bForg.setLayoutY(310);
		bForg.setPrefSize(150,30);
		bRegi.setLayoutX(145);
		bRegi.setLayoutY(270);
		bRegi.setPrefSize(150,30);

		loginLayout.setPrefSize(450, 400);
		loginLayout.setStyle("-fx-background-color: white;");
		loginLayout.getChildren().addAll(username, password, usnText, pswText, bLogin, bForg, bRegi);

		Pane border = new Pane();
		border.setPrefSize(300,400);
		border.setBackground(null);

		Pane enmLogo = new Pane();
		enmLogo.setPrefSize(400,80);
		enmLogo.setBackground(null);

		AnchorPane log = new AnchorPane(border,loginLayout);
		log.setTopAnchor(border, 0.0);
		log.setLeftAnchor(border, 0.0);
		log.setTopAnchor(border, 0.0);
		log.setRightAnchor(border, 0.0);
		log.setTopAnchor(border, 55.0);
		log.setLeftAnchor(border, 225.0);
		loginScene = new Scene(log, 450, 400);
		window.setResizable(false);

		regiConfirm = new Label();
		regiConfirm.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));


		Pane regisLayout = new Pane();
		username1.setLayoutX(20);
		username1.setLayoutY(15);
		usnText1.setLayoutX(165);
		usnText1.setLayoutY(10);
		password1.setLayoutX(20);
		password1.setLayoutY(45);
		pswText1.setLayoutX(165);
		pswText1.setLayoutY(40);
		firstName.setLayoutX(20);
		firstName.setLayoutY(75);
		fnameText.setLayoutX(165);
		fnameText.setLayoutY(70);
		lastName.setLayoutX(20);
		lastName.setLayoutY(105);
		lnameText.setLayoutX(165);
		lnameText.setLayoutY(100);
		email.setLayoutX(20);
		email.setLayoutY(135);
		emText.setLayoutX(165);
		emText.setLayoutY(130);
		address.setLayoutX(20);
		address.setLayoutY(165);
		addText.setLayoutX(165);
		addText.setLayoutY(160);
		zip.setLayoutX(20);
		zip.setLayoutY(195);
		zipText.setLayoutX(165);
		zipText.setLayoutY(190);
		state.setLayoutX(345);
		state.setLayoutY(195);
		stateText.setLayoutX(390);
		stateText.setLayoutY(190);
		ssn.setLayoutX(20);
		ssn.setLayoutY(225);
		ssnText.setLayoutX(165);
		ssnText.setLayoutY(220);
		securityQ.setLayoutX(20);
		securityQ.setLayoutY(255);
		sqText.setLayoutX(165);
		sqText.setLayoutY(250);
		securityA.setLayoutX(20);
		securityA.setLayoutY(285);
		saText.setLayoutX(165);
		saText.setLayoutY(280);
		bCreate.setLayoutX(195);
		bCreate.setLayoutY(320);
		bBack.setLayoutX(275);
		bBack.setLayoutY(320);
		regiConfirm.setLayoutX(190);
		regiConfirm.setLayoutY(370);

		regisLayout.setStyle("-fx-background-color: grey");

		regisLayout.getChildren().addAll(username1,usnText1,password1,pswText1,firstName,fnameText,lastName,
				lnameText,email,emText,address,addText,zip,zipText,state,stateText,ssn,ssnText,securityQ,
				sqText,securityA,saText,bCreate,bBack,regiConfirm);
		regiScene = new Scene(regisLayout, 500, 400);

		window.setScene(loginScene);
		window.show();

		//forgot panel

				id = new Label("Login ID: ");
				id.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				id.setStyle("-fx-text-fill: Black;");
				id.setLayoutX(15);
				id.setLayoutY(15);

				c1Id = new Label();
				c1Id.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				c1Id.setStyle("-fx-text-fill: Blue;");
				c1Id.setLayoutX(150);
				c1Id.setLayoutY(15);

				q = new Label("Security Question: ");
				q.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				q.setStyle("-fx-text-fill: Black;");
				q.setLayoutX(15);
				q.setLayoutY(65);

				c1Q = new Label();
				c1Q.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				c1Q.setStyle("-fx-text-fill: Blue;");
				c1Q.setLayoutX(150);
				c1Q.setLayoutY(65);

				a = new Label("Answer: ");
				a.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				a.setStyle("-fx-text-fill: Black;");
				a.setLayoutX(15);
				a.setLayoutY(115);

				answer = new TextField();
				answer.setPromptText("Answer to your security question");
				answer.setPrefSize(600,25);
				answer.setLayoutX(150);
				answer.setLayoutY(115);

				yourPsw = new Label("Your password is: ");
				yourPsw.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 14));
				yourPsw.setStyle("-fx-text-fill: Black;");
				yourPsw.setLayoutX(15);
				yourPsw.setLayoutY(200);

				retrievedPsw = new Label();
				retrievedPsw.setFont(Font.font(STYLESHEET_MODENA, FontWeight.NORMAL, 30));
				retrievedPsw.setStyle("-fx-text-fill: Red;");
				retrievedPsw.setLayoutX(15);
				retrievedPsw.setLayoutY(225);

				forgot = new Button("Forgot Password");
				forgot.setOnAction( e ->
						retrievedPsw.setText(retrievePsw(c1Id.getText(), c1Q.getText(), answer.getText())));
				forgot.setLayoutX(250);
				forgot.setLayoutY(175);

				btBack2 = new Button("Back");
				btBack2.setOnAction(e-> {
					window.setScene(loginScene);
				});
				btBack2.setLayoutX(375);
				btBack2.setLayoutY(175);

				Pane forgotLayout = new Pane();
				//forgotLayout.setBackground(bg2);
				forgotLayout.getChildren().addAll(id, c1Id, q, c1Q, a, answer, forgot, yourPsw, retrievedPsw, btBack2);
				forgotScene = new Scene(forgotLayout, 775, 300);

			}

public void login(String loginID, String psw) {

		Customer c1 = new Customer();

		c1.setUserName(loginID);
		c1.setPassword(psw);
		c1.setAction(Action.LOGIN);
		
		System.out.println("Customer: " + loginID + " " + psw);

		boolean loginSuccess = PopUP.confirmation(c1);
		
		if (loginSuccess) {

			System.out.println("Successful Login!");
			System.out.println(c1.toString());
			c1.setAction(Action.FIRST_NAME);
			c1.setId(1);
			c1.setFirstName(PopUP.find(c1));

			c1.setAction(Action.LAST_NAME);
			c1.setLastName(PopUP.find(c1));

			Stage stage = (Stage) bLogin.getScene().getWindow();

			stage.close();

			AccountPanel ap = new AccountPanel(c1);
			try {
				ap.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public void regiInput (String LoginID, String Password, String FirstName, String LastName, String Email, String Address, String ZipCode,
			   String State, String SocialSecurity, String SecurityQuestion, String SecurityAnswer) {

Random rand = new Random();
c1.setFirstName(FirstName);
c1.setLastName(LastName);
c1.setUserName(LoginID);
c1.setPassword(Password);
c1.setEmail(Email);
c1.setAddress(Address);
c1.setZip(ZipCode);
c1.setState(State);
c1.setSSN(SocialSecurity);
c1.setSecurityQ(SecurityQuestion);
c1.setSecurityA(SecurityAnswer);
c1.setAction(Action.REGISTER);

try {

BizLogicProcess.process1(c1);;

}

catch (Exception e) {

e.printStackTrace();

}

}
	public String retrieveQ(String loginID) {

		Customer c1 = new Customer();

		c1.setUserName(loginID);
		c1.setAction(Action.FIND_QUESTION);

		c1.setSecurityQ(PopUP.find(c1));

		return c1.getSecurityQ();

	}

	public String retrievePsw(String loginID, String securityQ, String securityA) {

		Customer c1 = new Customer();

		c1.setUserName(loginID);
		c1.setSecurityQ(securityQ);
		c1.setSecurityA(securityA);

		c1.setAction(Action.FIND_PASSWORD);

		c1.setPassword(PopUP.find(c1));

		return c1.getPassword();
	}




	}


	


