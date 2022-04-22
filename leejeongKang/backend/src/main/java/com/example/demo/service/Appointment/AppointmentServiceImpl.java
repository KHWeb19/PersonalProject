package com.example.demo.service.Appointment;

import com.example.demo.entity.Appointment.Appointment;
import com.example.demo.repository.Appointment.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository repository;

    @Override
    @Transactional
    public void register (Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    @Transactional
    public List<Appointment> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "aptNo"));

    }

    @Override
    public Appointment read (Long aptNo) {
        Optional<Appointment> maybeReadAppointment = repository.findById(Long.valueOf(aptNo));

        if(maybeReadAppointment.equals(Optional.empty())) {
            log.info("Can't read appointment!");
            return null;
        }

        return maybeReadAppointment.get();
    }

    @Override
    public void remove (Long aptNo) {
        repository.deleteById(Long.valueOf(aptNo));
    }
}
