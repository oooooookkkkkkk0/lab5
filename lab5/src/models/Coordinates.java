package models;

public class Coordinates {
        private Float x; //Максимальное значение поля: 839, Поле не может быть null
        private double y;
    // создаем объект класса координат
        public Coordinates (Float x, double y) {
            this.x = x;
            this.y = y;
        }
        public Float getX() {
            return x;
        }
        public double getY() {
            return y;
        }
    }