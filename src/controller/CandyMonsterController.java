package controller;

import model.CandyMonster;
import view.CandyMonsterView;

public class CandyMonsterController {
	private CandyMonsterView candyMonsterView;
	private CandyMonster candyMonster;
	private InGameController inGameController;
	
	public CandyMonsterController(InGameController inGameController, int candyNumber){
		this.inGameController = inGameController;
		this.candyMonster = new CandyMonster(100, 200, candyNumber); //x, y, candyNumber TODO fix x, y
		this.candyMonsterView = new CandyMonsterView(candyMonster, candyNumber);
	}
	
	public CandyMonster getCandyMonster(){
		return this.candyMonster;
	}
	
	public CandyMonsterView getCandyMonsterView(){
		return this.candyMonsterView;
	}
}
