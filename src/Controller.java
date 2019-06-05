import java.io.*;
import java.util.ArrayList;


public class Controller {

    private String txt1;
    private File txt2;

    public Controller(File txt2) {
        this.txt2 = txt2;
    }

    Controller() {
    }

    ;

    public void read_file_txt(File txt2) throws IOException {

        this.txt2 = txt2;
        FileInputStream f_stream = new FileInputStream(txt2);
        BufferedReader br = new BufferedReader(new InputStreamReader(f_stream));

        String strLine;
        ArrayList<String> list = new ArrayList<String>();


//Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            // Print the content on the console
            list.add(strLine);
            System.out.println(strLine);
            System.out.println(list.size());
        }

//Close the input stream
        f_stream.close();
    }

    ;

    private void creation_mtx() {

    }

    ;

    private void movement_by_mtx() {

    }

    ;


    public void add_number() {
    }

    ;

    public void decryption() {
        System.out.println("Расшифровка");
    }

    ;

    public void render() {

    }

    public String codeString1(String input) {
        char[][] matrix = new char[3][3];

        Encryption(matrix, 1, 1, true, 0, input);

        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                output += matrix[j][i];

            }

        }


        return output;
    }

    public String codeString2(String output) {
        char[][] matrix2 = new char[3][3];

        decryption1(matrix2, 0, 0, true, 0, output);

        String input = "";
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                input += matrix2[j][i];

            }

        }


        return input;
    }


    private void Encryption(char[][] matrix1, int x, int y, boolean goRight, int length, String s) {

        int iterator1 = 0;

        // if first iteration
        if (length == 0) {
            matrix1[x][y] = s.charAt(iterator1);
            Encryption(matrix1, x + 1, y, goRight, length + 1, s.substring(1));
        }
        //if last iteration
        else if (length == matrix1.length) {
            for (int i = 1; i < matrix1.length; i++) {
                matrix1[i][y] = s.charAt(iterator1);
                iterator1++;
            }

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    System.out.print(matrix1[j][i] + " ");
                }
                System.out.print("\n");
            }
        }
        // any other iteration
        else {
            if (goRight) {
                //go right
                for (int i = 0; i < length; i++) {
                    matrix1[x + i][y] = s.charAt(iterator1);
                    iterator1++;
                }
                //go up
                for (int j = 0; j < length; j++) {
                    matrix1[x + length - 1][y - j - 1] = s.charAt(iterator1);
                    iterator1++;
                }
                //next iteration
                Encryption(matrix1, x + length - 2, y - length, !goRight, length + 1, s.substring(length * 2));
            } else if (!goRight) {
                //go left

                for (int i = 0; i < length; i++) {
                    matrix1[x - i][y] = s.charAt(iterator1);
                    iterator1++;
                }
                //go down
                for (int j = 0; j < length; j++) {
                    matrix1[x - length + 1][y + j + 1] = s.charAt(iterator1);
                    iterator1++;
                }
                //next iteration
                Encryption(matrix1, x - length + 2, y + length, !goRight, length + 1, s.substring(length * 2));
            }

        }

    }

    private void decryption(char[][] matrix2, int y, int x, boolean goRight, int length, String s) {
        int iterator1 = 0;
        char[][] matrix = new char[3][3];
        int x1 = 0, y1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[y1][x1] = s.charAt(iterator1);
            }
        }

        if (length == 0) {
            matrix2[y1][x1] = matrix[y][x];
            decryption(matrix2, y, x + 1, goRight, length + 1, s.substring(1));
        } else if (length == matrix2.length) {

            y1++;
            for (int i = 0; i < length; i++)
                matrix2[y1][i] = matrix[y][x];


            for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    System.out.print(matrix2[i][j]);
                }
            }
        } else {
            if (goRight) {
                x1++;
                matrix2[y1][x1] = matrix[y][x];

                x1++;
                matrix2[y1][x1] = matrix[y - 1][x];

                decryption(matrix2, y, x - 1, !goRight, length + 1, s.substring(length * 2));
            } else if (!goRight) {
                y1++;
                x1--;
                x1--;
                matrix2[y1][x1] = matrix[y][x];
                x1++;
                matrix2[y1][x1] = matrix[y][x - 1];
                x1++;
                matrix2[y1][x1] = matrix[y + 1][x];
                decryption(matrix2, y, x, goRight, 9, s.substring(6));
            }

        }
    }

    private void decryption1(char[][] matrix1, int x, int y, boolean goRight, int length, String s) {

        int iterator1 = 4;

        // if first iteration
        if (length == 0) {
            matrix1[x][y] = s.charAt(iterator1);
            decryption1(matrix1, x + 1, y, goRight, length + 1, s.substring(1));
        }
        //if last iteration
        else if (length == matrix1.length) {
            for (int i = 1; i < matrix1.length; i++) {
                matrix1[i][y] = s.charAt(iterator1);
                iterator1++;
            }

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    System.out.print(matrix1[j][i] + " ");
                }
                System.out.print("\n");
            }
        }
        // any other iteration
        else {
            if (goRight) {
                //go right
                for (int i = 0; i < length; i++) {
                    matrix1[x + i][y] = s.charAt(iterator1);
                    iterator1++;
                }
                //go up
                for (int j = 0; j < length; j++) {
                    matrix1[x + length - 1][y - j - 1] = s.charAt(iterator1);
                    iterator1++;
                }
                //next iteration
                decryption1(matrix1, x + length - 2, y - length, !goRight, length + 1, s.substring(length * 2));
            } else if (!goRight) {
                //go left

                for (int i = 0; i < length; i++) {
                    matrix1[x - i][y] = s.charAt(iterator1);
                    iterator1++;
                }
                //go down
                for (int j = 0; j < length; j++) {
                    matrix1[x - length + 1][y + j + 1] = s.charAt(iterator1);
                    iterator1++;
                }
                //next iteration
                decryption1(matrix1, x - length + 2, y + length, !goRight, length + 1, s.substring(length * 2));
            }

        }

    }
}