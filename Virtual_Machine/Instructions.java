public class Instructions {
    // Atributos
    public String opCode = "";
    public String jvs = "";
    public String jvt = "";
    public String jvd = "";

    public Register registerOne;
    public Register registerTwo;
    public Register registerAnswer;

    public void execute() {
        switch (opCode) {
        case "0000": // instrução add
            registerAnswer.value = registerOne.value + registerTwo.value;
            System.out.println("===============[SUM]================");
            System.out.println("| ADDRESS ------------------ VALUE |");
            System.out.println("| [" + registerAnswer.address + "]  -------------------  [" + registerAnswer.value + "]  |");
            System.out.println("====================================");
            break;

        case "0001":
            break; // instrução addi

        }
    }

}