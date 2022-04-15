public class Planner {

	public static void main(String[] args) {

		// Creating the gift transfer queue
		GiftTransfer giftQueue = new GiftTransfer();

		// Creating Santa Claus 
		SantaClaus Santa = new SantaClaus(giftQueue);

		// Creating Santa's workshop
		Workshop workshop =  new Workshop(giftQueue);

		// Starts the creation of the factories
		workshop.createFactories();

		// Santa starts receiving gifts from reindeers
		Santa.start();

	}
}
