package OtherFeatures.DesignPatterns.Structural;

public class ProxyPattern {
	// Example usage of the Proxy pattern
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		Proxy proxy = new Proxy(realSubject);

		proxy.request();
	}

	interface Subject {
		void request();
	}

	static class RealSubject implements Subject {
		@Override
		public void request() {
			System.out.println("RealSubject: Handling request.");
		}
	}

	static class Proxy implements Subject {
		private RealSubject realSubject;

		public Proxy(RealSubject realSubject) {
			this.realSubject = realSubject;
		}

		@Override
		public void request() {
			System.out.println("Proxy: Pre-processing before forwarding request.");
			realSubject.request();
			System.out.println("Proxy: Post-processing after forwarding request.");
		}
	}

}
