import java.util.Scanner;

public class Day05b {
    static final int[] inputProgram = {3,225,1,225,6,6,1100,1,238,225,104,0,1102,79,14,225,1101,17,42,225,2,74,69,224,1001,224,-5733,224,4,224,1002,223,8,223,101,4,224,224,1,223,224,223,1002,191,83,224,1001,224,-2407,224,4,224,102,8,223,223,101,2,224,224,1,223,224,223,1101,18,64,225,1102,63,22,225,1101,31,91,225,1001,65,26,224,101,-44,224,224,4,224,102,8,223,223,101,3,224,224,1,224,223,223,101,78,13,224,101,-157,224,224,4,224,1002,223,8,223,1001,224,3,224,1,224,223,223,102,87,187,224,101,-4698,224,224,4,224,102,8,223,223,1001,224,4,224,1,223,224,223,1102,79,85,224,101,-6715,224,224,4,224,1002,223,8,223,1001,224,2,224,1,224,223,223,1101,43,46,224,101,-89,224,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,1101,54,12,225,1102,29,54,225,1,17,217,224,101,-37,224,224,4,224,102,8,223,223,1001,224,3,224,1,223,224,223,1102,20,53,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,107,226,226,224,1002,223,2,223,1006,224,329,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,344,101,1,223,223,7,677,226,224,102,2,223,223,1006,224,359,101,1,223,223,108,226,226,224,1002,223,2,223,1005,224,374,101,1,223,223,8,226,677,224,1002,223,2,223,1006,224,389,101,1,223,223,1108,226,226,224,102,2,223,223,1006,224,404,101,1,223,223,1007,677,677,224,1002,223,2,223,1006,224,419,101,1,223,223,8,677,677,224,1002,223,2,223,1005,224,434,1001,223,1,223,1008,226,226,224,102,2,223,223,1005,224,449,1001,223,1,223,1008,226,677,224,102,2,223,223,1006,224,464,101,1,223,223,1107,677,677,224,102,2,223,223,1006,224,479,101,1,223,223,107,677,677,224,1002,223,2,223,1005,224,494,1001,223,1,223,1107,226,677,224,1002,223,2,223,1005,224,509,101,1,223,223,1108,226,677,224,102,2,223,223,1006,224,524,101,1,223,223,7,226,226,224,1002,223,2,223,1005,224,539,101,1,223,223,108,677,677,224,1002,223,2,223,1005,224,554,101,1,223,223,8,677,226,224,1002,223,2,223,1005,224,569,1001,223,1,223,1008,677,677,224,102,2,223,223,1006,224,584,101,1,223,223,107,226,677,224,102,2,223,223,1005,224,599,1001,223,1,223,7,226,677,224,102,2,223,223,1005,224,614,101,1,223,223,1007,226,226,224,1002,223,2,223,1005,224,629,101,1,223,223,1107,677,226,224,1002,223,2,223,1006,224,644,101,1,223,223,108,226,677,224,102,2,223,223,1006,224,659,101,1,223,223,1007,677,226,224,102,2,223,223,1006,224,674,101,1,223,223,4,223,99,226};

    public static void main(String[] args) {
        runProgram(inputProgram);
    }

    public static int runProgram(int[] program) {
        Scanner inputReader = new Scanner(System.in);
        int raise;

        for (int i = 0; i < program.length; i += raise) {
            raise = 1;

            String code = String.valueOf(program[i]);
            for (int j = code.length(); j < 5; j++) {
                code = "0" + code;
            }

            if (code.substring(3).equals("01")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                program[program[i + 3]] = firstValue + secondValue;

                raise = 4;
            }

            if (code.substring(3).equals("02")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                program[program[i + 3]] = firstValue * secondValue;

                raise = 4;
            }

            if (code.substring(3).equals("03")) {
                System.out.print("Run what program?");
                String input = inputReader.nextLine();
                program[program[i + 1]] = Integer.parseInt(input);

                raise = 2;
            }

            if (code.substring(3).equals("04")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                System.out.println(firstValue);

                raise = 2;
            }

            if (code.substring(3).equals("05")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue > 0) {
                    i = secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("06")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue == 0) {
                    i = secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("07")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue < secondValue) {
                    program[program[i + 3]] = 1;
                } else {
                    program[program[i + 3]] = 0;
                }

                raise = 4;
            }

            if (code.substring(3).equals("08")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue == secondValue) {
                    program[program[i + 3]] = 1;
                } else {
                    program[program[i + 3]] = 0;
                }

                raise = 4;
            }

            if (program[i] == 99) {
                break;
            }
        }

        return program[0];
    }
}
