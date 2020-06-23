package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int DisplaySize;
    private JImageDisplay Display;
    private FractalGenerator Fractal;
    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        // Здесь будет храниться значение размера отображения
        DisplaySize = size;

        // Инициализация объектов диапазона и фрактального генератора
        Fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        Fractal.getInitialRange(range);
        Display = new JImageDisplay(DisplaySize, DisplaySize); // x, y
    }

    public void createAndShowGUI() {
        Display.setLayout(new BorderLayout());
        JFrame JimageDisplay = new JFrame("Fractal Explorer");
        // Добавим объект отображения изображения в позицию CENTER
        JimageDisplay.add(Display, BorderLayout.CENTER);
        // Кнопка для сброса отображения
        JButton resetButton = new JButton("Reset Display");
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);
        // Кнопка сброса в положении SOUTH
        JimageDisplay.add(resetButton, BorderLayout.SOUTH);

        MouseHandler click = new MouseHandler();
        Display.addMouseListener(click);

        // Операция закрытия окна по умолчанию:
        JimageDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Данные операции правильно разметят содержимое окна, сделают его
        // видимым (окна первоначально не отображаются при их создании для того,
        // чтобы можно было сконфигурировать их прежде, чем выводить на экран), и
        // затем запретят изменение размеров окна.
        JimageDisplay.pack();
        JimageDisplay.setVisible(true);
        JimageDisplay.setResizable(false);
    }

    private void drawFractal() { // Метод для вывода на экран фрактала, должен циклически проходить через каждый пиксель в отображении (т.е. значения x и y будут меняться от 0 до размера отображения)
        for (int x = 0; x < DisplaySize; x++) {
            for (int y = 0; y < DisplaySize; y++) { //x, y - пиксельная координата; xCoord, yCoord - координата в пространстве фрактала
                // Получим координаты x и у, соответствующих координатам пикселя X и У
                double xCoord = Fractal.getCoord(range.x, range.x + range.width, DisplaySize, x);
                double yCoord = Fractal.getCoord(range.y, range.y + range.height, DisplaySize, y);
                // Вычислим количество итераций для соответствующих координат в области отображения фрактала
                int iteration = Fractal.numIterations(xCoord, yCoord);

                if (iteration == -1) { // Если число итераций равно -1 (т.е. точка не выходит за границы),установим пиксель в черный цвет (для rgb значение 0).
                    Display.drawPixel(x, y, 0);
                }
                else { // Иначе выберем значение цвета, основанное на количестве итераций
                    // Воспользуемся цветовым пространством HSV: поскольку значение цвета
                    // варьируется от 0 до 1, получается плавная последовательность цветов от
                    // красного к желтому, зеленому, синему, фиолетовому и затем обратно к красному
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    // Обновим отображение в соответствии с цветом для каждого пикселя
                    Display.drawPixel(x, y, rgbColor);
                }
            }

        }
        Display.repaint(); // Обновим JimageDisplay в соответствии с текущим изображением
    }

    // Внутренний класс для обработки событий от кнопки сброса. Обработчик сбрасывает
    // диапазон к начальному, определенному генератором, а затем перерисовает фрактал
    private class ResetHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            Fractal.getInitialRange(range);
            drawFractal();
        }
    }

    // Внутренний класс для обработки событий с дисплея от мыши
    private class MouseHandler extends MouseAdapter {

        @Override // Переопределим метод
        // При получении события о щелчке мышью, класс должен
        // отобразить пиксельные кооринаты щелчка в область фрактала, а затем вызвать
        // метод генератора recenterAndZoomRange с координатами, по которым щелкнули, и масштабом 0.5, что приведёт к увеличению фрактала
        public void mouseClicked(MouseEvent e) {
            // Получение координаты х области щелчка мыши
            int x = e.getX();
            double xCoord = Fractal.getCoord(range.x, range.x + range.width, DisplaySize, x);
            // Получение координаты у области щелчка мыши
            int y = e.getY();
            double yCoord = Fractal.getCoord(range.y, range.y + range.height, DisplaySize, y);
            // Увеличение фрактала
            Fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            // Перерисуем фрактал
            drawFractal();
        }
    }
    public static void main(String[] args)
    {
        FractalExplorer DisplayExplorer = new FractalExplorer(800);
        DisplayExplorer.createAndShowGUI();
        DisplayExplorer.drawFractal();
    }
}
