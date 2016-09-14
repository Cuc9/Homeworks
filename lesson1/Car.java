package lesson1;

/**
 * Created by arpi on 31.01.2016.
 */
public class Car {
    private boolean engineStatus; // false
    private double speed; // 0.0
    public String regNumber;
    int year;

    public void setEngineStatus (boolean status){
        if (!status) {
            this.speed = 0;
        }
        this.engineStatus = status;
    }

    public boolean getEngineStatus () {
        return this.engineStatus;
    }

    public double getSpeed () {
        return this.speed;
    }

    /*метод приведения авто в движение с поддержанием заданной скорости
    если двигатель выключен - авто заводится и едет
    если скорость отрицательная - едем задним ходом*/
    public void move (double speed) {
        this.engineStatus = true;
        this.speed = speed;
    }

    public static void carStatus (Car aCar) {
        if (aCar != null) {
            if (aCar.getEngineStatus()) {
                System.out.print("Двигатель заведен, ");
                if (aCar.getSpeed() > 0) {
                    System.out.println("автомобиль едет вперед со скоростью " + aCar.getSpeed() + " км/ч.");
                } else if (aCar.getSpeed() < 0) {
                    System.out.println("автомобиль едет назад со скоростью " + aCar.getSpeed()*(-1) + " км/ч.");
                } else {
                    System.out.println("авто стоит.");
                }
            } else {
                System.out.print("Двигатель выключен, ");
                if (aCar.getSpeed() != 0) {
                    System.out.println("автомобиль катится ))))");
                } else {
                    System.out.println("авто стоит.");
                }
            }
        } else {
            System.out.println("Нет такого авто");
        }
    }

    private class Driver {
        private String name;
        private int drivingStage;

        public void setName(String name) {
            this.name = name;
        }

        public void setDrivingStage(int drivingStage) {
            this.drivingStage = drivingStage;
        }

        public String getName() {
            return name;
        }

        public int getDrivingStage() {
            return drivingStage;
        }
    }

    public static void main(String[] args) {
        Car car2 = new Car();
        Car car3 = null;

        carStatus(car2);
        car2.setEngineStatus(true);
        car2.move(50);
        carStatus(car2);
        car2.setEngineStatus(false);
        car2.move(-25.5);
        carStatus(car2);
        car2.setEngineStatus(false);
        carStatus(car2);
        // 2й способ завести автомобиль
        car2.move(0);
        carStatus(car2);

        carStatus(car3);
    }
}
