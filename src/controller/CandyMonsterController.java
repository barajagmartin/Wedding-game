package controller;

import model.CandyMonster;
import view.CandyMonsterView;

public class CandyMonsterController {
	private CandyMonsterView candyMonsterView;
	private CandyMonster candyMonster;
	
	public CandyMonsterController(int candyNumber){
		this.candyMonster = new CandyMonster(candyNumber, 600, 300); //CandyNumber, x, y
		this.candyMonsterView = new CandyMonsterView(candyMonster);
	}
	
	public CandyMonster getCandyMonster(){
		return this.candyMonster;
	}
	
	public CandyMonsterView getCandyMonsterView(){
		return this.candyMonsterView;
	}
}
