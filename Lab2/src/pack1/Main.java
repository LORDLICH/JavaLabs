package pack1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setResizable(true);
        primaryStage.setTitle("Complex Number Calculator");
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 520, 140);

        root.setGridLinesVisible(false);
        root.setPadding(new Insets(5, 5, 5, 5));
        for (int i = 0; i < 5; i++) {
            root.getColumnConstraints().add(new ColumnConstraints());
        }

        root.getColumnConstraints().get(0).setPercentWidth(20);
        root.getColumnConstraints().get(1).setPercentWidth(30);
        root.getColumnConstraints().get(2).setPercentWidth(10);
        root.getColumnConstraints().get(3).setPercentWidth(30);
        root.getColumnConstraints().get(4).setPercentWidth(10);

        root.add(new Label("Number 1: z = "), 0, 0);
        root.add(new Label("Number 2: z = "), 0, 1);
        root.add(new Label("Result:   z = "), 0, 3);
        root.add(new Label("  +"), 2, 0);
        root.add(new Label("  +"), 2, 1);
        root.add(new Label("  +"), 2, 3);
        root.add(new Label("  i"), 4, 0);
        root.add(new Label("  i"), 4, 1);
        root.add(new Label("  i"), 4, 3);

        Label realPartLabel = new Label("");
        root.add(realPartLabel, 1, 3);
        Label imaginaryPartLabel = new Label("");
        root.add(imaginaryPartLabel, 3, 3);

        TextField firstRealPart_t = new TextField();
        root.add(firstRealPart_t, 1, 0,1,1);

        TextField secondRealPart_t = new TextField();
        root.add(secondRealPart_t, 1, 1,1,1);

        TextField firstImaginaryPart_t = new TextField();
        root.add(firstImaginaryPart_t, 3, 0,1,1);

        TextField secondImaginaryPart_t = new TextField();
        root.add(secondImaginaryPart_t, 3, 1,1,1);

        Button additionButton = new Button("+");
        additionButton.setMaxWidth(Double.MAX_VALUE);
        additionButton.setMaxHeight(Double.MAX_VALUE);
        GridPane.setMargin(additionButton, new Insets(5));
        root.add(additionButton, 0, 2,2,1);

        Button subtractionButton = new Button("-");
        subtractionButton.setMaxWidth(Double.MAX_VALUE);
        subtractionButton.setMaxHeight(Double.MAX_VALUE);
        GridPane.setMargin(subtractionButton, new Insets(5));
        root.add(subtractionButton, 2, 2,3,1);

        ButtonHandler.additionButtonHandler(additionButton, realPartLabel,imaginaryPartLabel,
                firstRealPart_t,firstImaginaryPart_t, secondRealPart_t,secondImaginaryPart_t);
        ButtonHandler.subtractionButtonHandler(subtractionButton, realPartLabel, imaginaryPartLabel,
                firstRealPart_t,firstImaginaryPart_t,secondRealPart_t,secondImaginaryPart_t);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
