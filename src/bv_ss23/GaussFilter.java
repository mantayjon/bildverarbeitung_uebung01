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
        double sum = 0;
        kernel = new double[kernelSize][kernelSize];

        for (int y = 0; y < kernelSize; y++) {
            for (int x = 0; x < kernelSize; x++) {
                double d = Math.sqrt(Math.pow(kernelSize / 2 - x, 2) + Math.pow(kernelSize / 2 - y, 2));
                kernel[y][x] = Math.exp((-Math.pow(d, 2)) / (2 * Math.pow(sigma, 2)));
                sum += kernel[y][x];
            }
        }
        for (int y = 0; y < kernelSize; y++) {
            for (int x = 0; x < kernelSize; x++) {
                kernel[y][x] = kernel[y][x] / sum;
            }
        }
        for(int x=0; x<src.width; x++) {
            for(int y=0; y<src.height; y++) {
                int pos = y * src.width + x;
                double sumGray = 0;

                for(int k=0; k<kernelSize; k++) {
                    for(int l=0; l<kernelSize; l++) {
                        // Konstant fortsetzen
                        int xFilter = x+k-kernelSize/2;
                        if(xFilter<0) xFilter = 0;
                        else if(xFilter>src.width-1) xFilter = src.width - 1;
                        int yFilter = y+l-kernelSize/2;
                        if(yFilter<0) yFilter = 0;
                        else if(yFilter>src.height-1) yFilter = src.height - 1;

                        int posFilter = yFilter * src.width + xFilter;
                        int gray = (src.argb[posFilter] & 0x0000ff);
                        sumGray += gray * kernel[k][l];
                    }
                }
                dst.argb[pos] = 0xFF000000 + (((int)sumGray & 0xff) << 16) + (((int)sumGray & 0xff) << 8) + ((int)sumGray & 0xff);
            }
        }


    }
}





