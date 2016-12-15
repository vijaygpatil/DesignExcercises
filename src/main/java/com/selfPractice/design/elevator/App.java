package com.selfPractice.design.elevator;

/**
 * This class is going to instantiate the ElevatorController
 * @author Valentin Litvak, Michael Williamson
 */
public class App {
    public static void main( String[] args ) { 
        /* 1: Create a building with 15 floors and 6 elevators. */
        Building building = new Building( 15, 6 );

        /* 2: Make elevator 1 go to floor 11. */
        building.addFloorRequest( 11, 1 );

        // 3: Make elevator 2 go to floor 11.
        building.addFloorRequest( 14, 2 );

        // 4
        building.addFloorRequest( 13, 2 );
        building.addFloorRequest( 15, 2 );

        // 5
        try {
            Thread.sleep( 30000 );
        } catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }

        // 6
        building.addFloorRequest( 10, 1 );
        building.addFloorRequest( 1, 1 );

        // 7
        try {
            Thread.sleep( 10000 );
        } catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
        building.addFloorRequest( 2, 1 );

        // 8
        building.addFloorRequest( 5, 1 );
        building.addFloorRequest( 3, 1 );
    }
}
