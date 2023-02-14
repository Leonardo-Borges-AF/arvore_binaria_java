public class árvore_binária {
    No raiz;

    public void insere(No n) {
        if (raiz == null) {
            raiz = n;
            System.out.println("inserido");
        }

        else { // busca para indentificar onde sera inserido
            No aux = raiz;
            while (aux != null) {
                if (n.getChave() > aux.getChave()) { // move para direita
                    No dir = aux.getDir();

                    if (dir != null) {
                        aux = aux.getDir();
                    }

                    else { // insere na posicao do filho a direita de aux
                        aux.setDir(n);
                        n.setPai(dir);
                        aux = null;
                        System.out.println("in dir");
                    }
                }

                else {// move para esquerda
                    No esq = aux.getEsq();

                    if (esq != null) {
                        aux = aux.getEsq();
                    }

                    else { // insere na posicao do filho a esquerda
                        aux.setEsq(n);
                        n.setPai(aux);
                        aux = null;
                        System.out.print("in esq");
                    }
                }

            }
        }
    }

    public No procura(int busca) {
        No aux = raiz;
        while (aux != null) {
            if (aux.getChave() == busca) {
                return aux;
            } else if (busca > aux.getChave()) {
                aux = aux.getDir();
            } else {
                aux = aux.getEsq();
            }
        }
        return null;
    }

    public void preOrdem(No test) {
        if (test != null) {
            System.out.println(test.toString());
            preOrdem(test.getEsq());
            preOrdem(test.getDir());
        }
    }

    public void posOrdem(No test) {
        if (test != null) {
            posOrdem(test.getEsq());
            posOrdem(test.getDir());
            System.out.println(test.toString());
        }
    }

    public void emOrdem(No test) {
        if (test != null) {
            emOrdem(test.getEsq());
            System.out.println(test.toString());
            emOrdem(test.getDir());
        }
    }

}
