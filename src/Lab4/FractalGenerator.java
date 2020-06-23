package Lab4;

import java.awt.geom.Rectangle2D;


/**
 * Этот класс предоставляет общий интерфейс и операции для
 * генераторов фракталов, которые можно просматривать в Fractal Explorer.
 */
public abstract class FractalGenerator {

    /**
     *  Эта статическкий вспомогательный метод принимает целочисленную координату и преобразует ее
     *  в значение двойной точности, соответствующее определенному диапазону. Он
     *  используется для преобразования координат пикселя в двойную точности значения для
     *  вычислений фрактал и т.д.
     *
     * @param rangeMin минимального значения диапазона с плавающей точкой
     * @param rangeMax максимального значения диапазона с плавающей точкой
     *
     * @param size размер измерения, из которого берется координата пикселя.
     *        Например, это может быть ширина изображения или высота изображения.
     *
     * @param coord координата координаты для вычисления значения двойной точности.
     *        Координата должна находиться в диапазоне [0, размер].
     */
    public static double getCoord(double rangeMin, double rangeMax,
                                  int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /**
     * Устанавливает указанный прямоугольник, чтобы содержать начальный диапазон, подходящий для
     * генерируемого фрактала.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
     * Обновляет текущий диапазон для центрирования по указанным координатам
     * и для увеличения или уменьшения с помощью указанного коэффициента масштабирования.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
                                     double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    /**
     * Учитывая координату x + iy в комплексной плоскости,
     * вычисляет и возвращает количество итераций, прежде чем
     * функция fractal покинет ограничивающую область для этой точки, точка, которая
     * не проходит до достижения предела итерации, указывается
     * с результатом -1.
     */
    public abstract int numIterations(double x, double y);
}