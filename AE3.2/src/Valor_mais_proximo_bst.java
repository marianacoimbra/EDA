import java.util.Scanner;

class Valor_mais_proximo_bst {

    private No root;
    private String preOrder = "";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Valor_mais_proximo_bst ovalor = new Valor_mais_proximo_bst();

        String[] array = entrada.nextLine().split(" ");
        int valor = Integer.parseInt(entrada.nextLine());

        int[] valores = ovalor.toInt(array);

        ovalor.insereValores(valores);

        System.out.println(ovalor.preOrder());
        System.out.println(ovalor.encontraMaisProximo(valor));
    }

    public int encontraMaisProximo(int valor) {
        return achaMaisProximo(valor, this.root, this.root.value);
    }

    private int achaMaisProximo(int valor, No no, int proximo) {
        if (no == null)
            return proximo;

        if (Math.abs(no.value - valor) < Math.abs(proximo - valor))
            proximo = no.value;

        if (valor < no.value)
            return achaMaisProximo(valor, no.left, proximo);
        else
            return achaMaisProximo(valor, no.right, proximo);
    }

    private void insereValores(int[] valores) {
        for (int i = 0; i < valores.length; i++)
            this.add(valores[i]);
    }

    private int[] toInt(String[] entrada) {
        int[] valores = new int[entrada.length];

        for (int i = 0; i < valores.length; i++)
            valores[i] = Integer.parseInt(entrada[i]);

        return valores;
    }

    public void add(int element) {
        if (this.isEmpty())
            this.root = new No(element);
        else
            this.add(element, this.root, this.root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private void add(int element, No no, No pai) {
        if (no == null) {
            No novo = new No(element);
            novo.parent = pai;
            if (element < pai.value) {
                pai.left = novo;
            } else {
                pai.right = novo;
            }
        } else {
            if (element < no.value) {
                add(element, no.left, no);
            } else {
                add(element, no.right, no);
            }
        }
    }

    public String preOrder() {
        String saida = "[";
        saida += preOrder(this.root);
        saida = saida.substring(0, saida.length() - 2);
        saida += "]";
        return saida;
    }

    private String preOrder(No node) {
        String saida = node.value + ", ";
        if (node.left != null)
            saida += preOrder(node.left);
        if (node.right != null)
            saida += preOrder(node.right);
        return saida;
    }
}

class No {

    int value;
    No left;
    No right;
    No parent;

    public No(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}