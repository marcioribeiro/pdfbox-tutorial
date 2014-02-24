package com.panteracode.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 * 
 * @author Marcio Ribeiro
 * classe responsável por criar documentos PDF
 */
public class DocumentoPdf {

	public void criarDocumentoSimples(){
		try {
			PDDocument documento = new PDDocument();
			PDPage pag = new PDPage();
			documento.addPage(pag);
			
			//seleciona a fonte usada no documento
			PDFont font = PDType1Font.COURIER;
			
			PDPageContentStream contentStream = new PDPageContentStream(documento,pag);
			
			contentStream.beginText();
			contentStream.setFont(font, 13);
			contentStream.moveTextPositionByAmount(10,700);
			contentStream.drawString("Olá Mundo !");
			/*contentStream.moveTextPositionByAmount(10,20);
			contentStream.drawLine(10,25,90,90);*/
			contentStream.endText();
			
			contentStream.close();
			documento.save("primeiro doc.pdf");
			documento.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
