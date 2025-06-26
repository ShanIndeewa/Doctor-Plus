package DoctorPlus.Controllers.PrescriptionController;

import DoctorPlus.ObjectClasses.Doctor;
import DoctorPlus.ObjectClasses.Patient;
import DoctorPlus.ViewInterfaces.Prescription.PrescriptionTable;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;

import javax.swing.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;


public class PDFMaker {
    JTable table;
    private static String doctorName;
    private static Patient patient;

    public PDFMaker( PrescriptionTable prescriptionTable,String doctor,Patient patient) {
        this.doctorName = doctor;
        this.patient = patient;

        table = prescriptionTable.getTable();
        printTableToPDF(table);
    }

    public static void printTableToPDF(JTable table) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save PDF");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Documents", "pdf"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String pdfFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (!pdfFilePath.toLowerCase().endsWith(".pdf")) {
                pdfFilePath += ".pdf";
            }

            Document document = new Document();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
                document.open();
                addHeader(document);
                addPatientInformation(document);
                addPrescriptionTable(document, table);
                addFooter(document);
                document.close();
                System.out.println("PDF created successfully at: " + pdfFilePath);

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addHeader(Document document) throws DocumentException {
        Paragraph clinicName = new Paragraph("Dr."+doctorName+" / Doctor Plus", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
        clinicName.setAlignment(Element.ALIGN_CENTER);
        document.add(clinicName);

        Paragraph contactInfo = new Paragraph("Address: 123 Sea road,Galle\nContact: (091) 456-7890", FontFactory.getFont(FontFactory.HELVETICA, 12));
        contactInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(contactInfo);

        document.add(Chunk.NEWLINE);
    }

    public static void addPatientInformation(Document document) throws DocumentException {
        Paragraph patientInfo = new Paragraph("Patient Name: "+patient.getFirstName()+" "+patient.getLastName()+"\nPatient ID:"+patient.getPatientId()+"\nDate: " + LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 12));
        patientInfo.setAlignment(Element.ALIGN_LEFT);
        document.add(patientInfo);

        document.add(Chunk.NEWLINE);
    }

    public static void addPrescriptionTable(Document document, JTable table) throws DocumentException {
        PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
        pdfTable.setWidthPercentage(100);

        for (int i = 0; i < table.getColumnCount(); i++) {
            pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(i), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12))));
        }

        for (int row = 0; row < table.getRowCount(); row++) {
            for (int col = 0; col < table.getColumnCount(); col++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getValueAt(row, col).toString(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
            }
        }

        document.add(pdfTable);
        document.add(Chunk.NEWLINE);
    }

    public static void addFooter(Document document) throws DocumentException {
        Paragraph signature = new Paragraph("Doctor's Signature: _____________________", FontFactory.getFont(FontFactory.HELVETICA, 12));
        signature.setAlignment(Element.ALIGN_RIGHT);
        document.add(signature);

        Paragraph date = new Paragraph("Date: " + LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 12));
        date.setAlignment(Element.ALIGN_RIGHT);
        document.add(date);
    }
}

