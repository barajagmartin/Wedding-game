package controller;

import org.newdawn.slick.Color;

import model.CandyMonster;
import model.Item;
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
	
	public void isDropedDown(Item item){
		if(!item.isPickedUp() && item.CANDY_NUMBER == candyMonster.CANDY_NUMBER && 
				candyMonsterView.getShape().contains(inGameController.getItemController().get(candyMonster.CANDY_NUMBER).getItemView().getShape())){
			candyMonsterView.setColor(Color.black); //senare ändra bild
			inGameController.getItemController().remove(candyMonster.CANDY_NUMBER);
		}
	}
}
