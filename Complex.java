import java.lang.Math;
public class Complex{
	private double real;
	private double imaginary;

	Complex(double real, double imaginary){
		this.real=real;
		this.imaginary=imaginary;
	}

	public void setReal(double real){
		this.real=real;
	}

	public void setImaginary(double imaginary){
		this.imaginary=imaginary;
	}

	public double getReal(){
		return this.real;
	}

	public double getImaginary(){
		return this.imaginary;
	}

	public Complex square(){ 
		return new Complex(this.real*this.real-this.imaginary*this.imaginary, 2*this.real*this.imaginary);
	}
		
	public Complex cube(){
		return new Complex(this.real*this.real*this.real-3*this.real*this.imaginary*this.imaginary,3*this.real*this.real*this.imaginary-this.imaginary*this.imaginary*this.imaginary);
	}

	public Complex addComplex(Complex c){
		return new Complex(this.real+c.getReal(),this.imaginary+c.getImaginary());
	}

	public double module(){
		return Math.sqrt(this.real*this.real +this.imaginary*this.imaginary);
	}

	public boolean equal(Complex b){
		return this.real == b.getReal() && this.imaginary==b.getImaginary();
	}
	
	public Complex exponente(){
		return new Complex(Math.exp(this.real)*Math.cos(this.imaginary),Math.exp(this.real)*Math.sin(this.imaginary));
	}


}
