import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Main {
    public static void main(final String[] args) {

        int j = 0;

        final String fileName;

        final Instructions briefing = new Instructions();

        final ArrayList<Register> registers = new ArrayList<>();// ArrayList<> para guardar os registradores
        final String[] instruction = { "0000000100100011", "0010001100000001" }; // Instruções na memória

        final Cache cache = new Cache();
        createRecords(registers); // Cria registradores

        for (int i = 0; i < instruction.length; i++) {
            allMethods(cache, i, j, instruction, briefing, registers);

        }

    }

    public static void createRecords(final ArrayList<Register> registers) {
        final Register jv0 = new Register();
        final Register jv1 = new Register();
        final Register jv2 = new Register();
        final Register jv3 = new Register();

        // Endereços
        jv0.address = "000"; // 0
        jv1.address = "001"; // 1
        jv2.address = "010"; // 2
        jv3.address = "011"; // 3

        // Valores
        jv0.value = 4;
        jv1.value = 2;
        jv2.value = 6;
        jv3.value = 10;

        registers.add(jv0);
        registers.add(jv1);
        registers.add(jv2);
        registers.add(jv3);

    }

    public static void goThroughArray(final Instructions briefing, final String[] instructions, final int pos) {

        briefing.opCode = instructions[pos].substring(0, 4);

        briefing.jvs = instructions[pos].substring(4, 8);

        briefing.jvt = instructions[pos].substring(8, 12);

        briefing.jvd = instructions[pos].substring(12, 16);

    }

    public static void allMethods(Cache cache, int i, int j, String[] instruction, Instructions briefing,
            ArrayList<Register> registers) {
        if (cache.instruction[i].equals(instruction[i])) {
            cache.tag = true;
            System.out.println("Hit");
            goThroughArray(briefing, instruction, i);// Percorre o Array, intepreta a instrução

            showOrganization(briefing);// Mostra a organização

            System.out.println("");

            inspection(briefing, registers);// Verifica quais registradores

            briefing.execute();// Executa

            System.out.println("");
        } else {
            System.out.println("Miss"); // Caso não exista na memoria
            cache.instruction[j] = instruction[j]; // Cache busca a instrução na memoria principal e insere ela
            j++;
            allMethods(cache, i, j, instruction, briefing, registers);
        }

    }

    public static void showOrganization(final Instructions briefing) {
        String instruction = null;
        if (briefing.opCode.equals("0000")) {
            instruction = "ADD";
        }
        if (briefing.opCode.equals("0010")) {
            instruction = "SUB";
        }
        System.out.println("===============[" + instruction + "]================");
        System.out.println("| OP ----- JVS ----- JVT ----- JVD |");
        System.out.println("|" + briefing.opCode + " ---- " + briefing.jvs + " ---- " + briefing.jvt + " ---- "
                + briefing.jvd + "|");
        System.out.println("====================================");
    }

    public static void inspection(final Instructions briefing, final ArrayList<Register> registers) {
        switch (briefing.jvs) {
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

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVS}");
            break;
        }

        switch (briefing.jvt) {
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

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVT}");
            break;
        }

        switch (briefing.jvd) {
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

        default:
            JOptionPane.showMessageDialog(null, "Inspection Error! {JVD}");
            break;
        }

    }

}
