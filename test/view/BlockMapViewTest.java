package view;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import model.BlockMap;

import org.junit.Test;
import org.newdawn.slick.SlickException;

public class BlockMapViewTest {

	@Test
	public void testConstructor() throws FileNotFoundException, SlickException {
		BlockMapView blockMapView = new BlockMapView(new BlockMap(), new FileInputStream("test.tmx"));
		
		assertTrue(blockMapView.getBlockMap().getBlockList().get(0).getPosX() == 0);
		assertTrue(blockMapView.getBlockMap().getBlockList().get(0).getPosY() == 0);
		assertTrue(blockMapView.getBlockMap().getBlockList().get(1).getPosX() == 32);
		assertTrue(blockMapView.getBlockMap().getBlockList().get(1).getPosY() == 32);
		for (int i = 0 ; i < 2 ; i++) {
			assertTrue(blockMapView.getBlockMap().getBlockList().get(i).getWidth() == 32);
			assertTrue(blockMapView.getBlockMap().getBlockList().get(i).getHeight() == 32);
		}
		assertTrue(blockMapView.getBlockMap().getBlockList().size() > 2);
	}

}
