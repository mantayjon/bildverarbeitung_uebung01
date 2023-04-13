// BV Ue1 SS2023 Vorgabe
//
// Copyright (C) 2023 by Klaus Jung
// All rights reserved.
// Date: 2023-03-23
 		   	  	  		

package bv_ss23;

public class GaussFilter {
 		   	  	  		
	private double[][] kernel;
 		   	  	  		
	public double[][] getKernel() {
		return kernel;
	}

	public void apply(RasterImage src, RasterImage dst, int kernelSize, double sigma) {
 		   	  	  		
		// TODO: Implement a Gauss filter of size "kernelSize" x "kernelSize" with given "sigma"
		
		// Step 1: Allocate appropriate memory for the field variable "kernel" representing a 2D array.
		
		// Step 2: Fill in appropriate values into the "kernel" array.
		// Hint:
		// Use g(d) = e^(- d^2 / (2 * sigma^2)), where d is the distance of a coefficient's position to the hot spot.
		// Note that in this comment e^ denotes the exponential function and ^2 the square. In Java ^ is a different operator. 
		
		// Step 3: Normalize the "kernel" such that the sum of all its values is one.
		
		// Step 4: Apply the filter given by "kernel" to the source image "src". The result goes to image "dst".
		// Use "constant continuation" for boundary processing.
				
	}
		   		     	

}
 		   	  	  		




