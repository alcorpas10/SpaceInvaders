package tp.p1.game.GameObjects.Lists;

import tp.p1.game.GameObjects.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		currentObjects = 0;
		objects = new GameObject[width * height];
	}
	private int getCurrentObjects() {
		return currentObjects;
	}
	public void add(GameObject object) {
		objects[getCurrentObjects()] = object;
		currentObjects++;
	}
	private GameObject getObjectInPosition(int x, int y) {
		int index = getIndex(x, y);
		if (index != -1) return objects[index];
		else return null;
	}
	private int getIndex(int x, int y) {
		int index = -1;
		boolean enc = false;
		for (int i = 0; i < getCurrentObjects() && !enc; i++) {
			if (objects[i].isOnPosition(x, y)) {
				enc = true;
				index = i;
			}
		}
		return index;
	}
	private void remove(GameObject object) {
		int index = getIndex(object.getX(), object.getY());
		objects[index] = null;
		for (int i = index; i < getCurrentObjects() - 1; i++) {
			objects[i] = objects[i + 1];
		}
		objects[getCurrentObjects() - 1] = null;
		currentObjects--;
	}
	public void update() {
		for (int i = 0; i < getCurrentObjects(); i++) {
			checkAttacks(objects[i]);
		}
		removeDead();
	}
	private void checkAttacks(GameObject object) {
		//computerAction();
	// TODO implement
	}
	public void computerAction() {
	// TODO implement
	}
	private void removeDead() {
		for (int i = 0; i < currentObjects; i++) {
			if (!objects[i].isAlive()) remove(objects[i]);
		}
	}
	public String toString(int x, int y) {
		return getObjectInPosition(x, y).toString();
	}
}