package ru.cobp.backend.credit.service;

import org.springframework.stereotype.Service;
import ru.cobp.backend.credit.dto.CreditDto;
import ru.cobp.backend.credit.dto.CreditParams;

import java.util.List;

@Service
public class CreditPublicServiceImpl implements CreditPublicService {

    @Override
    public List<CreditDto> getAll(CreditParams params) {
        return null;
    }

    @Override
    public CreditDto getById(long id) {
        return null;
    }
}
