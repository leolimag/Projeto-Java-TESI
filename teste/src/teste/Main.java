package teste;

public class Main {

	public static void main(String[] args) {
		int vet[] = new int[5];
		int c = 0;
		for (int i = 0; i < vet.length; i++){
			vet[vet.length -1] = c;
			System.out.println(vet[vet.length - 1]);
			c++;
		}

	}

}
