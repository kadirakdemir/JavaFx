package sample;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            KlasorOlustur();
            BitMatrix bitMatrix;
            Writer writer=new QRCodeWriter();
            bitMatrix=writer.encode("https://mkakdemir.blogspot.com/2018/10/javafx-qrcode-ornek.html", BarcodeFormat.QR_CODE,200,200);
            MatrixToImageWriter.writeToStream(bitMatrix,"png",new FileOutputStream(new File("QRCode/qrcode.png")));
            System.out.println("oluşturuluyor");
        }catch (Exception ex){}
    }

    void KlasorOlustur(){
        try {
            String saveDir = System.getProperty("user.dir") + File.separator + "QRCode";
            File dir = new File("QRCode");
            if (!dir.exists()) {
                dir.mkdir(); // Klasör oluşturuluyor
                saveDir = System.getProperty("user.dir") + File.separator + "QRCode";
            }
        }catch (Exception ex){

        }
    }
}
