package OtherFeatures.DesignPatterns.Structural;

class CPU {
	public void start() {
		System.out.println("CPU is starting");
	}
}

class Memory {
	public void load() {
		System.out.println("Memory is loading");
	}
}

class HardDrive {
	public void read() {
		System.out.println("HardDrive is reading data");
	}
}

// Facade
class ComputerFacade {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public ComputerFacade() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void start() {
		cpu.start();
		memory.load();
		hardDrive.read();
		System.out.println("Computer started successfully.");
	}
}

// Usage
public class FacadePattern {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}