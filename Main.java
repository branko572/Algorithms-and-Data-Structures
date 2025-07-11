//Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку јазли со точно две деца има во поддрвото на избран јазол“.
//
//        Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.
//
//        Влезот ќе содржи N+Q редови од видот
//
//        root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
//
//        add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
//
//        ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
//
//        Пример и структура на влезот:
//
//        Влез
//
//        Објаснување
//
//        Излез
//
//        11 9
//        root bravo
//        add bravo echo LEFT
//        add echo beard LEFT
//        ask beard
//        ask bravo
//        add bravo foxtrot RIGHT
//        add beard hotel LEFT
//        add beard india RIGHT
//        ask echo
//        add foxtrot golf LEFT
//        add golf juliet RIGHT
//        add india sierra RIGHT
//        ask foxtrot
//        ask bravo
//        ask beard
//        add echo mike RIGHT
//        add foxtrot tango RIGHT
//        ask echo
//        ask bravo
//        ask foxtrot
//        Прикажано е изгледот на дрвото при секоја од 4те групи прашања во влезот
//
//
//
//
//
//
//        0
//        0
//        1
//        0
//        2
//        1
//        2
//        4
//        1
//
//
//
//        ------
//
//
//
//        In the following task, you need to build a binary tree with N nodes, for which you will need to answer Q questions of the type "how many nodes with exactly two children are there in the subtree of a selected node"..
//
//        Each node will have a unique name. The name of the root of the tree will always be given to you first.
//
//        The input will contain N+Q rows of the type
//
//        root name - You need to set the root of the tree to be the node named name
//
//        add parent_name child_name - You need to add a child node named child_name to the node named parent_name
//
//        ask node_name - We need to answer the question about the subtree of the node named node_name
//
//        Example and structure of the input:
//
//        Input
//
//        Explanation
//
//        Output
//
//        11 9
//        root bravo
//        add bravo echo LEFT
//        add echo beard LEFT
//        ask beard
//        ask bravo
//        add bravo foxtrot RIGHT
//        add beard hotel LEFT
//        add beard india RIGHT
//        ask echo
//        add foxtrot golf LEFT
//        add golf juliet RIGHT
//        add india sierra RIGHT
//        ask foxtrot
//        ask bravo
//        ask beard
//        add echo mike RIGHT
//        add foxtrot tango RIGHT
//        ask echo
//        ask bravo
//        ask foxtrot
//        The tree layout is shown for each of the 4 groups of questions in the sample input.
//
//
//
//
//
//
//        0
//        0
//        1
//        0
//        2
//        1
//        2
//        4
//        1
//
//        For example:
//
//        Input	Result
//        11 9
//        root bravo
//        add bravo echo LEFT
//        add echo beard LEFT
//        ask beard
//        ask bravo
//        add bravo foxtrot RIGHT
//        add beard hotel LEFT
//        add beard india RIGHT
//        ask echo
//        add foxtrot golf LEFT
//        add golf juliet RIGHT
//        add india sierra RIGHT
//        ask foxtrot
//        ask bravo
//        ask beard
//        add echo mike RIGHT
//        add foxtrot tango RIGHT
//        ask echo
//        ask bravo
//        ask foxtrot
//        0
//        0
//        1
//        0
//        2
//        1
//        2
//        4
//        1




import java.util.*;

class TreeNode {
    String name;
    TreeNode left, right;

    TreeNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    static Map<String, TreeNode> tree = new HashMap<>();

    // Метод за броење на јазли со точно две деца
    public static int countNodesWithTwoChildren(TreeNode root) {
        if (root == null) {
            return 0;  // Ако јазелот е null, врати 0
        }

        // Рекурзивно брои ги јазлите со две деца во левото и десното поддрво
        int left = countNodesWithTwoChildren(root.left);
        int right = countNodesWithTwoChildren(root.right);

        // Ако тековниот јазел има точно две деца, додади 1
        if (root.left != null && root.right != null) {
            return left + right + 1;
        }

        // Во спротивно, врати го збирот од левото и десното поддрво
        return left + right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // Број на јазли
        int Q = sc.nextInt();  // Број на прашања
        sc.nextLine();  // Да се исчисти новиот ред после nextInt()

        for (int i = 0; i < N + Q; i++) {
            String command = sc.nextLine();
            String[] tokens = command.split(" ");

            if (tokens[0].equals("root")) {
                // Креирање на коренот
                TreeNode root = new TreeNode(tokens[1]);
                tree.put(tokens[1], root);
            } else if (tokens[0].equals("add")) {
                // Додавање на дете
                String parent = tokens[1];
                String child = tokens[2];
                String pos = tokens[3];

                TreeNode parentNode = tree.get(parent);
                if (parentNode != null) {
                    TreeNode childNode = new TreeNode(child);
                    if (pos.equals("LEFT")) {
                        parentNode.left = childNode;
                    } else if (pos.equals("RIGHT")) {
                        parentNode.right = childNode;
                    }
                    tree.put(child, childNode);
                }
            } else if (tokens[0].equals("ask")) {
                // Прашање за бројот на јазли со две деца
                String nodeName = tokens[1];
                TreeNode node = tree.get(nodeName);
                if (node != null) {
                    System.out.println(countNodesWithTwoChildren(node));
                } else {
                    System.out.println(0);  // Ако јазелот не постои, врати 0
                }
            }
        }

        sc.close();  // Затвори го Scanner
    }
}