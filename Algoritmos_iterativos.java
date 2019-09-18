
public class Algoritmos_iterativos {

	public static void troca_vizinhos(int[] v) {
		for(int i = 1; i < v.length; i += 2) {
			int aux = v[i];
			v[i] = v[i - 1];
			v[i - 1] = aux;
		}
	}

	public static boolean eh_palindromo(char[] palavra) {
		int aux = palavra.length - 1;
		for(int i = 0; i < (palavra.length/2) + 1; i ++) {
			if (!(palavra[i] == palavra[aux])){
				return false;
			}
			aux --;
		}
		return true;
	}

	public static int[] two_sum(int[] v, int target) {
		int[] novoArray = new int[2];
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v.length; j ++) {
				if(v[i] + v[j] == target && i!=j) {
					novoArray[0] = v[i];
					novoArray[1] = v[j];
					return novoArray;
				}
			}
		}
		return novoArray;
	}

	public static boolean eh_primo(int n) {
		boolean resultado = true;
		for (int i = n - 1; i > 1; i--) {
			if (n % i == 0){
				resultado = false;
				break;
			}
		}
		return resultado;
	}

	public static boolean tem_repetido(int[] v) {
		for(int i = 0; i < v.length; i++) {
			for (int j = 1; j < v.length; j ++) {
				if(v[i] == v[j] && i != j) {
					return true;
				}
			}
		}
		return false;
	}

	public static String vetorCircular(int[] array, int quantidadeElementos) {
		String saida = "";
		int indice = 0;
		for(int i = 0; i < quantidadeElementos - 1; i++) {
			saida += array[indice % array.length] + " ";
			indice++;
		}
		saida += array[indice % array.length];
		return saida;
	}

	public static boolean verifica_divisiveis(int[] v) {
		for(int i = 0; i < v.length; i++) {
			for (int j = 1; j < v.length; j ++) {
				if(v[i] % v[j] == 0 && i != j) {
					return true;
				}
			}
		}
		return false;
	}

	public static int[] bubble_sort(int[] lista) {
		for (int i = lista.length; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				if (lista[j - 1] > lista[j]) {
					int aux = lista[j];
					lista[j] = lista[j - 1];
					lista[j - 1] = aux;
				}
			}
		}
		return lista;
	}
}
