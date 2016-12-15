package com.selfPractice.design.elevator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Elevator class.
 */
public class ElevatorTest {

    /**
     * tests the constructor.
     *
     */
    @Test
    public void testConstructor() {
        Elevator elevatorOne = new Elevator( 1 );
        Elevator elevatorTwo = new Elevator( 2 );
        Assert.assertTrue( true );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeNumber() {
        Elevator elevator = new Elevator( -1 );
        Assert.fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorZeroNumber() {
        Elevator elevator = new Elevator( 0 );
        Assert.fail();
    }

    /**
     * this test is the same as the one below, but that is because they are very closesly related.
     */
    @Test
    public void testAddDestination() {
        Elevator elevator = new Elevator( 1 );
        Assert.assertEquals( 0, elevator.getNumPendingDestinations() );
        
        elevator.addDestination( 2 );
        Assert.assertEquals( 1, elevator.getNumPendingDestinations() );
    }
    
    /**
     * this test is the same as the one above, but that is because they are very closesly related.
     */
    @Test
    public void testGetNumPendingDestinations() {
        Elevator elevator = new Elevator( 1 );
        Assert.assertEquals( 0, elevator.getNumPendingDestinations() );
        
        elevator.addDestination( 2 );
        Assert.assertEquals( 1, elevator.getNumPendingDestinations() );
    }
}
