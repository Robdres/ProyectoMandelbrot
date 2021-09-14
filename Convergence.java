import java.lang.Math;
public class Convergence{

	public static int calculateConvergence(Complex constante, Complex iterable, int iterations){
		int i=0;
		while(i<iterations){
			iterable=iterable.square(); // square, cube,exponente
			iterable=iterable.addComplex(constante);
			if(iterable.module()>2){
				break;
			}
			i++;
		}
		return i;
	}


//	public static void main(String[] args){
//		System.out.println(calculateConvergence(new Complex(0.01,0.01),new Complex(0,0),100));
//	}
}
