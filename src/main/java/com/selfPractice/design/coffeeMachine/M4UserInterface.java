package com.selfPractice.design.coffeeMachine;

public class M4UserInterface extends UserInterface implements Pollable {

	private CoffeeMakerAPI api;
	
	public M4UserInterface(CoffeeMakerAPI api) {
		this.api = api;
	}

	@Override
	public void done() {
		api.setIndicatorState(CoffeeMakerAPI.INDICATOR_ON);
	}

	@Override
	public void completeCycle() {
		api.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF);

	}

	@Override
	public void poll() {
		int buttonStatus = api.getBrewButtonStatus();
		if (buttonStatus == CoffeeMakerAPI.BREW_BUTTON_PUSHED) {
			startBrewing();
		}
	}
}
