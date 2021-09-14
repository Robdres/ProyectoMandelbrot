import javafx.scene.paint.Color;

public class MandelbrotSet{
	public double rMAX,rMIN,iMAX,iMIN;
	private Complex z;
	private int convergenceSteps =300;
	Color convergenceColor = Color.RED;

	public MandelbrotSet(Complex min, Complex max, Complex z){
		this.rMIN = min.getReal(); 
		this.rMAX = max.getReal(); 
		this.iMIN = min.getImaginary(); 
		this.iMAX = max.getImaginary(); 
		this.z=z;
	}

	public int getCS(){ 
		return convergenceSteps;
	}

	public double getImaginary(){
		return z.getImaginary();
	}

	public double getReal(){
		return z.getReal();
	}

	public boolean isMandelbrot(){
		return z.getReal()==0 && z.getImaginary()==0;
	}

	public Color getColor(){
		return convergenceColor;
	}

}
