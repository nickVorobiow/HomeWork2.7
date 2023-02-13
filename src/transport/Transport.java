package transport;
import com.company.Driver;
import com.company.Mechanic;
import java.util.List;

public abstract class Transport<T extends Driver> implements Participant {
    private final String brand;
    private final String model;
    private String engineVolume;
    private T driver;
    private List<Mechanic> mechanicList;
    private boolean diagnosticsFlag = false;

    public Transport(String brand, String model, String engineVolume, T driver, List<Mechanic> mechanicList) {
        if(brand == null) {this.brand = "set brand";}
        else {this.brand = brand;}
        if(model == null) {this.model = "set model";}
        else {this.model = model;}
        if (Double.parseDouble(engineVolume) <= 0) {this.engineVolume = "default";}
        else {this.engineVolume = engineVolume;}
        this.driver = driver;
        this.mechanicList = mechanicList;
    }

    public T getDriver() {
        return driver;
    }
    public void setDriver(T driver) {
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngineVolume() {return engineVolume;}
    public void setEngineVolume(String engineVolume) {
        if (Double.parseDouble(engineVolume) <= 0) {this.engineVolume = "default";}
        else {this.engineVolume = engineVolume;}
    }

    public boolean getDiagnosticsFlag() {
        return diagnosticsFlag;
    }
    public void setDiagnosticsFlag(boolean diagnosticsFlag) {
        this.diagnosticsFlag = diagnosticsFlag;
    }

    public abstract void startMove();
    public abstract void stopMove();
    public abstract void printType();
    public abstract Type getType();
    public abstract boolean passDiagnostics() throws TransportTypeException;

    @Override
    public String toString() {
        return
                "brand:'" + brand + '\'' +
                ", model:'" + model + '\'' +
                ", engineVolume:'" + engineVolume + '\'' +
                ", driver name:'" + driver.getFullName() + '\'' +
                ", mechanics:'" + mechanicList + '\'';
    }
}

