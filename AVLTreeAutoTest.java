public class AVLTreeAutoTest extends AVLTreeTest {

	public AVLTreeAutoTest() {
		super();
	}

	public static void main(String[] args) throws NodeAlreadyExistsException {
		AVLTree tree = new AVLTree();

		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] values2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};

		//ADICIONAR primeiros valores
		try {
			print(TESTING_INSERT, true);
			for (int i: values) {
				print(INSERTING + i + ELLIPSIS, false);
				tree.add(i);
			}
		} catch (Exception e) {
			print(e.toString(), true);
		}

		// test contains()
		try {
			print(TESTING_FIND, true);
			for (int i: values) {
				print(FINDING + i + ELLIPSIS, false);
				if (tree.contains(i)) {
					print(SUCCESS, true);
				} else {
					print(FAILED, true);
				}
			}
		} catch (Exception e) {
			print(e.toString(), true);
		}

//		TESTES
		//EXIBIR A ARVORE
		tree.printTree();

		//ALTURA DA ARVORE
		System.out.println("Altura da árvore: "+tree.height());

		//LIMPAR A ARVORE
		tree.clear();

		//ADICIONAR OS OUTROS VALORES
		try {
			print(TESTING_INSERT, true);
			for (int i: values2) {
				print(INSERTING + i + ELLIPSIS, false);
				tree.add(i);
			}
		} catch (Exception e) {
			print(e.toString(), true);
		}

		//CAMINHAMENTO CENTRAL
		tree.inOrder(tree.getRoot());
	}
}
