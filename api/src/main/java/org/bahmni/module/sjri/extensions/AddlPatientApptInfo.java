package org.bahmni.module.sjri.extensions;

import org.apache.commons.collections.map.HashedMap;
import org.bahmni.module.sjri.utils.SJRIProperties;
import org.openmrs.Patient;
import org.openmrs.PersonAttribute;
import org.openmrs.module.appointments.model.Appointment;
import org.openmrs.module.appointments.web.extension.AppointmentResponseExtension;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddlPatientApptInfo implements AppointmentResponseExtension {

    private static final String DEFAULT_PATIENT_ATTRIBUTES = "";

    public AddlPatientApptInfo() {
        SJRIProperties.load();
    }

    @Override
    public Map<String, String> run(Appointment appointment) {
        Map<String, String> addlInfo = new HashedMap();

        Patient patient = appointment.getPatient();
        String property = SJRIProperties.getProperty("appointment.patient.attributes");
        property = property != null ? property : DEFAULT_PATIENT_ATTRIBUTES;

        String[] attributeNames = property.split(",");
        for (String attributeName : attributeNames) {
            PersonAttribute attribute = patient.getAttribute(attributeName);
            if (attribute != null) {
                addlInfo.put(attributeName, attribute.getValue());
            }
        }
        return addlInfo;
    }
}
