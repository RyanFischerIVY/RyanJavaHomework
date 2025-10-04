import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class ProgAssignmentM6A1 extends Application {
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    private Connection conn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Connect to DB (use your own connection details)
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.addRow(0, new Label("ID:"), tfId);
        grid.addRow(1, new Label("Last Name:"), tfLastName);
        grid.addRow(2, new Label("First Name:"), tfFirstName);
        grid.addRow(3, new Label("MI:"), tfMi);
        grid.addRow(4, new Label("Address:"), tfAddress);
        grid.addRow(5, new Label("City:"), tfCity);
        grid.addRow(6, new Label("State:"), tfState);
        grid.addRow(7, new Label("Telephone:"), tfTelephone);
        grid.addRow(8, new Label("Email:"), tfEmail);

        HBox buttons = new HBox(10);
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        buttons.getChildren().addAll(btView, btInsert, btUpdate);
        grid.add(buttons, 1, 9);

        // Handlers
        btView.setOnAction(e -> viewStaff());
        btInsert.setOnAction(e -> insertStaff());
        btUpdate.setOnAction(e -> updateStaff());

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff DB App");
        primaryStage.show();
    }

    private void viewStaff() {
        String sql = "SELECT * FROM staff WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tfId.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tfLastName.setText(rs.getString("lastName"));
                tfFirstName.setText(rs.getString("firstName"));
                tfMi.setText(rs.getString("mi"));
                tfAddress.setText(rs.getString("address"));
                tfCity.setText(rs.getString("city"));
                tfState.setText(rs.getString("state"));
                tfTelephone.setText(rs.getString("telephone"));
                tfEmail.setText(rs.getString("email"));
            } else {
                showAlert("No staff found for ID: " + tfId.getText());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertStaff() {
        String sql = "INSERT INTO staff (id,lastName,firstName,mi,address,city,state,telephone,email) VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tfId.getText());
            ps.setString(2, tfLastName.getText());
            ps.setString(3, tfFirstName.getText());
            ps.setString(4, tfMi.getText());
            ps.setString(5, tfAddress.getText());
            ps.setString(6, tfCity.getText());
            ps.setString(7, tfState.getText());
            ps.setString(8, tfTelephone.getText());
            ps.setString(9, tfEmail.getText());
            ps.executeUpdate();
            showAlert("Inserted successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateStaff() {
        String sql = "UPDATE staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tfLastName.getText());
            ps.setString(2, tfFirstName.getText());
            ps.setString(3, tfMi.getText());
            ps.setString(4, tfAddress.getText());
            ps.setString(5, tfCity.getText());
            ps.setString(6, tfState.getText());
            ps.setString(7, tfTelephone.getText());
            ps.setString(8, tfEmail.getText());
            ps.setString(9, tfId.getText());
            int rows = ps.executeUpdate();
            if (rows > 0) showAlert("Update successful.");
            else showAlert("No staff found for ID: " + tfId.getText());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
