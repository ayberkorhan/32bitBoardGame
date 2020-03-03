public class Board {
    RandomNum rand = new RandomNum();
    int x = 0;
    int y = 0;
    private int xAxis = 8;
    private int yAxis = 8;
    private Character startPoint = 'S';
    private Character endPoint = 'E';
    private Character wall = '⛝';
    private Character square = '■';
    private Character path = '□';
    private char[][] area = new char[xAxis][yAxis];
    private char[][] walls = new char[xAxis][yAxis];
    private String[] match;
    // area dizisine oyun tahtası ataması
    public Board() {
        int wallsCount = rand.genereteRand(6, 9); //duvar sayısının random belirlenmesi
        for (int i = 0; i < wallsCount; ++i) {// walls dizisine rastgele duvarların ataması
            walls[rand.genereteRand(0, 7)][rand.genereteRand(0, 7)] = wall;
        }
        System.out.print("Duvar konumları: ");

        for (int i = 0; i < xAxis; ++i) {
            for (int j = 0; j < yAxis; ++j) {
                if (area[i] == area[0] && area[j] == area[0]) {//başlangıç noktası ataması
                    area[i][j] = startPoint;
                } else if (area[i] == area[7] && area[j] == area[7]) {//bitiş noktası ataması
                    area[i][j] = endPoint;
                } else {// oyun tahtası ve duvarların matrise ataması
                    if (walls[i][j] != walls[7][j] && walls[i][j] != walls[i][7] && walls[i][j] != walls[0][j] && walls[i][j] != walls[i][0]) {
                        if (area[i + 1][j + 1] != wall && area[i - 1][j - 1] != wall) {//çözülebilir tahta oluşması için gerekli kısıtlamalar
                            area[i][j] = wall;
                            System.out.print((j + 1) + "," + (i + 1) + "  "); //yerleştirilen duvarların konum çıktıları
                        }
                    } else {//geri kalan yerlerin boşluk olması
                        area[i][j] = square;
                    }
                }
            }
        }
        System.out.println();
        pathFinding();
        matchedWalls();
    }
    public void pathFinding() {
        while (area[x][y] != area[7][7]) {// başlangıçtan bitişe gidiş sorgusu
            if (area[x][y] != area[7][y]) { // en alt satırdayken daha alta inmesini önleme
                if (area[x + 1][y] != wall) { //alt konumda duvar sorgusu
                    area[x + 1][y] = path;
                    x++;
                } else if (area[x][y + 1] != wall) { //sağ konumda duvar sorgusu
                    area[x][y + 1] = path;
                    y++;
                } else if (area[x][y - 1] != wall) { //sol konumda duvar sorgusu
                    area[x][y - 1] = path;
                    y++;
                }
            }
            if (area[x][y] != area[x][7]) { // en sağ sütundayken sağa gitmesini önleme
                if (area[x][y + 1] != wall) { //sağ konumda duvar sorgusu
                    area[x][y + 1] = path;
                    y++;
                } else if (area[x + 1][y] != wall) { //alt konumda duvar sorgusu
                    area[x + 1][y] = path;
                    x++;
                }
            }
        }
    }
    public void matchedWalls() {
        System.out.print("Karşılaşılan duvarlar: ");
        for (int i = 0; i < xAxis; ++i) {
            for (int j = 0; j < yAxis; ++j) {
                if (area[i][j] == wall) {
                    if      (area[i - 1][j] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i][j - 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i + 1][j] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i][j + 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i + 1][j + 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i - 1][j - 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i + 1][j - 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                    else if (area[i - 1][j + 1] == path) System.out.print((j + 1) + "," + (i + 1) + " ");
                }
            }
        }
        System.out.print("\n\n");
    }
    public void printBoard() { //boardun ekrana çıktısı
        for (int i = 0; i < xAxis; ++i) {
            for (int j = 0; j < xAxis; ++j) {
                System.out.print(area[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
