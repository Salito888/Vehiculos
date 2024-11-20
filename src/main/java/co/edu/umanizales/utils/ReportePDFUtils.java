
package co.edu.umanizales.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import co.edu.umanizales.model.Vehiculo;

import java.io.FileOutputStream;
import java.util.List;

public class ReportePDFUtils {
    public void generarReporte(List<Vehiculo> vehiculos, String rutaArchivo) throws Exception {
        com.itextpdf.text.Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
        documento.open();

        // Título del documento
        documento.add(new Paragraph("Reporte de Vehículos\n\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));

        // Crear tabla
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("ID");
        tabla.addCell("Tipo");
        tabla.addCell("Disponibilidad");

        for (Vehiculo vehiculo : vehiculos) {
            tabla.addCell(vehiculo.getId());
            tabla.addCell(vehiculo.getTipo());
            PdfPCell celdaDisponibilidad = new PdfPCell(new Phrase(vehiculo.isDisponible() ? "Disponible" : "Alquilado"));
            celdaDisponibilidad.setBackgroundColor(vehiculo.isDisponible() ? BaseColor.GREEN : BaseColor.RED);
            tabla.addCell(celdaDisponibilidad);
        }

        documento.add(tabla);
        documento.close();
    }
}




