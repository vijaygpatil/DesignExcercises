package com.selfPractice.design.elevator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BuildingTest {
    /**
     * Ensures that the building creates the number of floors from the first argument,
     * and number of elevators from the second argument.
     */
    @Test
    public void testConstructor() {
        Building building = new Building( 1, 3 );
        Assert.assertEquals( 1, building.getNumFloors() );
        Assert.assertEquals( 3, building.getNumElevators() );
    }

    /**
     * Ensures that the user of the class cannot create 0 floors since this will defeat the purpose of the app.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumFloorsConstructor() {
        Building building = new Building( 0, 1 );
        Assert.fail();
    }
    
    /**
     * Ensures that the user of the class cannot create 0 elevators since this will defeat the purpose of the app.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumElevatorsConstructor() {
        Building building = new Building( 1, 0 );
        Assert.fail();
    }

    /**
     * Ensures that the user of the class is able to get the number of floors from the instance.
     */
    @Test
    public void testGetNumFloors() {
        Building buildingOne = new Building( 1, 1 );
        Assert.assertEquals( 1, buildingOne.getNumFloors() );

        Building buildingTwo = new Building( 2, 1 );
        Assert.assertEquals( 2, buildingTwo.getNumFloors() );

        Building buildingThree = new Building( 7, 1 );
        Assert.assertEquals( 7, buildingThree.getNumFloors() );
    }

    /**
     * Ensures that the user of the class is able to get the number of elevators from the instance.
     */
    @Test
    public void testGetNumElevators() {
        Building buildingOne = new Building( 1, 1 );
        Assert.assertEquals( 1, buildingOne.getNumElevators() );

        Building buildingTwo = new Building( 1, 2 );
        Assert.assertEquals( 2, buildingTwo.getNumElevators() );

        Building buildingThree = new Building( 1, 7 );
        Assert.assertEquals( 7, buildingThree.getNumElevators() );
    }

    /**
     * Ensures that an elevatorController object is accessible through the building class, 
     * We are not sure if this is the best way to test this yet, but it is the best way we know.
     */
    @Test
    public void testGetElevatorController() {
        Building building = new Building( 2, 2 );
        Assert.assertNotNull( building.getElevatorController() );
    }

    /**
     * Ensures that the addFloorRequest method can be used to add Requests to the Building's specific elevator controller.
     */
    @Test
    public void testAddFloorRequest() {
        Building building = new Building( 2, 2 );
        System.out.println( "building.getNumElevators(): " + building.getNumElevators() );
        System.out.println( "building..getElevatorController().getNumElevators(): " + building.getElevatorController().getNumElevators() );
        building.addFloorRequest( 2, 2 );
        Assert.assertEquals( 1, building.getElevatorController().getNumRequests() );

        building.addFloorRequest( 2, 2 );
        Assert.assertEquals( 2, building.getElevatorController().getNumRequests() );

        building.addFloorRequest( 2, 2 );
        Assert.assertEquals( 3, building.getElevatorController().getNumRequests() );
    }
}
