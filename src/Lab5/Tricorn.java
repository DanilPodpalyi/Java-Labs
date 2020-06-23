package Lab5;

import java.awt.geom.Rectangle2D;

// Этот класс отвечает за фрактал Tricorn

public class Tricorn extends FractalGenerator {
    public void getInitialRange(Rectangle2D.Double range) { // Double класс определяет диапазон (range) прямоугольника в координатах х и у
        range.x=-2; //x для Tricorn
        range.y=-2; //y для Tricorn
        range.width=4; // Ширина для Tricorn
        range.height=4; // Высота для Tricorn
    }

    public static final int MAX_ITERATIONS = 2000; //Константа с максимальным количеством итераций

    public int numIterations(double x, double y) { // Реализует итеративную функцию для фрактала Tricorn (рассчитывает количество итераций для соответсвующей координаты
        int iteration = 0;
        double complex_real = 0;
        double complex_imaginary = 0;

        // Вычисления повторяются до тех пор, пока |z| > 2 (в данной ситуации точка находится не во множестве Tricorn), или пока
        // число итераций не достигнет максимального значения, например, 2000 (в этом случае делается предположение, что точка находится в наборе).
        // Модуль комплексного числа в квадрате: |z|^2=x^2+y^2

        while ((iteration < MAX_ITERATIONS) && (complex_real * complex_real + complex_imaginary * complex_imaginary) < 4) {
            // Фрактал (последовательность) Tricorn Z0=0, Z1=(Z0)^2+c, Z2=(Z1)^2+c, ...
            // c - определенная точка фрактала, которую мы отображаем на экране, с=x+iy
            // Если переформулировать эти выражения в виде итеративной последовательности значений координат комплексной плоскости (x,y),
            // то есть заменив Zn = Xn+iYn, a c=X0+iY0, то мы получим:
            // X(n+1)=(Xn)^2-(Yn)^2+X0
            // Y(n+1)=-2*Xn*Yn+Y0
            // Единственное отличие Tricorn от Мандельброта только в том, что используется комплексное сопряжение z(n-1) на каждой итерации, поэтому у двойки знак -
            double complex_realUpdated = complex_real * complex_real - complex_imaginary * complex_imaginary + x;
            double complex_imaginaryUpdated = -2 * complex_real * complex_imaginary + y;
            complex_real = complex_realUpdated;
            complex_imaginary = complex_imaginaryUpdated;
            iteration += 1; // После обновления координат x и y, итерация +1
        }
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        return iteration;
    }
    // Возврат имени фрактала, для того, чтобы Сombo-boxe мог управлять коллекцией объектов в Swing
    public String toString() {
        return "Tricorn";
    }
}