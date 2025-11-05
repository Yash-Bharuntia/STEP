package Week7.AssignmentProblem;

public class FleetManagement {

    // Abstract Parent Class
    abstract static class Vehicle {
        String id;
        public Vehicle(String id) { this.id = id; }
        abstract void dispatch();
    }

    // Child Classes
    static class Bus extends Vehicle {
        public Bus(String id) { super(id); }
        @Override
        void dispatch() {
            System.out.println("🚌 Bus " + id + ": Starting fixed Route 7A. Current capacity: 80%.");
        }
    }

    static class Taxi extends Vehicle {
        public Taxi(String id) { super(id); }
        @Override
        void dispatch() {
            System.out.println("🚕 Taxi " + id + ": Dispatched to customer location. Fare calculation started.");
        }
    }

    static class Train extends Vehicle {
        public Train(String id) { super(id); }
        @Override
        void dispatch() {
            System.out.println("🚆 Train " + id + ": Departing on schedule from Central Station, Platform 3.");
        }
    }

    public static void main(String[] args) {
        // Parent type array holding child type objects
        Vehicle[] fleet = {
                new Bus("B-101"),
                new Taxi("T-204"),
                new Train("TR-05")
        };

        System.out.println("--- Dispatching All Vehicles ---");
        for (Vehicle vehicle : fleet) {
            // JVM decides at runtime which 'dispatch()' method to call
            vehicle.dispatch();
        }
    }
}
