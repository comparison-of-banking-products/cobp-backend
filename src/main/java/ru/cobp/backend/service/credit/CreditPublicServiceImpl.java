package ru.cobp.backend.service.credit;

import org.springframework.stereotype.Service;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;

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
