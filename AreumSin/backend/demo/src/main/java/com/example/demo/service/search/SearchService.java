package com.example.demo.service.search;

import com.example.demo.request.search.ChangePwRequest;
import com.example.demo.request.search.SearchIdRequest;
import com.example.demo.request.search.SearchPwRequest;
import com.example.demo.response.search.SearchIdResponse;

public interface SearchService {
    SearchIdResponse searchId(SearchIdRequest searchIdRequest);

    Boolean searchPw(SearchPwRequest searchPwRequest);

    void changePw(ChangePwRequest changePwRequest);
}
