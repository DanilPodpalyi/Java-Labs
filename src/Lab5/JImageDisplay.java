package Lab5;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

class JImageDisplay extends JComponent { // JImageDisplay расширяет возможности JComponent
    private BufferedImage displayImage;  // Управляет изображением, содержимое которого можно записать
    public BufferedImage getImage() {
        return displayImage;
    }

    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Тип изображения TYPE_INT_RGB определяет, как цвета каждого пикселя будут представлены в изображении; значение TYPE_INT_RGB обозначает, что
        // красные, зеленые и синие компоненты имеют по 8 битов, представленные в формате int в указанном порядке
        Dimension imageDimension = new Dimension(width, height); //Отображение на экране изображения с заданными параметрами ширины и высоты
        super.setPreferredSize(imageDimension);
    }

    @Override //Переопределим метод
    public void paintComponent (Graphics g) { // Необходим для отрисовки компонентов
        super.paintComponent (g); // Необходим вызов метода суперкласса для того, чтобы объекты отображались правильно
        g.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);; // Передаем значение null для ImageObserver, поскольку данная функциональность не требуется
    }

    public void clearImage() { // Устанавливает все пиксели изображения в черный цвет (значение RGB 0)
        int[] blankArray = new int[getWidth() * getHeight()];
        displayImage.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }

    public void drawPixel (int x, int y, int rgbColor) { // Устанавливает пиксель в определенный цвет
        displayImage.setRGB(x, y, rgbColor);
    }
}