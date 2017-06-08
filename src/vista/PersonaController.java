package vista;

import Controlador.Controlador;
import Modelo.DatosPersona;
import Modelo.Persona;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;


public class PersonaController {

	@FXML
	private TableView<Persona> Tabla;

	@FXML
	private TableColumn<Persona,String> ColName;

	@FXML
	private TableColumn<Persona,String> ColApellido;

	@FXML
	private TableColumn<Persona,String> ColEdad;

	@FXML
	private Button Nuevo;
	
	@FXML
	private Button Borrar;

	@FXML
    private TextField NombreField;
    @FXML
    private TextField ApellidoField;
    @FXML
    private TextField EdadField;


	// Reference to the Controlador.
    private Controlador controlador;
    private Persona persona;
    private boolean okClicked = false;

    // Reference to the data
    private DatosPersona personData;

    @FXML
    private void initialize() {
    }
    
    
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = Tabla.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	this.personData.getPersonData().remove(selectedIndex);
        	Tabla.setItems( this.personData.getPersonData());

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.WARNING);
        	ShowAlertNoSelectionPerson(alert);
        }
    }

    
        
    public void setPerson(Persona persona) {
        this.persona = persona;

        NombreField.setText(persona.getNombre());
        ApellidoField.setText(persona.getApellido());
        EdadField.setText(persona.getEdad());
    }

    private void ShowAlertNoSelectionPerson(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Persona no seleccionada");
        alert.setContentText("Por favor!!! Seleccione una persona de la tabla");

        alert.showAndWait();
    }
    
    public boolean isOkClicked() {
    	return okClicked;
    }
    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
    		persona = new Persona(null, null, null); //crear objeto persona y pasar por parametro los datos
           
    		persona.setNombre(NombreField.getText());
            persona.setApellido(ApellidoField.getText());
            persona.setEdad(EdadField.getText());
            
            //aqui añadimos la persona
            this.personData.addPerson(persona);   
            Tabla.setItems(this.personData.getPersonData());
            
            okClicked = true;
            
        }
    }

	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		this.controlador = controlador;
	}

	public void setDatos(DatosPersona personData2) {
		this.personData = personData2;
		// TODO Auto-generated method stub
		Tabla.setItems(this.personData.getPersonData());
        ColName.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
		ColApellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));
		ColEdad.setCellValueFactory(new PropertyValueFactory<Persona,String>("edad"));


	}
	
	        
        private boolean isInputValid() {
            String errorMessage = "";

            if (NombreField.getText() == null || NombreField.getText().length() == 0) {
                errorMessage += "Nombre no válido!\n";
            }
            if (ApellidoField.getText() == null || ApellidoField.getText().length() == 0) {
                errorMessage += "Apellido no válido!\n";
            }
            if (EdadField.getText() == null || EdadField.getText().length() == 0) {
                errorMessage += "Edad no válida!\n";
            }else {
                // try to parse the postal code into an int.
                try {
                    Integer.parseInt(EdadField.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Teléfono no válido!\n";
                }
            }
            if (errorMessage.length() == 0) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Campos incorrectos!!");
                alert.setContentText("Por favor, corrija campos incorrectos");

                alert.showAndWait();
                return false;
            }
        }

}
