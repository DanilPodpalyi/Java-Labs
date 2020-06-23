package Lab5;

import java.awt.geom.Rectangle2D;

// Этот класс отвечает за фрактал BurningShip

public class BurningShip extends FractalGenerator {

    public void getInitialRange(Rectangle2D.Double range) { // Double класс определяет диапазон (range) прямоугольника в координатах х и у
        range.x=-2; //x для BurningShip
        range.y=-2.5; //y для BurningShip
        range.width=4; // Ширина для BurningShip
        range.height=4; // Высота для BurningShip
    }

    public static final int MAX_ITERATIONS = 2000; //Константа с максимальным количеством итераций

    public int numIterations(double x, double y) { // Реализует итеративную функцию для фрактала BurningShip (рассчитывает количество итераций для соответсвующей координаты
        int iteration = 0;
        double complex_real = 0;
        double complex_imaginary = 0;

        // Вычисления повторяются до тех пор, пока |z| > 2 (в данной ситуации точка находится не во множестве BurningShip), или пока
        // число итераций не достигнет максимального значения, например, 2000 (в этом случае делается предположение, что точка находится в наборе).
        // Модуль комплексного числа в квадрате: |z|^2=x^2+y^2

        while ((iteration < MAX_ITERATIONS) && (complex_real * complex_real + complex_imaginary * complex_imaginary) < 4) {
            // Фрактал (последовательность) BurningShip: Z0=0, Z(n+1)=(|Re(Zn)|+i|Im(Zn)|)^2+c
            // c - определенная точка фрактала, которую мы отображаем на экране, с=x+iy
            // Если переформулировать эти выражения в виде итеративной последовательности значений координат комплексной плоскости (x,y),
            // то есть заменив Zn = Xn+iYn, a c=X0+iY0, то мы получим:
            // X(n+1)=abs((Xn)^2-(Yn)^2+X0)
            // Y(n+1)=abs(2*Xn*Yn+Y0)
            double complex_realUpdated = Math.abs(complex_real * complex_real - complex_imaginary * complex_imaginary + x); // Для модуля воспользуемся Math
            double complex_imaginaryUpdated = Math.abs(2 * complex_real * complex_imaginary + y);
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
        return "Burning Ship";
    }
}