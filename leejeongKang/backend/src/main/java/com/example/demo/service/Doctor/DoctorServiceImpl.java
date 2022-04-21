package com.example.demo.service.Doctor;

import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.repository.Doctor.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Override
    @Transactional
    public void register (Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    @Transactional
    public List<Doctor> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "doctorNo"));
    }

    @Override
    public Doctor read (Long doctorNo) {
        Optional<Doctor> maybeReadDoctor = repository.findById(Long.valueOf(doctorNo));

        if(maybeReadDoctor.equals(Optional.empty())) {
            return null;
        }
        return maybeReadDoctor.get();
    }

    @Override
    public void modify (Doctor doctor) { repository.save(doctor);}

    @Override
    public void remove (Long doctorNo) { repository.deleteById(Long.valueOf(doctorNo));}
}
