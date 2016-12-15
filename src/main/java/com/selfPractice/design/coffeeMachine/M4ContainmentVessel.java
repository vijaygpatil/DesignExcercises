package com.selfPractice.design.coffeeMachine;

public class M4ContainmentVessel extends ContainmentVessel implements Pollable {
	private CoffeeMakerAPI api;
	private int lastPotStatus;

	public M4ContainmentVessel(CoffeeMakerAPI api) {
		this.api = api;
		lastPotStatus = CoffeeMakerAPI.POT_EMPTY;
	}

	public boolean isReady() {
		int plateStatus = api.getWarmerPlateStatus();
		return plateStatus == CoffeeMakerAPI.POT_EMPTY;
	}

	public void poll() {
		int potStatus = api.getWarmerPlateStatus();
		if (potStatus != lastPotStatus) {
			if (isBrewing) {
				handleBrewingEvent(potStatus);
			} else if (isComplete == false) {
				handleIncompleteEvent(potStatus);
			}
			lastPotStatus = potStatus;
		}
	}

	private void handleBrewingEvent(int potStatus) {
		if (potStatus == CoffeeMakerAPI.POT_NOT_EMPTY) {
			containerAvailable();
			api.setWarmerState(CoffeeMakerAPI.WARMER_ON);
		} else if (potStatus == CoffeeMakerAPI.WARMER_EMPTY) {
			containerUnavailable();
			api.setWarmerState(CoffeeMakerAPI.WARMER_OFF);
		} else { // potStatus == api.POT_EMPTY
			containerAvailable();
			api.setWarmerState(CoffeeMakerAPI.WARMER_OFF);
		}
	}

	private void handleIncompleteEvent(int potStatus) {
		if (potStatus == CoffeeMakerAPI.POT_NOT_EMPTY) {
			api.setWarmerState(CoffeeMakerAPI.WARMER_ON);
		} else if (potStatus == CoffeeMakerAPI.WARMER_EMPTY) {
			api.setWarmerState(CoffeeMakerAPI.WARMER_OFF);
		} else { // potStatus == api.POT_EMPTY
			api.setWarmerState(CoffeeMakerAPI.WARMER_OFF);
			declareComplete();
		}
	}
}
