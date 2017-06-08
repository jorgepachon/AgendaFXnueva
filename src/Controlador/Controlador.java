package Controlador;

import java.io.IOException;

import Modelo.DatosPersona;
import Modelo.Persona;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vista.PersonaController;

public class Controlador {

	private Stage primaryStage;
	private AnchorPane rootLayout;

	private DatosPersona personData;
	private Persona persona;


	public void AbrirVentanaPrincipal(Stage primaryStage){
		try {
			this.primaryStage = primaryStage;

			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../vista/AgendaUI.fxml"));
            rootLayout = (AnchorPane) loader.load();

         // Give the controller access to the main app.
            PersonaController vistacontroller = loader.getController();
            vistacontroller.setControlador(this);
            vistacontroller.setDatos(personData);
            this.primaryStage.getIcons().add(new Image("file:resources/images/cajones.png"));
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Agenda");
            primaryStage.show();

           } catch(Exception e) {
			e.printStackTrace();
		}

	}



    public void NewPerson(){
    	Persona persona = new Persona(null, null, null);
    	
    	this.personData.addPerson(persona);
    		

    }
    

	public void setpersonData(DatosPersona personData) {
		// TODO Auto-generated method stub
		this.personData = personData;

	}
}
