import java.util.*;
import java.lang.*;
import processing.core.PApplet;

public class projekAkhir {

        public static class GerakParabolaMatahari extends PApplet {

            int bgColor = color(105, 57, 237); // Warna latar (biru)

            // inisialisasi
            int xs = -120, ys = 275;
            float mountain1Y = 700;
            float mountain2Y = 700;

            float ufoX = 600;
            float ufoY = 200;

            float ufoX2 = 400;
            float ufoY2 = 300;

            float ufoX3 = 1000;
            float ufoY3 = 150;

            float cloud1X = 0;
            float cloud2X = 300;
            float cloud3X = 700;
            float cloud4X = 1000;
            float cloud5X = -300;

            public static void main(String[] args) {
                PApplet.runSketch(new String[]{"Matahari Gerak Parabola"}, new GerakParabolaMatahari());
            }

            @Override
            public void settings() {
                size(1300, 750);
            }

            @Override
            public void setup() {
                frameRate(15);
            }

            void drawSky() {
                for (int i = 0; i <= height; i += 2) {
                    fill(133, 89 - i / 10, 136 - i / 2);
                    rect(0, i, width, 2);
                }
            }

            float ufoSpeed = 5; // kecepatan UFO berpindah

            @Override
            public void draw() {
                // Ganti warna latar
                drawSky();
                int x1 = 0;
                int y1 = 0;
                int x2 = 1300;
                int y2 = 0;

                int[] colors = {
                        color(148, 87, 235),  // Chinese Violet
                        color(115, 79, 150),  // Dark Lavender
                        color(82, 45, 128),   // Regalia
                        color(35, 41, 122),   // St. Patrick's Blue
                        color(46, 45, 134),   // Space Cadet
                        color(30, 33, 93)     // Cetacean Blue
                };

                noStroke(); // Menghilangkan garis tepi

                for (int x = 0; x <= 380; x++) {
                    int currentColor = lerpColor(colors[0], colors[5], map(x, 0, 380, 0, 1));
                    fill(currentColor); // Menggunakan fill untuk mengatur warna latar belakang
                    rect(x1, y1, x2, y2); // Menggunakan rect untuk mengisi warna latar belakang
                    y1++;
                    y2++;
                }

                // Gambar dua gunung
                drawFirstMountain();
                drawSecondMountain();

                // Gambar bintang
                drawStars();

                // Gerakan UFO
                ufoX -= ufoSpeed;
                ufoX2 += ufoSpeed;
                ufoX3 -= ufoSpeed;

                // Jika UFO melewati batas layar, reset posisinya ke sebelah kiri
                if (ufoX < -110) {
                    ufoX = width; // Width of UFO is 110
                }
                if (ufoX2 > width) {
                    ufoX2 = -110;
                }
                if (ufoX3 < -110) {
                    ufoX3 = width;
                }

                // Gambar UFO
                drawUFO(ufoX, ufoY);
                drawUFO(ufoX2, ufoY2);
                drawUFO(ufoX3, ufoY3);


                // Gambar dan tinggi awan bergerak
                drawCloud(cloud1X, 300);
                drawCloud(cloud2X, 150);
                drawCloud(cloud3X, 250);
                drawCloud(cloud4X, 150);
                drawCloud(cloud5X, 200);

                // Gerakan awan
                cloud1X += 2;
                cloud2X += 2;
                cloud3X += 2;
                cloud4X += 2;
                cloud5X += 2;

                // Reset posisi awan jika melewati batas kanan layar
                if (cloud1X > width) {
                    cloud1X = -200;
                }
                if (cloud2X > width) {
                    cloud2X = -200;
                }
                if (cloud3X > width) {
                    cloud3X = -200;
                }
                if (cloud4X > width) {
                    cloud4X = -200;
                }
                if (cloud5X > width) {
                    cloud5X = -200;
                }
            }


            void drawFirstMountain() {
                int color1 = color(43, 43, 43); // Warna awal (hijau tua)
                int color2 = color(66, 179, 66); // Warna akhir (hijau terang)
                fill(lerpColor(color1, color2, 0.5F)); // untuk gradasi hijau
                noStroke();

                // Gambar gunung 1
                triangle(0, mountain1Y, width / 4, mountain1Y - 300, width / 2, mountain1Y);
            }

            void drawSecondMountain() {
                int color1 = color(43, 43, 43); // Warna awal (hijau tua)
                int color2 = color(66, 179, 66); // Warna akhir (hijau terang)
                fill(lerpColor(color1, color2, 0.5F)); // untuk gradasi hijau
                noStroke();

                // Gambar gunung 2
                triangle(width / 2, mountain2Y, 3 * width / 4, mountain2Y - 200, width, mountain2Y);
            }

            void drawStars() {
                fill(255); // warna untuk bintang
                for (int i = 0; i < 100; i++) {
                    float x = random(width);
                    float y = random(height / 2); // bintang-bintang hanya muncul di bagian atas layar
                    ellipse(x, y, 2, 2); // Menggunakan ellipse untuk menggambar bintang
                }
            }

            void drawCloud(float x, float y) {
                fill(152); // warna untuk awan
                noStroke();
                // ukuran awan
                ellipse(x, y, 100, 70);
                ellipse(x + 40, y + 10, 100, 70);
                ellipse(x + 70, y, 100, 70);
            }

            void drawUFO(float x, float y) {
                fill(42); // Warna untuk UFO
                noStroke();
                ellipse(x, y, 110, 50); // Badan UFO
                fill(42);
                ellipse(x + 0, y - 20, 60, 50); // Kepala UFO

                // Draw UFO windows
                fill(255); // Warna untuk jendela UFO
                ellipse(x - 20, y - 10, 10, 10); // Jendela 1
                ellipse(x, y - 10, 10, 10); // Jendela 2
                ellipse(x + 20, y - 10, 10, 10); // Jendela 3
            }
        }
    }

