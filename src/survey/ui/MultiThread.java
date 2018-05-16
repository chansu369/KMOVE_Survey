package survey.ui;

public class MultiThread implements Runnable{
	String name;
	
	public MultiThread(String name) {
		System.out.println(name+"µË´Ï´Ù");
		this.name =name;
	}
	
	@Override
	public void run() {
		AdminUI aui = new AdminUI();
		aui.printMenu();
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
