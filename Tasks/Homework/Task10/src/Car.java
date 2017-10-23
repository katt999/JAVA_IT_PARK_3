/**
 * Created by EVZabinskaya on 23.10.2017.
 */
public class Car {
    private String name;
    private String motorType;
    private int engineCapacity; // Объем двигателя
    private int power;
    private int numberOfCylinders;
    private double  maximumSpeed;
    private int volumeOfFuelTank;
    private int wheelRadius;
    private boolean presenceOfDisks;
    private int airbags;
    private String transmission;
    private int doors;
    private int numberOfTransfers;
    private String bodyType;

    private Car(Builder builder) {
        this.name = builder.name;
        this.motorType = builder.motorType;
        this.engineCapacity = builder.engineCapacity;
        this.power = builder.power;
        this.numberOfCylinders = builder.numberOfCylinders;
        this.maximumSpeed = builder.maximumSpeed;
        this.volumeOfFuelTank = builder.volumeOfFuelTank;
        this.wheelRadius = builder.wheelRadius;
        this.presenceOfDisks = builder.presenceOfDisks;
        this.airbags = builder.airbags;
        this.transmission = builder.transmission;
        this.doors = builder.doors;
        this.numberOfTransfers = builder.numberOfTransfers;
        this.bodyType = builder.bodyType;
    }

    public static class Builder {
        private String name;
        private String motorType;
        private int engineCapacity;
        private int power;
        private int numberOfCylinders;
        private double  maximumSpeed;
        private int volumeOfFuelTank;
        private int wheelRadius;
        private boolean presenceOfDisks;
        private int airbags;
        private String transmission;
        private int doors;
        private int numberOfTransfers;
        private String bodyType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder motorType(String motorType) {
            this.motorType = motorType;
            return this;
        }

        public Builder engineCapacity(int engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder numberOfCylinders(int numberOfCylinders) {
            this.numberOfCylinders = numberOfCylinders;
            return this;
        }

        public Builder maximumSpeed(double maximumSpeed) {
            this.maximumSpeed = maximumSpeed;
            return this;
        }

        public Builder volumeOfFuelTank(int volumeOfFuelTank) {
            this.volumeOfFuelTank = volumeOfFuelTank;
            return this;
        }

        public Builder wheelRadius(int wheelRadius) {
            this.wheelRadius = wheelRadius;
            return this;
        }

        public Builder presenceOfDisks(boolean presenceOfDisks) {
            this.presenceOfDisks = presenceOfDisks;
            return this;
        }

        public Builder airbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder numberOfTransfers(int numberOfTransfers) {
            this.numberOfTransfers = numberOfTransfers;
            return this;
        }

        public Builder bodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getVolumeOfFuelTank() {
        return volumeOfFuelTank;
    }

    public void setVolumeOfFuelTank(int volumeOfFuelTank) {
        this.volumeOfFuelTank = volumeOfFuelTank;
    }

    public int getWheelRadius() {
        return wheelRadius;
    }

    public void setWheelRadius(int wheelRadius) {
        this.wheelRadius = wheelRadius;
    }

    public boolean isPresenceOfDisks() {
        return presenceOfDisks;
    }

    public void setPresenceOfDisks(boolean presenceOfDisks) {
        this.presenceOfDisks = presenceOfDisks;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getNumberOfTransfers() {
        return numberOfTransfers;
    }

    public void setNumberOfTransfers(int numberOfTransfers) {
        this.numberOfTransfers = numberOfTransfers;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
