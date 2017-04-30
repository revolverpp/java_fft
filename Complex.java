package fft_impl;

public class Complex {

    double real, imag;

    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    static Complex polar(double m, double ang) {
        return new Complex(Math.cos(ang) * m, Math.sin(ang) * m);
    }

    public static Complex[] realToComplex(double[] reals) {
        Complex[] out = new Complex[reals.length];
        for (int i = 0; i < out.length; i++)
            out[i] = new Complex(reals[i], 0);
        return out;
    }

    Complex mult(Complex c1) {
        return new Complex(this.real * c1.real + this.imag * c1.imag * -1,
                            this.imag * c1.real + this.real * c1.imag);
    }

    Complex add(Complex c1) {
        return new Complex(this.real + c1.real, this.imag + c1.imag);
    }

    Complex sub(Complex c1) {
        return new Complex(this.real - c1.real, this.imag - c1.imag);
    }

    public double absValue() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

}
