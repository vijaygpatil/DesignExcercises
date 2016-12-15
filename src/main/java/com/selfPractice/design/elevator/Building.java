package com.selfPractice.design.elevator;

/**
 * uses Facade pattern - sort of - because it manages the floors, elevators and elevatorController
 */
public class Building {

    private int numFloors;
    private int numElevators;
    private ElevatorController elevatorController;

    /**
     * @param numFloorsIn number of floors that the building should create.
     * @param numElevatorsIn number of elevators that the building should create.
     * @throws IllegalArgumentException   
     * @return Building object with numElevators of numElevatorsIn and numFloors of numFloorsIn
     */
    public Building( int numFloorsIn, int numElevatorsIn ) throws IllegalArgumentException {
        if ( numFloorsIn <= 0 || numElevatorsIn <= 0 )
            throw new IllegalArgumentException();
        System.out.println( "Constructing building..." );
        setupFloors( numFloorsIn );
        setupElevators( numElevatorsIn, numFloorsIn );
    }

    /**
     * @return numFloors is the number of floors in the building, duh.
     */
    public int getNumFloors() {
        return numFloors;
    }

    /**
     * sets the number of floors to numFloorsIn
     * @param numFloorsIn used to set numFloors data member
     */
    private void setNumFloors( int numFloorsIn ) {
        numFloors = numFloorsIn;
    }

    /**
     * @return numElevators is the number of elevators in the building
     */
    public int getNumElevators() {
        return numElevators;
    }

    /**
     * @param numElevatorsIn used to set numElevators data member
     */
    private void setNumElevators( int numElevatorsIn ) {
        numElevators = numElevatorsIn;
    }

    /**
     * @return elevatorController object
     */
    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    /**
     * sets up initial floors for the building, also sets the numFloors data member
     * to the passed in parameter numFloorsIn
     * @param numFloorsIn uses this to create the number of floors and set numFloors
     */
    private void setupFloors( int numFloorsIn ) {
        setNumFloors( numFloorsIn );
    }

    /**
     * sets up initial elevators for the building, also sets the numElevators data member
     * to the passed in parameter numElevatorsIn
     * @param numElevatorsIn uses this to create the number of elevators and set numElevators
     * @param numFloorsIn the number of floors in the building.
	 */
    private void setupElevators( int numElevatorsIn, int numFloorsIn ) {
        setNumElevators( numElevatorsIn );
        elevatorController = new ElevatorController( numElevatorsIn, numFloorsIn );
    }

    /**
     * delegates the request to elevatorController, note that this will not be used in the final implementation.
     * @param requestedNumFloor the floor you want this elevator to go to.
     * @param elevatorNumber the elevator you want to use.
     */
    public void addFloorRequest( int requestedNumFloor, int elevatorNumber ) {
        elevatorController.addFloorRequest( requestedNumFloor, elevatorNumber );
    }
}
