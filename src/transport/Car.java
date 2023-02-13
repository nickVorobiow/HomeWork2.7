package transport;

import com.company.CarDriver;
import com.company.Mechanic;
import java.util.List;

public class Car extends Transport<CarDriver> implements Participant{
    private BodyType bodyType;

    public Car(String brand, String model, String engineVolume, CarDriver driver, BodyType bodyType, List<Mechanic> mechanicList) {
        super(brand, model, engineVolume, driver, mechanicList);
        this.bodyType = bodyType;
    }

    @Override
    public void startMove() {System.out.println("Car starts moving...");}
    @Override
    public void stopMove() {System.out.println("Car stops moving...");}
    @Override
    public void pit_stop() {System.out.println("Машина ушла на пит-стоп");}
    @Override
    public void bestTime() {
        System.out.println("Лучшее время машины:__:__");
    }
    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость машины:___");
    }

    @Override
    public Type getType() {
        return Type.valueOf("CAR");
    }

    @Override
    public boolean passDiagnostics() {
        if (getDiagnosticsFlag()) {
            return true;
        } else {
            setDiagnosticsFlag(true);
            return false;
        }
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println("Тип машины:" + bodyType.getNameInRussian());
        }
        else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                '}';
    }

    public class Key {
        private final boolean distantEnginePower;
        private final boolean withoutKeyAccess;

        public Key(boolean distantEnginePower, boolean withoutKeyAccess) {
            if (new Boolean(distantEnginePower) ==  null) {this.distantEnginePower = false;}
            else {this.distantEnginePower = distantEnginePower;}

            if (new Boolean(withoutKeyAccess) == null) {this.withoutKeyAccess = false;}
            else {this.withoutKeyAccess = withoutKeyAccess;}
        }

        @Override
        public String toString() {
            return "distantEnginePower=" + distantEnginePower +
                    ", withoutKeyAccess=" + withoutKeyAccess;
        }
    }

    public enum BodyType {
        SEDAN("седан"),
        HATCHBACK("хэтчбэк"),
        COUPE("купэ"),
        UNIVERSAL("универсал"),
        OFFROAD("внедорожник"),
        SUV("кроссовер"),
        PICKUP("пикап"),
        VAN("фургон"),
        MINIVAN("минивэн");

        private String nameInRussian;

        BodyType(String nameInRussian) {
            this.nameInRussian = nameInRussian;
        }

        public String getNameInRussian() {
            return nameInRussian;
        }

        @Override
        public String toString() {
            return "Тип кузова: " + nameInRussian;
        }
    }
}
