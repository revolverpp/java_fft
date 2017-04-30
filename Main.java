import fft_impl.Complex;
import fft_impl.rad2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/home/ubuntu/Desktop/sine.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        ArrayList<Double> arr = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.isEmpty())
                continue;
            arr.add(Integer.parseInt(line) / 32768.0);
        }

        double[] data = new double[32768];
        for (int i = 0; i < 32768; i++)
            data[i] = arr.get(i);

        Complex[] bins = rad2.fft(Complex.realToComplex(data));
        System.out.print("[");
        for (Complex c : bins)
            System.out.print(c.absValue() + ", ");
        System.out.println("]");

        rad2.a();
    }
}
