package controller;

import model.CandyMonster;
import view.CandyMonsterView;

public class CandyMonsterController {
	private CandyMonsterView candyMonsterView;
	private CandyMonster candyMonster;
	private InGameController inGameController;
	
	public CandyMonsterController(InGameController inGameController, int candyNumber){
		this.inGameController = inGameController;
		this.candyMonster = new CandyMonster(this.inGameController.getBlockMapController().getCandyMonsterMap().getBlockList().get(candyNumber).getPosX(), 
											this.inGameController.getBlockMapController().getCandyMonsterMap().getBlockList().get(candyNumber).getPosY(), 
											candyNumber); //x, y, candyNumber
		this.candyMonsterView = new CandyMonsterView(this.candyMonster, candyNumber);
	}
	
	public CandyMonster getCandyMonster(){
		return this.candyMonster;
	}
	
	public CandyMonsterView getCandyMonsterView(){
		return this.candyMonsterView;
	}
}
