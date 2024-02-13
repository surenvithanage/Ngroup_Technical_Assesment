package org.assessment.service;

import org.assessment.GenerateFlatFile;
import org.assessment.bean.Body;
import org.assessment.bean.Header;
import org.assessment.bean.Trailer;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FlatFileService {

    public static void generateFlatFile() {
        StreamFactory streamFactory = StreamFactory.newInstance();

        try {
            InputStream stream = GenerateFlatFile.class.getResourceAsStream("/format.xml");
            streamFactory.load(stream);

            try (BeanWriter writer = streamFactory.createWriter("headerFile", new FileWriter("flatFile.txt"))) {
                Header header = new Header();
                header.setRecordType("H");
                header.setFileType("FLAT_FILE");

                // Write the Header object to the file
                writer.write("header", header);
            }

            try (BeanWriter writer = streamFactory.createWriter("bodyFile", new FileWriter("flatFile.txt", true))) {

                List<Body> bodyRecords = new ArrayList<>();
                bodyRecords.add(new Body("6813162459", "RM2.00"));
                bodyRecords.add(new Body("2039229524", "RM10.00"));
                bodyRecords.add(new Body("2299488320", "RM5.00"));

                // Create a Body object
                for (Body body : bodyRecords) {
                    writer.write("body", body);
                }
            }

            try (BeanWriter writer = streamFactory.createWriter("trailerFile", new FileWriter("flatFile.txt", true))) {
                Trailer trailer = new Trailer();
                trailer.setRecordType("T");
                trailer.setFileType("FLAT_FILE");

                // Write the Trailer object to the file
                writer.write("trailer", trailer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
