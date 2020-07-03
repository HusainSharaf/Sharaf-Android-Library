package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.woo.htmltopdf.HtmlToPdf;
import io.woo.htmltopdf.HtmlToPdfObject;

public class ConvertHTMLToPDF extends AppCompatActivity {
    String targetPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covnert_h_t_m_l_to_p_d_f);

        Button show = findViewById(R.id.show);
        Button convert = findViewById(R.id.convert);
        final WebView html = findViewById(R.id.html);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String htmlDocument = "<html><body><h1>HTML Created</h1><p>Testing, " +
                        "testing, testing...</p></body></html>";
                html.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
                String myPath = Environment.getExternalStorageDirectory().getPath() + "/TestingHTMLtoPDF/HTML to PDF.pdf";
                boolean success = HtmlToPdf.create().object(HtmlToPdfObject.forHtml("<p><em>Apples</em>, not oranges</p>")).convert(myPath);
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creating empty pdf
                createEmptyPdf();

                // converting HTML to PDF
                convertHTMLtoPDF(targetPdf);

            }
        });


    }

    private void createEmptyPdf(){
        // create a new document
        PdfDocument document = new PdfDocument();

        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();

        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        // Drawing Red Circle
        // paint.setColor(Color.RED);
        // canvas.drawCircle(50, 50, 30, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("Hello", 80, 50, paint);
        paint.setColor(Color.GREEN);
        canvas.drawText("السلام عليكم ورحمة الله وبركاته", 120, 100, paint);

        //canvas.draw
        // finish the page
        document.finishPage(page);


        // write the document content
        //Create directory
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/TestingHTMLtoPDF/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }

        // create PDF
        targetPdf = directory_path+"HTML to PDF.pdf";
        File filePath = new File(targetPdf);

        try {
            document.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }

        // close the document
        document.close();
    }

    private void convertHTMLtoPDF(String targetPdf){
        Toast.makeText(this, "Converting HTML to PDF : " ,  Toast.LENGTH_LONG).show();
    }

}