public class Instructions {
    // Atributos
    public String opCode = "";
    public String jvs = "";
    public String jvt = "";
    public String jvd = "";

    public Register registerOne;
    public Register registerTwo;
    public Register registerAnswer;
    final int[] memData = {12, 16, 20};

     

    public void execute() {
        switch (opCode) {
        case "0000": // instrução add
            registerAnswer.value = registerOne.value + registerTwo.value;
            System.out.println("===============[SUM]================");
            System.out.println("| ADDRESS ------------------ VALUE |");
            System.out.println(
                    "| [" + registerAnswer.address + "]  -------------------  [" + registerAnswer.value + "]  |");
            System.out.println("====================================");
            break;

        case "0100"://Instrução de Load
            final int address = Integer.parseInt(registerTwo.address + registerAnswer.address);

            registerOne.value = memData[address];
            System.out.println("Valor do jv" + Integer.parseInt(registerOne.address, 16) + ": " + registerOne.value);
            break;

        case "0010"://Instrução de sub
            registerAnswer.value = registerOne.value - registerTwo.value;
            System.out.println("===============[SUB]================");
            System.out.println("| ADDRESS ------------------ VALUE |");
            System.out.println(
                    "| [" + registerAnswer.address + "]  -------------------  [" + registerAnswer.value + "]  |");
            System.out.println("====================================");
            break;

        case "0101":
            break;
        }

    }

}