/**
 * Producer_Consumer.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  5 Producers and 2 Consumers
 */

/**
 * Screw Producer
 * 
 * @author sdudhani
 * 
 */
class ScrewProducer implements Runnable {
	static int prod_array[];
	int prod_max;
	int prod_batch;

	ScrewProducer() {
		prod_array = new int[1];
		prod_max = 16;
		prod_batch = 4;
	}

	public void run() {
		while (true) {
			synchronized (prod_array) {
				if (prod_array[0] >= prod_max) {
					/*
					 * The production array is full Notify the other Consumers
					 */
					prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Item array full : " + prod_batch);

					/*
					 * wait for item requirement to go down and then produce
					 */
					try {
						prod_array.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "Items produced : " + prod_batch);
				// Resume production of items
				prod_array[0] += prod_batch;
				if (prod_batch > prod_max) {
					prod_array[0] = prod_max;
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "New item Count : " + prod_array[0]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Notify the other consumers
				prod_array.notifyAll();
			}
		}

	}
}

/**
 * Screw Producer
 * 
 * @author sdudhani
 * 
 */
class BaseProducer implements Runnable {
	static int prod_array[];
	int prod_max;
	int prod_batch;

	BaseProducer() {
		prod_array = new int[1];
		prod_max = 16;
		prod_batch = 2;
	}

	public void run() {
		while (true) {
			synchronized (prod_array) {
				if (prod_array[0] >= prod_max) {
					/*
					 * The production array is full Notify the other Consumers
					 */
					prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Item array full : " + prod_batch);

					/*
					 * wait for item requirement to go down and then produce
					 */
					try {
						prod_array.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "Items produced : " + prod_batch);
				// Resume production of items
				prod_array[0] += prod_batch;
				if (prod_batch > prod_max) {
					prod_array[0] = prod_max;
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "New item Count : " + prod_array[0]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Notify the other consumers
				prod_array.notifyAll();
			}
		}

	}
}

/**
 * Socket Producer
 * 
 * @author sdudhani
 * 
 */
class SocketProducer implements Runnable {
	static int prod_array[];
	int prod_max;
	int prod_batch;

	SocketProducer() {
		prod_array = new int[1];
		prod_max = 21;
		prod_batch = 7;
	}

	public void run() {
		while (true) {
			synchronized (prod_array) {
				if (prod_array[0] >= prod_max) {
					/*
					 * The production array is full Notify the other Consumers
					 */
					prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Item array full : " + prod_batch);

					/*
					 * wait for item requirement to go down and then produce
					 */
					try {
						prod_array.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "Items produced : " + prod_batch);
				// Resume production of items
				prod_array[0] += prod_batch;
				if (prod_batch > prod_max) {
					prod_array[0] = prod_max;
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "New item Count : " + prod_array[0]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Notify the other consumers
				prod_array.notifyAll();
			}
		}

	}
}

/**
 * Light Bulbs Producer
 * 
 * @author sdudhani
 * 
 */
class LightBulbsProducer implements Runnable {
	static int prod_array[];
	int prod_max;
	int prod_batch;

	LightBulbsProducer() {
		prod_array = new int[1];
		prod_max = 16;
		prod_batch = 4;
	}

	public void run() {
		while (true) {
			synchronized (prod_array) {
				if (prod_array[0] >= prod_max) {
					/*
					 * The production array is full Notify the other Consumers
					 */
					prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Item array full : " + prod_batch);
					/*
					 * wait for item requirement to go down and then produce
					 */
					try {
						prod_array.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "Items produced : " + prod_batch);
				// Resume production of items
				prod_array[0] += prod_batch;
				if (prod_batch > prod_max) {
					prod_array[0] = prod_max;
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "New item Count : " + prod_array[0]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Notify the other consumers
				prod_array.notifyAll();
			}
		}

	}
}

/**
 * Stand Producer
 * 
 * @author sdudhani
 * 
 */
class StandProducer implements Runnable {
	int prod_max;
	int prod_batch;
	static int prod_array[];

	StandProducer() {
		prod_array = new int[1];
		prod_max = 12;
		prod_batch = 4;

	}

	public void run() {
		while (true) {
			synchronized (prod_array) {
				if (prod_array[0] >= prod_max) {
					/*
					 * The production array is full Notify the other Consumers
					 */
					prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Item array full : " + prod_batch);

					/*
					 * wait for item requirement to go down and then produce
					 */
					try {
						prod_array.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "Items produced : " + prod_batch);

				// Resume production of items
				prod_array[0] += prod_batch;
				if (prod_batch > prod_max) {
					prod_array[0] = prod_max;
				}
				System.out.println(Thread.currentThread().getName() + " : "
						+ "New item Count : " + prod_array[0]);

				// Notify the other consumers
				prod_array.notifyAll();
			}
		}

	}
}
/**
 * Consumer
 * @author sdudhani
 *
 */
abstract class Consumer implements Runnable {
	static final int screw_req = 4;
	static final int stand_req = 1;
	static final int socket_req = 3;
	static final int base_req = 1;
	static final int lightbulb_req = 3;

	public void run() {
		while (true) {
			// Take lock on Screws
			synchronized (ScrewProducer.prod_array) {
				// Check if required units are available
				if (ScrewProducer.prod_array[0] >= screw_req) {
					synchronized (StandProducer.prod_array) {
						// Check if required units are available
						if (StandProducer.prod_array[0] >= stand_req) {
							synchronized (BaseProducer.prod_array) {
								// Check if required units are available
								if (BaseProducer.prod_array[0] >= base_req) {
									synchronized (SocketProducer.prod_array) {
										// Check if required units are available
										if (SocketProducer.prod_array[0] >= socket_req) {
											synchronized (LightBulbsProducer.prod_array) {
												// Check if required units are
												// available
												if (LightBulbsProducer.prod_array[0] >= lightbulb_req) {
													/*
													 * items required for the
													 * Product are available
													 */
													BaseProducer.prod_array[0] -= base_req;
													SocketProducer.prod_array[0] -= socket_req;
													LightBulbsProducer.prod_array[0] -= lightbulb_req;
													StandProducer.prod_array[0] -= stand_req;
													ScrewProducer.prod_array[0] -= screw_req;
/*
													// Notify all the producers
													StandProducer.prod_array
															.notify();
													ScrewProducer.prod_array
															.notify();
													BaseProducer.prod_array
															.notify();
													LightBulbsProducer.prod_array
															.notify();
													SocketProducer.prod_array
															.notify();
*/
													try {
														Thread.sleep(100);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch block
														e.printStackTrace();
													}
													System.out
															.println(Thread
																	.currentThread()
																	.getName()
																	+ " : "
																	+ "Items produced : XXXXXXXXXXXXXXXX");

												} else {
													// Request for more
													// production of item
													LightBulbsProducer.prod_array
															.notifyAll();
													System.out
															.println(Thread
																	.currentThread()
																	.getName()
																	+ " : "
																	+ "Items requested");
													try {
														LightBulbsProducer.prod_array.wait();
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}

										} else {
											// Request for more production of
											// item
											SocketProducer.prod_array.notifyAll();
											System.out
													.println(Thread
															.currentThread()
															.getName()
															+ " : "
															+ "Items requested");
											try {
												SocketProducer.prod_array.wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}

								} else {
									// Request for more production of item
									BaseProducer.prod_array.notifyAll();
									System.out.println(Thread.currentThread()
											.getName()
											+ " : "
											+ "Items requested");
									try {
										BaseProducer.prod_array.wait();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
							}

						} else {
							// Request for more production of item
							StandProducer.prod_array.notifyAll();
							System.out.println(Thread.currentThread().getName()
									+ " : " + "Items requested");
							try {
								StandProducer.prod_array.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}

				} else {
					// Request for more production of item
					ScrewProducer.prod_array.notifyAll();
					System.out.println(Thread.currentThread().getName() + " : "
							+ "Items requested");
					try {
						ScrewProducer.prod_array.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

}
/**
 * First Consumer
 * @author sdudhani
 *
 */
class Consumer1 extends Consumer {

}
/**
 * Second Consumer
 * @author sdudhani
 *
 */
class Consumer2 extends Consumer {

}
/**
 * Producer Consumer
 * @author sdudhani
 *
 */
public class Producer_Consumer {

	public static void main(String[] args) {
		/*
		 * Create Instance of Screw,Stand Producer
		 */
		Thread Prod1 = new Thread(new ScrewProducer(), "Screw");
		Thread Prod2 = new Thread(new StandProducer(), "Stand");
		Thread Prod3 = new Thread(new BaseProducer(), "Base");
		Thread Prod4 = new Thread(new SocketProducer(), "Socket");
		Thread Prod5 = new Thread(new LightBulbsProducer(), "LightBulb");
		Thread Consumer1 = new Thread(new Consumer1(), "Consumer1");
		Thread Consumer2 = new Thread(new Consumer2(), "Consumer2");
		Prod1.start();
		Prod2.start();
		Prod3.start();
		Prod4.start();
		Prod5.start();
		Consumer1.start();
		Consumer2.start();
	}

}
