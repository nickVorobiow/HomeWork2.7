package transport;
import com.company.CargoDriver;
import com.company.Mechanic;
import java.util.List;

public class Cargo extends Transport<CargoDriver> implements Participant {
    private Tonnage tonnage;

    public Cargo(String brand, String model, String engineVolume,
                 CargoDriver driver, Tonnage tonnage, List<Mechanic> mechanicList) {
        super(brand, model, engineVolume, driver, mechanicList);
        this.tonnage = tonnage;
    }

    @Override
    public void startMove() {
        System.out.println("Cargo car starts moving...");
    }
    @Override
    public void stopMove() {
        System.out.println("Cargo car stops moving...");
    }
    @Override
    public void pit_stop() {
        System.out.println("Грузовая машина ушла на пит-стоп");
    }
    @Override
    public void bestTime() {
        System.out.println("Лучшее время грузовой машины:__:__");
    }
    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость грузовой машины:___");
    }
    @Override
    public Type getType() {
        return Type.valueOf("CARGO");
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
        if (tonnage != null) {
            System.out.println("Грузовой автомобиль с грузоподъемностью:\n\t" + tonnage);
        }
        else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public String toString() {
        return "Cargo{" +
                super.toString() +
                '}';
    }

    public enum Tonnage {
        N1(null, 3.5f),
        N2(3.5f, 12.0f),
        N3(12.0f, null);

        private Float lower_bound;
        private Float upper_bound;

        Tonnage(Float lower_bound, Float upper_bound) {
            this.lower_bound = lower_bound;
            this.upper_bound = upper_bound;
        }

        @Override
        public String toString() {
            if (lower_bound == null) {
                return "Грузоподъемность до " +
                        upper_bound + " тонн";
            } else if (upper_bound == null) {
                return "Грузоподъемность от " +
                        lower_bound + " тонн";
            } else {
                return "Грузоподъемность от " +
                        lower_bound + " до " + upper_bound + " тонн";
            }
        }
    }
}
