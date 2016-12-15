package com.selfPractice.design.elevator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for ElevatorController class.
 */
public class ElevatorControllerTest {
    /**
     * Ensures that the building creates the number of floors from the first argument,
     * and number of elevators from the second argument.
     */
    @Test
    public void testConstructor() {
        ElevatorController elevatorController = new ElevatorController( 2, 4 );
        Assert.assertEquals( 0, elevatorController.getNumRequests() );
    }

    /**
     * Ensures that the user of the class cannot create 0 elevators since this will defeat the purpose of the app.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumElevatorsConstructor() {
        ElevatorController elevatorController = new ElevatorController( 1, 0 );
        Assert.fail();
    }

    /**
     * Ensures that the user of the class cannot create 0 floors since this will defeat the purpose of the app.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumFloorsConstructor() {
        ElevatorController elevatorController = new ElevatorController( 0, 1 );
        Assert.fail();
    }

    /**
     * Ensures that getNumElevators() method returns the number of elevators that the ElevatorController manages, this should also be the same number of elevators that the BUilding owns.
     */
    public void testGetNumElevators() {
        ElevatorController elevatorController = new ElevatorController( 2, 2 );
        Assert.assertEquals( 0, elevatorController.getNumRequests() );

        Assert.assertEquals( 2, elevatorController.getNumElevators() );
    }
	
	/**
     * Ensures that getNumFLoors() method returns the number of floors that the ElevatorController manages, this should also be the same number of elevators that the BUilding owns.
     */
	    public void testGetNumFLoors() {
        ElevatorController elevatorController = new ElevatorController( 2, 2 );
        Assert.assertEquals( 0, elevatorController.getNumRequests() );
        Assert.assertEquals( 2, elevatorController.getNumFloors() );
    }

    /**
     * Ensures that the addFloorRequest method can be used to add Requests to the Building's specific elevator controller.
     */
    @Test
    public void testAddFloorRequest() {
        ElevatorController elevatorController = new ElevatorController( 2, 2 );
        Assert.assertEquals( 0, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 1, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 2, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 3, elevatorController.getNumRequests() );
    }

    /**
     * This is the same test as the testAddFloorRequest because the idea is the same, 
     * the only other thing we would need to test here is when the numRequests goes down, 
     * but currently we do not know of a good way to do this due to Thread.sleep() etc..
     */
    @Test
    public void testGetNumRequests() {
        ElevatorController elevatorController = new ElevatorController( 2, 2 );
        Assert.assertEquals( 0, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 1, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 2, elevatorController.getNumRequests() );

        elevatorController.addFloorRequest( 2, 2 );
        Assert.assertEquals( 3, elevatorController.getNumRequests() );
    }


}
