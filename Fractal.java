import javafx.scene.paint.Color; 
import javafx.scene.image.PixelWriter;

public class Fractal{
	public static void drawFractal(int inicio, int fin,PixelWriter points, MandelbrotSet fractal, int xSize, int ySize, Color colour){
		double convergenceSteps;
		double precision = Math.max((fractal.rMAX-fractal.rMIN)/xSize,(fractal.iMAX-fractal.iMIN)/ySize);
		for(double x = fractal.rMIN +(precision*inicio), r = inicio; r<=fin; x+=precision,r++){
			for(double y = fractal.iMIN, i = 0; i<ySize; y += precision, i++){
				if(fractal.isMandelbrot()){
					convergenceSteps = Convergence.calculateConvergence(new Complex(x,y),new Complex(fractal.getReal(),fractal.getImaginary()),fractal.getCS());
				}else{ 
					convergenceSteps = Convergence.calculateConvergence(new Complex(fractal.getImaginary(),fractal.getReal()),new Complex(y,x),fractal.getCS());
				}

				double t = convergenceSteps/fractal.getCS();
				double gamma = 1 - (t-1)*(t-1)*(t-1)*(t-1);

				if (convergenceSteps<100){
					points.setColor((int)r,(int)i, Color.color(gamma,gamma*0.6,gamma));
				}else{
					points.setColor((int)r,(int)i, colour);

				}

			}
		}
	}
}
