package hello.service;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Service
@Validated
public class ValidationService {

    public void addSth(@Size(min = 1, max = 10) String start, int end) {

    }
}
