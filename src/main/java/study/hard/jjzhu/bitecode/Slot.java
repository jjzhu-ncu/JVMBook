package study.hard.jjzhu.bitecode;

public class Slot {
	public static void main(String[] args) {
		/*
		* byte[] placeholder = new byte[64 * 1024 * 1024]; //64M
		* System.gc();
		*/
		{
			byte[] placeholder = new byte[64 * 1024 * 1024]; //64M
		}
		int a = 0;
		System.gc();
	}
}
