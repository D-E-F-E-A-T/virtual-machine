import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final int POSITION = 0;
        String fileName;

        Instructions briefing = new Instructions();

        ArrayList<Register> registers = new ArrayList<>();// ArrayList<> para guardar os registradores
        ArrayList<String> instruction = new ArrayList<>(); // ArrayList<> para guardar as instruções

        Files file = new Files(); // Instancia da Classe File

        Scanner input = new Scanner(System.in); // Entrada
        System.out.println("Entre com o nome do Arquivo");
        fileName = input.nextLine();
        file.read(fileName, instruction); // Lê o Arquivo, busca a instrução

        createRecords(registers); // Cria registradores

        goThroughArray(briefing, instruction, POSITION);// Percorre o Array, intepreta a instrução

        showOrganization(briefing, fileName);// Mostra a organização

        System.out.println("");

        inspection(briefing, registers);// Verifica quais registradores

        briefing.execute();// Executa

    }

    public static void createRecords(ArrayList<Register> registers) {
        Register jv0 = new Register();
        Register jv1 = new Register();
        Register jv2 = new Register();
        Register jv3 = new Register();
        Register zero = new Register();
        Register jv4 = new Register();

        // Endereços
        jv0.address = "000"; // 0
        jv1.address = "001"; // 1
        jv2.address = "010"; // 2
        jv3.address = "011"; // 3
        jv4.address = "100"; // 4
        zero.address = "101"; // 5

        // Valores
        jv0.value = 1;
        jv1.value = 2;
        jv2.value = 3;
        jv3.value = 4;
        zero.value = 0;
        jv4.value = 0;

        registers.add(jv0);
        registers.add(jv1);
        registers.add(jv2);
        registers.add(jv3);
        registers.add(zero);
        registers.add(jv4);

    }

    public static void goThroughArray(Instructions briefing, ArrayList<String> instructions, int pos) {

        briefing.opCode = instructions.get(pos).substring(0, 4);

        briefing.jvs = instructions.get(pos).substring(4, 8);

        briefing.jvt = instructions.get(pos).substring(8, 12);

        briefing.jvd = instructions.get(pos).substring(12, 16);

    }

    public static void showOrganization(Instructions briefing, String fileName) {
        System.out.println("===============[" + fileName.toUpperCase() + "]================");
        System.out.println("| OP ----- JVS ----- JVT ----- JVD |");
        System.out.println("|" + briefing.opCode + " ---- " + briefing.jvs + " ---- " + briefing.jvt + " ---- "
                + briefing.jvd + "|");
        System.out.println("====================================");
    }

    public static void inspection(Instructions briefing, ArrayList<Register> registers) {
        switch (briefing.jvt) {
        case "0000":
            briefing.registerOne = registers.get(0);
            break;

        case "0001":
            briefing.registerOne = registers.get(1);
            break;

        case "0010":
            briefing.registerOne = registers.get(2);
            break;

        case "0011":
            briefing.registerOne = registers.get(3);
            break;

        case "0100":
            briefing.registerOne = registers.get(4);
            break;

        case "0101":
            briefing.registerOne = registers.get(5);
            break;

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVT}");
            break;
        }

        switch (briefing.jvd) {
        case "0000":
            briefing.registerTwo = registers.get(0);
            break;

        case "0001":
            briefing.registerTwo = registers.get(1);
            break;

        case "0010":
            briefing.registerTwo = registers.get(2);
            break;

        case "0011":
            briefing.registerTwo = registers.get(3);
            break;

        case "0100":
            briefing.registerTwo = registers.get(4);
            break;

        case "0101":
            briefing.registerTwo = registers.get(5);
            break;

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVD}");
            break;
        }

        
        switch (briefing.jvs) {
        case "0000":
            briefing.registerAnswer = registers.get(0);
            break;

        case "0001":
            briefing.registerAnswer = registers.get(1);
            break;

        case "0010":
            briefing.registerAnswer = registers.get(2);
            break;

        case "0011":
            briefing.registerAnswer = registers.get(3);
            break;

        case "0100":
            briefing.registerAnswer = registers.get(4);
            break;

        case "0101":
            briefing.registerAnswer = registers.get(5);
            break;

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVS}");
            break;
        }
        
    }

}
