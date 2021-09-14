import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import java.io.File;
import javafx.scene.paint.Color;
import java.text.ParseException;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.geometry.Pos; 
import javafx.scene.control.TextField; 
import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter; 
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;

public class Mandelbrot extends Application {
	private final static Logger logger = Logger.getLogger(Mandelbrot.class.getName());
	private Complex z = new Complex(0,0);
	private PixelWriter pixelWriter;
	private int xSize =1000, ySize=1000; 
	
	@Override
	public void start(Stage primaryStage){
		Parameters parameters = getParameters();
		setSize(parameters);
		System.out.println(parameters.getNamed());
		WritableImage writableImage = new WritableImage(xSize,ySize); 
		pixelWriter = writableImage.getPixelWriter();
		ImageView imageView = new ImageView();
		

		imageView.setImage(writableImage);

		Button julia = new Button("GraficarJulia");
		Button mandelbrot = new Button("Mandelbrot"); 
		TextField real = new TextField("-.599");
		TextField imaginary = new TextField("-0.411");
		Button saveImage = new Button("Guardar Imagen :)");

		GridPane grid = new GridPane();
		grid.add(mandelbrot,0,1);
		grid.add(real,0,2);	
		grid.add(imaginary,0,3);	
		grid.add(julia,0,4);
		grid.add(saveImage,0,5);
		
		mandelbrot.setOnAction(e -> {
			z = new Complex(0,0);
			reDraw(z,Color.WHITE);
		});

		julia.setOnAction(e ->{
			try{
				z.setReal(Double.parseDouble(real.getText().trim()));
				z.setImaginary(Double.parseDouble(imaginary.getText().trim()));
				reDraw(z,Color.RED);
			}catch(Exception f){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en los valores ingresados");
				alert.setContentText("El valor" + real.getText() +" "+imaginary.getText() + "i no es valido");
			}
		});
		

		saveImage.setOnAction(e -> {
			try{
				File outputfile = new File("Conjunto "+ real.getText()+"+" + imaginary.getText() + "i"+".png");
				BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
				ImageIO.write(bufferedImage, "png", outputfile);
			} catch (IOException ex){
				ex.getStackTrace();
			}
		});

		StackPane root = new StackPane();
 		root.getChildren().add(imageView);	
		StackPane.setAlignment(real, Pos.CENTER);
		root.getChildren().add(grid);
		imageView.fitWidthProperty().bind(root.widthProperty());
		imageView.fitHeightProperty().bind(root.heightProperty());
		

		primaryStage.setTitle("Visualizador de Mandebrot y Julia");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		reDraw(new Complex(0,0),Color.WHITE);
	}
	
	public void reDraw(Complex z, Color colour){
		ExecutorService exec = Executors.newFixedThreadPool(1);
		
		Complex minNormal= new Complex(-2,-2);
		Complex maxChange = new Complex(-2,2);
		MandelbrotSet fractal= new MandelbrotSet(minNormal,maxChange,z); 
		
		long startTime=System.currentTimeMillis();
		exec.submit(()->Platform.runLater(() -> Fractal.drawFractal(0,xSize-1,pixelWriter,fractal,xSize,ySize,colour)));
		long endTime=System.currentTimeMillis();
		exec.shutdown();
		logger.finer("done in "+ (endTime -startTime)+"ms");
	}

		
	
	private void setSize(Parameters params){
		if(params.getNamed().containsKey("width")){
			xSize = Integer.decode(params.getNamed().get("width"));
		}
		if(params.getNamed().containsKey("height")){
			ySize = Integer.decode(params.getNamed().get("height"));
		
		}

	}
}



