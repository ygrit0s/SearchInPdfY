import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введи поисктовую строку");
            var input = scanner.nextLine().toLowerCase();
            var dir = new File("pdfs");
            for (var pdfFile : dir.listFiles()) {
                var reader = new PdfReader(pdfFile);
                var doc = new PdfDocument(reader);
                var page = doc.getPage(1);
                var text = PdfTextExtractor.getTextFromPage(page).toLowerCase();
                if (text.contains(input)) {
                    System.out.println("Мы нашли в " + pdfFile.getName());
                }
                System.out.println("Нажмите Enter чтобы продолжить поиск");
                var answer = scanner.nextLine();
                if (!answer.isEmpty()) break;
            }
            System.out.println("Выйти из программы Y/N?");
            var isExit = scanner.nextLine();
            if (isExit.equalsIgnoreCase("y")) break;
        }
    }
}