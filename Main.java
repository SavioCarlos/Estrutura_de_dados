public class Main {
    public static void main(String[] args) {
        char[][] labirinto = {
                {  '1', '1', '1', '1', '1', '1', '1' },
                {  '1', 'S', '0', '1', '0', '0', '1' },
                {  '1', '1', '0', '1', '0', '1', '1' },
                {  '1', '0', '0', '0', '0', '0', '1' },
                {  '1', '0', '1', '1', '1', '0', '1' },
                {  '1', '0', '0', 'D', '0', '0', '1' },
                {  '1', '1', '1', '1', '1', '1', '1' }
        };

        Labirinto lab = new Labirinto(labirinto);
        lab.resolveLabirinto();
    }
}
