package com.example.demo.service.booking;


import com.example.demo.controller.bookingController.request.BookingRequest;
import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.booking.BookingRepository;
import com.example.demo.repository.upload.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepository repository;
    @Autowired
    UploadRepository uploadRepository;

    @Transactional
    @Override
    public void register(BookingRequest info, String originalFilename) {
        String putLink = info.getDate()+"."+info.getId()+"."+originalFilename;

        if(info.getCakeArrNo() == 0) {
            BookingInfo bookingInfo2 = new BookingInfo(info.getId(), info.getDate(), info.getTime(), "예약중", info.getContents(), putLink);
            repository.save(bookingInfo2);

        }else {
            Optional<UploadCake> uploadCake = uploadRepository.findById(Long.valueOf(info.getCakeArrNo()));
            UploadCake checkCake = uploadCake.get();

            BookingInfo bookingInfo1 =
                    new BookingInfo(info.getId(), info.getDate(), info.getTime(), "예약중", info.getContents(), putLink,
                            info.getCakeArrNo());
            repository.save(bookingInfo1);
        }

    }

    @Override
    public void exceptFilesBooking(BookingRequest info) {

        if(info.getCakeArrNo() == 0) {
            BookingInfo bookingInfo2 = new BookingInfo(info.getId(), info.getDate(), info.getTime(), "예약중", info.getContents());
            repository.save(bookingInfo2);

        }else {
            Optional<UploadCake> uploadCake = uploadRepository.findById(Long.valueOf(info.getCakeArrNo()));
            UploadCake checkCake = uploadCake.get();


            BookingInfo bookingInfo1 =
                    new BookingInfo(info.getId(), info.getDate(), info.getTime(), "예약중", info.getContents(),
                            info.getCakeArrNo());
            repository.save(bookingInfo1);

        }
    }

    @Override
    public List<BookingInfo> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"bookingNo"));
    }


    @Override
    public BookingInfo read(Integer bookingNo, String id) {
        Optional<BookingInfo> maybeReadBoard = repository.findById(Long.valueOf(bookingNo));

        if(maybeReadBoard.equals(Optional.empty())){
            log.info("content is null");
            return null;
        }
        BookingInfo checkId = maybeReadBoard.get();

        if(checkId.getId().equals(id)){
            return checkId;
        }else if(checkId.getId().equals("manager")){
            return checkId;
        }else
            return null;

    }

    @Override
    public void modify(BookingInfo bookingInfo) {
        repository.save(bookingInfo);
    }

}
