package fft_impl;

public class rad2 {

    public static Complex[] fft(Complex[] data) {
        int N = data.length;

        if (N == 1)
            return data;

        Complex[] even = new Complex[N / 2];
        Complex[] odd = new Complex[N / 2];

        for (int i = 0; i < N / 2; i++) {
            even[i] = data[2 * i];
            odd[i] = data[2 * i + 1];
        }

        even = fft(even);
        odd = fft(odd);

        Complex[] bins = new Complex[N];

        for (int k = 0; k < N / 2; k++) {
            Complex c_exp = Complex.polar(1.0, -2 * Math.PI * k / N);
            c_exp = c_exp.mult(odd[k]);

            bins[k] = even[k].add(c_exp);
            bins[k + N / 2] = even[k].sub(c_exp);
        }

        return bins;
    }
    
}
