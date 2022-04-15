import java.util.Random;

public class Reindeer extends Thread {
	
	private int number;
	private ToyFactory factories[];
	private GiftTransfer giftQueue;
	
	public Reindeer(ToyFactory factories[], int number, GiftTransfer giftQueue) {
		this.factories = factories;
		this.number = number;
		this.giftQueue = giftQueue;
		
	}
	
	public void run() {
		while(true) {
			
			int gift = getGiftFromFactory();
			if(gift != 0) {
				System.out.println("Reindeer " + number + " received gift " + gift);
				giveGiftToSanta(gift);			
			}
			Random rand = new Random();
			long milis = rand.nextInt(30) + 10;				//sleeps for 10-30 miliseconds
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void giveGiftToSanta(int gift) {
		giftQueue.giveGift(gift);
		System.out.println("Reindeer " + number + " gave gift " + gift + " to Santa");
	}

	private int getGiftFromFactory() {
		Random rand = new Random();
		int factory = rand.nextInt(Workshop.nrFactories) + 0;
		return factories[factory].getGift();
	}
}
